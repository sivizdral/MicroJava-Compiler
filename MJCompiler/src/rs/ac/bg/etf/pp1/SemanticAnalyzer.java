package rs.ac.bg.etf.pp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
	public static int nVars;
	int loop = 0;
	
	public static Struct booleanType = new Struct(Struct.Bool);
	
	Struct currentType = null;
	String subclass = "";
	Struct subclassType = null;
	String superclass = "";
	Struct superclassType = null;
	public HashMap<Struct, String> allClasses = new HashMap<>();
	
	Obj iterating = null;
	Obj currentDesignator = null;
	
	Logger log = Logger.getLogger(getClass());
	
	public SemanticAnalyzer() {
		Tab.currentScope.addToLocals(new Obj(Obj.Type, "bool", booleanType));
		globals.add(Tab.find("chr"));
		globals.add(Tab.find("ord"));
		globals.add(Tab.find("len"));
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
    		report_error("Tip " + name + " ne postoji u tabeli simbola!", type);
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
    		report_error("Vec postoji konstanta sa imenom " + constName + "!", constTailX);
    		return; 
    	}
    	
    	if (!constTailX.getFirstConst().struct.assignableTo(currentType)) {
    		report_error("Tip i vrednost nisu kompatibilni u deklaraciji konstante!", constTailX);
    		return;
    	}
    	
    	Obj obj = Tab.insert(Obj.Con, constName, currentType);
    	report_info("Konstanta " + constName + " definisana!", constTailX);
    	
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
    		report_error("Vec postoji konstanta sa imenom " + constName + "!", constDeclX);
    		return; 
    	}
    	
    	if (!constDeclX.getFirstConst().struct.assignableTo(currentType)) {
    		report_error("Tip i vrednost nisu kompatibilni u deklaraciji konstante!", constDeclX);
    		return;
    	}
    	
    	Obj obj = Tab.insert(Obj.Con, constName, currentType);
    	report_info("Konstanta " + constName + " definisana!", constDeclX);
    	
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
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji globalna promenljiva sa imenom " + varName + "!", globalArrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana globalna promenljiva (niz) " + varName + "!", globalArrayVar);
    }
    
    public void visit(FirstGlobalVarDeclIdentOnly globalVar) {
    	String varName = globalVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji globalna promenljiva sa imenom " + varName + "!", globalVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana globalna promenljiva " + varName + "!", globalVar);
		//nVars++;
    }
    
    /* CLASS VAR DECLARATION */
    
    public void visit(FirstClassVarDeclArrayIdent classArrayVar) {
    	String varName = classArrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {  
    		report_error("Vec postoji promenljiva klase sa imenom " + varName + "!", classArrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Fld, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana promenljiva klase (niz) " + varName + "!", classArrayVar);
    }
    
    public void visit(FirstClassVarDeclIdentOnly classVar) {
    	String varName = classVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji promenljiva klase sa imenom " + varName + "!", classVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Fld, varName, currentType);
		report_info("Deklarisana promenljiva klase " + varName + "!", classVar);
    }
    
    /* LOCAL VAR DECLARATION */
    
    public void visit(FirstVarDeclArrayIdent arrayVar) {
    	String varName = arrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji lokalna promenljiva sa imenom " + varName +"!", arrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana lokalna promenljiva (niz) " + varName + "!", arrayVar);
    }
    
    public void visit(FirstVarDeclIdentOnly var) {
    	String varName = var.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && Tab.currentScope.findSymbol(varName) != null) {
    		report_error("Vec postoji lokalna promenljiva sa imenom " + varName + "!", var);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana lokalna promenljiva " + varName + "!", var);
    }
    
    /* CLASS DECLARATION START */
    
    HashMap<Obj, List<Obj>> constructors = new HashMap<>();
    
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
        		if (field.getKind() == Obj.Fld) {
        			Tab.insert(Obj.Fld, field.getName(), field.getType());
        		}
        		if (field.getKind() == Obj.Meth) {
        			if (field.getName().split("-")[0].equals(superclass)) continue;
        			Tab.currentScope().addToLocals(field);
        		}
        	}
    	}

    }
    
    /* CLASS DECLARATION SUCCESSFUL END */
    
    public void visit(ClassDecl classDecl) {
    	constructors.clear();
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
    	
    	if (!constructorName.equals(subclass)) {
    		report_error("Ime konstruktora se ne poklapa sa imenom okruzujuce klase!", null);
    		constructorStart.obj = Tab.noObj;
    		currentMethod = Tab.noObj;
    		Tab.openScope();
    		return;
    	}
    	
    	constructorName += "-" + constructors.size();
    	
    	constructorStart.obj = currentMethod = Tab.insert(Obj.Meth, constructorName, Tab.noType);
    	Tab.openScope();
    	Tab.insert(Obj.Var, "this", subclassType);
    	paramCount++;  	
    }
    
    List<Obj> params = new ArrayList<>();
    
    public void visit(FirstConstructorDecl constructorDecl) {
    	boolean exists = false;
    	for (Map.Entry<Obj, List<Obj>> entry : constructors.entrySet()) {
    		if (entry.getValue().size() != params.size()) continue;
    		int size = entry.getValue().size();
    		boolean same = true;
    		for (int i = 0; i < size; i++) {
    			Obj obj = entry.getValue().get(i);
    			Obj param = params.get(i);
    			if (!obj.getType().equals(param.getType())) {
    				same = false;
    				break;
    			}
    		}
    		if (same) {
    			exists = true;
    			break;
    		}
    	}
    	
    	if (exists) report_error("U klasi je vec definisan konstruktor sa zadatim parametrima!", constructorDecl);
    	else {
    		report_info("Definisan konstruktor klase " + subclass + "!", null);
    		constructors.put(currentMethod, params);
    	}
    	
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	
    	params = new ArrayList<>();
    	paramCount = 0;
    	currentMethod = null;
    }
    
    public void addDefaultConstructor() {
      	currentMethod = Tab.insert(Obj.Meth, subclass, Tab.noType);
    	Tab.openScope();
    	Tab.insert(Obj.Var, "this", subclassType);
    	paramCount++;
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	Tab.closeScope();
    	paramCount = 0;
    	currentMethod = null;
    	report_info("Definisan podrazumevani konstruktor klase" + subclass + "!", null);
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
    
    /* METHOD DECLARATION */
    
    public void visit(MethodDecl2 methodDeclaration) {
    	methodDeclaration.obj = currentMethod;
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
    		obj = Tab.insert(Obj.Var, paramName, new Struct(Struct.Array, currentType));
    		report_info("Deklarisan parametar (niz) " + paramName + "!", param);
    	} else {
    		obj = Tab.insert(Obj.Var, paramName, currentType);
    		report_info("Deklarisan parametar " + paramName + "!", param);
    	}  	
    	
    	params.add(obj);
    	arrayType = false;
    }
    
    public void visit(NoFormParsOptional nopars) {
    	params.clear();
    }
    
    public void visit(MethodStartType methodStart) {
    	String name = methodStart.getName();
    	Obj obj = Tab.currentScope().findSymbol(name);
    	
    	currentMethodName = name;
    	
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
    	
    	currentMethodName = name;
    	
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
    	
    	if (name.equals("main")) {
    		hasMainMethod = true;
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
    
    /* GLOBAL METHOD DECL */
    
    List<Obj> globals = new ArrayList<>();
    
    public void visit(MethodDecl methodDeclaration) {
    	methodDeclaration.obj = currentMethod;
    	if (currentMethod.getType() != Tab.noType && !returnFound) {
    		report_error("Funkcija " + currentMethodName + " nema return naredbu!", null);
    	}
    	
    	if (currentMethodName.equals("main") && paramCount > 0) {
    		report_error("Funkcija main ne sme da ima parametre!", null);
    	}
    	
    	currentMethod.setLevel(paramCount);
    	Tab.chainLocalSymbols(currentMethod);
    	
    	globals.add(currentMethod);
    	
    	/*if (overrided != null) {
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
    	}*/
    	
    	Tab.closeScope();
    	paramCount = 0;
    	returnFound = false;
    	currentMethod = overrided = null;
    	currentMethodName = "";
    }
    
    /* RETURN */
    
    public void visit(OptionalExprX returnExpr) {
    	if (currentMethod == null || currentMethod == Tab.noObj) {
    		report_error("Return se ne nalazi unutar funkcije/metoda!", returnExpr);
    		returnExpr.struct = Tab.noType;
    		return;
    	}
    	
		returnFound = true;
		
		if (currentMethod.getType() == Tab.noType) {
			report_error("Return je tipiziran, a metoda/funkcija je void povratnog tipa!", returnExpr);
    		returnExpr.struct = Tab.noType;
    		return;
		}
		
		if (currentMethod.getType() != returnExpr.getExpr().struct) {
			report_error("Return vraca pogresan povratni tip!", returnExpr);
    		returnExpr.struct = Tab.noType;
    		return;
		}
		
		returnExpr.struct = returnExpr.getExpr().struct;
		report_info("Return naredba!", returnExpr);
    }
    
    public void visit(NoOptionalExpr returnExpr) {
    	if (currentMethod == null || currentMethod == Tab.noObj) {
    		report_error("Return se ne nalazi unutar funkcije/metoda!", returnExpr);
    		returnExpr.struct = Tab.noType;
    		return;
    	}

    	returnFound = true;
    	returnExpr.struct = Tab.noType;
    	
    	if (currentMethod.getType() != Tab.noType) {
    		report_error("Return ne vraca tip, a metoda nije void!", returnExpr);
    		returnExpr.struct = Tab.noType;
    		return;
    	}
    	
    	report_info("Return naredba!", returnExpr);
    }
    
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
    
    List<Obj> designators = new ArrayList<>();
    
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
    	designators.add(obj);
    	//currentDesignator = obj;
    	
    	if (kind == Obj.Var) {
    		report_info("Pristup promenljivoj/parametru " + name + "!", dStart);
    		return;
    	}
    	
    	if (kind == Obj.Con) {
    		report_info("Pristup konstanti " + name + "!", dStart);
    		return;
    	}	
    }
    
    boolean hasList = false;
    
    public void visit(Designator d) {
    	if (!hasList)
    		d.obj = d.getDesignatorStart().obj;
    	else d.obj = d.getIdentExprList().obj;
    	hasList = false;
    	designators.remove(designators.size() - 1);
    }
    
    public void visit(IdentExprListExpr arrayDesignator) {
    	Obj obj = arrayDesignator.getLeftIdent().getIdentExprList().obj;
    	Expr expr = arrayDesignator.getExpr();
    	hasList = true;
    	
    	currentDesignator = designators.remove(designators.size() - 1);
    	
    	
    	if (expr.struct != Tab.intType) {
    		report_error("Nekompatibilan tip za indeksiranje - mora biti ceo broj!", arrayDesignator);
    		arrayDesignator.obj = Tab.noObj;
    	} else if (currentDesignator != null) {
    		if (currentDesignator.getType().getKind() != Struct.Array) {
    			report_error("Promenljiva " + currentDesignator.getName() + " kojoj se pristupa nije niz!", arrayDesignator);
    			arrayDesignator.obj = Tab.noObj;
    		} else {
    			arrayDesignator.obj = new Obj(Obj.Elem, currentDesignator.getName(), currentDesignator.getType().getElemType());
    			designators.add(arrayDesignator.obj);
    		}
    	} else if (obj.getType().getKind() != Struct.Array) {
    		report_error("Promenljiva " + currentDesignator.getName() + " kojoj se pristupa nije niz!", arrayDesignator);
			arrayDesignator.obj = Tab.noObj;
    	} else {
			arrayDesignator.obj = new Obj(Obj.Elem, obj.getName(), obj.getType().getElemType());
			designators.add(arrayDesignator.obj);
		}
    	
    	currentDesignator = null;
    	
    }
    
    public void visit(IdentExprListIdent fieldDesignator) {
    	hasList = true;
    	
    	currentDesignator = designators.remove(designators.size() - 1);
    	
    	if (currentDesignator == null || currentDesignator == Tab.noObj) {
    		fieldDesignator.obj = Tab.noObj;
    		return;
    	}
    	
    	if (currentDesignator.getType().getKind() != Struct.Class) {
    		report_error("Poziv se moze vrsiti samo nad nekim objektom ili klasom, a " + currentDesignator.getName() + " to nije!", fieldDesignator);
    		fieldDesignator.obj = Tab.noObj;
    		return;
    	}
    	
    	if (currentDesignator.getType() == subclassType) {
    		Obj obj = Tab.currentScope().getOuter().findSymbol(fieldDesignator.getField());
    		
    		if (obj == null) {
    			report_error("Polje " + fieldDesignator.getField() + " ne postoji u klasi " + subclass + "!", fieldDesignator);
    			fieldDesignator.obj = Tab.noObj;
    			return;
    		} else {
    			report_info("Pristupa se polju " + fieldDesignator.getField() + " klase " + subclass + "!", fieldDesignator);
    			designators.add(obj);
    			fieldDesignator.obj = obj;
    			return;
    		}
    	}
    	
    	ArrayList<Obj> arr = new ArrayList<>(currentDesignator.getType().getMembers());
    	
    	for (Obj obj : arr) {
    		if (fieldDesignator.getField().equals(obj.getName())) {
    			report_info("Pristupa se polju/metodi " + obj.getName() + "!", fieldDesignator);
    			designators.add(obj);
    			fieldDesignator.obj = obj;
    			return;
    		}
    	}
    	
    	report_error("Dato ime nije polje/metod date klase!", fieldDesignator);
    	
    	currentDesignator = null;
    }
    
    /*public void visit(NoIdentExprList dsg) {
    	dsg.obj = currentDesignator;
    }*/
    
    /* FACTOR */
    
    public void visit(FactorActPars functionCall) {
    	Designator d = functionCall.getFuncDesig().getDesignator();
    	
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
    	if (factor.getConstructorType().getType().struct.getKind() != Struct.Class) {
    		report_error("Operator new se moze pozivati samo za klasne tipove!",factor);
    		factor.struct = Tab.noType;
    	} else {
    		report_info("Kreiran je objekat klase!", factor);
    		factor.struct = factor.getConstructorType().getType().struct;
    		factor.getConstructorType().obj = calledConstructor;
    		calledConstructor = null;
    	}
    }
    
    public void visit(FactorNewArray factor) {
		if (factor.getExpr().struct != Tab.intType) {
			report_error("Velicina mora biti int tipa!", factor);
			factor.struct = Tab.noType;
		}
		else {
			report_info("Kreiran je niz objekata klase!", factor);
    		factor.struct = new Struct(Struct.Array, factor.getType().struct);
		}
    }
    
    /* ACT PARS */
    
    Stack<Obj> calls = new Stack<>();
    Stack<List<Struct>> pars = new Stack<>();
    Obj calledConstructor = null;
    
    public void visit(Param param) {
    	List<Struct> list = pars.pop();
    	list.add(param.getExpr().struct);
    	pars.push(list);
    }
    
    public void visit(NoOptionalActPars prms) {
    	Obj called = calls.pop();
    	List<Struct> params = pars.pop();
    	String message = "";
    	
    	if (called.getKind() == Obj.Type) {
    		for (Obj mem : called.getType().getMembers()) {
    			if (mem.getName().split("-")[0].equals(called.getName())) {
    				message = "";
    				if (mem.getLevel() != params.size() + 1) {
    					message = "Brojnost formalnih i stvarnih parametara se ne poklapa!" + mem.getLevel() + " " + (params.size() + 1);
    				}
    				else {
    					int ind = 0;
    					for (Obj formal : mem.getLocalSymbols()) {
    						if (!formal.getName().equals("this")) {
    							if (!canBeAssigned(params.get(ind - 1), formal.getType())) {
    								message = "Stvarni i formalni parametar se ne poklapaju (redni broj + " + ind + ")!";
    							}
    						}
    						ind++;
    						if (ind == mem.getLevel()) break;
    					}
    				}
    				if (message.equals("")) {
    					calledConstructor = mem;
    					break;
    				}
    			}
    		}
    		if (!message.equals("")) {
    			report_error(message, null);
    			report_error("Ne postoji konstruktor koji se poklapa sa zadatim parametrima!", prms);
    		}
    	} else if (called.getKind() == Obj.Meth) {
    		message = "";
    		int one = !globals.contains(called) ? 1 : 0;
			if (called.getLevel() != params.size() + one) {
				report_error("Brojnost formalnih i stvarnih parametara se ne poklapa!" + called.getLevel() + " " + (params.size() + 1), prms);
			}
			else {
				int ind = 0;
				for (Obj formal : called.getLocalSymbols()) {
					if (!formal.getName().equals("this")) {
						if (!canBeAssigned(params.get(ind), formal.getType())) {
							report_error("Stvarni i formalni parametar se ne poklapaju (redni broj + " + ind + ")!", prms);
						}
						ind++;
					}
					if (ind == called.getLevel()) break;
				}
			}
    	}
    }
    
    public void visit(ActPars prms) {
    	Obj called = calls.pop();
    	List<Struct> params = pars.pop();
    	String message = "";
    	
    	if (called.getKind() == Obj.Type) {
    		for (Obj mem : called.getType().getMembers()) {
    			if (mem.getName().split("-")[0].equals(called.getName())) {
    				message = "";
    				if (mem.getLevel() != params.size() + 1) {
    					message = "Brojnost formalnih i stvarnih parametara se ne poklapa!";
    				}
    				else {
    					int ind = 0;
    					for (Obj formal : mem.getLocalSymbols()) {
    						if (!formal.getName().equals("this")) {
    							if (!canBeAssigned(params.get(ind - 1), formal.getType())) {
    								message = "Stvarni i formalni parametar se ne poklapaju (redni broj + " + ind + ")!";
    							}
    						}
    						ind++;
    						if (ind == mem.getLevel()) break;
    					}
    				}
    				if (message.equals("")) {
    					calledConstructor = mem;
    					break;
    				}
    			}
    		}
    		if (!message.equals("")) {
    			report_error(message, null);
    			report_error("Ne postoji konstruktor koji se poklapa sa zadatim parametrima!", prms);
    		}
    	} else if (called.getKind() == Obj.Meth) {
    		message = "";
    		int one = !globals.contains(called) ? 1 : 0;
			if (called.getLevel() != params.size() + one) {
				report_error("Brojnost formalnih i stvarnih parametara se ne poklapa!", prms);
			}
			else {
				int ind = 0;
				for (Obj formal : called.getLocalSymbols()) {
					if (!formal.getName().equals("this")) {
						if (!canBeAssigned(params.get(ind), formal.getType())) {
							report_error("Stvarni i formalni parametar se ne poklapaju (redni broj + " + ind + ")!", prms);
						}
						ind++;
					}
					if (ind == called.getLevel()) break;
				}
			}
    	}
    }
    
    public void visit(ConstructorType type) {
    	calls.push(Tab.find(allClasses.get(type.getType().struct)));
    	pars.push(new ArrayList<>());
    }
    
    public void visit(FuncDesig desig) {
    	calls.push(desig.getDesignator().obj);
    	pars.push(new ArrayList<>());
    }
    
    /* COND FACT */
    
    boolean hasRelop = false;
    Expr cfexpr = null;
    
    public void visit(CondFact condFact) {
    	
    	if (!hasRelop && condFact.getExpr().struct != booleanType) {
    		report_error("Uslov nije boolean!", condFact);
    		condFact.struct = Tab.noType;
    		return;
    	}
    	else if (!hasRelop) {
    		condFact.struct = condFact.getExpr().struct;
    		return;
    	}
    	
    	if (!condFact.getExpr().struct.compatibleWith(cfexpr.struct)) {
    		report_error("Izrazi u uslovu su nekompatibilni!", condFact);
    		condFact.struct = Tab.noType;
    		return;
    	}
    	
    	int kind1 = condFact.getExpr().struct.getKind();
    	int kind2 = cfexpr.struct.getKind();
    	
    	if (((kind1 == Struct.Array && kind2 == Struct.Array) || (kind1 == Struct.Class && kind2 == Struct.Class)) && !currentOperator.equals(Op.NEQ) && !currentOperator.equals(Op.EQEQ)) {
    		report_error("Klase i nizovi mogu da se porede samo sa == i !=!", condFact);
    		condFact.struct = Tab.noType;
    		return;
    	}
    	
    	hasRelop = false;
    }
    
    public void visit(OptionalRelopExprX relop) {
    	hasRelop = true;
    	cfexpr = relop.getExpr();
    }
    
    
    /* TERM */
    
    public void visit(TermOne term) {
    	term.struct = term.getFactor().struct;
    }
    
    public void visit(TermFactorList termList) {
    	termList.struct = Tab.intType;
    	
    	if (termList.getTerm().struct != Tab.intType || termList.getFactor().struct != Tab.intType) {
    		report_error("Cinioci moraju biti int!", termList);
    		termList.struct = Tab.noType;
    	}
    }
    
    /* EXPR */
    
    boolean negation = false;
    boolean addition = false;
    
    public void visit(OptMinusX minus) {
    	negation = true;
    }
    
    public void visit(AddopTermListX addopList) {
    	addition = true;
    	
    	if (addopList.getTerm().struct != Tab.intType) {
    		report_error("Ne moze da se sabira izraz koji nije int!", addopList);
    	}
    }
    
    public void visit(Expr expr) {
    	if (expr.getTerm().struct != Tab.intType && negation) {
    		report_error("Ne moze da se negira izraz koji nije int!", expr);
    		expr.struct = Tab.noType;
    		return;
    	}
    	
    	if (expr.getTerm().struct != Tab.intType && addition) {
    		report_error("Ne moze da se sabira izraz koji nije int!", expr);
    		expr.struct = Tab.noType;
    		return;
    	}
    	
    	expr.struct = expr.getTerm().struct;
    	negation = false;
    	addition = false;
    }
    
    /* OPERATORS */
    
    enum Op {
    	EQ,
    	NEQ,
    	EQEQ,
    	GT,
    	GTE,
    	LT,
    	LTE,
    	PLUS,
    	MINUS,
    	MUL,
    	DIV,
    	PROC
    };
    
    Op currentOperator = null;
    
    public void visit(Assignop op) {
    	currentOperator = Op.EQ;
    }
    
    public void visit(RelopEq op) {
    	currentOperator = Op.EQEQ;
    }
    
    public void visit(RelopNE op) {
    	currentOperator = Op.NEQ;
    }
    
    public void visit(RelopGT op) {
    	currentOperator = Op.GT;
    }
    
    public void visit(RelopGTE op) {
    	currentOperator = Op.GTE;
    }
    
    public void visit(RelopLT op) {
    	currentOperator = Op.LT;
    }
    
    public void visit(RelopLTE op) {
    	currentOperator = Op.LTE;
    }
    
    public void visit(AddopP op) {
    	currentOperator = Op.PLUS;
    }
    
    public void visit(AddopM op) {
    	currentOperator = Op.MINUS;
    }
    
    public void visit(MulopM op) {
    	currentOperator = Op.MUL;
    }
    
    public void visit(MulopD op) {
    	currentOperator = Op.DIV;
    }
    
    public void visit(MulopP op) {
    	currentOperator = Op.PROC;
    }
    
    /* DESIGNATOR STATEMENT */
    
    public boolean canBeAssigned(Struct x, Struct y) {
    	if (!x.assignableTo(y)) {
    		int kindx = x.getKind();
    		int kindy = y.getKind();
    		if (kindx == kindy && kindx == Struct.Class) {
    			Struct c = x;
    			while (c != null) {
    				if (c.equals(y)) return true;
    				c = c.getElemType();
    			}
    		}
    			
    		return false;
    	} else return true;
    }
    
    public void visit(DesignatorStmtAssign assign) {
    	int kind = assign.getDesignator().obj.getKind();
    	
    	if (kind != Obj.Elem && kind != Obj.Var && kind != Obj.Fld) {
    		report_error("Dodela se ne moze vrsiti ako sa leve strane nije promenljiva, element ili polje!", assign);
    		return;
    	}
    	
    	if (!canBeAssigned(assign.getExpr().struct, assign.getDesignator().obj.getType())) {
    		report_error("Dodela nije moguca jer tipovi nisu kompatibilni!", assign);
    		return;
    	}
    	
    	if (assign.getDesignator().obj == iterating) {
    		report_error("Nije dozvoljeno u foreach koristiti varijablu za svrhu promene vrednosti!", assign);
    	}
    }
    
    public void visit(DesignatorStmtCall call) {
    	if (call.getFuncDesig().getDesignator().obj.getKind() != Obj.Meth) {
    		report_error("Poziv se mora vrsiti nad funkcijom/metodom!", call);
    		return;
    	}
    }
    
    public void visit(DesignatorStmtInc inc) {
    	int kind = inc.getDesignator().obj.getKind();
    	
    	if (inc.getDesignator().obj.getType() != Tab.intType) {
    		report_error("Samo int tip moze da se inkrementira!", inc);
    		return;
    	}
    	
    	if (kind != Obj.Fld && kind != Obj.Elem && kind != Obj.Var) {
    		report_error("Izraz za inkrementiranje mora biti neka promenljiva, polje ili element!", inc);
    	}
    }
    
    public void visit(DesignatorStmtDec dec) {
    	int kind = dec.getDesignator().obj.getKind();
    	
    	if (dec.getDesignator().obj.getType() != Tab.intType) {
    		report_error("Samo int tip moze da se dekrementira!", dec);
    		return;
    	}
    	
    	if (kind != Obj.Fld && kind != Obj.Elem && kind != Obj.Var) {
    		report_error("Izraz za dekrementiranje mora biti neka promenljiva, polje ili element!", dec);
    	}
    }
    
    List<Obj> assignList = new ArrayList<>();
    
    public void visit(OptionalDesignatorX optdes) {
    	int kind = optdes.getDesignator().obj.getKind();
    	if (kind != Obj.Elem && kind != Obj.Fld && kind != Obj.Var) {
    		report_error("Izraz mora biti neka promenljiva, polje ili element!", optdes);
    		return;
    	}
    	else {
    		assignList.add(optdes.getDesignator().obj);
    	}
    }
    
    public void visit(SecondTypeDesignatorStmt stmt) {
    	if (stmt.getDesignator().obj.getType().getKind() != Struct.Array) {
    		report_error("Desna strana mora biti niz!", stmt);
    		return;
    	}
    	
    	for (Obj obj : assignList) {
    		if (!canBeAssigned(stmt.getDesignator().obj.getType().getElemType(), obj.getType())) {
    			report_error("U nizu postoji nekompatiblinost u dodeli!", stmt);
    			return;
    		}
    	}
    	
    	assignList.clear();
    }
    
}
