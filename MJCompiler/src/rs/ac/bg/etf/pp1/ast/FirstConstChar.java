// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class FirstConstChar extends FirstConst {

    private Character C1;

    public FirstConstChar (Character C1) {
        this.C1=C1;
    }

    public Character getC1() {
        return C1;
    }

    public void setC1(Character C1) {
        this.C1=C1;
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
        buffer.append("FirstConstChar(\n");

        buffer.append(" "+tab+C1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstConstChar]");
        return buffer.toString();
    }
}
