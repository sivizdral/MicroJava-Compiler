// generated with ast extension for cup
// version 0.8
// 26/11/2022 18:42:47


package rs.ac.bg.etf.pp1.ast;

public class MulopP extends Mulop {

    public MulopP () {
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
        buffer.append("MulopP(\n");

        buffer.append(tab);
        buffer.append(") [MulopP]");
        return buffer.toString();
    }
}
