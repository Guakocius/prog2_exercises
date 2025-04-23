package aufgabe5;

import java.lang.Math;

public class PythagorasTree_V2 {

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
        Point D = new Point(x - s2, y + c2);
        // StdDraw.text(D.getX(), D.getY(), "D");
        StdDraw.line(x, y, D.getX(), D.getY());
        //C
        Point C = new Point (x + c - s2, y + s + c2);
        // StdDraw.text(C.getX(), C.getY(), "C");
        StdDraw.line(D.getX(), D.getY(), C.getX(), C.getY());
        StdDraw.line(B.getX(), B.getY(), C.getX(), C.getY());

        if (l >= BORDER) {
            // DCE
            Point E = new Point(x - s2 + u * Math.cos(randomAngle + angle), y + c2 + u * Math.sin(randomAngle + angle));
            drawPyTree(randomAngle + angle, D.getX(), D.getY(), u, newPenWidth*1.13*(u/l));
            drawPyTree(Math.toRadians(-90)+randomAngle+angle, E.getX(), E.getY(), v, newPenWidth*1.13*(v/l));
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
        // StdDraw.setPenColor(StdDraw.RED);
        // drawPyTree(0, 0.6, 0.6, 0.3);
    }
}
