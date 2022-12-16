// generated with ast extension for cup
// version 0.8
// 16/11/2022 21:14:34


package rs.ac.bg.etf.pp1.ast;

public class NoStatementList extends StatementList {

    public NoStatementList () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoStatementList(\n");

        buffer.append(tab);
        buffer.append(") [NoStatementList]");
        return buffer.toString();
    }
}
