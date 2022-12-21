// generated with ast extension for cup
// version 0.8
// 21/11/2022 20:19:22


package rs.ac.bg.etf.pp1.ast;

public class NoIdentExprList extends IdentExprList {

    public NoIdentExprList () {
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
        buffer.append("NoIdentExprList(\n");

        buffer.append(tab);
        buffer.append(") [NoIdentExprList]");
        return buffer.toString();
    }
}
