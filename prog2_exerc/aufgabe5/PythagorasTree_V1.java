package aufgabe5;

public class PythagorasTree_V1 {

    private static final double DELTA = 30;
    private static final double GAMMA = 0;
    private static final double RAD_DELTA = Math.toRadians(DELTA);
    private static final double RAD_GAMMA = Math.toRadians(GAMMA);
    private static final double BORDER = 0.14;
    /*
     * Draws a Pythagorean tree based on the given angle.
     */
    public static void drawPyTree(double angle, double x, double y, double l, double newPenWidth) {
        StdDraw.setPenRadius(newPenWidth);
        double w = l;
        double s = w * Math.sin(angle);
        double c = w * Math.cos(angle);
        double u = w * Math.cos(RAD_DELTA);
        double v = w * Math.sin(RAD_DELTA);
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
        Point D = new Point(A.getX() - s, A.getY() + c);
        StdDraw.line(A.getX(), A.getY(), D.getX(), D.getY());
        //C
        Point C = new Point(A.getX() + c - s, A.getY() + s + c);
        // StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        StdDraw.line(B.getX(), B.getY(), C.getX(), C.getY());
        if (l < BORDER) {
                StdDraw.line(A.getX(), A.getY(), B.getX(), B.getY());
                StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        } else {
            // DCE
            Point E = new Point(A.getX() - s + u * Math.cos(RAD_DELTA + angle), A.getY() + c + u * Math.sin(RAD_DELTA + angle));
            
            if (v < BORDER) {
                StdDraw.line(C.getX(), C.getY(), E.getX(), E.getY());
            }
            drawPyTree(RAD_DELTA + angle, D.getX(), D.getY(), u, newPenWidth * 1.12 * (u / l));
            drawPyTree(Math.toRadians(-90) + RAD_DELTA + angle, E.getX(), E.getY(), v, newPenWidth * 1.12 * (u / l));
        }
    }

    /*
     * The main method is the entry point of the program.
     * @param args not used
     */
    public static void main(String[] args) {
        StdDraw.setXscale(0, 10);
        StdDraw.setYscale(0, 10);
        drawPyTree(RAD_GAMMA, 6, 1, 1.5, 0.004);
    }
}
