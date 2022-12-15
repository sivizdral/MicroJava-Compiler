// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:4:46


package rs.ac.bg.etf.pp1.ast;

public class OtherClassVarDeclListX extends OtherClassVarDeclList {

    private OtherVarDeclList OtherVarDeclList;
    private FirstVarDecl FirstVarDecl;

    public OtherClassVarDeclListX (OtherVarDeclList OtherVarDeclList, FirstVarDecl FirstVarDecl) {
        this.OtherVarDeclList=OtherVarDeclList;
        if(OtherVarDeclList!=null) OtherVarDeclList.setParent(this);
        this.FirstVarDecl=FirstVarDecl;
        if(FirstVarDecl!=null) FirstVarDecl.setParent(this);
    }

    public OtherVarDeclList getOtherVarDeclList() {
        return OtherVarDeclList;
    }

    public void setOtherVarDeclList(OtherVarDeclList OtherVarDeclList) {
        this.OtherVarDeclList=OtherVarDeclList;
    }

    public FirstVarDecl getFirstVarDecl() {
        return FirstVarDecl;
    }

    public void setFirstVarDecl(FirstVarDecl FirstVarDecl) {
        this.FirstVarDecl=FirstVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OtherVarDeclList!=null) OtherVarDeclList.accept(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OtherVarDeclList!=null) OtherVarDeclList.traverseTopDown(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OtherVarDeclList!=null) OtherVarDeclList.traverseBottomUp(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OtherClassVarDeclListX(\n");

        if(OtherVarDeclList!=null)
            buffer.append(OtherVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstVarDecl!=null)
            buffer.append(FirstVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OtherClassVarDeclListX]");
        return buffer.toString();
    }
}
