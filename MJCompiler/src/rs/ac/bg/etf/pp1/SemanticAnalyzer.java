package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int paramCount = 0;
	Obj currentMethod = null;
	Obj overrided = null;
	String currentMethodName = "";
	boolean returnFound = false;
	boolean errorDetected = false;
	boolean arrayType = false;
	int nVars;
	int loop = 0;
	
	public Struct booleanType = new Struct(Struct.Bool);
	
	Struct currentType = null;
	String subclass = "";
	Struct subclassType = null;
	String superclass = "";
	Struct superclassType = null;
	public HashMap<Struct, String> allClasses = new HashMap<>();
	
	Obj iterating = null;
	Obj currentDesignator = null;
	
	boolean inConstructor = false;
	
	Logger log = Logger.getLogger(getClass());
	
	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", booleanType));
	}

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
    
    public boolean passed(){
    	return !errorDetected;
    }
    
    /* PROGRAM START AND END */
    
    boolean hasMainMethod = false;
    
    public void visit(ProgName progName){
    	progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
    	Tab.openScope();
    }
    
    public void visit(Program program) {
    	nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(program.getProgName().obj);
    	Tab.closeScope();
    	
    	if (!hasMainMethod) report_error("Greska: program ne sadrzi main metodu!", program);
    }
    
    /* TYPE  VISIT */
    
    public void visit(Type type) {
    	String name = type.getName();
    	
    	if (Tab.find(name) == Tab.noObj) {
    		report_error("Tip " + name + " ne postoji u tabeli simbola!", null);
    		type.struct = currentType = Tab.noType;
    		return;
    	}
    	
    	Obj node = Tab.find(name);
    	
    	if(Obj.Type == node.getKind()){
			type.struct = currentType = node.getType();
		} else {
			report_error("Ime " + name + " ne predstavlja tip!", type);
			type.struct = currentType = Tab.noType;
		}
    	
    } 
    
    /* GLOBAL CONST DECLARATION */
    
    public void visit(FirstConstNum numConst) {
    	numConst.struct = Tab.intType;
    }
    
    public void visit(FirstConstChar charConst) {
    	charConst.struct = Tab.charType;
    }
    
    public void visit(FirstConstBool boolConst) {
    	boolConst.struct = Tab.find("bool").getType();
    }
    
    public void visit(ConstTailX constTailX) {
    	String constName = constTailX.getName();
    	Obj found = Tab.find(constName);
    	
    	if (found != Tab.noObj) {
    		report_error("Vec postoji konstanta sa ovim imenom!", constTailX);
    		return; 
    	}
    	
    	if (!constTailX.getFirstConst().struct.assignableTo(currentType)) {
    		report_error("Tip i vrednost nisu kompatibilni u deklaraciji konstante!", constTailX);
    		return;
    	}
    	
    	Obj obj = Tab.insert(Obj.Con, constName, currentType);
    	report_info("Konstanta definisana!", constTailX);
    	
    	FirstConst fc = constTailX.getFirstConst();
    	
    	if (fc.getClass() == FirstConstNum.class) {
    		obj.setAdr(((FirstConstNum) fc).getValue());
    	} else if (fc.getClass() == FirstConstChar.class) {
    		obj.setAdr(((FirstConstChar) fc).getValue());
    	} else if (fc.getClass() == FirstConstBool.class) {
    		obj.setAdr(((FirstConstBool) fc).getValue() == true ? 1 : 0);
    	}
    }
    
    public void visit(ConstDeclX constDeclX) {
    	String constName = constDeclX.getName();
    	Obj found = Tab.find(constName);
    	
    	if (found != Tab.noObj) {
    		report_error("Vec postoji konstanta sa ovim imenom!", constDeclX);
    		return; 
    	}
    	
    	if (!constDeclX.getFirstConst().struct.assignableTo(currentType)) {
    		report_error("Tip i vrednost nisu kompatibilni u deklaraciji konstante!", constDeclX);
    		return;
    	}
    	
    	Obj obj = Tab.insert(Obj.Con, constName, currentType);
    	report_info("Konstanta definisana!", constDeclX);
    	
    	FirstConst fc = constDeclX.getFirstConst();
    	
    	if (fc.getClass() == FirstConstNum.class) {
    		obj.setAdr(((FirstConstNum) fc).getValue());
    	} else if (fc.getClass() == FirstConstChar.class) {
    		obj.setAdr(((FirstConstChar) fc).getValue());
    	} else if (fc.getClass() == FirstConstBool.class) {
    		obj.setAdr(((FirstConstBool) fc).getValue() == true ? 1 : 0);
    	}
    }
    
    /* GLOBAL VAR DECLARATION */
    
    public void visit(FirstGlobalVarDeclArrayIdent globalArrayVar) {
    	String varName = globalArrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj) {
    		report_error("Vec postoji globalna promenljiva sa ovim imenom!", globalArrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana globalna promenljiva (niz)!", globalArrayVar);
    }
    
    public void visit(FirstGlobalVarDeclIdentOnly globalVar) {
    	String varName = globalVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj) {
    		report_error("Vec postoji globalna promenljiva sa ovim imenom!", globalVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana globalna promenljiva!", globalVar);
		nVars++;
    }
    
    /* CLASS VAR DECLARATION */
    
    public void visit(FirstClassVarDeclArrayIdent classArrayVar) {
    	String varName = classArrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {  
    		report_error("Vec postoji promenljiva klase sa ovim imenom!", classArrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana promenljiva klase (niz)!", classArrayVar);
    }
    
    public void visit(FirstClassVarDeclIdentOnly classVar) {
    	String varName = classVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji promenljiva klase sa ovim imenom!", classVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana promenljiva klase!", classVar);
    }
    
    /* LOCAL VAR DECLARATION */
    
    public void visit(FirstVarDeclArrayIdent arrayVar) {
    	String varName = arrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && obj.getLevel() != 0) {  // OBRATI PAZNJU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		report_error("Vec postoji lokalna promenljiva sa ovim imenom!", arrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana lokalna promenljiva (niz)!", arrayVar);
    }
    
    public void visit(FirstVarDeclIdentOnly var) {
    	String varName = var.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && obj.getLevel() != 0) {
    		report_error("Vec postoji lokalna promenljiva sa ovim imenom!", var);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana lokalna promenljiva!", var);
    }
    
    /* CLASS DECLARATION START */
    
    public void visit(ClassDeclStart classDeclStart) {
    	String varName = classDeclStart.getClassName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj) {
    		report_error("Vec postoji klasa ili promenljiva sa ovim imenom!", classDeclStart);
    		subclass = superclass = "";
    		subclassType = superclassType = Tab.noType;
    		classDeclStart.obj = Tab.noObj;
    		Tab.openScope();
    		return;
    	}
    	
    	superclassType = classDeclStart.getExtension().struct;
    	superclass = allClasses.get(superclassType);
    	subclassType = new Struct(Struct.Class);
    	subclass = varName;
    	subclassType.setElementType(superclassType);
    	
    	classDeclStart.obj = Tab.insert(Obj.Type, varName, subclassType);
    	Tab.openScope();
    	
    	report_info("Kreirana je klasa " + varName + "!", classDeclStart);
    	
    	// VIRTUAL FUNCTION TABLE
    	
    	Tab.insert(Obj.Fld, "VFT", Tab.intType);
    	
    	// COPY FIELDS FROM SUPERCLASS
    	
    	if (superclassType != Tab.noType) {
    		for (Obj field: superclassType.getMembers()) {
        		if (field.getName().equals("VFT") || field.getName().equals(superclass)) continue;
        		if (field.getKind() == Obj.Fld) 
        			Tab.insert(Obj.Fld, field.getName(), field.getType());
        		if (field.getKind() == Obj.Meth) 
        			Tab.currentScope().addToLocals(field);
        	}
    	}

    }
    
    /* CLASS DECLARATION SUCCESSFUL END */
    
    public void visit(ClassDecl classDecl) {
    	allClasses.put(subclassType, subclass);
    	Tab.chainLocalSymbols(subclassType);
    	Tab.closeScope();
    	subclass = superclass = "";
    	subclassType = superclassType = null;
    }
    
    /* EXTENSION */
    
    public void visit(NoExtension extension) {
    	extension.struct = Tab.noType;
    }
    
    public void visit(ExtensionX extension) {
    	String typeName = extension.getType().getName();
    	Obj obj = Tab.find(typeName);
    	
    	if (obj == Tab.noObj) {
    		extension.struct = Tab.noType;
    		report_error("Ne postoji zadata natklasa!", extension);
    		return;
    	}
    	
    	if (allClasses.getOrDefault(obj.getType(), null) == null) {
    		report_error("Zadata natklasa nije zapravo klasa!", extension);
    		extension.struct = Tab.noType;
    		return;
    	}
    	
    	extension.struct = obj.getType();
    }
    
    /* CONSTRUCTOR DECLARATION */
    
    public void visit(ConstructorDeclStart constructorStart) {
    	String constructorName = constructorStart.getConstructorName();
    	inConstructor = true;
    	
    	if (!constructorName.equals(subclass)) {
    		report_error("Ime konstruktora se ne poklapa sa imenom okruzujuce klase!", null);
    		constructorStart.obj = Tab.noObj;
    		currentMethod = Tab.noObj;
    		Tab.openScope();
    		return;
    	}
    	
    	constructorStart.obj = currentMethod = Tab.insert(Obj.Meth, constructorName, Tab.noType);
    	Tab.openScope();
    	Tab.insert(Obj.Var, "this", subclassType);
    	paramCount++;  	
    }
    
    public void visit(FirstConstructorDecl constructorDecl) {
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	inConstructor = false;
    	paramCount = 0;
    	currentMethod = null;
    	
    	report_info("Definisan konstruktor klase!", null);
    }
    
    public void addDefaultConstructor() {
      	currentMethod = Tab.insert(Obj.Meth, subclass, Tab.noType);
    	Tab.openScope();
    	Tab.insert(Obj.Var, "this", subclassType);
    	paramCount++;
    	inConstructor = true;
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	paramCount = 0;
    	inConstructor = false;
    	currentMethod = null;
    	report_info("Definisan podrazumevani konstruktor klase!", null);
    }
    
    public void visit(ListsMet lists) {
    	addDefaultConstructor();
    }
    
    /*public void visit(ListsMetVoid lists) {
    	addDefaultConstructor();
    }*/
    
    public void visit(ListsNoConNoMet lists) {
    	addDefaultConstructor();
    }
    
    /* METHOD DECLARATION */
    
    public void visit(MethodDecl2 methodDeclaration) {
    	if (currentMethod.getType() != Tab.noType && !returnFound) {
    		report_error("Metoda " + currentMethodName + " nema return naredbu!", null);
    	}
    	
    	if (currentMethodName.equals("main") && paramCount > 0) {
    		report_error("Metoda main ne sme da ima parametre!", null);
    	}
    	
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	
    	if (overrided != null) {
    		if (overrided.getLevel() != currentMethod.getLevel()) {
    			report_error("Metod " + currentMethodName + " ne preklapa dobro, jer nije isti po broju parametara!", methodDeclaration);
    		} else {
    			ArrayList<Obj> overridedParams = new ArrayList<>(overrided.getLocalSymbols());
    			ArrayList<Obj> currentParams = new ArrayList<>(currentMethod.getLocalSymbols());
    			
    			for (int i = 0; i < overridedParams.size(); i++) {
    				if (i != 0 && overridedParams.get(i).getType() != currentParams.get(i).getType()) {
    					report_error("Metod " + currentMethodName + " ima pogresan tip parametra sa rednim brojem " + i + "!", methodDeclaration);
    				}
    			}
    		}
    	}
    	
    	Tab.closeScope();
    	paramCount = 0;
    	returnFound = false;
    	currentMethod = overrided = null;
    	currentMethodName = "";
    }
    
    public void visit(OptionalSquaresX optSquares) {
    	arrayType = true;
    }
    
    public void visit(IdentSquaresX param) {
    	String paramName = param.getName();
    	Obj obj = Tab.find(paramName);
    	paramCount++;
    	
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(paramName) != null) {
    		report_error("Parametar " + paramName + " se vec nalazi u listi formalnih parametara!", param);
    		return;
    	}
    	
    	if (arrayType) {
    		Tab.insert(Obj.Var, paramName, new Struct(Struct.Array, currentType));
    	} else {
    		Tab.insert(Obj.Var, paramName, currentType);
    	}  	
    	arrayType = false;
    }
    
    public void visit(MethodStartType methodStart) {
    	String name = methodStart.getName();
    	Obj obj = Tab.currentScope().findSymbol(name);
    	
    	if (obj != null && subclassType == null) {
    		report_error("Metoda sa imenom " + name + " je vec deklarisana!", null);
    		currentMethod = Tab.noObj;
    		methodStart.obj = Tab.noObj;
    		Tab.openScope();
    		return;
    	} else if (obj != null) overrided = obj;
    	
    	if (overrided != null) {
    		Tab.currentScope().getLocals().deleteKey(name);
    	}
    	
    	currentMethod = Tab.insert(Obj.Meth, name, methodStart.getType().struct);
    	methodStart.obj = currentMethod;
    	Tab.openScope();
    	
    	if(subclassType != null) {
    		paramCount++;
    		Tab.insert(Obj.Var, "this", subclassType);
			report_info("Metoda sa nazivom " + name + " definisana u klasi " + subclass + "!", methodStart);
		} else {
			report_info("Definisana funkcija sa nazivom " + name, methodStart);
		}
    }
    
    public void visit(MethodStartVoid methodStart) {
    	String name = methodStart.getName();
    	Obj obj = Tab.currentScope().findSymbol(name);
    	
    	if (obj != null && subclassType == null) {
    		report_error("Metoda sa imenom " + name + " je vec deklarisana!", null);
    		currentMethod = Tab.noObj;
    		methodStart.obj = Tab.noObj;
    		Tab.openScope();
    		return;
    	} else if (obj != null) overrided = obj;
    	
    	if (overrided != null) {
    		Tab.currentScope().getLocals().deleteKey(name);
    	}
    	
    	currentMethod = Tab.insert(Obj.Meth, name, Tab.noType);
    	methodStart.obj = currentMethod;
    	Tab.openScope();
    	
    	if(subclassType != null) {
    		paramCount++;
    		Tab.insert(Obj.Var, "this", subclassType);
			report_info("Metoda sa nazivom " + name + " definisana u klasi " + subclass + "!", methodStart);
		} else {
			report_info("Definisana funkcija sa nazivom " + name, methodStart);
		}
    }
    
    /*public void visit(OptionalExprX returnExpr) {
    	hasReturnType = true;
    	returnType = returnExpr.struct;
    }*/
    
    // TODO: return naredba, globalne metode (jer sam ih razdvojio od klasnih)
    
    /* WHILE, BREAK, CONTINUE, FOREACH */
    
    public void visit(WhileStmtStart whileStart) {
    	loop++;
    }
    
    public void visit(WhileStmt whileEnd) {
    	loop--;
    }
    
    public void visit(BreakStmt breakStmt) {
    	if (loop > 0) return;
    	report_error("Break naredba nije unutar petlje!", breakStmt);
    }
    
    public void visit(ContinueStmt continueStmt) {
    	if (loop > 0) return;
    	report_error("Continue naredba nije unutar petlje!", continueStmt);
    }
    
    public void visit(DesignatorFE foreachDesignator) {
    	Obj obj = foreachDesignator.getDesignatorStart().obj;
    	loop++;
    	
    	if (obj.getType().getKind() != Struct.Array) {
    		report_error("Foraech petlja moze samo da se pozove nad nizom!", foreachDesignator);
    		foreachDesignator.struct = Tab.noType;
    	}
    	else {
    		foreachDesignator.struct = obj.getType().getElemType();
    	}
    	
    }
    
    public void visit(FEVar foreachVariable) {
    	String name = foreachVariable.getName();
    	Obj obj = Tab.find(name);
    	
    	if (obj == Tab.noObj) {
    		report_error("Promenljiva sa nazivom " + name + " nije prethodno deklarisana!", foreachVariable);
    		foreachVariable.obj = Tab.noObj;
    		return;
    	}
    	
    	foreachVariable.obj = obj;
    	
    	if (obj.getKind() != Obj.Var) {
    		report_error("Varijabla u foreach petlji mora biti promenljiva!", foreachVariable);
    		foreachVariable.obj = Tab.noObj;
    	} else {
    		iterating = obj;
    	}
    }
    
    public void visit(ForeachStmt foreach) {
    	if (iterating.getType() != foreach.getDesignatorFE().struct) {
    		report_error("Postoji nepoklapanje izmedju tipa elementa niza i iterirajuce varijable!", foreach);
    	}
    	iterating = null;
    	loop--;
    }
    
    /* PRINT, READ */
    
    public void visit(PrintStmt printStmt) {
    	Struct type = printStmt.getExpr().struct;
    	if (type != booleanType && type != Tab.intType && type != Tab.charType) report_error("Prvi argument mora biti int, char ili boolean!", printStmt);
    }
    
    public void visit(ReadStmt readStmt) {
    	Designator d = readStmt.getDesignator();
    	Obj obj = d.obj;
    	Struct type = obj.getType();
    	int kind = obj.getKind();
    	
    	if (kind != Obj.Elem && kind != Obj.Var && kind != Obj.Fld) {
    		report_error("Izraz mora biti promenljiva, element niza ili polje objekta!", readStmt);
    	} else if (type != Tab.intType && type != Tab.charType && type != booleanType) {
    		report_error("Izraz mora biti tipa int, char ili boolean!", readStmt);
    	}  	
    }
    
    /* DESIGNATOR */
    
    public void visit(DesignatorStart dStart) {
    	String name = dStart.getName();
    	Obj obj = Tab.find(name);
    	
    	if (obj == Tab.noObj) {
    		report_error("Koristi se nedeklarisana promenljiva " + name + "!", dStart);
    		dStart.obj = Tab.noObj;
    		return;
    	} else {
    		dStart.obj = obj;
    	}
    	
    	int kind = obj.getKind();
    	currentDesignator = obj;
    	
    	if (kind == Obj.Var) {
    		report_info("Pristup promenljivoj/parametru " + name + "!", dStart);
    		return;
    	}
    	
    	if (kind == Obj.Con) {
    		report_info("Pristup konstanti " + name + "!", dStart);
    		return;
    	}	
    }
    
    public void visit(IdentExprListExpr arrayDesignator) {
    	Obj obj = arrayDesignator.getIdentExprList().obj;
    	Expr expr = arrayDesignator.getExpr();
    	
    	if (expr.struct != Tab.intType) {
    		report_error("Nekompatibilan tip za indeksiranje - mora biti ceo broj!", arrayDesignator);
    		arrayDesignator.obj = Tab.noObj;
    	} else if (currentDesignator != null) {
    		if (currentDesignator.getType().getKind() != Struct.Array) {
    			report_error("Promenljiva " + currentDesignator.getName() + " kojoj se pristupa nije niz!", arrayDesignator);
    			arrayDesignator.obj = Tab.noObj;
    		} else {
    			arrayDesignator.obj = new Obj(Obj.Elem, currentDesignator.getName(), currentDesignator.getType().getElemType());
    		}
    	} else if (obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva " + currentDesignator.getName() + " kojoj se pristupa nije niz!", arrayDesignator);
			arrayDesignator.obj = Tab.noObj;
    	} else {
			arrayDesignator.obj = new Obj(Obj.Elem, obj.getName(), obj.getType().getElemType());
		}
    	
    	currentDesignator = null;
    }
    
    public void visit(IdentExprListIdent fieldDesignator) {
    	
    	currentDesignator = null;
    }
    
    /* FACTOR */
    
    public void visit(FactorActPars functionCall) {
    	Designator d = functionCall.getDesignator();
    	
    	if (d.obj.getKind() != Obj.Meth) {
    		report_error("Poziv metode mora pozvati metodu koja je deklarisana!", functionCall);
    		functionCall.struct = Tab.noType;
    	} else {
    		report_info("Poziv metode/funkcije " + d.obj.getName(), functionCall);
    		functionCall.struct = d.obj.getType();
    	}
    }
    
    public void visit(FactorExpr factor) {
    	factor.struct = factor.getExpr().struct;
    }
    
    public void visit(FactorNumConst fnc) {
    	fnc.struct = Tab.intType;
    }
    
    public void visit(FactorCharConst fcc) {
    	fcc.struct = Tab.charType;
    }
    
    public void visit(FactorBoolConst fbc) {
    	fbc.struct = booleanType;
    }
    
    public void visit(FactorDesignatorOnly factor) {
    	factor.struct = factor.getDesignator().obj.getType();
    }
    
    public void visit(FactorNew factor) {
    	if (factor.getType().struct.getKind() != Struct.Class) {
    		report_error("Operator new se moze pozivati samo za klasne tipove!",factor);
    		factor.struct = Tab.noType;
    	} else {
    		report_info("Kreiran je objekat klase!", factor);
    		factor.struct = factor.getType().struct;
    	}
    }
    
    public void visit(FactorNewArray factor) {
    	if (factor.getType().struct.getKind() != Struct.Class) {
    		report_error("Operator new se moze pozivati samo za klasne tipove!",factor);
    		factor.struct = Tab.noType;
    	} else {
    		if (factor.getExpr().struct != Tab.intType) {
    			report_error("Velicina mora biti int tipa!", factor);
    			factor.struct = Tab.noType;
    		}
    		else {
    			report_info("Kreiran je niz objekata klase!", factor);
        		factor.struct = new Struct(Struct.Array, factor.getType().struct);
    		}
    	}
    }
    
    
}
