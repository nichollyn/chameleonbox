package gem.sparseboolean.math;

public class Point2D {
    private double mX;
    private double mY;

    public Point2D() {
        mX = 0;
        mY = 0;
    }

    public Point2D(double x, double y) {
        mX = x;
        mY = y;
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Point2D) {
            Point2D other = (Point2D) o;
            return mX == other.getX() && mY == other.getY();
        } else {
            return false;
        }
    }

    public static Point2D add(Point2D lhs, Point2D rhs) {
        return new Point2D(lhs.getX() + rhs.getX(), lhs.getY() + rhs.getY());
    }

    public static Point2D sub(Point2D lhs, Point2D rhs) {
        return new Point2D(lhs.getX() - rhs.getX(), lhs.getY() - rhs.getY());
    }

    public static Point2D mul(Point2D lhs, Point2D rhs) {
        return new Point2D(lhs.getX() * rhs.getX(), lhs.getY() * rhs.getY());
    }

    public static Point2D mul(Point2D point, double factor) {
        return new Point2D(point.getX() * factor, point.getY() * factor);
    }
}
