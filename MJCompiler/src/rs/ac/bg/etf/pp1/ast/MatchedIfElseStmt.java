// generated with ast extension for cup
// version 0.8
// 17/11/2022 17:54:35


package rs.ac.bg.etf.pp1.ast;

public class MatchedIfElseStmt extends Matched {

    private ConditionIF ConditionIF;
    private Matched Matched;
    private ElseElse ElseElse;
    private Matched Matched1;

    public MatchedIfElseStmt (ConditionIF ConditionIF, Matched Matched, ElseElse ElseElse, Matched Matched1) {
        this.ConditionIF=ConditionIF;
        if(ConditionIF!=null) ConditionIF.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.ElseElse=ElseElse;
        if(ElseElse!=null) ElseElse.setParent(this);
        this.Matched1=Matched1;
        if(Matched1!=null) Matched1.setParent(this);
    }

    public ConditionIF getConditionIF() {
        return ConditionIF;
    }

    public void setConditionIF(ConditionIF ConditionIF) {
        this.ConditionIF=ConditionIF;
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
        if(ConditionIF!=null) ConditionIF.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(ElseElse!=null) ElseElse.accept(visitor);
        if(Matched1!=null) Matched1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionIF!=null) ConditionIF.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(ElseElse!=null) ElseElse.traverseTopDown(visitor);
        if(Matched1!=null) Matched1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionIF!=null) ConditionIF.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(ElseElse!=null) ElseElse.traverseBottomUp(visitor);
        if(Matched1!=null) Matched1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIfElseStmt(\n");

        if(ConditionIF!=null)
            buffer.append(ConditionIF.toString("  "+tab));
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
