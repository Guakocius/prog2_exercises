package aufgabe5;

import java.lang.Math;

public class PythagorasTree_V1 {

    private static final double DELTA = 30;
    private static final double GAMMA = 0;
    private static final double RAD_DELTA = Math.toRadians(DELTA);
    private static final double RAD_GAMMA = Math.toRadians(GAMMA);
    private static final double BORDER = 0.04;
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
        if (l < BORDER) {
            StdDraw.setPenColor(StdDraw.GREEN);
        } else {
            StdDraw.setPenColor(StdDraw.BROWN);
        }
        Point A = new Point(x, y);
        // StdDraw.text(x, y, "A");
        //B
        Point B = new Point(x + c, y + s);
        StdDraw.line(x, y, B.getX(), B.getY());
        // StdDraw.text(B.getX(), B.getY(), "B");
        //D
        Point D = new Point(x - s, y + c);
        // StdDraw.text(D.getX(), D.getY(), "D");
        StdDraw.line(x, y, D.getX(), D.getY());
        //C
        Point C = new Point(x + c - s, y + s + c);
        // StdDraw.text(C.getX(), C.getY(), "C");
        StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        StdDraw.line(B.getX(), B.getY(), C.getX(), C.getY());

        if (l >= BORDER) {
            // DCE
            Point E = new Point(x - s + u * Math.cos(RAD_DELTA + angle), y + c + u * Math.sin(RAD_DELTA + angle));
            drawPyTree(RAD_DELTA + angle, D.getX(), D.getY(), u, newPenWidth*1.12*(u/l));
            drawPyTree(Math.toRadians(-90)+RAD_DELTA+angle, E.getX(), E.getY(), v, newPenWidth*1.12*(u/l));
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
        // StdDraw.setPenColor(StdDraw.RED);
        // drawPyTree(0, 0.6, 0.6, 0.3);
    }
}
