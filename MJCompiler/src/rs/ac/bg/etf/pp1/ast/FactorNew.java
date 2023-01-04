// generated with ast extension for cup
// version 0.8
// 4/0/2023 23:30:38


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private ConstructorType ConstructorType;
    private OptionalActPars OptionalActPars;

    public FactorNew (ConstructorType ConstructorType, OptionalActPars OptionalActPars) {
        this.ConstructorType=ConstructorType;
        if(ConstructorType!=null) ConstructorType.setParent(this);
        this.OptionalActPars=OptionalActPars;
        if(OptionalActPars!=null) OptionalActPars.setParent(this);
    }

    public ConstructorType getConstructorType() {
        return ConstructorType;
    }

    public void setConstructorType(ConstructorType ConstructorType) {
        this.ConstructorType=ConstructorType;
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
        if(ConstructorType!=null) ConstructorType.accept(visitor);
        if(OptionalActPars!=null) OptionalActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorType!=null) ConstructorType.traverseTopDown(visitor);
        if(OptionalActPars!=null) OptionalActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorType!=null) ConstructorType.traverseBottomUp(visitor);
        if(OptionalActPars!=null) OptionalActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(ConstructorType!=null)
            buffer.append(ConstructorType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalActPars!=null)
            buffer.append(OptionalActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
