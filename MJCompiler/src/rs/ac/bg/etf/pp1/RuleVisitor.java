package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;
import rs.ac.bg.etf.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor{

	int printCallCount = 0;
	int varDeclCount = 0;
	int constDeclCount = 0;
	
	Logger log = Logger.getLogger(getClass());

	public void visit(FirstVarDeclIdentOnly vardecl){
		varDeclCount++;
	}
	
	public void visit(FirstVarDeclArrayIdent vardecl){
		varDeclCount++;
	}
	
	public void visit(FirstConstNum cdecl) {
		constDeclCount++;
	}
	
    public void visit(PrintStmt print) {
		printCallCount++;
	}

}
