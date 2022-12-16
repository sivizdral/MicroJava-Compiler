package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor {

	int printCallCount = 0;
	int varDeclCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	boolean errorDetected = false;
	int nVars;
	
	Struct currentType = null;
	
	Logger log = Logger.getLogger(getClass());

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
    
    /* LOCAL VAR DECLARATION */
    
    public void visit(FirstVarDeclArrayIdent arrayVar) {
    	String varName = arrayVar.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && obj.getLevel() != 0) {  // OBRATI PAZNJU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    		report_error("Vec postoji globalna promenljiva sa ovim imenom!", arrayVar);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, new Struct(Struct.Array, currentType));
		report_info("Deklarisana lokalna promenljiva (niz)!", arrayVar);
    }
    
    public void visit(FirstVarDeclIdentOnly var) {
    	String varName = var.getName();
    	
    	Obj obj = Tab.find(varName);
    	if (obj != Tab.noObj && obj.getLevel() != 0) {
    		report_error("Vec postoji globalna promenljiva sa ovim imenom!", var);
    		return;
    	}
    	
    	Tab.insert(Obj.Var, varName, currentType);
		report_info("Deklarisana lokalna promenljiva!", var);
    }
    
    
}
