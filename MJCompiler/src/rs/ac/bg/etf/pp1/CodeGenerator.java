package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {
	
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
    	/* URADITI *****************************************************/
    }
    
    public void visit(FactorNewArray factor) {
		Code.put(Code.newarray);
		if (factor.struct.getElemType() != Tab.charType) {
			Code.put(1);
		} else {
			Code.put(0);
		}
    }

}
