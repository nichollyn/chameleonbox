package gem.sparseboolean.math;

public class Matrix2x2 {
    public static Matrix2x2 add(Matrix2x2 lhs, Matrix2x2 rhs) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = lhs.m[0][0] + rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] + rhs.m[0][1];
        out.m[1][0] = lhs.m[1][0] + rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] + rhs.m[1][1];

        return out;
    }

    public static Matrix2x2 div(Matrix2x2 lhs, double f) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = lhs.m[0][0] / f;
        out.m[0][1] = lhs.m[0][1] / f;
        out.m[1][0] = lhs.m[1][0] / f;
        out.m[1][1] = lhs.m[1][1] / f;

        return out;
    }

    public static Matrix2x2 getMatrix2x2WithIdentity() {
        Matrix2x2 matrix = new Matrix2x2();
        matrix.identity();
        return matrix;
    }

    public static Matrix2x2 getMatrix2x2WithZero() {
        Matrix2x2 matrix = new Matrix2x2();
        matrix.zero();
        return matrix;
    }

    public static Matrix2x2 mul(Matrix2x2 lhs, double f) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = lhs.m[0][0] * f;
        out.m[0][1] = lhs.m[0][1] * f;
        out.m[1][0] = lhs.m[1][0] * f;
        out.m[1][1] = lhs.m[1][1] * f;

        return out;
    }

    public static Matrix2x2 mul(Matrix2x2 lhs, Matrix2x2 rhs) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = lhs.m[0][0] * rhs.m[0][0] + lhs.m[0][1] * rhs.m[1][0];
        out.m[1][0] = lhs.m[1][0] * rhs.m[0][0] + lhs.m[1][1] * rhs.m[1][0];

        out.m[0][1] = lhs.m[0][0] * rhs.m[0][1] + lhs.m[0][1] * rhs.m[1][1];
        out.m[1][1] = lhs.m[1][0] * rhs.m[0][1] + lhs.m[1][1] * rhs.m[1][1];

        return out;
    }

    public static Vector2 mul(Matrix2x2 lhs, Vector2 rhs) {
        Vector2 result = new Vector2();

        result.setX(rhs.getX() * lhs.m[0][0] + rhs.getY() * lhs.m[0][1]);
        result.setY(rhs.getX() * lhs.m[1][0] + rhs.getY() * lhs.m[1][1]);

        return result;
    }

    public static Matrix2x2 negation(Matrix2x2 original) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = -original.m[0][0];
        out.m[0][1] = -original.m[0][1];
        out.m[1][0] = -original.m[1][0];
        out.m[1][1] = -original.m[1][1];

        return out;
    }

    public static Matrix2x2 sub(Matrix2x2 lhs, Matrix2x2 rhs) {
        Matrix2x2 out = new Matrix2x2();

        out.m[0][0] = lhs.m[0][0] - rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] - rhs.m[0][1];
        out.m[1][0] = lhs.m[1][0] - rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] - rhs.m[1][1];

        return out;
    }

    public double[][] m = new double[2][2];

    public Matrix2x2() {
        identity();
    }

    public Matrix2x2(Matrix2x2 other) {
        copyValueFrom(other);
    }

    public void add(Matrix2x2 rhs) {
        m[0][0] += rhs.m[0][0];
        m[0][1] += rhs.m[0][1];
        m[1][0] += rhs.m[1][0];
        m[1][1] += rhs.m[1][1];
    }

    public void copyValueFrom(Matrix2x2 other) {
        m[0][0] = other.m[0][0];
        m[0][1] = other.m[0][1];
        m[1][0] = other.m[1][0];
        m[1][1] = other.m[1][1];
    }

    public double determinant() {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public void div(double f) {
        m[0][0] /= f;
        m[0][1] /= f;
        m[1][0] /= f;
        m[1][1] /= f;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Matrix2x2) {
            Matrix2x2 other = (Matrix2x2) o;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (m[i][j] != other.m[i][j])
                        return false;
                }
            }

            return true;
        } else {
            return false;
        }
    }

    public double getElement(int rowNum, int colNum) {
        return m[rowNum][colNum];
    }

    public void identity() {
        m[0][0] = 1.0;
        m[0][1] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 1.0;
    }

    public void inverse() {
        double det = determinant();

        if (det == 0) {
            return;
        }

        Matrix2x2 temp = new Matrix2x2();
        temp.m[0][0] = m[1][1];
        temp.m[0][1] = -m[0][1];
        temp.m[1][0] = -m[1][0];
        temp.m[1][1] = m[0][0];

        copyValueFrom(Matrix2x2.mul(temp, 1 / det));
    }

    public void mul(double f) {
        m[0][0] *= f;
        m[0][1] *= f;
        m[1][0] *= f;
        m[1][1] *= f;
    }

    public void mul(Matrix2x2 rhs) {
        double[][] out = new double[2][2];

        out[0][0] = m[0][0] * rhs.m[0][0] + m[0][1] * rhs.m[1][0];
        out[1][0] = m[1][0] * rhs.m[0][0] + m[1][1] * rhs.m[1][0];

        out[0][1] = m[0][0] * rhs.m[0][1] + m[0][1] * rhs.m[1][1];
        out[1][1] = m[1][0] * rhs.m[0][1] + m[1][1] * rhs.m[1][1];

        m[0][0] = out[0][0];
        m[1][0] = out[1][0];
        m[0][1] = out[0][1];
        m[1][1] = out[1][1];
    }

    public void sub(Matrix2x2 rhs) {
        m[0][0] -= rhs.m[0][0];
        m[0][1] -= rhs.m[0][1];
        m[1][0] -= rhs.m[1][0];
        m[1][1] -= rhs.m[1][1];
    }

    public void zero() {
        m[0][0] = 0.0;
        m[0][1] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 0.0;
    }

    Matrix2x2 getInverse() {
        Matrix2x2 result = new Matrix2x2(this);
        result.inverse();

        return result;
    }
}
