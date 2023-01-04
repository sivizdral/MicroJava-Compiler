// generated with ast extension for cup
// version 0.8
// 4/0/2023 19:43:26


package rs.ac.bg.etf.pp1.ast;

public class CondTermOrListX extends CondTermOrList {

    private CondTermOrList CondTermOrList;
    private DummyAfterTerm DummyAfterTerm;
    private CondTerm CondTerm;

    public CondTermOrListX (CondTermOrList CondTermOrList, DummyAfterTerm DummyAfterTerm, CondTerm CondTerm) {
        this.CondTermOrList=CondTermOrList;
        if(CondTermOrList!=null) CondTermOrList.setParent(this);
        this.DummyAfterTerm=DummyAfterTerm;
        if(DummyAfterTerm!=null) DummyAfterTerm.setParent(this);
        this.CondTerm=CondTerm;
        if(CondTerm!=null) CondTerm.setParent(this);
    }

    public CondTermOrList getCondTermOrList() {
        return CondTermOrList;
    }

    public void setCondTermOrList(CondTermOrList CondTermOrList) {
        this.CondTermOrList=CondTermOrList;
    }

    public DummyAfterTerm getDummyAfterTerm() {
        return DummyAfterTerm;
    }

    public void setDummyAfterTerm(DummyAfterTerm DummyAfterTerm) {
        this.DummyAfterTerm=DummyAfterTerm;
    }

    public CondTerm getCondTerm() {
        return CondTerm;
    }

    public void setCondTerm(CondTerm CondTerm) {
        this.CondTerm=CondTerm;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondTermOrList!=null) CondTermOrList.accept(visitor);
        if(DummyAfterTerm!=null) DummyAfterTerm.accept(visitor);
        if(CondTerm!=null) CondTerm.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondTermOrList!=null) CondTermOrList.traverseTopDown(visitor);
        if(DummyAfterTerm!=null) DummyAfterTerm.traverseTopDown(visitor);
        if(CondTerm!=null) CondTerm.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondTermOrList!=null) CondTermOrList.traverseBottomUp(visitor);
        if(DummyAfterTerm!=null) DummyAfterTerm.traverseBottomUp(visitor);
        if(CondTerm!=null) CondTerm.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondTermOrListX(\n");

        if(CondTermOrList!=null)
            buffer.append(CondTermOrList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DummyAfterTerm!=null)
            buffer.append(DummyAfterTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondTerm!=null)
            buffer.append(CondTerm.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondTermOrListX]");
        return buffer.toString();
    }
}
