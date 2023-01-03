// generated with ast extension for cup
// version 0.8
// 3/0/2023 20:15:40


package rs.ac.bg.etf.pp1.ast;

public class NoOtherConstList extends OtherConstList {

    public NoOtherConstList () {
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
        buffer.append("NoOtherConstList(\n");

        buffer.append(tab);
        buffer.append(") [NoOtherConstList]");
        return buffer.toString();
    }
}
