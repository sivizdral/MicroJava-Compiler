// generated with ast extension for cup
// version 0.8
// 4/0/2023 19:43:26


package rs.ac.bg.etf.pp1.ast;

public class UnmatchedIfElse extends Unmatched {

    private StartIF StartIF;
    private ConditionIF ConditionIF;
    private DummyAfterCond DummyAfterCond;
    private Matched Matched;
    private ElseElse ElseElse;
    private Unmatched Unmatched;

    public UnmatchedIfElse (StartIF StartIF, ConditionIF ConditionIF, DummyAfterCond DummyAfterCond, Matched Matched, ElseElse ElseElse, Unmatched Unmatched) {
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
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
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

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
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
        if(Unmatched!=null) Unmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StartIF!=null) StartIF.traverseTopDown(visitor);
        if(ConditionIF!=null) ConditionIF.traverseTopDown(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(ElseElse!=null) ElseElse.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StartIF!=null) StartIF.traverseBottomUp(visitor);
        if(ConditionIF!=null) ConditionIF.traverseBottomUp(visitor);
        if(DummyAfterCond!=null) DummyAfterCond.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(ElseElse!=null) ElseElse.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfElse(\n");

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

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfElse]");
        return buffer.toString();
    }
}
