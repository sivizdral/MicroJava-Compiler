// generated with ast extension for cup
// version 0.8
// 14/11/2022 18:13:47


package rs.ac.bg.etf.pp1.ast;

public class OptOptActParsX extends OptOptActPars {

    private OptionalActPars OptionalActPars;

    public OptOptActParsX (OptionalActPars OptionalActPars) {
        this.OptionalActPars=OptionalActPars;
        if(OptionalActPars!=null) OptionalActPars.setParent(this);
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
        if(OptionalActPars!=null) OptionalActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalActPars!=null) OptionalActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalActPars!=null) OptionalActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptOptActParsX(\n");

        if(OptionalActPars!=null)
            buffer.append(OptionalActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptOptActParsX]");
        return buffer.toString();
    }
}
