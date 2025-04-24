package aufgabe5;

public class PythagorasTree_V2 {

    private static final double GAMMA = 0;
    private static final double RAD_GAMMA = Math.toRadians(GAMMA);
    private static final double BORDER = 0.04;
    /*
     * Draws a Pythagorean tree based on the given angle.
     */
    public static void drawPyTree(double angle, double x, double y, double l, double newPenWidth) {
        if (l < BORDER) {
            return;
        }
        StdDraw.setPenRadius(newPenWidth);
        double w = l;
        double lowerbound =  w * 1.5;
        double upperbound = 2 * w;
        double h = Math.random() * (upperbound - lowerbound) + lowerbound;
        double s = w * Math.sin(angle);
        double c = w * Math.cos(angle);
        double s2 = h * Math.sin(angle);
        double c2 = h * Math.cos(angle);
        double randomAngle = Math.toRadians(Math.random() * (70) + 15);
        double u = w * Math.cos(randomAngle);
        double v = w * Math.sin(randomAngle);
        if (l < 3 * BORDER) {
            StdDraw.setPenColor(StdDraw.GREEN);
        } else {
            StdDraw.setPenColor(StdDraw.BROWN);
        }
        // A
        Point A = new Point(x, y);
        // B
        Point B = new Point(A.getX() + c, A.getY() + s);
        // StdDraw.line(A.getX(), A.getY(), B.getX(), B.getY());
        // D
        Point D = new Point(A.getX() - s2, A.getY() + c2);
        StdDraw.line(A.getX(), A.getY(), D.getX(), D.getY());
        // C
        Point C = new Point(A.getX() + c - s2, A.getY() + s + c2);
        // StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        StdDraw.line(B.getX(), B.getY(), C.getX(), C.getY());
        if (l < BORDER) {
                StdDraw.line(A.getX(), A.getY(), B.getX(), B.getY());
                StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        } else {
            // DCE
            Point E = new Point(A.getX() - s2 + u * Math.cos(randomAngle + angle), A.getY() + c2 + u * Math.sin(randomAngle + angle));
            if (v < BORDER) {
                StdDraw.line(C.getX(), C.getY(), E.getX(), E.getY());
            }
            drawPyTree(randomAngle + angle, D.getX(), D.getY(), u, newPenWidth*1.10 * (u / l));
            drawPyTree(Math.toRadians(-90) + randomAngle + angle, E.getX(), E.getY(), v, newPenWidth * 1.13 * (v / l));
        }
    }

    /*
     * The main method is the entry point of the program.
     * @param args not used
     */
    public static void main(String[] args) {
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        drawPyTree(RAD_GAMMA, 4, 0.5, 1.0, 0.004);
    }
}
