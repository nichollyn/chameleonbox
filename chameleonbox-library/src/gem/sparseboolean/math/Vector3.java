package gem.sparseboolean.math;

public class Vector3 {
    private static final int T_ADD = 1;
    private static final int T_SUB = 2;
    private static final int T_MUL = 3;

    private double mX = 0.;
    private double mY = 0.;
    private double mZ = 0.;

    public static Vector3 add(Vector3 lhs, Vector3 rhs) {
        return arithmetic(lhs, rhs, T_ADD);
    }

    public static double dotProduct(Vector3 lhs, Vector3 rhs) {
        return lhs.getX() * rhs.getX() + lhs.getY() * rhs.getY() + lhs.getZ()
                * rhs.getZ();
    }

    public static Vector3 mul(Vector3 vector, double factor) {
        double x = vector.getX() * factor;
        double y = vector.getY() * factor;
        double z = vector.getZ() * factor;

        return new Vector3(x, y, z);
    }

    public static Vector3 mul(Vector3 lhs, Vector3 rhs) {
        return arithmetic(lhs, rhs, T_MUL);
    }

    public static Vector3 sub(Vector3 lhs, Vector3 rhs) {
        return arithmetic(lhs, rhs, T_SUB);
    }

    private static Vector3 arithmetic(Vector3 lhs, Vector3 rhs, int arithType) {
        if (lhs != null && rhs != null && arithType >= T_ADD
                && arithType <= T_MUL) {
            double x = 0.;
            double y = 0;
            double z = 0.;
            double lhsX = lhs.getX();
            double lhsY = lhs.getY();
            double lhsZ = lhs.getZ();
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();
            double rhsZ = rhs.getZ();

            switch (arithType) {
            case T_ADD:
                x = lhsX + rhsX;
                y = lhsY + rhsY;
                z = lhsZ + rhsZ;
                break;
            case T_SUB:
                x = lhsX - rhsX;
                y = lhsY - rhsY;
                z = lhsZ - rhsZ;
                break;
            case T_MUL:
                x = lhsX * rhsX;
                y = lhsY * rhsY;
                z = lhsZ * rhsZ;
                break;
            }

            return new Vector3(x, y, z);
        } else {
            return null;
        }
    }

    public Vector3() {
        mX = 0.;
        mY = 0.;
        mZ = 0.;
    }

    public Vector3(Vector3 other) {
        copyValueFrom(other);
    }

    public Vector3(double x, double y, double z) {
        mX = x;
        mY = y;
        mZ = z;
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

    public void add(Vector3 rhs) {
        arithmetic(rhs, T_ADD);
    }

    public void copyValueFrom(Vector3 other) {
        mX = other.getX();
        mY = other.getY();
        mZ = other.getZ();
    }

    public double dotProduct(Vector3 rhs) {
        return mX * rhs.getX() + mY * rhs.getY() + mZ * rhs.getZ();
    }

    public static Vector3 negation(Vector3 original) {
        return new Vector3(-original.getX(), -original.getY(), -original.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Vector3) {
            Vector3 other = (Vector3) o;
            return mX == other.getX() && mY == other.getY()
                    && mZ == other.getZ();
        } else {
            return false;
        }
    }

    public double length() {
        return Math.sqrt(mX * mX + mY * mY + mZ * mZ);
    }

    public double lengthSquared() {
        return mX * mX + mY * mY + mZ * mZ;
    }

    public void mul(double factor) {
        mX = mX * factor;
        mY = mY * factor;
        mZ = mZ * factor;
    }

    public void mul(Vector3 rhs) {
        arithmetic(rhs, T_MUL);
    }

    public void normalize() {
        double len = length();

        mX = mX / len;
        mY = mY / len;
        mZ = mZ / len;
    }

    public void sub(Vector3 rhs) {
        arithmetic(rhs, T_SUB);
    }

    private void arithmetic(Vector3 rhs, int arithType) {
        if (arithType >= T_ADD && arithType <= T_MUL) {
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();
            double rhsZ = rhs.getZ();

            switch (arithType) {
            case T_ADD:
                mX = mX + rhsX;
                mY = mY + rhsY;
                mZ = mZ + rhsZ;
                break;
            case T_SUB:
                mX = mX - rhsX;
                mY = mY - rhsY;
                mZ = mZ - rhsZ;
                break;
            case T_MUL:
                mX = mX * rhsX;
                mY = mY * rhsY;
                mZ = mZ * rhsZ;
                break;
            }
        }
    }

    public Vector3 crossProduct(Vector3 rhs) {
        return new Vector3(mY * rhs.getZ() - mZ * rhs.getY(), mZ * rhs.getX()
                - mX * rhs.getZ(), mX * rhs.getY() - mY * rhs.getX());
    }

    public static Vector3 crossProduct(Vector3 lhs, Vector3 rhs) {
        return new Vector3(lhs.getY() * rhs.getZ() - lhs.getZ() * rhs.getY(),
                lhs.getZ() * rhs.getX() - lhs.getX() * rhs.getZ(), lhs.getX()
                        * rhs.getY() - lhs.getY() * rhs.getX());
    }
}
