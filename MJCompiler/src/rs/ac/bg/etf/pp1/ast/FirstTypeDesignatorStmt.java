// generated with ast extension for cup
// version 0.8
// 21/11/2022 20:19:22


package rs.ac.bg.etf.pp1.ast;

public class FirstTypeDesignatorStmt extends DesignatorStatement {

    private Designator Designator;
    private DsgStmtEnd DsgStmtEnd;

    public FirstTypeDesignatorStmt (Designator Designator, DsgStmtEnd DsgStmtEnd) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DsgStmtEnd=DsgStmtEnd;
        if(DsgStmtEnd!=null) DsgStmtEnd.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DsgStmtEnd getDsgStmtEnd() {
        return DsgStmtEnd;
    }

    public void setDsgStmtEnd(DsgStmtEnd DsgStmtEnd) {
        this.DsgStmtEnd=DsgStmtEnd;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DsgStmtEnd!=null) DsgStmtEnd.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DsgStmtEnd!=null) DsgStmtEnd.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DsgStmtEnd!=null) DsgStmtEnd.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FirstTypeDesignatorStmt(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DsgStmtEnd!=null)
            buffer.append(DsgStmtEnd.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FirstTypeDesignatorStmt]");
        return buffer.toString();
    }
}
