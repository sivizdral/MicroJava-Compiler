// generated with ast extension for cup
// version 0.8
// 3/0/2023 20:15:40


package rs.ac.bg.etf.pp1.ast;

public class VarDeclX extends VarDecl {

    private Type Type;
    private FirstVarDecl FirstVarDecl;
    private OtherVarDeclList OtherVarDeclList;

    public VarDeclX (Type Type, FirstVarDecl FirstVarDecl, OtherVarDeclList OtherVarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FirstVarDecl=FirstVarDecl;
        if(FirstVarDecl!=null) FirstVarDecl.setParent(this);
        this.OtherVarDeclList=OtherVarDeclList;
        if(OtherVarDeclList!=null) OtherVarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FirstVarDecl getFirstVarDecl() {
        return FirstVarDecl;
    }

    public void setFirstVarDecl(FirstVarDecl FirstVarDecl) {
        this.FirstVarDecl=FirstVarDecl;
    }

    public OtherVarDeclList getOtherVarDeclList() {
        return OtherVarDeclList;
    }

    public void setOtherVarDeclList(OtherVarDeclList OtherVarDeclList) {
        this.OtherVarDeclList=OtherVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.accept(visitor);
        if(OtherVarDeclList!=null) OtherVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.traverseTopDown(visitor);
        if(OtherVarDeclList!=null) OtherVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FirstVarDecl!=null) FirstVarDecl.traverseBottomUp(visitor);
        if(OtherVarDeclList!=null) OtherVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclX(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstVarDecl!=null)
            buffer.append(FirstVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OtherVarDeclList!=null)
            buffer.append(OtherVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclX]");
        return buffer.toString();
    }
}
