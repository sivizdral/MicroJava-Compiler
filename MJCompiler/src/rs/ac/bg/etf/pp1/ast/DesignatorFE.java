// generated with ast extension for cup
// version 0.8
// 26/11/2022 18:42:47


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFE implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Struct struct = null;

    private DesignatorStart DesignatorStart;
    private IdentExprList IdentExprList;

    public DesignatorFE (DesignatorStart DesignatorStart, IdentExprList IdentExprList) {
        this.DesignatorStart=DesignatorStart;
        if(DesignatorStart!=null) DesignatorStart.setParent(this);
        this.IdentExprList=IdentExprList;
        if(IdentExprList!=null) IdentExprList.setParent(this);
    }

    public DesignatorStart getDesignatorStart() {
        return DesignatorStart;
    }

    public void setDesignatorStart(DesignatorStart DesignatorStart) {
        this.DesignatorStart=DesignatorStart;
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
        if(DesignatorStart!=null) DesignatorStart.accept(visitor);
        if(IdentExprList!=null) IdentExprList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStart!=null) DesignatorStart.traverseTopDown(visitor);
        if(IdentExprList!=null) IdentExprList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStart!=null) DesignatorStart.traverseBottomUp(visitor);
        if(IdentExprList!=null) IdentExprList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorFE(\n");

        if(DesignatorStart!=null)
            buffer.append(DesignatorStart.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IdentExprList!=null)
            buffer.append(IdentExprList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorFE]");
        return buffer.toString();
    }
}
