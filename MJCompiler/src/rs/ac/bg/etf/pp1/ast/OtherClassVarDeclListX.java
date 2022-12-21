// generated with ast extension for cup
// version 0.8
// 21/11/2022 20:19:22


package rs.ac.bg.etf.pp1.ast;

public class OtherClassVarDeclListX extends OtherClassVarDeclList {

    private OtherClassVarDeclList OtherClassVarDeclList;
    private FirstClassVarDecl FirstClassVarDecl;

    public OtherClassVarDeclListX (OtherClassVarDeclList OtherClassVarDeclList, FirstClassVarDecl FirstClassVarDecl) {
        this.OtherClassVarDeclList=OtherClassVarDeclList;
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.setParent(this);
        this.FirstClassVarDecl=FirstClassVarDecl;
        if(FirstClassVarDecl!=null) FirstClassVarDecl.setParent(this);
    }

    public OtherClassVarDeclList getOtherClassVarDeclList() {
        return OtherClassVarDeclList;
    }

    public void setOtherClassVarDeclList(OtherClassVarDeclList OtherClassVarDeclList) {
        this.OtherClassVarDeclList=OtherClassVarDeclList;
    }

    public FirstClassVarDecl getFirstClassVarDecl() {
        return FirstClassVarDecl;
    }

    public void setFirstClassVarDecl(FirstClassVarDecl FirstClassVarDecl) {
        this.FirstClassVarDecl=FirstClassVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.accept(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.traverseTopDown(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.traverseBottomUp(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OtherClassVarDeclListX(\n");

        if(OtherClassVarDeclList!=null)
            buffer.append(OtherClassVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstClassVarDecl!=null)
            buffer.append(FirstClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OtherClassVarDeclListX]");
        return buffer.toString();
    }
}
