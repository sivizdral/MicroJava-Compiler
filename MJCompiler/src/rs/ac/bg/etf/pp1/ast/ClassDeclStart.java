// generated with ast extension for cup
// version 0.8
// 4/0/2023 19:43:26


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclStart implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private String className;
    private Extension Extension;

    public ClassDeclStart (String className, Extension Extension) {
        this.className=className;
        this.Extension=Extension;
        if(Extension!=null) Extension.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public Extension getExtension() {
        return Extension;
    }

    public void setExtension(Extension Extension) {
        this.Extension=Extension;
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
        if(Extension!=null) Extension.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extension!=null) Extension.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extension!=null) Extension.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclStart(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(Extension!=null)
            buffer.append(Extension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclStart]");
        return buffer.toString();
    }
}
