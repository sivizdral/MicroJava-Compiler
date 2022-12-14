// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class MDL21 extends MethodDeclList2 {

    private MethodDeclList2 MethodDeclList2;
    private String I2;
    private String I3;
    private MethodDecl2 MethodDecl2;

    public MDL21 (MethodDeclList2 MethodDeclList2, String I2, String I3, MethodDecl2 MethodDecl2) {
        this.MethodDeclList2=MethodDeclList2;
        if(MethodDeclList2!=null) MethodDeclList2.setParent(this);
        this.I2=I2;
        this.I3=I3;
        this.MethodDecl2=MethodDecl2;
        if(MethodDecl2!=null) MethodDecl2.setParent(this);
    }

    public MethodDeclList2 getMethodDeclList2() {
        return MethodDeclList2;
    }

    public void setMethodDeclList2(MethodDeclList2 MethodDeclList2) {
        this.MethodDeclList2=MethodDeclList2;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public String getI3() {
        return I3;
    }

    public void setI3(String I3) {
        this.I3=I3;
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
        if(MethodDeclList2!=null) MethodDeclList2.accept(visitor);
        if(MethodDecl2!=null) MethodDecl2.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclList2!=null) MethodDeclList2.traverseTopDown(visitor);
        if(MethodDecl2!=null) MethodDecl2.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclList2!=null) MethodDeclList2.traverseBottomUp(visitor);
        if(MethodDecl2!=null) MethodDecl2.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MDL21(\n");

        if(MethodDeclList2!=null)
            buffer.append(MethodDeclList2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(" "+tab+I3);
        buffer.append("\n");

        if(MethodDecl2!=null)
            buffer.append(MethodDecl2.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MDL21]");
        return buffer.toString();
    }
}
