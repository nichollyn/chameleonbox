package gem.sparseboolean.math;

public class Vector4 {
    private static final int T_ADD = 1;
    private static final int T_SUB = 2;
    private static final int T_MUL = 3;

    private double mX = 0.;
    private double mY = 0.;
    private double mZ = 0.;
    private double mW = 0.;

    public static Vector4 add(Vector4 lhs, Vector4 rhs) {
        return arithmetic(lhs, rhs, T_ADD);
    }

    public static Vector4 mul(Vector4 vector, double factor) {
        double x = vector.getX() * factor;
        double y = vector.getY() * factor;
        double z = vector.getZ() * factor;
        double w = vector.getW() * factor;

        return new Vector4(x, y, z, w);
    }

    public static Vector4 mul(Vector4 lhs, Vector4 rhs) {
        return arithmetic(lhs, rhs, T_MUL);
    }

    public static Vector4 sub(Vector4 lhs, Vector4 rhs) {
        return arithmetic(lhs, rhs, T_SUB);
    }

    private static Vector4 arithmetic(Vector4 lhs, Vector4 rhs, int arithType) {
        if (lhs != null && rhs != null && arithType >= T_ADD
                && arithType <= T_MUL) {
            double x = 0.;
            double y = 0.;
            double z = 0.;
            double w = 0.;
            double lhsX = lhs.getX();
            double lhsY = lhs.getY();
            double lhsZ = lhs.getZ();
            double lhsW = lhs.getW();
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();
            double rhsZ = rhs.getZ();
            double rhsW = rhs.getW();

            switch (arithType) {
            case T_ADD:
                x = lhsX + rhsX;
                y = lhsY + rhsY;
                z = lhsZ + rhsZ;
                w = lhsW + rhsW;
                break;
            case T_SUB:
                x = lhsX - rhsX;
                y = lhsY - rhsY;
                z = lhsZ - rhsZ;
                w = lhsW - rhsW;
                break;
            case T_MUL:
                x = lhsX * rhsX;
                y = lhsY * rhsY;
                z = lhsZ * rhsZ;
                w = lhsW * rhsW;
                break;
            }

            return new Vector4(x, y, z, w);
        } else {
            return null;
        }
    }

    public Vector4() {
        mX = 0.;
        mY = 0.;
        mZ = 0.;
        mW = 0.;
    }

    public Vector4(Vector4 other) {
        copyValueFrom(other);
    }

    public Vector4(double x, double y, double z, double w) {
        mX = x;
        mY = y;
        mZ = z;
        mW = w;
    }

    public double getX() {
        return mX;
    }

    public void setX(double x) {
        mX = x;
    }

    public double getY() {
        return mY;
    }

    public void setY(double y) {
        mY = y;
    }

    public double getZ() {
        return mZ;
    }

    public void setZ(double z) {
        mZ = z;
    }

    public double getW() {
        return mW;
    }

    public void setW(double w) {
        mW = w;
    }

    public void add(Vector4 rhs) {
        arithmetic(rhs, T_ADD);
    }

    public void copyValueFrom(Vector4 other) {
        mX = other.getX();
        mY = other.getY();
        mZ = other.getZ();
        mW = other.getW();
    }

    public static Vector4 negation(Vector4 original) {
        return new Vector4(-original.getX(), -original.getY(),
                -original.getZ(), -original.getW());
    }

    void divide_xyz_by_w() throws Exception {
        if (mW == 0) {
            throw new Exception("Can't divide by zero");
        }

        mX = mX / mW;
        mY = mY / mW;
        mZ = mZ / mW;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Vector4) {
            Vector4 other = (Vector4) o;
            return mX == other.getX() && mY == other.getY()
                    && mZ == other.getZ() && mW == other.getW();
        } else {
            return false;
        }
    }

    public void mul(double factor) {
        mX = mX * factor;
        mY = mY * factor;
        mZ = mZ * factor;
        mW = mW * factor;
    }

    public void mul(Vector4 rhs) {
        arithmetic(rhs, T_MUL);
    }

    public void sub(Vector4 rhs) {
        arithmetic(rhs, T_SUB);
    }

    private void arithmetic(Vector4 rhs, int arithType) {
        if (arithType >= T_ADD && arithType <= T_MUL) {
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();
            double rhsZ = rhs.getZ();
            double rhsW = rhs.getW();

            switch (arithType) {
            case T_ADD:
                mX = mX + rhsX;
                mY = mY + rhsY;
                mZ = mZ + rhsZ;
                mW = mW + rhsW;
                break;
            case T_SUB:
                mX = mX - rhsX;
                mY = mY - rhsY;
                mZ = mZ - rhsZ;
                mW = mW - rhsW;
                break;
            case T_MUL:
                mX = mX * rhsX;
                mY = mY * rhsY;
                mZ = mZ * rhsZ;
                mW = mW * rhsW;
                break;
            }
        }
    }
}
