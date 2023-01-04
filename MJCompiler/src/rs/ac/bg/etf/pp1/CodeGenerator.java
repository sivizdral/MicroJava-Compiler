package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
	HashMap<Obj, Integer> objVFT = new HashMap<>();
	Stack<Obj> callingStack = new Stack<>();
	int mainPC = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	Obj currentClass = null;
	List<Obj> methodsInClass = new ArrayList<>();
	
	/* PRINT */
	
	public void visit(PrintStmt stmt) {
		if (stmt.getExpr().struct == Tab.charType) {
			Code.put(Code.bprint);
		} else {
			Code.put(Code.print);
		}
	}
	
	public void visit(OptionalNumConstX printAddition) {
		Code.loadConst(printAddition.getWidth());
	}
	
	public void visit(NoOptionalNumConst printAddition) {
		Struct type = ((PrintStmt) printAddition.getParent()).getExpr().struct;
		
		if (type == SemanticAnalyzer.booleanType || type == Tab.intType) {
			Code.loadConst(5);
			return;
		}
		
		if (type == Tab.charType) {
			Code.loadConst(1);
			return;
		}
	}
	
	/* READ */
	
	public void visit(ReadStmt stmt) {
		if (stmt.getDesignator().obj.getType() != Tab.charType) {
			Code.put(Code.read);
		} else {
			Code.put(Code.bread);
		}
		
		Code.store(stmt.getDesignator().obj);
	}
	
	/* FACTOR */
    
    public void visit(FactorExpr factor) {
    	factor.struct = factor.getExpr().struct;
    }
    
    public void visit(FactorNumConst fnc) {
    	Code.loadConst(fnc.getN1());
    }
    
    public void visit(FactorCharConst fcc) {
    	Code.loadConst(((int) fcc.getC1()));
    }
    
    public void visit(FactorBoolConst fbc) {
    	Code.loadConst((fbc.getB1() == true ? 1 : 0));
    }
    
    public void visit(FactorDesignatorOnly factor) {
    	Code.load(factor.getDesignator().obj);
    }
    
    public void visit(FactorNew factor) {
    	Obj called = callingStack.pop();
    	if (called.getName().equals("ord") || called.getName().equals("chr")) return;
    	if (called.getName().equals("len")) Code.put(Code.arraylength);
    	Code.put(Code.call);
    	Code.put2(called.getAdr() - Code.pc);
    }
    
    public void visit(ConstructorType type) {
    	callingStack.push(type.obj);
    	Code.put(Code.new_);
    	
    	// alokacija u bajtovima za objekat
    	Code.put2(((FactorNew) type.getParent()).struct.getNumberOfFields() * 4);
    	
    	// za this
    	Code.put(Code.dup);
    	
    	// za VFT
    	Code.put(Code.dup);
    	
    	String name = type.obj.getName().split("-")[0];
    	Obj classObj = null;
    	for (Obj obj : objVFT.keySet()) {
    		if (obj.getName().equals(name)) {
    			classObj = obj;
    			break;
    		}
    	}
    	Code.loadConst(objVFT.getOrDefault(classObj, -1));
    	
    	// VFT ide na prvo mesto
    	Code.put(Code.putfield);
    	Code.put2(0);
    }
    
    public void visit(FactorNewArray factor) {
		Code.put(Code.newarray);
		if (factor.struct.getElemType() != Tab.charType) {
			Code.put(1);
		} else {
			Code.put(0);
		}
    }
    
    /* EXPR */
    
    public void visit(OptMinusX negative) {
    	Code.put(Code.neg);
    }
    
    public void visit(AddopTermListX addition) {
    	if (addition.getAddop() instanceof AddopP) Code.put(Code.add);
    	if (addition.getAddop() instanceof AddopM) Code.put(Code.sub);
    }
    
    /* TERM */
    
    public void visit(TermFactorList term) {
    	if (term.getMulop() instanceof MulopM) Code.put(Code.mul);
    	if (term.getMulop() instanceof MulopD) Code.put(Code.div);
    	if (term.getMulop() instanceof MulopP) Code.put(Code.rem);
    }
    
    /* GLOBAL FUNCTION */
    
    public void visit(MethodStartVoid methodStart) {
    	methodStart.obj.setAdr(Code.pc);
    	if (methodStart.obj.getName().equals("main")) {
    		mainPC = Code.pc;
    		int counter = SemanticAnalyzer.nVars;
    		for (Obj obj : objVFT.keySet()) {
    			objVFT.put(obj, counter);
    			for (Obj mem : obj.getType().getMembers()) {
    				if (!mem.getName().split("-")[0].equals(obj.getName()) && mem.getKind() == Obj.Meth) {
    					String name = mem.getName().split("-")[0];
    					for (int i = 0; i < name.length(); i++) {
    						char c = name.charAt(i);
    						Code.loadConst(c);
    						Code.put(Code.putstatic);
    						Code.put2(counter);
    						counter++;
    					}
    					Code.loadConst(-1);
    					Code.put(Code.putstatic);
    					Code.put2(counter);
    					counter++;
    					Code.loadConst(mem.getAdr());
    					Code.put(Code.putstatic);
    					Code.put2(counter);
    					counter++;
    				}
    			}
    			Code.loadConst(-2);
    			Code.put(Code.putstatic);
    			Code.put2(counter);
    			counter++;
    		}
    		SemanticAnalyzer.nVars = counter;
    	}
    	
    	Code.put(Code.enter);
    	Code.put(methodStart.obj.getLevel());
    	Code.put(methodStart.obj.getLocalSymbols().size());
    	currentMethod = methodStart.obj;
    }
    
    public void visit(MethodStartType methodStart) {
    	methodStart.obj.setAdr(Code.pc);
    	Code.put(Code.enter);
    	Code.put(methodStart.obj.getLevel());
    	Code.put(methodStart.obj.getLocalSymbols().size());
    	currentMethod = methodStart.obj;
    }
    
    public void visit(MethodDecl methodDecl) {
    	if (!returnFound) {
    		if (methodDecl.obj.getType() != Tab.noType) {
    			Code.put(Code.trap);
    			Code.put(1);
    		} else {
    			Code.put(Code.exit);
    			Code.put(Code.return_);
    		}
    	}
    	currentMethod = null;
    	returnFound = false;
    }
    
    public void visit(MethodDecl2 methodDecl) {
    	if (!returnFound) {
    		if (methodDecl.obj.getType() != Tab.noType) {
    			Code.put(Code.trap);
    			Code.put(1);
    		} else {
    			Code.put(Code.exit);
    			Code.put(Code.return_);
    		}
    	}
    	methodsInClass.add(currentMethod);
    	currentMethod = null;
    	returnFound = false;
    }
    
    /* CONSTRUCTORS */
    
    public void visit(ConstructorDeclStart constructorStart) {
    	constructorStart.obj.setAdr(Code.pc);
    	Code.put(Code.enter);
    	Code.put(constructorStart.obj.getLevel());
    	Code.put(constructorStart.obj.getLocalSymbols().size());
    	currentMethod = constructorStart.obj;
    }
    
    public void visit(FirstConstructorDecl constructor) {
    	Code.put(Code.exit);
		Code.put(Code.return_);
		currentMethod = null;
    }
    
    public void visit(ListsMet lists) {
    	addDefaultConstructor();
    }
    
    public void visit(ListsNoConNoMet lists) {
    	addDefaultConstructor();
    }
    
    public void visit(NoConstructorMethodLists lists) {
    	addDefaultConstructor();
    }
    
    public void addDefaultConstructor() {
    	for (Obj mem : currentClass.getType().getMembers()) {
    		String className = currentClass.getName();
    		String consName = mem.getName();
    		if (className.equals(consName) && mem.getKind() == Obj.Meth) {
    			mem.setAdr(Code.pc);
    			Code.put(Code.enter);
    			Code.put(1);
    			Code.put(1);
    			Code.put(Code.exit);
    			Code.put(Code.return_);
    			break;
    		}
    	}
    }
    
    public void visit(ClassDecl classDecl) {
    	objVFT.put(currentClass, -1);
    	currentClass = null;
    }
    
    public void visit(ClassDeclStart classStart) {
    	currentClass = classStart.obj;
    }
    
    /* DESIGNATOR */
    
    DesignatorStart designator = null;
    
    public void visit(DesignatorStart dsgStart) {
    	if ((dsgStart.obj.getKind() == Obj.Meth && methodsInClass.contains(dsgStart.obj) && dsgStart.getParent() instanceof FuncDesig)
    			|| (dsgStart.obj.getKind() == Obj.Fld && (dsgStart.getParent() instanceof FactorDesignatorOnly || dsgStart.getParent() instanceof DesignatorStatement))) 
    		Code.put(Code.load_n + 0);
    	designator = dsgStart;
    }
    
    public void visit(IdentExprListIdent fieldDsg) {
    	Code.load(fieldDsg.getIdentExprList().obj);
    }
    
    public void visit(LeftIdent arrayDsg) {
    	Code.load(arrayDsg.getIdentExprList().obj);
    }
    
    public void visit(NoIdentExprList dsg) {
    	dsg.obj = designator.obj;
    }
    
    /* WHILE, BREAK, CONTINUE, FOREACH */
    
    Stack<Integer> loopStack = new Stack<>();
    Stack<List<Integer>> orStack = new Stack<>();
    Stack<List<Integer>> andStack = new Stack<>();
    Stack<List<Integer>> elseStack = new Stack<>();
    Stack<List<Integer>> breakStack = new Stack<>();
    Stack<Integer> foreachStack = new Stack<>();
    
    public void visit(WhileStmt whileStmt) {
    	List<Integer> ands = andStack.pop();
    	List<Integer> ors = orStack.pop();
    	List<Integer> elses = elseStack.pop();
    	List<Integer> breaks = breakStack.pop();
    	
    	for (int and : ands) {
    		Code.fixup(and);
    	}
    	
    	for (int brk : breaks) {
    		Code.fixup(brk);
    	}
    	
    	Code.putJump(loopStack.pop());
    }
    
    public void visit(WhileStmtStart whileStart) {
    	loopStack.push(Code.pc); // address of current while
    	breakStack.push(new ArrayList<>());
    	elseStack.push(new ArrayList<>());
    	andStack.push(new ArrayList<>());
    	orStack.push(new ArrayList<>());
    }
    
    public void visit(ContinueStmt continueStmt) {
    	Code.putJump(loopStack.peek());
    }
    
    public void visit(BreakStmt breakStmt) {
    	List<Integer> breaks = breakStack.pop();
    	breaks.add(Code.pc + 1);
    	Code.putJump(0);
    	breakStack.push(breaks);
    }
    
    public void visit(DesignatorFE foreach) {
    	if (foreach.getIdentExprList() instanceof NoIdentExprList) Code.load(foreach.getIdentExprList().obj);
    	else Code.load(foreach.getDesignatorStart().obj);
    	Code.loadConst(-1);
    	loopStack.push(Code.pc);
    	breakStack.push(new ArrayList<>());
    	Code.loadConst(1);
    	Code.put(Code.add);
    	Code.put(Code.dup2);
    	Code.put(Code.pop);
    	Code.put(Code.arraylength);
    	Code.put(Code.dup2);
    	Code.put(Code.pop);
    	Code.put(Code.dup_x1);
    	Code.put(Code.pop);
    	foreachStack.push(Code.pc + 1);
    	Code.putFalseJump(Code.lt, 0);
    	Code.put(Code.dup2);
    	if (((ForeachStmt)foreach.getParent()).getFEVar().obj.getType() == Tab.charType) Code.put(Code.baload);
    	else Code.put(Code.aload);
    	Code.store(((ForeachStmt)foreach.getParent()).getFEVar().obj);
    }
    
    public void visit(ForeachStmt foreach) {
    	Code.putJump(loopStack.pop());
    	Code.fixup(foreachStack.pop());
    	List<Integer> breaks = breakStack.pop();
    	for (int br : breaks) {
    		Code.fixup(br);
    	}
    	Code.put(Code.pop);
    	Code.put(Code.pop);
    }
    
    /* CONDITION */
    
    public void visit(OptionalRelopExprX relopCond) {
    	List<Integer> ands = andStack.pop();
    	ands.add(Code.pc + 1);
    	andStack.push(ands);
    	if (relopCond.getRelop() instanceof RelopEq) Code.putFalseJump(Code.eq, 0);
    	if (relopCond.getRelop() instanceof RelopNE) Code.putFalseJump(Code.ne, 0);
    	if (relopCond.getRelop() instanceof RelopGT) Code.putFalseJump(Code.gt, 0);
    	if (relopCond.getRelop() instanceof RelopGTE) Code.putFalseJump(Code.ge, 0);
    	if (relopCond.getRelop() instanceof RelopLT) Code.putFalseJump(Code.lt, 0);
    	if (relopCond.getRelop() instanceof RelopLTE) Code.putFalseJump(Code.le, 0);
    }
    
    public void visit(NoOptionalRelopExpr cond) {
    	Code.loadConst(1);
    	List<Integer> ands = andStack.pop();
    	ands.add(Code.pc + 1);
    	andStack.push(ands);
    	Code.putFalseJump(Code.eq, 0);
    }
    
    public void visit(DummyAfterTerm dummy) {
    	
    	// TRUE
    	List<Integer> ors = orStack.pop();
    	ors.add(Code.pc + 1);
    	orStack.push(ors);
    	Code.putJump(0);
    	
    	// FALSE
    	List<Integer> ands = andStack.pop();
    	for (int and : ands) {
    		Code.fixup(and);
    	}
    	ands.clear();
    	andStack.push(ands);
    }
    
    public void visit(DummyAfterCond dummy) {
    	List<Integer> ors = orStack.pop();
    	for (int or : ors) {
    		Code.fixup(or);
    	}
    	ors.clear();
    	orStack.push(ors);
    }
    
    public void visit(ElseElse elseElse) {
    	List<Integer> elses = elseStack.pop();
    	elses.add(Code.pc + 1);
    	elseStack.push(elses);
    	Code.putJump(0);
    	List<Integer> ands = andStack.pop();
    	for (int and : ands) {
    		Code.fixup(and);
    	}
    	ands.clear();
    	andStack.push(ands);
    }
    
    /* IF */
    
    public void visit(StartIF startIF) {
    	elseStack.push(new ArrayList<>());
    	andStack.push(new ArrayList<>());
    	orStack.push(new ArrayList<>());
    }
    
    public void visit(UnmatchedIf uif) {
    	List<Integer> ands = andStack.pop();
    	for (int and : ands) {
    		Code.fixup(and);
    	}
    	ands.clear();
    	orStack.pop();
    	elseStack.pop();
    }
    
    public void visit(UnmatchedIfElse uifelse) {
    	List<Integer> elses = elseStack.pop();
    	for (int el : elses) {
    		Code.fixup(el);
    	}
    	elses.clear();
    	orStack.pop();
    	andStack.pop();
    }
    
    public void visit(MatchedIfElseStmt mif) {
    	List<Integer> elses = elseStack.pop();
    	for (int el : elses) {
    		Code.fixup(el);
    	}
    	elses.clear();
    	orStack.pop();
    	andStack.pop();
    }
    
    /* DESIGNATOR STATEMENT */
    
    public void visit(FuncDesig desig) {
    	callingStack.push(desig.getDesignator().obj);
    	if (methodsInClass.contains(desig.getDesignator().obj)) Code.put(Code.dup);
    }
    
    public void visit(DesignatorStmtCall call) {
    	if (methodsInClass.contains(call.getFuncDesig().getDesignator().obj)) {
    		Code.put(Code.getfield);
        	Code.put2(0);
        	Code.put(Code.invokevirtual);
        	String name = call.getFuncDesig().getDesignator().obj.getName();
        	for (int i = 0; i < name.length(); i++) {
        		Code.put4(name.charAt(i));
        	}
        	Code.put4(-1);
    	} else {
    		Obj called = call.getFuncDesig().getDesignator().obj;
        	if (called.getName().equals("len")) Code.put(Code.arraylength);
        	Code.put(Code.call);
        	Code.put2(called.getAdr() - Code.pc);
    	}
    	if (Tab.noType != call.getFuncDesig().getDesignator().obj.getType()) Code.put(Code.pop);
    	callingStack.pop();
    }
    
    public void visit(Param param) {
    	if (methodsInClass.contains(callingStack.peek())) {
    		Code.put(Code.dup_x1);
    		Code.put(Code.pop);
    	}
    }
    
	public void visit(FactorActPars call) {
		if (methodsInClass.contains(call.getFuncDesig().getDesignator().obj)) {
    		Code.put(Code.getfield);
        	Code.put2(0);
        	Code.put(Code.invokevirtual);
        	String name = call.getFuncDesig().getDesignator().obj.getName();
        	for (int i = 0; i < name.length(); i++) {
        		Code.put4(name.charAt(i));
        	}
        	Code.put4(-1);
    	} else {
    		Obj called = call.getFuncDesig().getDesignator().obj;
        	if (called.getName().equals("len")) Code.put(Code.arraylength);
        	Code.put(Code.call);
        	Code.put2(called.getAdr() - Code.pc);
    	}
    	callingStack.pop();
    }
	
	public void visit(DesignatorStmtAssign assign) {
		Code.store(assign.getDesignator().obj);
	}
	
	public void visit(DesignatorStmtInc inc) {
		if (inc.getDesignator().obj.getKind() == Obj.Fld) Code.put(Code.dup);
		else if (inc.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		Code.load(inc.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(inc.getDesignator().obj);
	}
	
	public void visit(DesignatorStmtDec dec) {
		if (dec.getDesignator().obj.getKind() == Obj.Fld) Code.put(Code.dup);
		else if (dec.getDesignator().obj.getKind() == Obj.Elem) Code.put(Code.dup2);
		Code.load(dec.getDesignator().obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(dec.getDesignator().obj);
	}
	
	List<Obj> assignList = new ArrayList<>();
	
	public void visit(NoOptionalDesignator dsg) {
		assignList.add(null);
	}
	
	public void visit(OptionalDesignatorX dsg) {
		assignList.add(dsg.getDesignator().obj);
	}
	
	public void visit(SecondTypeDesignatorStmt dsgArrayAssign) {
		Code.loadConst(assignList.size());
		Code.load(dsgArrayAssign.getDesignator().obj);
		Code.put(Code.arraylength);
		Code.put(Code.jcc + Code.le);
    	Code.put2(5);
    	Code.put(Code.trap);
    	Code.put(2);
    	for (Obj obj : assignList) {
    		if (obj != null) {
    			Code.load(dsgArrayAssign.getDesignator().obj);
    			Code.loadConst(assignList.indexOf(obj));
    			Code.put(Code.aload);
    			Code.store(obj);
    		}
    	}
    	assignList.clear();
	}
	
	
}
