// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class NoReturnType extends ReturnType {

    public NoReturnType () {
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
        buffer.append("NoReturnType(\n");

        buffer.append(tab);
        buffer.append(") [NoReturnType]");
        return buffer.toString();
    }
}
