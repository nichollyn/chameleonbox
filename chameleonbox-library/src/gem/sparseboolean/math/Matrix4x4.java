package gem.sparseboolean.math;

public class Matrix4x4 {
    // OpenGL is column major. 
    // Transpost Matrix4x4 before passing it through glLoadMatrix
    public static Matrix4x4 add(Matrix4x4 lhs, Matrix4x4 rhs) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = lhs.m[0][0] + rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] + rhs.m[0][1];
        out.m[0][2] = lhs.m[0][2] + rhs.m[0][2];
        out.m[0][3] = lhs.m[0][3] + rhs.m[0][3];
        out.m[1][0] = lhs.m[1][0] + rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] + rhs.m[1][1];
        out.m[1][2] = lhs.m[1][2] + rhs.m[1][2];
        out.m[1][3] = lhs.m[1][3] + rhs.m[1][3];
        out.m[2][0] = lhs.m[2][0] + rhs.m[2][0];
        out.m[2][1] = lhs.m[2][1] + rhs.m[2][1];
        out.m[2][2] = lhs.m[2][2] + rhs.m[2][2];
        out.m[2][3] = lhs.m[2][3] + rhs.m[2][3];
        out.m[3][0] = lhs.m[3][0] + rhs.m[3][0];
        out.m[3][1] = lhs.m[3][1] + rhs.m[3][1];
        out.m[3][2] = lhs.m[3][2] + rhs.m[3][2];
        out.m[3][3] = lhs.m[3][3] + rhs.m[3][3];

        return out;
    }

    public static Matrix4x4 div(Matrix4x4 lhs, double f) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = lhs.m[0][0] / f;
        out.m[0][1] = lhs.m[0][1] / f;
        out.m[0][2] = lhs.m[0][2] / f;
        out.m[0][3] = lhs.m[0][3] / f;
        out.m[1][0] = lhs.m[1][0] / f;
        out.m[1][1] = lhs.m[1][1] / f;
        out.m[1][2] = lhs.m[1][2] / f;
        out.m[1][3] = lhs.m[1][3] / f;
        out.m[2][0] = lhs.m[2][0] / f;
        out.m[2][1] = lhs.m[2][1] / f;
        out.m[2][2] = lhs.m[2][2] / f;
        out.m[2][3] = lhs.m[2][3] / f;
        out.m[3][0] = lhs.m[3][0] / f;
        out.m[3][1] = lhs.m[3][1] / f;
        out.m[3][2] = lhs.m[3][2] / f;
        out.m[3][3] = lhs.m[3][3] / f;

        return out;
    }

    public static Matrix4x4 getMatrix4x4WithIdentity() {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.identity();
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithRotateX(double angle) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.rotate_x(angle);
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithRotateY(double angle) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.rotate_y(angle);
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithRotateZ(double angle) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.rotate_z(angle);
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithScale(double x, double y, double z) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.scale(x, y, z);
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithTranslate(double x, double y,
            double z) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.translate(x, y, z);
        return matrix;
    }

    public static Matrix4x4 getMatrix4x4WithZero() {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.zero();
        return matrix;
    }

    public static Matrix4x4 mul(Matrix4x4 lhs, double f) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = lhs.m[0][0] * f;
        out.m[0][1] = lhs.m[0][1] * f;
        out.m[0][2] = lhs.m[0][2] * f;
        out.m[0][3] = lhs.m[0][3] * f;
        out.m[1][0] = lhs.m[1][0] * f;
        out.m[1][1] = lhs.m[1][1] * f;
        out.m[1][2] = lhs.m[1][2] * f;
        out.m[1][3] = lhs.m[1][3] * f;
        out.m[2][0] = lhs.m[2][0] * f;
        out.m[2][1] = lhs.m[2][1] * f;
        out.m[2][2] = lhs.m[2][2] * f;
        out.m[2][3] = lhs.m[2][3] * f;
        out.m[3][0] = lhs.m[3][0] * f;
        out.m[3][1] = lhs.m[3][1] * f;
        out.m[3][2] = lhs.m[3][2] * f;
        out.m[3][3] = lhs.m[3][3] * f;

        return out;
    }

    public static Matrix4x4 mul(Matrix4x4 lhs, Matrix4x4 rhs) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = lhs.m[0][0] * rhs.m[0][0] + lhs.m[0][1] * rhs.m[1][0]
                + lhs.m[0][2] * rhs.m[2][0] + lhs.m[0][3] * rhs.m[3][0];
        out.m[0][1] = lhs.m[0][0] * rhs.m[0][1] + lhs.m[0][1] * rhs.m[1][1]
                + lhs.m[0][2] * rhs.m[2][1] + lhs.m[0][3] * rhs.m[3][1];
        out.m[0][2] = lhs.m[0][0] * rhs.m[0][2] + lhs.m[0][1] * rhs.m[1][2]
                + lhs.m[0][2] * rhs.m[2][2] + lhs.m[0][3] * rhs.m[3][2];
        out.m[0][3] = lhs.m[0][0] * rhs.m[0][3] + lhs.m[0][1] * rhs.m[1][3]
                + lhs.m[0][2] * rhs.m[2][3] + lhs.m[0][3] * rhs.m[3][3];

        out.m[1][0] = lhs.m[1][0] * rhs.m[0][0] + lhs.m[1][1] * rhs.m[1][0]
                + lhs.m[1][2] * rhs.m[2][0] + lhs.m[1][3] * rhs.m[3][0];
        out.m[1][1] = lhs.m[1][0] * rhs.m[0][1] + lhs.m[1][1] * rhs.m[1][1]
                + lhs.m[1][2] * rhs.m[2][1] + lhs.m[1][3] * rhs.m[3][1];
        out.m[1][2] = lhs.m[1][0] * rhs.m[0][2] + lhs.m[1][1] * rhs.m[1][2]
                + lhs.m[1][2] * rhs.m[2][2] + lhs.m[1][3] * rhs.m[3][2];
        out.m[1][3] = lhs.m[1][0] * rhs.m[0][3] + lhs.m[1][1] * rhs.m[1][3]
                + lhs.m[1][2] * rhs.m[2][3] + lhs.m[1][3] * rhs.m[3][3];

        out.m[2][0] = lhs.m[2][0] * rhs.m[0][0] + lhs.m[2][1] * rhs.m[1][0]
                + lhs.m[2][2] * rhs.m[2][0] + lhs.m[2][3] * rhs.m[3][0];
        out.m[2][1] = lhs.m[2][0] * rhs.m[0][1] + lhs.m[2][1] * rhs.m[1][1]
                + lhs.m[2][2] * rhs.m[2][1] + lhs.m[2][3] * rhs.m[3][1];
        out.m[2][2] = lhs.m[2][0] * rhs.m[0][2] + lhs.m[2][1] * rhs.m[1][2]
                + lhs.m[2][2] * rhs.m[2][2] + lhs.m[2][3] * rhs.m[3][2];
        out.m[2][3] = lhs.m[2][0] * rhs.m[0][3] + lhs.m[2][1] * rhs.m[1][3]
                + lhs.m[2][2] * rhs.m[2][3] + lhs.m[2][3] * rhs.m[3][3];

        out.m[3][0] = lhs.m[3][0] * rhs.m[0][0] + lhs.m[3][1] * rhs.m[1][0]
                + lhs.m[3][2] * rhs.m[2][0] + lhs.m[3][3] * rhs.m[3][0];
        out.m[3][1] = lhs.m[3][0] * rhs.m[0][1] + lhs.m[3][1] * rhs.m[1][1]
                + lhs.m[3][2] * rhs.m[2][1] + lhs.m[3][3] * rhs.m[3][1];
        out.m[3][2] = lhs.m[3][0] * rhs.m[0][2] + lhs.m[3][1] * rhs.m[1][2]
                + lhs.m[3][2] * rhs.m[2][2] + lhs.m[3][3] * rhs.m[3][2];
        out.m[3][3] = lhs.m[3][0] * rhs.m[0][3] + lhs.m[3][1] * rhs.m[1][3]
                + lhs.m[3][2] * rhs.m[2][3] + lhs.m[3][3] * rhs.m[3][3];

        return out;
    }

    public static Vector4 mul(Matrix4x4 lhs, Vector4 rhs) {
        Vector4 result = new Vector4();

        result.setX(rhs.getX() * lhs.m[0][0] + rhs.getY() * lhs.m[0][1]
                + rhs.getZ() * lhs.m[0][2] + rhs.getW() * lhs.m[0][3]);
        result.setY(rhs.getX() * lhs.m[1][0] + rhs.getY() * lhs.m[1][1]
                + rhs.getZ() * lhs.m[1][2] + rhs.getW() * lhs.m[1][3]);
        result.setZ(rhs.getX() * lhs.m[2][0] + rhs.getY() * lhs.m[2][1]
                + rhs.getZ() * lhs.m[2][2] + rhs.getW() * lhs.m[2][3]);
        result.setW(rhs.getX() * lhs.m[3][0] + rhs.getY() * lhs.m[3][1]
                + rhs.getZ() * lhs.m[3][2] + rhs.getW() * lhs.m[3][3]);

        return result;
    }

    public static Matrix4x4 negation(Matrix4x4 original) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = -original.m[0][0];
        out.m[0][1] = -original.m[0][1];
        out.m[0][2] = -original.m[0][2];
        out.m[0][3] = -original.m[0][3];
        out.m[1][0] = -original.m[1][0];
        out.m[1][1] = -original.m[1][1];
        out.m[1][2] = -original.m[1][2];
        out.m[1][3] = -original.m[1][3];
        out.m[2][0] = -original.m[2][0];
        out.m[2][1] = -original.m[2][1];
        out.m[2][2] = -original.m[2][2];
        out.m[2][3] = -original.m[2][3];
        out.m[3][0] = -original.m[3][0];
        out.m[3][1] = -original.m[3][1];
        out.m[3][2] = -original.m[3][2];
        out.m[3][3] = -original.m[3][3];

        return out;
    }

    public static Matrix4x4 sub(Matrix4x4 lhs, Matrix4x4 rhs) {
        Matrix4x4 out = new Matrix4x4();

        out.m[0][0] = lhs.m[0][0] - rhs.m[0][0];
        out.m[0][1] = lhs.m[0][1] - rhs.m[0][1];
        out.m[0][2] = lhs.m[0][2] - rhs.m[0][2];
        out.m[0][3] = lhs.m[0][3] - rhs.m[0][3];
        out.m[1][0] = lhs.m[1][0] - rhs.m[1][0];
        out.m[1][1] = lhs.m[1][1] - rhs.m[1][1];
        out.m[1][2] = lhs.m[1][2] - rhs.m[1][2];
        out.m[1][3] = lhs.m[0][3] - rhs.m[1][3];
        out.m[2][0] = lhs.m[2][0] - rhs.m[2][0];
        out.m[2][1] = lhs.m[2][1] - rhs.m[2][1];
        out.m[2][2] = lhs.m[2][2] - rhs.m[2][2];
        out.m[2][3] = lhs.m[2][3] - rhs.m[2][3];
        out.m[3][0] = lhs.m[3][0] - rhs.m[3][0];
        out.m[3][1] = lhs.m[3][1] - rhs.m[3][1];
        out.m[3][2] = lhs.m[3][2] - rhs.m[3][2];
        out.m[3][3] = lhs.m[3][3] - rhs.m[3][3];

        return out;
    }

    public double[][] m = new double[4][4];

    public Matrix4x4() {
        identity();
    }

    public Matrix4x4(double a00, double a01, double a02, double a03,
            double a10, double a11, double a12, double a13, double a20,
            double a21, double a22, double a23, double a30, double a31,
            double a32, double a33) {
        m[0][0] = a00;
        m[0][1] = a01;
        m[0][2] = a02;
        m[0][3] = a03;
        m[1][0] = a10;
        m[1][1] = a11;
        m[1][2] = a12;
        m[1][3] = a13;
        m[2][0] = a20;
        m[2][1] = a21;
        m[2][2] = a22;
        m[2][3] = a23;
        m[3][0] = a30;
        m[3][1] = a31;
        m[3][2] = a32;
        m[3][3] = a33;
    }

    public Matrix4x4(Matrix4x4 other) {
        copyValueFrom(other);
    }

    public void add(Matrix4x4 rhs) {
        m[0][0] += rhs.m[0][0];
        m[0][1] += rhs.m[0][1];
        m[0][2] += rhs.m[0][2];
        m[0][3] += rhs.m[0][3];
        m[1][0] += rhs.m[1][0];
        m[1][1] += rhs.m[1][1];
        m[1][2] += rhs.m[1][2];
        m[1][3] += rhs.m[1][3];
        m[2][0] += rhs.m[2][0];
        m[2][1] += rhs.m[2][1];
        m[2][2] += rhs.m[2][2];
        m[2][3] += rhs.m[2][3];
        m[3][0] += rhs.m[3][0];
        m[3][1] += rhs.m[3][1];
        m[3][2] += rhs.m[3][2];
        m[3][3] += rhs.m[3][3];
    }

    public void copyValueFrom(Matrix4x4 other) {
        m[0][0] = other.m[0][0];
        m[0][1] = other.m[0][1];
        m[0][2] = other.m[0][2];
        m[0][3] = other.m[0][3];
        m[1][0] = other.m[1][0];
        m[1][1] = other.m[1][1];
        m[1][2] = other.m[1][2];
        m[1][3] = other.m[1][3];
        m[2][0] = other.m[2][0];
        m[2][1] = other.m[2][1];
        m[2][2] = other.m[2][2];
        m[2][3] = other.m[2][3];
        m[3][0] = other.m[3][0];
        m[3][1] = other.m[3][1];
        m[3][2] = other.m[3][2];
        m[3][3] = other.m[3][3];
    }

    public double determinant() {
        double m00 = m[0][0];
        double m01 = m[0][1];
        double m02 = m[0][2];
        double m03 = m[0][3];
        double m10 = m[1][0];
        double m11 = m[1][1];
        double m12 = m[1][2];
        double m13 = m[1][3];
        double m20 = m[2][0];
        double m21 = m[2][1];
        double m22 = m[2][2];
        double m23 = m[2][3];
        double m30 = m[3][0];
        double m31 = m[3][1];
        double m32 = m[3][2];
        double m33 = m[3][3];

        double det = m03 * m12 * m21 * m30 - m02 * m13 * m21 * m30 - m03 * m11
                * m22 * m30 + m01 * m13 * m22 * m30 + m02 * m11 * m23 * m30
                - m01 * m12 * m23 * m30 - m03 * m12 * m20 * m31 + m02 * m13
                * m20 * m31 + m03 * m10 * m22 * m31 - m00 * m13 * m22 * m31
                - m02 * m10 * m23 * m31 + m00 * m12 * m23 * m31 + m03 * m11
                * m20 * m32 - m01 * m13 * m20 * m32 - m03 * m10 * m21 * m32
                + m00 * m13 * m21 * m32 + m01 * m10 * m23 * m32 - m00 * m11
                * m23 * m32 - m02 * m11 * m20 * m33 + m01 * m12 * m20 * m33
                + m02 * m10 * m21 * m33 - m00 * m12 * m21 * m33 - m01 * m10
                * m22 * m33 + m00 * m11 * m22 * m33;

        return det;
    }

    public void diagonal(double x, double y, double z, double w) {
        m[0][0] = x;
        m[0][1] = 0.0;
        m[0][2] = 0.0;
        m[0][3] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = y;
        m[1][2] = 0.0;
        m[1][3] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = z;
        m[2][3] = 0.0;
        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = 0.0;
        m[3][3] = w;
    }

    public void div(double f) {
        m[0][0] /= f;
        m[0][1] /= f;
        m[0][2] /= f;
        m[0][3] /= f;
        m[1][0] /= f;
        m[1][1] /= f;
        m[1][2] /= f;
        m[1][3] /= f;
        m[2][0] /= f;
        m[2][1] /= f;
        m[2][2] /= f;
        m[2][3] /= f;
        m[3][0] /= f;
        m[3][1] /= f;
        m[3][2] /= f;
        m[3][3] /= f;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Matrix4x4) {
            Matrix4x4 other = (Matrix4x4) o;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
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
        m[0][3] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 1.0;
        m[1][2] = 0.0;
        m[1][3] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = 1.0;
        m[2][3] = 0.0;
        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = 0.0;
        m[3][3] = 1.0;
    }

    public void inverse() {
        double det = determinant();

        if (det == 0) {
            return;
        }

        double m00 = m[0][0];
        double m01 = m[0][1];
        double m02 = m[0][2];
        double m03 = m[0][3];
        double m10 = m[1][0];
        double m11 = m[1][1];
        double m12 = m[1][2];
        double m13 = m[1][3];
        double m20 = m[2][0];
        double m21 = m[2][1];
        double m22 = m[2][2];
        double m23 = m[2][3];
        double m30 = m[3][0];
        double m31 = m[3][1];
        double m32 = m[3][2];
        double m33 = m[3][3];

        Matrix4x4 temp = new Matrix4x4();

        temp.m[0][0] = m12 * m23 * m31 - m13 * m22 * m31 + m13 * m21 * m32
                - m11 * m23 * m32 - m12 * m21 * m33 + m11 * m22 * m33;
        temp.m[0][1] = m03 * m22 * m31 - m02 * m23 * m31 - m03 * m21 * m32
                + m01 * m23 * m32 + m02 * m21 * m33 - m01 * m22 * m33;
        temp.m[0][2] = m02 * m13 * m31 - m03 * m12 * m31 + m03 * m11 * m32
                - m01 * m13 * m32 - m02 * m11 * m33 + m01 * m12 * m33;
        temp.m[0][3] = m03 * m12 * m21 - m02 * m13 * m21 - m03 * m11 * m22
                + m01 * m13 * m22 + m02 * m11 * m23 - m01 * m12 * m23;
        temp.m[1][0] = m13 * m22 * m30 - m12 * m23 * m30 - m13 * m20 * m32
                + m10 * m23 * m32 + m12 * m20 * m33 - m10 * m22 * m33;
        temp.m[1][1] = m02 * m23 * m30 - m03 * m22 * m30 + m03 * m20 * m32
                - m00 * m23 * m32 - m02 * m20 * m33 + m00 * m22 * m33;
        temp.m[1][2] = m03 * m12 * m30 - m02 * m13 * m30 - m03 * m10 * m32
                + m00 * m13 * m32 + m02 * m10 * m33 - m00 * m12 * m33;
        temp.m[1][3] = m02 * m13 * m20 - m03 * m12 * m20 + m03 * m10 * m22
                - m00 * m13 * m22 - m02 * m10 * m23 + m00 * m12 * m23;
        temp.m[2][0] = m11 * m23 * m30 - m13 * m21 * m30 + m13 * m20 * m31
                - m10 * m23 * m31 - m11 * m20 * m33 + m10 * m21 * m33;
        temp.m[2][1] = m03 * m21 * m30 - m01 * m23 * m30 - m03 * m20 * m31
                + m00 * m23 * m31 + m01 * m20 * m33 - m00 * m21 * m33;
        temp.m[2][2] = m01 * m13 * m30 - m03 * m11 * m30 + m03 * m10 * m31
                - m00 * m13 * m31 - m01 * m10 * m33 + m00 * m11 * m33;
        temp.m[2][3] = m03 * m11 * m20 - m01 * m13 * m20 - m03 * m10 * m21
                + m00 * m13 * m21 + m01 * m10 * m23 - m00 * m11 * m23;
        temp.m[3][0] = m12 * m21 * m30 - m11 * m22 * m30 - m12 * m20 * m31
                + m10 * m22 * m31 + m11 * m20 * m32 - m10 * m21 * m32;
        temp.m[3][1] = m01 * m22 * m30 - m02 * m21 * m30 + m02 * m20 * m31
                - m00 * m22 * m31 - m01 * m20 * m32 + m00 * m21 * m32;
        temp.m[3][2] = m02 * m11 * m30 - m01 * m12 * m30 - m02 * m10 * m31
                + m00 * m12 * m31 + m01 * m10 * m32 - m00 * m11 * m32;
        temp.m[3][3] = m01 * m12 * m20 - m02 * m11 * m20 + m02 * m10 * m21
                - m00 * m12 * m21 - m01 * m10 * m22 + m00 * m11 * m22;

        copyValueFrom(Matrix4x4.mul(temp, 1 / det));
    }

    public void lookAt(Vector3 eye, Vector3 at, Vector3 up) {
        // left handed
        Vector3 z_axis = Vector3.sub(at, eye);
        Vector3 x_axis = z_axis.crossProduct(up);
        Vector3 y_axis = x_axis.crossProduct(z_axis);

        x_axis.normalize();
        y_axis.normalize();
        z_axis.normalize();

        Matrix4x4 rot = new Matrix4x4();
        rot.m[0][0] = x_axis.getX();
        rot.m[0][1] = x_axis.getY();
        rot.m[0][2] = x_axis.getZ();
        rot.m[0][3] = 0;

        rot.m[1][0] = y_axis.getX();
        rot.m[1][1] = y_axis.getY();
        rot.m[1][2] = y_axis.getZ();
        rot.m[1][3] = 0;

        rot.m[2][0] = -z_axis.getX();
        rot.m[2][1] = -z_axis.getY();
        rot.m[2][2] = -z_axis.getZ();
        rot.m[2][3] = 0;

        rot.m[3][0] = 0.0;
        rot.m[3][1] = 0.0;
        rot.m[3][2] = 0.0;
        rot.m[3][3] = 1.0;

        Matrix4x4 trans = new Matrix4x4();
        trans.translate(-eye.getX(), -eye.getY(), -eye.getZ());

        copyValueFrom(Matrix4x4.mul(rot, trans));
    }

    public void mul(double f) {
        m[0][0] *= f;
        m[0][1] *= f;
        m[0][2] *= f;
        m[0][3] *= f;
        m[1][0] *= f;
        m[1][1] *= f;
        m[1][2] *= f;
        m[1][3] *= f;
        m[2][0] *= f;
        m[2][1] *= f;
        m[2][2] *= f;
        m[2][3] *= f;
        m[3][0] *= f;
        m[3][1] *= f;
        m[3][2] *= f;
        m[3][3] *= f;
    }

    public void mul(Matrix4x4 rhs) {
        double[][] out = new double[4][4];

        out[0][0] = m[0][0] * rhs.m[0][0] + m[0][1] * rhs.m[1][0] + m[0][2]
                * rhs.m[2][0] + m[0][3] * rhs.m[3][0];
        out[0][1] = m[0][0] * rhs.m[0][1] + m[0][1] * rhs.m[1][1] + m[0][2]
                * rhs.m[2][1] + m[0][3] * rhs.m[3][1];
        out[0][2] = m[0][0] * rhs.m[0][2] + m[0][1] * rhs.m[1][2] + m[0][2]
                * rhs.m[2][2] + m[0][3] * rhs.m[3][2];
        out[0][3] = m[0][0] * rhs.m[0][3] + m[0][1] * rhs.m[1][3] + m[0][2]
                * rhs.m[2][3] + m[0][3] * rhs.m[3][3];

        out[1][0] = m[1][0] * rhs.m[0][0] + m[1][1] * rhs.m[1][0] + m[1][2]
                * rhs.m[2][0] + m[1][3] * rhs.m[3][0];
        out[1][1] = m[1][0] * rhs.m[0][1] + m[1][1] * rhs.m[1][1] + m[1][2]
                * rhs.m[2][1] + m[1][3] * rhs.m[3][1];
        out[1][2] = m[1][0] * rhs.m[0][2] + m[1][1] * rhs.m[1][2] + m[1][2]
                * rhs.m[2][2] + m[1][3] * rhs.m[3][2];
        out[1][3] = m[1][0] * rhs.m[0][3] + m[1][1] * rhs.m[1][3] + m[1][2]
                * rhs.m[2][3] + m[1][3] * rhs.m[3][3];

        out[2][0] = m[2][0] * rhs.m[0][0] + m[2][1] * rhs.m[1][0] + m[2][2]
                * rhs.m[2][0] + m[2][3] * rhs.m[3][0];
        out[2][1] = m[2][0] * rhs.m[0][1] + m[2][1] * rhs.m[1][1] + m[2][2]
                * rhs.m[2][1] + m[2][3] * rhs.m[3][1];
        out[2][2] = m[2][0] * rhs.m[0][2] + m[2][1] * rhs.m[1][2] + m[2][2]
                * rhs.m[2][2] + m[2][3] * rhs.m[3][2];
        out[2][3] = m[2][0] * rhs.m[0][3] + m[2][1] * rhs.m[1][3] + m[2][2]
                * rhs.m[2][3] + m[2][3] * rhs.m[3][3];

        out[3][0] = m[3][0] * rhs.m[0][0] + m[3][1] * rhs.m[1][0] + m[3][2]
                * rhs.m[2][0] + m[3][3] * rhs.m[3][0];
        out[3][1] = m[3][0] * rhs.m[0][1] + m[3][1] * rhs.m[1][1] + m[3][2]
                * rhs.m[2][1] + m[3][3] * rhs.m[3][1];
        out[3][2] = m[3][0] * rhs.m[0][2] + m[3][1] * rhs.m[1][2] + m[3][2]
                * rhs.m[2][2] + m[3][3] * rhs.m[3][2];
        out[3][3] = m[3][0] * rhs.m[0][3] + m[3][1] * rhs.m[1][3] + m[3][2]
                * rhs.m[2][3] + m[3][3] * rhs.m[3][3];

        m[0][0] = out[0][0];
        m[1][0] = out[1][0];
        m[2][0] = out[2][0];
        m[3][0] = out[3][0];
        m[0][1] = out[0][1];
        m[1][1] = out[1][1];
        m[2][1] = out[2][1];
        m[3][1] = out[3][1];
        m[0][2] = out[0][2];
        m[1][2] = out[1][2];
        m[2][2] = out[2][2];
        m[3][2] = out[3][2];
        m[0][3] = out[0][3];
        m[1][3] = out[1][3];
        m[2][3] = out[2][3];
        m[3][3] = out[3][3];
    }

    /*
     *  Set to an orthographic projection matrix.
     *  
     *      2/(r-l)  0           0           -(r+l)/(r-l)
     *      0        2/(t-b)     0           -(t+b)/(t-b)
     *      0        0           -2/(f-n)    -(f+n)/(f-n)
     *      0        0           0           1
     */
    public void orthographic(double l, double r, double b, double t, double n,
            double f) {
        double sx = 1 / (r - l);
        double sy = 1 / (t - b);
        double sz = 1 / (f - n);

        m[0][0] = 2.0 * sx;
        m[0][1] = 0.0;
        m[0][2] = 0.0;
        m[0][3] = -(r + l) * sx;

        m[1][0] = 0.0;
        m[1][1] = 2.0 * sy;
        m[1][2] = 0.0;
        m[1][3] = -(t + b) * sy;

        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = -2.0 * sz;
        m[2][3] = -(f + n) * sz;

        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = 0.0;
        m[3][3] = 1.0;
    }

    /* 
     * Set to a perspective projection matrix specified in terms of field of view and aspect ratio.
     */
    public void perspective(double FoV, double aspectRatio, double nearPlane,
            double farPlane) {
        double t = Math.tan(FoV * 0.5) * nearPlane;
        double b = -t;

        double l = aspectRatio * b;
        double r = aspectRatio * t;

        perspective(l, r, t, b, nearPlane, farPlane);
    }

    /* 
     * Set to a perspective projection matrix.
     * 
     *      2*n/(r-l)    0           (r+l)/(r-l)     0
     *      0            2*n/(t-b)   (t+b)/(t-b)     0
     *      0            0           -(f+n)/(f-n)    -2*f*n/(f-n)
     *      0            0           -1              0
     */
    public void perspective(double l, double r, double t, double b, double n,
            double f) {
        m[0][0] = 2.0 * n / (r - l);
        m[0][1] = 0.0;
        m[0][2] = (r + l) / (r - l);
        m[0][3] = 0.0;

        m[1][0] = 0.0;
        m[1][1] = 2.0 * n / (t - b);
        m[1][2] = (t + b) / (t - b);
        m[1][3] = 0.0;

        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = -(f + n) / (f - n);
        m[2][3] = -2.0 * f * n / (f - n);

        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = -1.0;
        m[3][3] = 0.0;
    }

    /*
     *      (r-l)/2*n    0           0               (r+l)/(2*n)
     *      0            (t-b)/(2*n) 0               (t+b)/(2*n)
     *      0            0           0               -1
     *      0            0           -(f-n)/(2*f*n)  (f+n)/(2*f*n)
    */
    public void perspectiveInverse(double l, double r, double t, double b,
            double n, double f) {
        m[0][0] = (r - l) / (2.0 * n);
        m[0][1] = 0;
        m[0][2] = 0;
        m[0][3] = (r + l) / (2.0 * n);

        m[1][0] = 0;
        m[1][1] = (t - b) / (2.0 * n);
        m[1][2] = (t + b) / (2.0 * n);
        m[1][3] = 0;

        m[2][0] = 0;
        m[2][1] = 0;
        m[2][2] = 0;
        m[2][3] = -1;

        m[3][0] = 0;
        m[3][1] = 0;
        m[3][2] = -(f - n) / (2.0 * f * n);
        m[3][3] = (f + n) / (2.0 * f * n);
    }

    public void rotate(double angle, Vector3 axis) {

        if (axis.lengthSquared() < Constants.EPSILON_MICRO) {
            identity();
        } else {
            axis.normalize();

            double fCos = Math.cos(angle);
            double fSin = Math.sin(angle);
            double fOneMinusCos = 1.0 - fCos;
            double fX2 = axis.getX() * axis.getX();
            double fY2 = axis.getY() * axis.getY();
            double fZ2 = axis.getZ() * axis.getZ();
            double fXYM = axis.getX() * axis.getY() * fOneMinusCos;
            double fXZM = axis.getX() * axis.getZ() * fOneMinusCos;
            double fYZM = axis.getY() * axis.getZ() * fOneMinusCos;
            double fXSin = axis.getX() * fSin;
            double fYSin = axis.getY() * fSin;
            double fZSin = axis.getZ() * fSin;

            m[0][0] = fX2 * fOneMinusCos + fCos;
            m[0][1] = fXYM - fZSin;
            m[0][2] = fXZM + fYSin;
            m[0][3] = 0;

            m[1][0] = fXYM + fZSin;
            m[1][1] = fY2 * fOneMinusCos + fCos;
            m[1][2] = fYZM - fXSin;
            m[1][3] = 0;

            m[2][0] = fXZM - fYSin;
            m[2][1] = fYZM + fXSin;
            m[2][2] = fZ2 * fOneMinusCos + fCos;
            m[2][3] = 0;

            m[3][0] = 0;
            m[3][1] = 0;
            m[3][2] = 0;
            m[3][3] = 1;
        }
    }

    public void rotate_x(double angle) {
        identity();

        m[0][0] = 1.0;
        m[1][0] = 0.0;
        m[2][0] = 0.0;
        m[3][0] = 0.0;

        m[0][1] = 0.0;
        m[1][1] = Math.cos(angle);
        m[2][1] = Math.sin(angle);
        m[3][1] = 0.0;

        m[0][2] = 0.0;
        m[1][2] = -Math.sin(angle);
        m[2][2] = Math.cos(angle);
        m[3][2] = 0.0;

        m[0][3] = 0.0;
        m[1][3] = 0.0;
        m[2][3] = 0.0;
        m[3][3] = 1.0;
    }

    public void rotate_y(double angle) {
        identity();

        m[0][0] = Math.cos(angle);
        m[1][0] = 0.0;
        m[2][0] = -Math.sin(angle);
        m[3][0] = 0.0;

        m[0][1] = 0.0;
        m[1][1] = 1.0;
        m[2][1] = 0.0;
        m[3][1] = 0.0;

        m[0][2] = Math.sin(angle);
        m[1][2] = 0.0;
        m[2][2] = Math.cos(angle);
        m[3][2] = 0.0;

        m[0][3] = 0.0;
        m[1][3] = 0.0;
        m[2][3] = 0.0;
        m[3][3] = 1.0;
    }

    public void rotate_z(double angle) {
        identity();

        m[0][0] = Math.cos(angle);
        m[1][0] = Math.sin(angle);
        m[2][0] = 0.0;
        m[3][0] = 0.0;

        m[0][1] = -Math.sin(angle);
        m[1][1] = Math.cos(angle);
        m[2][1] = 0.0;
        m[3][1] = 0.0;

        m[0][2] = 0.0;
        m[1][2] = 0.0;
        m[2][2] = 1.0;
        m[3][2] = 0.0;

        m[0][3] = 0.0;
        m[1][3] = 0.0;
        m[2][3] = 0.0;
        m[3][3] = 1.0;
    }

    public void scale(double s) {
        m[0][0] = s;
        m[0][1] = 0.0;
        m[0][2] = 0.0;
        m[0][3] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = s;
        m[1][2] = 0.0;
        m[1][3] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = s;
        m[2][3] = 0.0;
        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = 0.0;
        m[3][3] = 1.0;
    }

    public void scale(double sx, double sy, double sz) {
        identity();

        m[0][0] = sx;
        m[1][0] = 0.0;
        m[2][0] = 0.0;
        m[3][0] = 0.0;

        m[0][1] = 0.0;
        m[1][1] = sy;
        m[2][1] = 0.0;
        m[3][1] = 0.0;

        m[0][2] = 0.0;
        m[1][2] = 0.0;
        m[2][2] = sz;
        m[3][2] = 0.0;

        m[0][3] = 0.0;
        m[1][3] = 0.0;
        m[2][3] = 0.0;
        m[3][3] = 1.0;
    }

    public void sub(Matrix4x4 rhs) {
        m[0][0] -= rhs.m[0][0];
        m[0][1] -= rhs.m[0][1];
        m[0][2] -= rhs.m[0][2];
        m[0][3] -= rhs.m[0][3];
        m[1][0] -= rhs.m[1][0];
        m[1][1] -= rhs.m[1][1];
        m[1][2] -= rhs.m[1][2];
        m[1][3] -= rhs.m[1][3];
        m[2][0] -= rhs.m[2][0];
        m[2][1] -= rhs.m[2][1];
        m[2][2] -= rhs.m[2][2];
        m[2][3] -= rhs.m[2][3];
        m[3][0] -= rhs.m[3][0];
        m[3][1] -= rhs.m[3][1];
        m[3][2] -= rhs.m[3][2];
        m[3][3] -= rhs.m[3][3];
    }

    public double trace() {
        return m[0][0] + m[1][1] + m[2][2] + m[3][3];
    }

    public void translate(double x, double y, double z) {
        identity();
        m[0][3] = x;
        m[1][3] = y;
        m[2][3] = z;
    }

    public void transpose() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                double t = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = t;
            }
        }
    }

    public void zero() {
        m[0][0] = 0.0;
        m[0][1] = 0.0;
        m[0][2] = 0.0;
        m[0][3] = 0.0;
        m[1][0] = 0.0;
        m[1][1] = 0.0;
        m[1][2] = 0.0;
        m[1][3] = 0.0;
        m[2][0] = 0.0;
        m[2][1] = 0.0;
        m[2][2] = 0.0;
        m[2][3] = 0.0;
        m[3][0] = 0.0;
        m[3][1] = 0.0;
        m[3][2] = 0.0;
        m[3][3] = 0.0;
    }

    Matrix4x4 getInverse() {
        Matrix4x4 result = new Matrix4x4(this);
        result.inverse();

        return result;
    }
}
