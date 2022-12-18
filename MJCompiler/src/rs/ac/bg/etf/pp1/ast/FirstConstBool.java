// generated with ast extension for cup
// version 0.8
// 18/11/2022 23:50:57


package rs.ac.bg.etf.pp1.ast;

public class FirstConstBool extends FirstConst {

    private Boolean value;

    public FirstConstBool (Boolean value) {
        this.value=value;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value=value;
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
        buffer.append("FirstConstBool(\n");

        buffer.append(" "+tab+value);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstConstBool]");
        return buffer.toString();
    }
}
