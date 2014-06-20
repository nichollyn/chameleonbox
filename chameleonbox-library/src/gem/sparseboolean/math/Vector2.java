package gem.sparseboolean.math;

public class Vector2 {
    private static final int T_ADD = 1;
    private static final int T_SUB = 2;
    private static final int T_MUL = 3;

    public static Vector2 add(Vector2 lhs, Vector2 rhs) {
        return arithmetic(lhs, rhs, T_ADD);
    }

    public static double crossProduct(Vector2 lhs, Vector2 rhs) {
        return lhs.getX() * rhs.getY() - lhs.getY() * rhs.getX();
    }

    public static Vector2 div(Vector2 lhs, Vector2 rhs) {
        return arithmetic(lhs, rhs, T_MUL);
    }

    public static double dotProduct(Vector2 lhs, Vector2 rhs) {
        return lhs.getX() * rhs.getX() + lhs.getY() * rhs.getY();
    }

    public static Vector2 mul(Vector2 vector, double factor) {
        double x = vector.getX() * factor;
        double y = vector.getY() * factor;

        return new Vector2(x, y);
    }

    public static Vector2 mul(Vector2 lhs, Vector2 rhs) {
        return arithmetic(lhs, rhs, T_MUL);
    }

    public static Vector2 sub(Vector2 lhs, Vector2 rhs) {
        return arithmetic(lhs, rhs, T_SUB);
    }

    private static Vector2 arithmetic(Vector2 lhs, Vector2 rhs, int arithType) {
        if (lhs != null && rhs != null && arithType >= T_ADD
                && arithType <= T_MUL) {
            double x = 0.;
            double y = 0;
            double lhsX = lhs.getX();
            double lhsY = lhs.getY();
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();

            switch (arithType) {
            case T_ADD:
                x = lhsX + rhsX;
                y = lhsY + rhsY;
                break;
            case T_SUB:
                x = lhsX - rhsX;
                y = lhsY - rhsY;
                break;
            case T_MUL:
                x = lhsX * rhsX;
                y = lhsY * rhsY;
                break;
            }

            return new Vector2(x, y);
        } else {
            return null;
        }
    }

    private double mX = 0.;

    private double mY = 0.;

    public Vector2() {
        mX = 0.;
        mY = 0.;
    }

    public Vector2(Vector2 other) {
        copyValueFrom(other);
    }

    public Vector2(double x, double y) {
        mX = x;
        mY = y;
    }

    public void add(Vector2 rhs) {
        arithmetic(rhs, T_ADD);
    }

    public void copyValueFrom(Vector2 other) {
        mX = other.getX();
        mY = other.getY();
    }

    public double crossProduct(Vector2 rhs) {
        return mX * rhs.getY() - mY * rhs.getX();
    }

    public double dotProduct(Vector2 rhs) {
        return mX * rhs.getX() + mY * rhs.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Vector2) {
            Vector2 other = (Vector2) o;
            return mX == other.getX() && mY == other.getY();
        } else {
            return false;
        }
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

    public double length() {
        return Math.sqrt(mX * mX + mY * mY);
    }

    public void mul(double factor) {
        mX = mX * factor;
        mY = mY * factor;
    }

    public void mul(Vector2 rhs) {
        arithmetic(rhs, T_MUL);
    }

    public static Vector2 negation(Vector2 original) {
        return new Vector2(-original.getX(), -original.getY());
    }

    public void normalize() {
        double len = length();

        mX = mX / len;
        mY = mY / len;
    }

    public void sub(Vector2 rhs) {
        arithmetic(rhs, T_SUB);
    }

    private void arithmetic(Vector2 rhs, int arithType) {
        if (arithType >= T_ADD && arithType <= T_MUL) {
            double rhsX = rhs.getX();
            double rhsY = rhs.getY();

            switch (arithType) {
            case T_ADD:
                mX = mX + rhsX;
                mY = mY + rhsY;
                break;
            case T_SUB:
                mX = mX - rhsX;
                mY = mY - rhsY;
                break;
            case T_MUL:
                mX = mX * rhsX;
                mY = mY * rhsY;
                break;
            }
        }
    }
}
