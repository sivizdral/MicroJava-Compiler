package rs.ac.bg.etf.pp1;

import java.util.HashMap;
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
	
	public void visit(FactorActPars functionCall) {
		
    }
    
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
    }
    
    public void visit(MethodStartType methodStart) {
    	methodStart.obj.setAdr(Code.pc);
    	Code.put(Code.enter);
    	Code.put(methodStart.obj.getLevel());
    	Code.put(methodStart.obj.getLocalSymbols().size());
    }

}
