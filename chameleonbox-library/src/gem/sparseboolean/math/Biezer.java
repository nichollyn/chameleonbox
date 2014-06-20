package gem.sparseboolean.math;

public class Biezer {
    public static double[] bernstein(int n, double t) {
        if (n < 0) {
            // throw an exception
            return null;
        }

        double[] bernstein = new double[n + 1];

        for (int i = 0; i <= n; i++) {
            bernstein[i] = MathUtil.binomialCoefficient(n, i) * Math.pow(t, i)
                    * Math.pow(1.0 - t, n - i);
        }

        return bernstein;
    }

    public static Point2D bezier_XY(int n, double t, double xcon[],
            double ycon[]) {
        if (n < 0) {
            // throw an exception
            return null;
        }

        double[] bval;
        double xval = 0.0;
        double yval = 0.0;
        int i;

        bval = bernstein(n, t);

        for (i = 0; i <= n; i++) {
            xval = xval + xcon[i] * bval[i];
        }

        for (i = 0; i <= n; i++) {
            yval = yval + ycon[i] * bval[i];
        }

        return new Point2D(xval, yval);
    }

    public static Point3D Bezier_XYZ(int n, double t, double xcon[],
            double ycon[], double zcon[]) {
        if (n < 0) {
            // throw an exception
            return null;
        }

        double[] bval;
        double xval = 0.0;
        double yval = 0.0;
        double zval = 0.0;
        int i;

        bval = bernstein(n, t);

        for (i = 0; i <= n; i++) {
            xval = xval + xcon[i] * bval[i];
        }

        for (i = 0; i <= n; i++) {
            yval = yval + ycon[i] * bval[i];
        }

        for (i = 0; i <= n; i++) {
            zval = zval + zcon[i] * bval[i];
        }

        return new Point3D(xval, yval, zval);
    }
}
