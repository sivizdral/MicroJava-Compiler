// generated with ast extension for cup
// version 0.8
// 18/11/2022 23:50:57


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarDeclX extends GlobalVarDecl {

    private Type Type;
    private FirstGlobalVarDecl FirstGlobalVarDecl;
    private OtherGlobalVarDeclList OtherGlobalVarDeclList;

    public GlobalVarDeclX (Type Type, FirstGlobalVarDecl FirstGlobalVarDecl, OtherGlobalVarDeclList OtherGlobalVarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FirstGlobalVarDecl=FirstGlobalVarDecl;
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.setParent(this);
        this.OtherGlobalVarDeclList=OtherGlobalVarDeclList;
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FirstGlobalVarDecl getFirstGlobalVarDecl() {
        return FirstGlobalVarDecl;
    }

    public void setFirstGlobalVarDecl(FirstGlobalVarDecl FirstGlobalVarDecl) {
        this.FirstGlobalVarDecl=FirstGlobalVarDecl;
    }

    public OtherGlobalVarDeclList getOtherGlobalVarDeclList() {
        return OtherGlobalVarDeclList;
    }

    public void setOtherGlobalVarDeclList(OtherGlobalVarDeclList OtherGlobalVarDeclList) {
        this.OtherGlobalVarDeclList=OtherGlobalVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.accept(visitor);
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.traverseTopDown(visitor);
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FirstGlobalVarDecl!=null) FirstGlobalVarDecl.traverseBottomUp(visitor);
        if(OtherGlobalVarDeclList!=null) OtherGlobalVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarDeclX(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstGlobalVarDecl!=null)
            buffer.append(FirstGlobalVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OtherGlobalVarDeclList!=null)
            buffer.append(OtherGlobalVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarDeclX]");
        return buffer.toString();
    }
}
