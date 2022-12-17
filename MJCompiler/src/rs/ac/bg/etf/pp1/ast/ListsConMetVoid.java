// generated with ast extension for cup
// version 0.8
// 17/11/2022 17:54:35


package rs.ac.bg.etf.pp1.ast;

public class ListsConMetVoid extends Lists {

    private ConstructorDeclStart ConstructorDeclStart;
    private ConstructorDeclList ConstructorDeclList;
    private String I3;
    private MethodDeclList2 MethodDeclList2;

    public ListsConMetVoid (ConstructorDeclStart ConstructorDeclStart, ConstructorDeclList ConstructorDeclList, String I3, MethodDeclList2 MethodDeclList2) {
        this.ConstructorDeclStart=ConstructorDeclStart;
        if(ConstructorDeclStart!=null) ConstructorDeclStart.setParent(this);
        this.ConstructorDeclList=ConstructorDeclList;
        if(ConstructorDeclList!=null) ConstructorDeclList.setParent(this);
        this.I3=I3;
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

    public String getI3() {
        return I3;
    }

    public void setI3(String I3) {
        this.I3=I3;
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
        if(MethodDeclList2!=null) MethodDeclList2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseTopDown(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseTopDown(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseBottomUp(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseBottomUp(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListsConMetVoid(\n");

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

        buffer.append(" "+tab+I3);
        buffer.append("\n");

        if(MethodDeclList2!=null)
            buffer.append(MethodDeclList2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ListsConMetVoid]");
        return buffer.toString();
    }
}
