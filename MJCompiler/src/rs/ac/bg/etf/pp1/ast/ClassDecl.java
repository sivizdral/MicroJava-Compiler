// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String I1;
    private Extension Extension;
    private VarDeclList VarDeclList;
    private ConstructorMethodLists ConstructorMethodLists;

    public ClassDecl (String I1, Extension Extension, VarDeclList VarDeclList, ConstructorMethodLists ConstructorMethodLists) {
        this.I1=I1;
        this.Extension=Extension;
        if(Extension!=null) Extension.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.ConstructorMethodLists=ConstructorMethodLists;
        if(ConstructorMethodLists!=null) ConstructorMethodLists.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public Extension getExtension() {
        return Extension;
    }

    public void setExtension(Extension Extension) {
        this.Extension=Extension;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public ConstructorMethodLists getConstructorMethodLists() {
        return ConstructorMethodLists;
    }

    public void setConstructorMethodLists(ConstructorMethodLists ConstructorMethodLists) {
        this.ConstructorMethodLists=ConstructorMethodLists;
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
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Extension!=null) Extension.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Extension!=null) Extension.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(Extension!=null)
            buffer.append(Extension.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorMethodLists!=null)
            buffer.append(ConstructorMethodLists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
