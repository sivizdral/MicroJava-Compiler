// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStmtCall extends DesignatorStatement {

    private FuncDesig FuncDesig;
    private OptionalActPars OptionalActPars;

    public DesignatorStmtCall (FuncDesig FuncDesig, OptionalActPars OptionalActPars) {
        this.FuncDesig=FuncDesig;
        if(FuncDesig!=null) FuncDesig.setParent(this);
        this.OptionalActPars=OptionalActPars;
        if(OptionalActPars!=null) OptionalActPars.setParent(this);
    }

    public FuncDesig getFuncDesig() {
        return FuncDesig;
    }

    public void setFuncDesig(FuncDesig FuncDesig) {
        this.FuncDesig=FuncDesig;
    }

    public OptionalActPars getOptionalActPars() {
        return OptionalActPars;
    }

    public void setOptionalActPars(OptionalActPars OptionalActPars) {
        this.OptionalActPars=OptionalActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FuncDesig!=null) FuncDesig.accept(visitor);
        if(OptionalActPars!=null) OptionalActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FuncDesig!=null) FuncDesig.traverseTopDown(visitor);
        if(OptionalActPars!=null) OptionalActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FuncDesig!=null) FuncDesig.traverseBottomUp(visitor);
        if(OptionalActPars!=null) OptionalActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStmtCall(\n");

        if(FuncDesig!=null)
            buffer.append(FuncDesig.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalActPars!=null)
            buffer.append(OptionalActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStmtCall]");
        return buffer.toString();
    }
}
