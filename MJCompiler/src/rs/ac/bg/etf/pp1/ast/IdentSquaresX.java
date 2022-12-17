// generated with ast extension for cup
// version 0.8
// 17/11/2022 17:54:35


package rs.ac.bg.etf.pp1.ast;

public class IdentSquaresX extends IdentSquares {

    private Type Type;
    private String I2;
    private OptionalSquares OptionalSquares;

    public IdentSquaresX (Type Type, String I2, OptionalSquares OptionalSquares) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.OptionalSquares=OptionalSquares;
        if(OptionalSquares!=null) OptionalSquares.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
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
        if(Type!=null) Type.accept(visitor);
        if(OptionalSquares!=null) OptionalSquares.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(OptionalSquares!=null) OptionalSquares.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(OptionalSquares!=null) OptionalSquares.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentSquaresX(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(OptionalSquares!=null)
            buffer.append(OptionalSquares.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentSquaresX]");
        return buffer.toString();
    }
}
