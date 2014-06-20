package gem.sparseboolean.math;

import java.util.ArrayList;

public class Algorithm {
    public static int pointInside2DPolygon(ArrayList<Point2D> polygon, int n,
            Point2D pt, int onEdge) {
        if (n < 3)
            return 0;
        // cross points count of x
        int __count = 0;

        // neighbor bound vertices
        Point2D p1, p2;

        // left vertex
        p1 = polygon.get(0);

        // check all rays
        for (int i = 1; i <= n; ++i) {
            // point is an vertex
            if (pt == p1)
                return onEdge;

            // right vertex
            p2 = polygon.get(i % n);

            // ray is outside of our interests
            if (pt.getY() < Math.min(p1.getY(), p2.getY())
                    || pt.getY() > Math.max(p1.getY(), p2.getY())) {
                // next ray left point
                p1 = p2;
                continue;
            }

            // ray is crossing over by the algorithm (common part of)
            if (pt.getY() > Math.min(p1.getY(), p2.getY())
                    && pt.getY() < Math.max(p1.getY(), p2.getY())) {
                // x is before of ray
                if (pt.getX() <= Math.max(p1.getX(), p2.getX())) {
                    // overlies on a horizontal ray
                    if (p1.getY() == p2.getY()
                            && pt.getX() >= Math.min(p1.getX(), p2.getX()))
                        return onEdge;

                    // ray is vertical
                    if (p1.getX() == p2.getX()) {
                        // overlies on a ray
                        if (p1.getX() == pt.getX())
                            return onEdge;
                        // before ray
                        else
                            ++__count;
                    }

                    // cross point on the left side
                    else {
                        // cross point of x
                        double xinters = (pt.getY() - p1.getY())
                                * (p2.getX() - p1.getX())
                                / (p2.getY() - p1.getY()) + p1.getX();

                        // overlies on a ray
                        if (Math.abs(pt.getX() - xinters) < Constants.DBL_EPSILON)
                            return onEdge;

                        // before ray
                        if (pt.getX() < xinters)
                            ++__count;
                    }
                }
            }
            // special case when ray is crossing through the vertex
            else {
                // p crossing over p2
                if (pt.getY() == p2.getY() && pt.getX() <= p2.getX()) {
                    // next vertex
                    Point2D p3 = polygon.get((i + 1) % n);

                    if (pt.getY() >= Math.min(p1.getY(), p3.getY())
                            && pt.getY() <= Math.max(p1.getY(), p3.getY())) {
                        ++__count;
                    } else {
                        __count += 2;
                    }
                }
            }

            // next ray left point
            p1 = p2;
        }

        // EVEN
        if (__count % 2 == 0) {
            return (0);
        }
        // ODD
        else {
            return (1);
        }
    }
}
