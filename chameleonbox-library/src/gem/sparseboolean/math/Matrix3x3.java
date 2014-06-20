package gem.sparseboolean.math;

public class Matrix3x3 {
    public static Matrix3x3 add(Matrix3x3 lhs, Matrix3x3 rhs) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = lhs.m[0][0] + rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] + rhs.m[0][1];
        out.m[0][2] = lhs.m[0][2] + rhs.m[0][2];
        out.m[1][0] = lhs.m[1][0] + rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] + rhs.m[1][1];
        out.m[1][2] = lhs.m[1][2] + rhs.m[1][2];
        out.m[2][0] = lhs.m[2][0] + rhs.m[2][0];
        out.m[2][1] = lhs.m[2][1] + rhs.m[2][1];
        out.m[2][2] = lhs.m[2][2] + rhs.m[2][2];

        return out;
    }

    public static Matrix3x3 div(Matrix3x3 lhs, double f) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = lhs.m[0][0] / f;
        out.m[0][1] = lhs.m[0][1] / f;
        out.m[0][2] = lhs.m[0][2] / f;
        out.m[1][0] = lhs.m[1][0] / f;
        out.m[1][1] = lhs.m[1][1] / f;
        out.m[1][2] = lhs.m[1][2] / f;
        out.m[2][0] = lhs.m[2][0] / f;
        out.m[2][1] = lhs.m[2][1] / f;
        out.m[2][2] = lhs.m[2][2] / f;

        return out;
    }

    public static Matrix3x3 getMatrix3x3WithIdentity() {
        Matrix3x3 matrix = new Matrix3x3();
        matrix.identity();
        return matrix;
    }

    public static Matrix3x3 getMatrix3x3WithZero() {
        Matrix3x3 matrix = new Matrix3x3();
        matrix.zero();
        return matrix;
    }

    public static Matrix3x3 mul(Matrix3x3 lhs, double f) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = lhs.m[0][0] * f;
        out.m[0][1] = lhs.m[0][1] * f;
        out.m[0][2] = lhs.m[0][2] * f;
        out.m[1][0] = lhs.m[1][0] * f;
        out.m[1][1] = lhs.m[1][1] * f;
        out.m[1][2] = lhs.m[1][2] * f;
        out.m[2][0] = lhs.m[2][0] * f;
        out.m[2][1] = lhs.m[2][1] * f;
        out.m[2][2] = lhs.m[2][2] * f;

        return out;
    }

    public static Matrix3x3 mul(Matrix3x3 lhs, Matrix3x3 rhs) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = lhs.m[0][0] * rhs.m[0][0] + lhs.m[0][1] * rhs.m[1][0]
                + lhs.m[0][2] * rhs.m[2][0];
        out.m[1][0] = lhs.m[1][0] * rhs.m[0][0] + lhs.m[1][1] * rhs.m[1][0]
                + lhs.m[1][2] * rhs.m[2][0];
        out.m[2][0] = lhs.m[2][0] * rhs.m[0][0] + lhs.m[2][1] * rhs.m[1][0]
                + lhs.m[2][2] * rhs.m[2][0];

        out.m[0][1] = lhs.m[0][0] * rhs.m[0][1] + lhs.m[0][1] * rhs.m[1][1]
                + lhs.m[0][2] * rhs.m[2][1];
        out.m[1][1] = lhs.m[1][0] * rhs.m[0][1] + lhs.m[1][1] * rhs.m[1][1]
                + lhs.m[1][2] * rhs.m[2][1];
        out.m[2][1] = lhs.m[2][0] * rhs.m[0][1] + lhs.m[2][1] * rhs.m[1][1]
                + lhs.m[2][2] * rhs.m[2][1];

        out.m[0][2] = lhs.m[0][0] * rhs.m[0][2] + lhs.m[0][1] * rhs.m[1][2]
                + lhs.m[0][2] * rhs.m[2][2];
        out.m[1][2] = lhs.m[1][0] * rhs.m[0][2] + lhs.m[1][1] * rhs.m[1][2]
                + lhs.m[1][2] * rhs.m[2][2];
        out.m[2][2] = lhs.m[2][0] * rhs.m[0][2] + lhs.m[2][1] * rhs.m[1][2]
                + lhs.m[2][2] * rhs.m[2][2];

        return out;
    }

    public static Vector3 mul(Matrix3x3 lhs, Vector3 rhs) {
        Vector3 result = new Vector3();

        result.setX(rhs.getX() * lhs.m[0][0] + rhs.getY() * lhs.m[0][1]
                + rhs.getZ() * lhs.m[0][2]);
        result.setY(rhs.getX() * lhs.m[1][0] + rhs.getY() * lhs.m[1][1]
                + rhs.getZ() * lhs.m[1][2]);
        result.setZ(rhs.getX() * lhs.m[2][0] + rhs.getY() * lhs.m[2][1]
                + rhs.getZ() * lhs.m[2][2]);

        return result;
    }

    public static Matrix3x3 negation(Matrix3x3 original) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = -original.m[0][0];
        out.m[0][1] = -original.m[0][1];
        out.m[0][2] = -original.m[0][2];
        out.m[1][0] = -original.m[1][0];
        out.m[1][1] = -original.m[1][1];
        out.m[1][2] = -original.m[1][2];
        out.m[2][0] = -original.m[2][0];
        out.m[2][1] = -original.m[2][1];
        out.m[2][2] = -original.m[2][2];

        return out;
    }

    public static Matrix3x3 sub(Matrix3x3 lhs, Matrix3x3 rhs) {
        Matrix3x3 out = new Matrix3x3();

        out.m[0][0] = lhs.m[0][0] - rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] - rhs.m[0][1];
        out.m[0][2] = lhs.m[0][2] - rhs.m[0][2];
        out.m[1][0] = lhs.m[1][0] - rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] - rhs.m[1][1];
        out.m[1][2] = lhs.m[1][2] - rhs.m[1][2];
        out.m[2][0] = lhs.m[2][0] - rhs.m[2][0];
        out.m[2][1] = lhs.m[2][1] - rhs.m[2][1];
        out.m[2][2] = lhs.m[2][2] - rhs.m[2][2];

        return out;
    }

    public double[][] m = new double[3][3];

    public Matrix3x3() {
        identity();
    }

    public Matrix3x3(Matrix3x3 other) {
        copyValueFrom(other);
    }

    public void add(Matrix3x3 rhs) {
        m[0][0] += rhs.m[0][0];
        m[0][1] += rhs.m[0][1];
        m[0][2] += rhs.m[0][2];
        m[1][0] += rhs.m[1][0];
        m[1][1] += rhs.m[1][1];
        m[1][2] += rhs.m[1][2];
        m[2][0] += rhs.m[2][0];
        m[2][1] += rhs.m[2][1];
        m[2][2] += rhs.m[2][2];
    }

    public void copyValueFrom(Matrix3x3 other) {
        m[0][0] = other.m[0][0];
        m[0][1] = other.m[0][1];
        m[0][2] = other.m[0][2];
        m[1][0] = other.m[1][0];
        m[1][1] = other.m[1][1];
        m[1][2] = other.m[1][2];
        m[2][0] = other.m[2][0];
        m[2][1] = other.m[2][1];
        m[2][2] = other.m[2][2];
    }

    public double determinant() {
        return m[0][0] * m[1][1] * m[2][2] + m[0][1] * m[1][2] * m[2][0]
                + m[0][2] * m[2][0] * m[2][1] - m[0][0] * m[1][2] * m[2][1]
                - m[0][1] * m[1][0] * m[2][2] - m[0][2] * m[1][1] * m[2][0];
    }

    public void div(double f) {
        m[0][0] /= f;
        m[0][1] /= f;
        m[0][2] /= f;
        m[1][0] /= f;
        m[1][1] /= f;
        m[1][2] /= f;
        m[2][0] /= f;
        m[2][1] /= f;
        m[2][2] /= f;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Matrix3x3) {
            Matrix3x3 other = (Matrix3x3) o;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
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
        m[0][2] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 1.0;
        m[1][2] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = 1.1;
    }

    public void inverse() {
        double det = determinant();

        if (det == 0) {
            return;
        }

        Matrix3x3 temp = new Matrix3x3();
        temp.m[0][0] = m[1][1] * m[2][2] - m[1][2] * m[2][1];
        temp.m[0][1] = m[0][2] * m[2][1] - m[0][1] * m[2][2];
        temp.m[0][2] = m[0][1] * m[1][2] - m[0][2] * m[1][1];

        temp.m[1][0] = m[1][2] * m[2][0] - m[1][0] * m[2][2];
        temp.m[1][1] = m[0][0] * m[2][2] - m[0][2] * m[2][0];
        temp.m[1][2] = m[0][2] * m[1][0] - m[0][0] * m[1][2];

        temp.m[2][0] = m[1][0] * m[2][1] - m[1][1] * m[2][0];
        temp.m[2][1] = m[0][1] * m[2][0] - m[0][0] * m[2][1];
        temp.m[2][2] = m[0][0] * m[1][1] - m[0][1] * m[1][0];

        copyValueFrom(Matrix3x3.mul(temp, 1 / det));
    }

    public void mul(double f) {
        m[0][0] *= f;
        m[0][1] *= f;
        m[0][2] *= f;
        m[1][0] *= f;
        m[1][1] *= f;
        m[1][2] *= f;
        m[2][0] *= f;
        m[2][1] *= f;
        m[2][2] *= f;
    }

    public void mul(Matrix3x3 rhs) {
        double[][] out = new double[3][3];

        out[0][0] = m[0][0] * rhs.m[0][0] + m[0][1] * rhs.m[1][0] + m[0][2]
                * rhs.m[2][0];
        out[1][0] = m[1][0] * rhs.m[0][0] + m[1][1] * rhs.m[1][0] + m[1][2]
                * rhs.m[2][0];
        out[2][0] = m[2][0] * rhs.m[0][0] + m[2][1] * rhs.m[1][0] + m[2][2]
                * rhs.m[2][0];

        out[0][1] = m[0][0] * rhs.m[0][1] + m[0][1] * rhs.m[1][1] + m[0][2]
                * rhs.m[2][1];
        out[1][1] = m[1][0] * rhs.m[0][1] + m[1][1] * rhs.m[1][1] + m[1][2]
                * rhs.m[2][1];
        out[2][1] = m[2][0] * rhs.m[0][1] + m[2][1] * rhs.m[1][1] + m[2][2]
                * rhs.m[2][1];

        out[0][2] = m[0][0] * rhs.m[0][2] + m[0][1] * rhs.m[1][2] + m[0][2]
                * rhs.m[2][2];
        out[1][2] = m[1][0] * rhs.m[0][2] + m[1][1] * rhs.m[1][2] + m[1][2]
                * rhs.m[2][2];
        out[2][2] = m[2][0] * rhs.m[0][2] + m[2][1] * rhs.m[1][2] + m[2][2]
                * rhs.m[2][2];

        m[0][0] = out[0][0];
        m[1][0] = out[1][0];
        m[2][0] = out[2][0];
        m[0][1] = out[0][1];
        m[1][1] = out[1][1];
        m[2][1] = out[2][1];
        m[0][2] = out[0][2];
        m[1][2] = out[1][2];
        m[2][2] = out[2][2];
    }

    public void sub(Matrix3x3 rhs) {
        m[0][0] -= rhs.m[0][0];
        m[0][1] -= rhs.m[0][1];
        m[0][2] -= rhs.m[0][2];
        m[1][0] -= rhs.m[1][0];
        m[1][1] -= rhs.m[1][1];
        m[1][2] -= rhs.m[1][2];
        m[2][0] -= rhs.m[2][0];
        m[2][1] -= rhs.m[2][1];
        m[2][2] -= rhs.m[2][2];
    }

    public void zero() {
        m[0][0] = 0.0;
        m[0][1] = 0.0;
        m[0][2] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 0.0;
        m[1][2] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = 0.0;
    }

    Matrix3x3 getInverse() {
        Matrix3x3 result = new Matrix3x3(this);
        result.inverse();

        return result;
    }
}
