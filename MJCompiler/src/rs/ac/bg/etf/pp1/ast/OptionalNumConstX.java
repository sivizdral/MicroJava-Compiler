// generated with ast extension for cup
// version 0.8
// 3/0/2023 20:15:41


package rs.ac.bg.etf.pp1.ast;

public class OptionalNumConstX extends OptionalNumConst {

    private Integer width;

    public OptionalNumConstX (Integer width) {
        this.width=width;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width=width;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OptionalNumConstX(\n");

        buffer.append(" "+tab+width);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OptionalNumConstX]");
        return buffer.toString();
    }
}
