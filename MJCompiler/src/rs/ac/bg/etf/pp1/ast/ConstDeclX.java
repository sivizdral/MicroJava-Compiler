// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:4:46


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclX extends ConstDecl {

    private Type Type;
    private String I2;
    private FirstConst FirstConst;
    private OtherConstList OtherConstList;

    public ConstDeclX (Type Type, String I2, FirstConst FirstConst, OtherConstList OtherConstList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.FirstConst=FirstConst;
        if(FirstConst!=null) FirstConst.setParent(this);
        this.OtherConstList=OtherConstList;
        if(OtherConstList!=null) OtherConstList.setParent(this);
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

    public FirstConst getFirstConst() {
        return FirstConst;
    }

    public void setFirstConst(FirstConst FirstConst) {
        this.FirstConst=FirstConst;
    }

    public OtherConstList getOtherConstList() {
        return OtherConstList;
    }

    public void setOtherConstList(OtherConstList OtherConstList) {
        this.OtherConstList=OtherConstList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FirstConst!=null) FirstConst.accept(visitor);
        if(OtherConstList!=null) OtherConstList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FirstConst!=null) FirstConst.traverseTopDown(visitor);
        if(OtherConstList!=null) OtherConstList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FirstConst!=null) FirstConst.traverseBottomUp(visitor);
        if(OtherConstList!=null) OtherConstList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclX(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        if(FirstConst!=null)
            buffer.append(FirstConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OtherConstList!=null)
            buffer.append(OtherConstList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclX]");
        return buffer.toString();
    }
}
