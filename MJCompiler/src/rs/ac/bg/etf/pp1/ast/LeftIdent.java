// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class LeftIdent implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private IdentExprList IdentExprList;

    public LeftIdent (IdentExprList IdentExprList) {
        this.IdentExprList=IdentExprList;
        if(IdentExprList!=null) IdentExprList.setParent(this);
    }

    public IdentExprList getIdentExprList() {
        return IdentExprList;
    }

    public void setIdentExprList(IdentExprList IdentExprList) {
        this.IdentExprList=IdentExprList;
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
        if(IdentExprList!=null) IdentExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IdentExprList!=null) IdentExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IdentExprList!=null) IdentExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("LeftIdent(\n");

        if(IdentExprList!=null)
            buffer.append(IdentExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [LeftIdent]");
        return buffer.toString();
    }
}
