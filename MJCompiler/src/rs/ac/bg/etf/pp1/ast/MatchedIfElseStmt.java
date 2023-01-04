// generated with ast extension for cup
// version 0.8
// 4/0/2023 23:30:38


package rs.ac.bg.etf.pp1.ast;

public class MatchedIfElseStmt extends Matched {

    private StartIF StartIF;
    private ConditionIF ConditionIF;
    private DummyAfterCond DummyAfterCond;
    private Matched Matched;
    private ElseElse ElseElse;
    private Matched Matched1;

    public MatchedIfElseStmt (StartIF StartIF, ConditionIF ConditionIF, DummyAfterCond DummyAfterCond, Matched Matched, ElseElse ElseElse, Matched Matched1) {
        this.StartIF=StartIF;
        if(StartIF!=null) StartIF.setParent(this);
        this.ConditionIF=ConditionIF;
        if(ConditionIF!=null) ConditionIF.setParent(this);
        this.DummyAfterCond=DummyAfterCond;
        if(DummyAfterCond!=null) DummyAfterCond.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.ElseElse=ElseElse;
        if(ElseElse!=null) ElseElse.setParent(this);
        this.Matched1=Matched1;
        if(Matched1!=null) Matched1.setParent(this);
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

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public ElseElse getElseElse() {
        return ElseElse;
    }

    public void setElseElse(ElseElse ElseElse) {
        this.ElseElse=ElseElse;
    }

    public Matched getMatched1() {
        return Matched1;
    }

    public void setMatched1(Matched Matched1) {
        this.Matched1=Matched1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StartIF!=null) StartIF.accept(visitor);
        if(ConditionIF!=null) ConditionIF.accept(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(ElseElse!=null) ElseElse.accept(visitor);
        if(Matched1!=null) Matched1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIF!=null) StartIF.traverseTopDown(visitor);
        if(ConditionIF!=null) ConditionIF.traverseTopDown(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(ElseElse!=null) ElseElse.traverseTopDown(visitor);
        if(Matched1!=null) Matched1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIF!=null) StartIF.traverseBottomUp(visitor);
        if(ConditionIF!=null) ConditionIF.traverseBottomUp(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(ElseElse!=null) ElseElse.traverseBottomUp(visitor);
        if(Matched1!=null) Matched1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIfElseStmt(\n");

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

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseElse!=null)
            buffer.append(ElseElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched1!=null)
            buffer.append(Matched1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedIfElseStmt]");
        return buffer.toString();
    }
}
