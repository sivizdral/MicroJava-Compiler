// generated with ast extension for cup
// version 0.8
// 26/11/2022 18:42:46


package rs.ac.bg.etf.pp1.ast;

public class ClassDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ClassDeclStart ClassDeclStart;
    private ClassVarDeclList ClassVarDeclList;
    private ConstructorMethodLists ConstructorMethodLists;

    public ClassDecl (ClassDeclStart ClassDeclStart, ClassVarDeclList ClassVarDeclList, ConstructorMethodLists ConstructorMethodLists) {
        this.ClassDeclStart=ClassDeclStart;
        if(ClassDeclStart!=null) ClassDeclStart.setParent(this);
        this.ClassVarDeclList=ClassVarDeclList;
        if(ClassVarDeclList!=null) ClassVarDeclList.setParent(this);
        this.ConstructorMethodLists=ConstructorMethodLists;
        if(ConstructorMethodLists!=null) ConstructorMethodLists.setParent(this);
    }

    public ClassDeclStart getClassDeclStart() {
        return ClassDeclStart;
    }

    public void setClassDeclStart(ClassDeclStart ClassDeclStart) {
        this.ClassDeclStart=ClassDeclStart;
    }

    public ClassVarDeclList getClassVarDeclList() {
        return ClassVarDeclList;
    }

    public void setClassVarDeclList(ClassVarDeclList ClassVarDeclList) {
        this.ClassVarDeclList=ClassVarDeclList;
    }

    public ConstructorMethodLists getConstructorMethodLists() {
        return ConstructorMethodLists;
    }

    public void setConstructorMethodLists(ConstructorMethodLists ConstructorMethodLists) {
        this.ConstructorMethodLists=ConstructorMethodLists;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclStart!=null) ClassDeclStart.accept(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.accept(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclStart!=null) ClassDeclStart.traverseTopDown(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseTopDown(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclStart!=null) ClassDeclStart.traverseBottomUp(visitor);
        if(ClassVarDeclList!=null) ClassVarDeclList.traverseBottomUp(visitor);
        if(ConstructorMethodLists!=null) ConstructorMethodLists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDecl(\n");

        if(ClassDeclStart!=null)
            buffer.append(ClassDeclStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassVarDeclList!=null)
            buffer.append(ClassVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstructorMethodLists!=null)
            buffer.append(ConstructorMethodLists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDecl]");
        return buffer.toString();
    }
}
