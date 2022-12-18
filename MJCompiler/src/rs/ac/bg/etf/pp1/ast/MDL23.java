// generated with ast extension for cup
// version 0.8
// 18/11/2022 23:50:57


package rs.ac.bg.etf.pp1.ast;

public class MDL23 extends MethodDeclList2 {

    private MethodDecl2 MethodDecl2;

    public MDL23 (MethodDecl2 MethodDecl2) {
        this.MethodDecl2=MethodDecl2;
        if(MethodDecl2!=null) MethodDecl2.setParent(this);
    }

    public MethodDecl2 getMethodDecl2() {
        return MethodDecl2;
    }

    public void setMethodDecl2(MethodDecl2 MethodDecl2) {
        this.MethodDecl2=MethodDecl2;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl2!=null) MethodDecl2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl2!=null) MethodDecl2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl2!=null) MethodDecl2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MDL23(\n");

        if(MethodDecl2!=null)
            buffer.append(MethodDecl2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MDL23]");
        return buffer.toString();
    }
}
