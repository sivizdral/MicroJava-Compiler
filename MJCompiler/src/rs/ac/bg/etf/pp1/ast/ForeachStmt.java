// generated with ast extension for cup
// version 0.8
// 21/11/2022 20:19:22


package rs.ac.bg.etf.pp1.ast;

public class ForeachStmt extends Matched {

    private DesignatorFE DesignatorFE;
    private FEVar FEVar;
    private Statement Statement;

    public ForeachStmt (DesignatorFE DesignatorFE, FEVar FEVar, Statement Statement) {
        this.DesignatorFE=DesignatorFE;
        if(DesignatorFE!=null) DesignatorFE.setParent(this);
        this.FEVar=FEVar;
        if(FEVar!=null) FEVar.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public DesignatorFE getDesignatorFE() {
        return DesignatorFE;
    }

    public void setDesignatorFE(DesignatorFE DesignatorFE) {
        this.DesignatorFE=DesignatorFE;
    }

    public FEVar getFEVar() {
        return FEVar;
    }

    public void setFEVar(FEVar FEVar) {
        this.FEVar=FEVar;
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
        if(DesignatorFE!=null) DesignatorFE.accept(visitor);
        if(FEVar!=null) FEVar.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorFE!=null) DesignatorFE.traverseTopDown(visitor);
        if(FEVar!=null) FEVar.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorFE!=null) DesignatorFE.traverseBottomUp(visitor);
        if(FEVar!=null) FEVar.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForeachStmt(\n");

        if(DesignatorFE!=null)
            buffer.append(DesignatorFE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FEVar!=null)
            buffer.append(FEVar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForeachStmt]");
        return buffer.toString();
    }
}
