// generated with ast extension for cup
// version 0.8
// 21/11/2022 21:13:21


package rs.ac.bg.etf.pp1.ast;

public class WhileStmt extends Matched {

    private WhileStmtStart WhileStmtStart;
    private ConditionWHILE ConditionWHILE;
    private Statement Statement;

    public WhileStmt (WhileStmtStart WhileStmtStart, ConditionWHILE ConditionWHILE, Statement Statement) {
        this.WhileStmtStart=WhileStmtStart;
        if(WhileStmtStart!=null) WhileStmtStart.setParent(this);
        this.ConditionWHILE=ConditionWHILE;
        if(ConditionWHILE!=null) ConditionWHILE.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public WhileStmtStart getWhileStmtStart() {
        return WhileStmtStart;
    }

    public void setWhileStmtStart(WhileStmtStart WhileStmtStart) {
        this.WhileStmtStart=WhileStmtStart;
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
        if(WhileStmtStart!=null) WhileStmtStart.accept(visitor);
        if(ConditionWHILE!=null) ConditionWHILE.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(WhileStmtStart!=null) WhileStmtStart.traverseTopDown(visitor);
        if(ConditionWHILE!=null) ConditionWHILE.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(WhileStmtStart!=null) WhileStmtStart.traverseBottomUp(visitor);
        if(ConditionWHILE!=null) ConditionWHILE.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WhileStmt(\n");

        if(WhileStmtStart!=null)
            buffer.append(WhileStmtStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

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
