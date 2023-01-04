// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class ListsCon extends Lists {

    private ConstructorDeclStart ConstructorDeclStart;
    private ConstructorDeclList ConstructorDeclList;

    public ListsCon (ConstructorDeclStart ConstructorDeclStart, ConstructorDeclList ConstructorDeclList) {
        this.ConstructorDeclStart=ConstructorDeclStart;
        if(ConstructorDeclStart!=null) ConstructorDeclStart.setParent(this);
        this.ConstructorDeclList=ConstructorDeclList;
        if(ConstructorDeclList!=null) ConstructorDeclList.setParent(this);
    }

    public ConstructorDeclStart getConstructorDeclStart() {
        return ConstructorDeclStart;
    }

    public void setConstructorDeclStart(ConstructorDeclStart ConstructorDeclStart) {
        this.ConstructorDeclStart=ConstructorDeclStart;
    }

    public ConstructorDeclList getConstructorDeclList() {
        return ConstructorDeclList;
    }

    public void setConstructorDeclList(ConstructorDeclList ConstructorDeclList) {
        this.ConstructorDeclList=ConstructorDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorDeclStart!=null) ConstructorDeclStart.accept(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseTopDown(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseBottomUp(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListsCon(\n");

        if(ConstructorDeclStart!=null)
            buffer.append(ConstructorDeclStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorDeclList!=null)
            buffer.append(ConstructorDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListsCon]");
        return buffer.toString();
    }
}
