package aufgabe9;

public class Sum extends CompoundExpression {

    public Expression a, b;
    public Sum(Expression a, Expression b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a.toString() + " + " + b.toString() + ")";
    }
}