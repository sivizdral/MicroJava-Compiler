package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.log4j.Logger;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.Program;

public class Compiler {
	
	public static void main(String[] args) throws Exception {
		
		Logger log = Logger.getLogger(MJParserTest.class);
				
				Reader br = null;
				try {
					File sourceCode = new File(args[0]);
					log.info("Compiling source file: " + sourceCode.getAbsolutePath());
					
					br = new BufferedReader(new FileReader(sourceCode));
					Yylex lexer = new Yylex(br);
					
					MJParser p = new MJParser(lexer);
			        Symbol s = p.parse();  //pocetak parsiranja
			        
			        Program prog = (Program)(s.value); 
					// ispis sintaksnog stabla
					log.info(prog.toString(""));
					log.info("===================================");
		
					// ispis prepoznatih programskih konstrukcija
					RuleVisitor v = new RuleVisitor();
					prog.traverseBottomUp(v); 
			      
					log.info(" Print count calls = " + v.printCallCount);
		
					log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);
					
					log.info("Deklarisanih konstanti ima = " + v.constDeclCount);
					
				} 
				finally {
					if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
				}
		
	}

}
