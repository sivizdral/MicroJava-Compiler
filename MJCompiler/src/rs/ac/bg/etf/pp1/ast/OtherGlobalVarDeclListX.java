// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class OtherGlobalVarDeclListX extends OtherGlobalVarDeclList {

    private OtherGlobalVarDeclList OtherGlobalVarDeclList;
    private FirstGlobalVarDecl FirstGlobalVarDecl;

    public OtherGlobalVarDeclListX (OtherGlobalVarDeclList OtherGlobalVarDeclList, FirstGlobalVarDecl FirstGlobalVarDecl) {
        this.OtherGlobalVarDeclList=OtherGlobalVarDeclList;
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.setParent(this);
        this.FirstGlobalVarDecl=FirstGlobalVarDecl;
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.setParent(this);
    }

    public OtherGlobalVarDeclList getOtherGlobalVarDeclList() {
        return OtherGlobalVarDeclList;
    }

    public void setOtherGlobalVarDeclList(OtherGlobalVarDeclList OtherGlobalVarDeclList) {
        this.OtherGlobalVarDeclList=OtherGlobalVarDeclList;
    }

    public FirstGlobalVarDecl getFirstGlobalVarDecl() {
        return FirstGlobalVarDecl;
    }

    public void setFirstGlobalVarDecl(FirstGlobalVarDecl FirstGlobalVarDecl) {
        this.FirstGlobalVarDecl=FirstGlobalVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.accept(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.traverseTopDown(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.traverseBottomUp(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OtherGlobalVarDeclListX(\n");

        if(OtherGlobalVarDeclList!=null)
            buffer.append(OtherGlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstGlobalVarDecl!=null)
            buffer.append(FirstGlobalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OtherGlobalVarDeclListX]");
        return buffer.toString();
    }
}
