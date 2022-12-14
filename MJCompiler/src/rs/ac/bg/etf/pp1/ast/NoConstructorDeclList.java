// generated with ast extension for cup
// version 0.8
// 14/11/2022 22:30:50


package rs.ac.bg.etf.pp1.ast;

public class NoConstructorDeclList extends ConstructorDeclList {

    private FirstConstructorDecl FirstConstructorDecl;

    public NoConstructorDeclList (FirstConstructorDecl FirstConstructorDecl) {
        this.FirstConstructorDecl=FirstConstructorDecl;
        if(FirstConstructorDecl!=null) FirstConstructorDecl.setParent(this);
    }

    public FirstConstructorDecl getFirstConstructorDecl() {
        return FirstConstructorDecl;
    }

    public void setFirstConstructorDecl(FirstConstructorDecl FirstConstructorDecl) {
        this.FirstConstructorDecl=FirstConstructorDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FirstConstructorDecl!=null) FirstConstructorDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FirstConstructorDecl!=null) FirstConstructorDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FirstConstructorDecl!=null) FirstConstructorDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NoConstructorDeclList(\n");

        if(FirstConstructorDecl!=null)
            buffer.append(FirstConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NoConstructorDeclList]");
        return buffer.toString();
    }
}
