package aufgabe9;

public class Product extends CompoundExpression {
    public Expression a, b;
    public Product(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return "(" + a.toString() + " * " + b.toString() + ")";
    }

}
