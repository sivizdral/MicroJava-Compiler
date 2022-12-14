// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class TypeIdentListX extends TypeIdentList {

    private TypeIdentList TypeIdentList;
    private Type Type;
    private String I3;
    private OptionalSquares OptionalSquares;

    public TypeIdentListX (TypeIdentList TypeIdentList, Type Type, String I3, OptionalSquares OptionalSquares) {
        this.TypeIdentList=TypeIdentList;
        if(TypeIdentList!=null) TypeIdentList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I3=I3;
        this.OptionalSquares=OptionalSquares;
        if(OptionalSquares!=null) OptionalSquares.setParent(this);
    }

    public TypeIdentList getTypeIdentList() {
        return TypeIdentList;
    }

    public void setTypeIdentList(TypeIdentList TypeIdentList) {
        this.TypeIdentList=TypeIdentList;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI3() {
        return I3;
    }

    public void setI3(String I3) {
        this.I3=I3;
    }

    public OptionalSquares getOptionalSquares() {
        return OptionalSquares;
    }

    public void setOptionalSquares(OptionalSquares OptionalSquares) {
        this.OptionalSquares=OptionalSquares;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(OptionalSquares!=null) OptionalSquares.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeIdentList!=null) TypeIdentList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalSquares!=null) OptionalSquares.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeIdentList!=null) TypeIdentList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalSquares!=null) OptionalSquares.traverseBottomUp(visitor);
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

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I3);
        buffer.append("\n");

        if(OptionalSquares!=null)
            buffer.append(OptionalSquares.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [TypeIdentListX]");
        return buffer.toString();
    }
}
