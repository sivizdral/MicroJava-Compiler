// generated with ast extension for cup
// version 0.8
// 17/11/2022 15:39:48


package rs.ac.bg.etf.pp1.ast;

public class CondFactAndListX extends CondFactAndList {

    private CondFactAndList CondFactAndList;
    private CondFact CondFact;

    public CondFactAndListX (CondFactAndList CondFactAndList, CondFact CondFact) {
        this.CondFactAndList=CondFactAndList;
        if(CondFactAndList!=null) CondFactAndList.setParent(this);
        this.CondFact=CondFact;
        if(CondFact!=null) CondFact.setParent(this);
    }

    public CondFactAndList getCondFactAndList() {
        return CondFactAndList;
    }

    public void setCondFactAndList(CondFactAndList CondFactAndList) {
        this.CondFactAndList=CondFactAndList;
    }

    public CondFact getCondFact() {
        return CondFact;
    }

    public void setCondFact(CondFact CondFact) {
        this.CondFact=CondFact;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CondFactAndList!=null) CondFactAndList.accept(visitor);
        if(CondFact!=null) CondFact.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CondFactAndList!=null) CondFactAndList.traverseTopDown(visitor);
        if(CondFact!=null) CondFact.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CondFactAndList!=null) CondFactAndList.traverseBottomUp(visitor);
        if(CondFact!=null) CondFact.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CondFactAndListX(\n");

        if(CondFactAndList!=null)
            buffer.append(CondFactAndList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CondFact!=null)
            buffer.append(CondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CondFactAndListX]");
        return buffer.toString();
    }
}
