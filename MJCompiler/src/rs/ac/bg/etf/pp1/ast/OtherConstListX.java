// generated with ast extension for cup
// version 0.8
// 18/11/2022 23:50:57


package rs.ac.bg.etf.pp1.ast;

public class OtherConstListX extends OtherConstList {

    private OtherConstList OtherConstList;
    private ConstTail ConstTail;

    public OtherConstListX (OtherConstList OtherConstList, ConstTail ConstTail) {
        this.OtherConstList=OtherConstList;
        if(OtherConstList!=null) OtherConstList.setParent(this);
        this.ConstTail=ConstTail;
        if(ConstTail!=null) ConstTail.setParent(this);
    }

    public OtherConstList getOtherConstList() {
        return OtherConstList;
    }

    public void setOtherConstList(OtherConstList OtherConstList) {
        this.OtherConstList=OtherConstList;
    }

    public ConstTail getConstTail() {
        return ConstTail;
    }

    public void setConstTail(ConstTail ConstTail) {
        this.ConstTail=ConstTail;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OtherConstList!=null) OtherConstList.accept(visitor);
        if(ConstTail!=null) ConstTail.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OtherConstList!=null) OtherConstList.traverseTopDown(visitor);
        if(ConstTail!=null) ConstTail.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OtherConstList!=null) OtherConstList.traverseBottomUp(visitor);
        if(ConstTail!=null) ConstTail.traverseBottomUp(visitor);
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

        if(ConstTail!=null)
            buffer.append(ConstTail.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OtherConstListX]");
        return buffer.toString();
    }
}
