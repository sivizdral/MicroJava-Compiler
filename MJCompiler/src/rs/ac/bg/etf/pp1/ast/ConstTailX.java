// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:51:21


package rs.ac.bg.etf.pp1.ast;

public class ConstTailX extends ConstTail {

    private String I1;
    private FirstConst FirstConst;

    public ConstTailX (String I1, FirstConst FirstConst) {
        this.I1=I1;
        this.FirstConst=FirstConst;
        if(FirstConst!=null) FirstConst.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
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
        if(FirstConst!=null) FirstConst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstConst!=null) FirstConst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstConst!=null) FirstConst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstTailX(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(FirstConst!=null)
            buffer.append(FirstConst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstTailX]");
        return buffer.toString();
    }
}
