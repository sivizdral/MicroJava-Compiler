// generated with ast extension for cup
// version 0.8
// 16/11/2022 20:26:24


package rs.ac.bg.etf.pp1.ast;

public class ConstructorMethodListsX extends ConstructorMethodLists {

    private Lists Lists;

    public ConstructorMethodListsX (Lists Lists) {
        this.Lists=Lists;
        if(Lists!=null) Lists.setParent(this);
    }

    public Lists getLists() {
        return Lists;
    }

    public void setLists(Lists Lists) {
        this.Lists=Lists;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Lists!=null) Lists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Lists!=null) Lists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Lists!=null) Lists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorMethodListsX(\n");

        if(Lists!=null)
            buffer.append(Lists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorMethodListsX]");
        return buffer.toString();
    }
}
