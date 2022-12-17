// generated with ast extension for cup
// version 0.8
// 17/11/2022 17:54:35


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclStart implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String constructorName;

    public ConstructorDeclStart (String constructorName) {
        this.constructorName=constructorName;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName=constructorName;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("ConstructorDeclStart(\n");

        buffer.append(" "+tab+constructorName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclStart]");
        return buffer.toString();
    }
}
