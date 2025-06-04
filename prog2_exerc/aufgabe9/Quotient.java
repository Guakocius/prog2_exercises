package aufgabe9;

public class Quotient extends CompoundExpression {
    public Expression a, b;
    public Quotient(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public String toString() {
        return "("+ a.toString() + " / " + b.toString() + ")";
    }
}
