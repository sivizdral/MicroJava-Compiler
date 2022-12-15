// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:4:46


package rs.ac.bg.etf.pp1.ast;

public class FactorExprActPars extends Factor {

    private Type Type;
    private ExprOrActPars ExprOrActPars;

    public FactorExprActPars (Type Type, ExprOrActPars ExprOrActPars) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ExprOrActPars=ExprOrActPars;
        if(ExprOrActPars!=null) ExprOrActPars.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ExprOrActPars getExprOrActPars() {
        return ExprOrActPars;
    }

    public void setExprOrActPars(ExprOrActPars ExprOrActPars) {
        this.ExprOrActPars=ExprOrActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ExprOrActPars!=null) ExprOrActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ExprOrActPars!=null) ExprOrActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ExprOrActPars!=null) ExprOrActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorExprActPars(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprOrActPars!=null)
            buffer.append(ExprOrActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorExprActPars]");
        return buffer.toString();
    }
}