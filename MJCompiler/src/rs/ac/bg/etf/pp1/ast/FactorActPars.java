// generated with ast extension for cup
// version 0.8
// 16/11/2022 20:26:24


package rs.ac.bg.etf.pp1.ast;

public class FactorActPars extends Factor {

    private Designator Designator;
    private OptOptActPars OptOptActPars;

    public FactorActPars (Designator Designator, OptOptActPars OptOptActPars) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.OptOptActPars=OptOptActPars;
        if(OptOptActPars!=null) OptOptActPars.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public OptOptActPars getOptOptActPars() {
        return OptOptActPars;
    }

    public void setOptOptActPars(OptOptActPars OptOptActPars) {
        this.OptOptActPars=OptOptActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(OptOptActPars!=null) OptOptActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(OptOptActPars!=null) OptOptActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(OptOptActPars!=null) OptOptActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorActPars(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptOptActPars!=null)
            buffer.append(OptOptActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorActPars]");
        return buffer.toString();
    }
}
