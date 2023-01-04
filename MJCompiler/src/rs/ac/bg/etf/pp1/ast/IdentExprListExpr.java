// generated with ast extension for cup
// version 0.8
// 4/0/2023 21:53:13


package rs.ac.bg.etf.pp1.ast;

public class IdentExprListExpr extends IdentExprList {

    private LeftIdent LeftIdent;
    private Expr Expr;

    public IdentExprListExpr (LeftIdent LeftIdent, Expr Expr) {
        this.LeftIdent=LeftIdent;
        if(LeftIdent!=null) LeftIdent.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public LeftIdent getLeftIdent() {
        return LeftIdent;
    }

    public void setLeftIdent(LeftIdent LeftIdent) {
        this.LeftIdent=LeftIdent;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LeftIdent!=null) LeftIdent.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LeftIdent!=null) LeftIdent.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LeftIdent!=null) LeftIdent.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IdentExprListExpr(\n");

        if(LeftIdent!=null)
            buffer.append(LeftIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IdentExprListExpr]");
        return buffer.toString();
    }
}
