// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:4:46


package rs.ac.bg.etf.pp1.ast;

public class WhileStmt extends Matched {

    private ConditionWHILE ConditionWHILE;
    private Statement Statement;

    public WhileStmt (ConditionWHILE ConditionWHILE, Statement Statement) {
        this.ConditionWHILE=ConditionWHILE;
        if(ConditionWHILE!=null) ConditionWHILE.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public ConditionWHILE getConditionWHILE() {
        return ConditionWHILE;
    }

    public void setConditionWHILE(ConditionWHILE ConditionWHILE) {
        this.ConditionWHILE=ConditionWHILE;
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
        if(ConditionWHILE!=null) ConditionWHILE.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConditionWHILE!=null) ConditionWHILE.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConditionWHILE!=null) ConditionWHILE.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WhileStmt(\n");

        if(ConditionWHILE!=null)
            buffer.append(ConditionWHILE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WhileStmt]");
        return buffer.toString();
    }
}