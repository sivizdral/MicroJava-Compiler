// generated with ast extension for cup
// version 0.8
// 29/11/2022 21:24:45


package rs.ac.bg.etf.pp1.ast;

public class SecondTypeDesignatorStmt extends DesignatorStatement {

    private OptionalDesignator OptionalDesignator;
    private OptionalDesignatorList OptionalDesignatorList;
    private Designator Designator;

    public SecondTypeDesignatorStmt (OptionalDesignator OptionalDesignator, OptionalDesignatorList OptionalDesignatorList, Designator Designator) {
        this.OptionalDesignator=OptionalDesignator;
        if(OptionalDesignator!=null) OptionalDesignator.setParent(this);
        this.OptionalDesignatorList=OptionalDesignatorList;
        if(OptionalDesignatorList!=null) OptionalDesignatorList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public OptionalDesignator getOptionalDesignator() {
        return OptionalDesignator;
    }

    public void setOptionalDesignator(OptionalDesignator OptionalDesignator) {
        this.OptionalDesignator=OptionalDesignator;
    }

    public OptionalDesignatorList getOptionalDesignatorList() {
        return OptionalDesignatorList;
    }

    public void setOptionalDesignatorList(OptionalDesignatorList OptionalDesignatorList) {
        this.OptionalDesignatorList=OptionalDesignatorList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OptionalDesignator!=null) OptionalDesignator.accept(visitor);
        if(OptionalDesignatorList!=null) OptionalDesignatorList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OptionalDesignator!=null) OptionalDesignator.traverseTopDown(visitor);
        if(OptionalDesignatorList!=null) OptionalDesignatorList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OptionalDesignator!=null) OptionalDesignator.traverseBottomUp(visitor);
        if(OptionalDesignatorList!=null) OptionalDesignatorList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SecondTypeDesignatorStmt(\n");

        if(OptionalDesignator!=null)
            buffer.append(OptionalDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OptionalDesignatorList!=null)
            buffer.append(OptionalDesignatorList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SecondTypeDesignatorStmt]");
        return buffer.toString();
    }
}
