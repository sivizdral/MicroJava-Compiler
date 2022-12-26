// generated with ast extension for cup
// version 0.8
// 26/11/2022 18:42:46


package rs.ac.bg.etf.pp1.ast;

public class ListsConMet extends Lists {

    private ConstructorDeclStart ConstructorDeclStart;
    private ConstructorDeclList ConstructorDeclList;
    private MethodStart MethodStart;
    private MethodDeclList2 MethodDeclList2;

    public ListsConMet (ConstructorDeclStart ConstructorDeclStart, ConstructorDeclList ConstructorDeclList, MethodStart MethodStart, MethodDeclList2 MethodDeclList2) {
        this.ConstructorDeclStart=ConstructorDeclStart;
        if(ConstructorDeclStart!=null) ConstructorDeclStart.setParent(this);
        this.ConstructorDeclList=ConstructorDeclList;
        if(ConstructorDeclList!=null) ConstructorDeclList.setParent(this);
        this.MethodStart=MethodStart;
        if(MethodStart!=null) MethodStart.setParent(this);
        this.MethodDeclList2=MethodDeclList2;
        if(MethodDeclList2!=null) MethodDeclList2.setParent(this);
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

    public MethodStart getMethodStart() {
        return MethodStart;
    }

    public void setMethodStart(MethodStart MethodStart) {
        this.MethodStart=MethodStart;
    }

    public MethodDeclList2 getMethodDeclList2() {
        return MethodDeclList2;
    }

    public void setMethodDeclList2(MethodDeclList2 MethodDeclList2) {
        this.MethodDeclList2=MethodDeclList2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstructorDeclStart!=null) ConstructorDeclStart.accept(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.accept(visitor);
        if(MethodStart!=null) MethodStart.accept(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseTopDown(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseTopDown(visitor);
        if(MethodStart!=null) MethodStart.traverseTopDown(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseBottomUp(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseBottomUp(visitor);
        if(MethodStart!=null) MethodStart.traverseBottomUp(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListsConMet(\n");

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

        if(MethodStart!=null)
            buffer.append(MethodStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclList2!=null)
            buffer.append(MethodDeclList2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListsConMet]");
        return buffer.toString();
    }
}
