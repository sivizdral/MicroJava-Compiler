// generated with ast extension for cup
// version 0.8
// 18/11/2022 23:50:57


package rs.ac.bg.etf.pp1.ast;

public class ListsMet extends Lists {

    private MethodStart MethodStart;
    private MethodDeclList2 MethodDeclList2;

    public ListsMet (MethodStart MethodStart, MethodDeclList2 MethodDeclList2) {
        this.MethodStart=MethodStart;
        if(MethodStart!=null) MethodStart.setParent(this);
        this.MethodDeclList2=MethodDeclList2;
        if(MethodDeclList2!=null) MethodDeclList2.setParent(this);
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
        if(MethodStart!=null) MethodStart.accept(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodStart!=null) MethodStart.traverseTopDown(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodStart!=null) MethodStart.traverseBottomUp(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ListsMet(\n");

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
        buffer.append(") [ListsMet]");
        return buffer.toString();
    }
}
