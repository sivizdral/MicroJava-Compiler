// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:51


package rs.ac.bg.etf.pp1.ast;

public class NoOptMinus extends OptMinus {

    public NoOptMinus () {
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
        buffer.append("NoOptMinus(\n");

        buffer.append(tab);
        buffer.append(") [NoOptMinus]");
        return buffer.toString();
    }
}
