// generated with ast extension for cup
// version 0.8
// 14/11/2022 18:13:47


package rs.ac.bg.etf.pp1.ast;

public class OtherConstListX extends OtherConstList {

    private OtherConstList OtherConstList;
    private String I2;
    private FirstConst FirstConst;

    public OtherConstListX (OtherConstList OtherConstList, String I2, FirstConst FirstConst) {
        this.OtherConstList=OtherConstList;
        if(OtherConstList!=null) OtherConstList.setParent(this);
        this.I2=I2;
        this.FirstConst=FirstConst;
        if(FirstConst!=null) FirstConst.setParent(this);
    }

    public OtherConstList getOtherConstList() {
        return OtherConstList;
    }

    public void setOtherConstList(OtherConstList OtherConstList) {
        this.OtherConstList=OtherConstList;
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OtherConstList!=null) OtherConstList.accept(visitor);
        if(FirstConst!=null) FirstConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OtherConstList!=null) OtherConstList.traverseTopDown(visitor);
        if(FirstConst!=null) FirstConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OtherConstList!=null) OtherConstList.traverseBottomUp(visitor);
        if(FirstConst!=null) FirstConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OtherConstListX(\n");

        if(OtherConstList!=null)
            buffer.append(OtherConstList.toString("  "+tab));
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

        buffer.append(tab);
        buffer.append(") [OtherConstListX]");
        return buffer.toString();
    }
}
