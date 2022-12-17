// generated with ast extension for cup
// version 0.8
// 17/11/2022 15:39:48


package rs.ac.bg.etf.pp1.ast;

public class FormPars implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IdentSquares IdentSquares;
    private TypeIdentList TypeIdentList;

    public FormPars (IdentSquares IdentSquares, TypeIdentList TypeIdentList) {
        this.IdentSquares=IdentSquares;
        if(IdentSquares!=null) IdentSquares.setParent(this);
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
    }

    public IdentSquares getIdentSquares() {
        return IdentSquares;
    }

    public void setIdentSquares(IdentSquares IdentSquares) {
        this.IdentSquares=IdentSquares;
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
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
        if(IdentSquares!=null) IdentSquares.accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentSquares!=null) IdentSquares.traverseTopDown(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentSquares!=null) IdentSquares.traverseBottomUp(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormPars(\n");

        if(IdentSquares!=null)
            buffer.append(IdentSquares.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TypeIdentList!=null)
            buffer.append(TypeIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormPars]");
        return buffer.toString();
    }
}
