// generated with ast extension for cup
// version 0.8
// 15/11/2022 17:51:21


package rs.ac.bg.etf.pp1.ast;

public class ClassVarDeclX extends ClassVarDecl {

    private Type Type;
    private FirstClassVarDecl FirstClassVarDecl;
    private OtherClassVarDeclList OtherClassVarDeclList;

    public ClassVarDeclX (Type Type, FirstClassVarDecl FirstClassVarDecl, OtherClassVarDeclList OtherClassVarDeclList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FirstClassVarDecl=FirstClassVarDecl;
        if(FirstClassVarDecl!=null) FirstClassVarDecl.setParent(this);
        this.OtherClassVarDeclList=OtherClassVarDeclList;
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FirstClassVarDecl getFirstClassVarDecl() {
        return FirstClassVarDecl;
    }

    public void setFirstClassVarDecl(FirstClassVarDecl FirstClassVarDecl) {
        this.FirstClassVarDecl=FirstClassVarDecl;
    }

    public OtherClassVarDeclList getOtherClassVarDeclList() {
        return OtherClassVarDeclList;
    }

    public void setOtherClassVarDeclList(OtherClassVarDeclList OtherClassVarDeclList) {
        this.OtherClassVarDeclList=OtherClassVarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.accept(visitor);
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.traverseTopDown(visitor);
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FirstClassVarDecl!=null) FirstClassVarDecl.traverseBottomUp(visitor);
        if(OtherClassVarDeclList!=null) OtherClassVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDeclX(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstClassVarDecl!=null)
            buffer.append(FirstClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(OtherClassVarDeclList!=null)
            buffer.append(OtherClassVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDeclX]");
        return buffer.toString();
    }
}
