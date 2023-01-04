// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class ConstructorDeclListX extends ConstructorDeclList {

    private ConstructorDeclList ConstructorDeclList;
    private ConstructorDeclStart ConstructorDeclStart;
    private FirstConstructorDecl FirstConstructorDecl;

    public ConstructorDeclListX (ConstructorDeclList ConstructorDeclList, ConstructorDeclStart ConstructorDeclStart, FirstConstructorDecl FirstConstructorDecl) {
        this.ConstructorDeclList=ConstructorDeclList;
        if(ConstructorDeclList!=null) ConstructorDeclList.setParent(this);
        this.ConstructorDeclStart=ConstructorDeclStart;
        if(ConstructorDeclStart!=null) ConstructorDeclStart.setParent(this);
        this.FirstConstructorDecl=FirstConstructorDecl;
        if(FirstConstructorDecl!=null) FirstConstructorDecl.setParent(this);
    }

    public ConstructorDeclList getConstructorDeclList() {
        return ConstructorDeclList;
    }

    public void setConstructorDeclList(ConstructorDeclList ConstructorDeclList) {
        this.ConstructorDeclList=ConstructorDeclList;
    }

    public ConstructorDeclStart getConstructorDeclStart() {
        return ConstructorDeclStart;
    }

    public void setConstructorDeclStart(ConstructorDeclStart ConstructorDeclStart) {
        this.ConstructorDeclStart=ConstructorDeclStart;
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
        if(ConstructorDeclList!=null) ConstructorDeclList.accept(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.accept(visitor);
        if(FirstConstructorDecl!=null) FirstConstructorDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseTopDown(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseTopDown(visitor);
        if(FirstConstructorDecl!=null) FirstConstructorDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstructorDeclList!=null) ConstructorDeclList.traverseBottomUp(visitor);
        if(ConstructorDeclStart!=null) ConstructorDeclStart.traverseBottomUp(visitor);
        if(FirstConstructorDecl!=null) FirstConstructorDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstructorDeclListX(\n");

        if(ConstructorDeclList!=null)
            buffer.append(ConstructorDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorDeclStart!=null)
            buffer.append(ConstructorDeclStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstConstructorDecl!=null)
            buffer.append(FirstConstructorDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstructorDeclListX]");
        return buffer.toString();
    }
}
