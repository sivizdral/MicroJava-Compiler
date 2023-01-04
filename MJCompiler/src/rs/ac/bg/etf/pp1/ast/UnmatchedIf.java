// generated with ast extension for cup
// version 0.8
// 4/0/2023 23:30:38


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIf extends Unmatched {

    private StartIF StartIF;
    private ConditionIF ConditionIF;
    private DummyAfterCond DummyAfterCond;
    private Statement Statement;

    public UnmatchedIf (StartIF StartIF, ConditionIF ConditionIF, DummyAfterCond DummyAfterCond, Statement Statement) {
        this.StartIF=StartIF;
        if(StartIF!=null) StartIF.setParent(this);
        this.ConditionIF=ConditionIF;
        if(ConditionIF!=null) ConditionIF.setParent(this);
        this.DummyAfterCond=DummyAfterCond;
        if(DummyAfterCond!=null) DummyAfterCond.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public StartIF getStartIF() {
        return StartIF;
    }

    public void setStartIF(StartIF StartIF) {
        this.StartIF=StartIF;
    }

    public ConditionIF getConditionIF() {
        return ConditionIF;
    }

    public void setConditionIF(ConditionIF ConditionIF) {
        this.ConditionIF=ConditionIF;
    }

    public DummyAfterCond getDummyAfterCond() {
        return DummyAfterCond;
    }

    public void setDummyAfterCond(DummyAfterCond DummyAfterCond) {
        this.DummyAfterCond=DummyAfterCond;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StartIF!=null) StartIF.accept(visitor);
        if(ConditionIF!=null) ConditionIF.accept(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIF!=null) StartIF.traverseTopDown(visitor);
        if(ConditionIF!=null) ConditionIF.traverseTopDown(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIF!=null) StartIF.traverseBottomUp(visitor);
        if(ConditionIF!=null) ConditionIF.traverseBottomUp(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIf(\n");

        if(StartIF!=null)
            buffer.append(StartIF.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConditionIF!=null)
            buffer.append(ConditionIF.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DummyAfterCond!=null)
            buffer.append(DummyAfterCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIf]");
        return buffer.toString();
    }
}
