// generated with ast extension for cup
// version 0.8
// 26/11/2022 18:42:46


package rs.ac.bg.etf.pp1.ast;

public class TypeIdentListX extends TypeIdentList {

    private TypeIdentList TypeIdentList;
    private IdentSquares IdentSquares;

    public TypeIdentListX (TypeIdentList TypeIdentList, IdentSquares IdentSquares) {
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
        this.IdentSquares=IdentSquares;
        if(IdentSquares!=null) IdentSquares.setParent(this);
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
    }

    public IdentSquares getIdentSquares() {
        return IdentSquares;
    }

    public void setIdentSquares(IdentSquares IdentSquares) {
        this.IdentSquares=IdentSquares;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
        if(IdentSquares!=null) IdentSquares.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
        if(IdentSquares!=null) IdentSquares.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        if(IdentSquares!=null) IdentSquares.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("TypeIdentListX(\n");

        if(TypeIdentList!=null)
            buffer.append(TypeIdentList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentSquares!=null)
            buffer.append(IdentSquares.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeIdentListX]");
        return buffer.toString();
    }
}
