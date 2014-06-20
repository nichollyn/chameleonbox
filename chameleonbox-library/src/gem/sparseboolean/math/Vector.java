package gem.sparseboolean.math;

import java.util.Arrays;

public class Vector {
    public static class DimensionOutOfRangeException extends Exception {
        private static final long serialVersionUID = -5570452634805948570L;
        private String msg;

        public DimensionOutOfRangeException(String msg) {
            this.msg = msg;
        }

        @Override
        public String getMessage() {
            return super.getMessage() + "\n" + msg;
        }
    }

    private static final int T_ADD = 1;
    private static final int T_SUB = 2;
    private static final int T_MUL = 3;

    private static final int T_DIV = 4;

    public static Vector add(Vector lhs, Vector rhs) {
        return arithmetic(lhs, rhs, T_ADD);
    }

    public static Vector div(Vector lhs, Vector rhs) {
        return arithmetic(lhs, rhs, T_DIV);
    }

    public static double dotProduct(Vector lhs, Vector rhs)
            throws IllegalArithmeticException {
        if (lhs == null || rhs == null
                || lhs.getDimension() != rhs.getDimension()) {
            throw new IllegalArithmeticException(
                    "Only vectors with the same dimen can calculate a dot product.");
        } else {
            double dotProduct = 0.;
            double[] lhsData = lhs.getData();
            double[] rhsData = rhs.getData();
            for (int i = 0; i < lhs.getDimension(); i++) {
                dotProduct += lhsData[i] * rhsData[i];
            }

            return dotProduct;
        }
    }

    public static Vector mul(Vector vector, double factor) {
        double[] data = vector.getData();
        int dimension = vector.getDimension();
        double[] out = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            out[i] = data[i] * factor;
        }

        return new Vector(out);
    }

    public static Vector mul(Vector lhs, Vector rhs) {
        return arithmetic(lhs, rhs, T_MUL);
    }

    public static Vector sub(Vector lhs, Vector rhs) {
        return arithmetic(lhs, rhs, T_SUB);
    }

    private static Vector arithmetic(Vector lhs, Vector rhs, int arithType) {
        if (lhs != null && rhs != null
                && lhs.getDimension() == rhs.getDimension()
                && arithType >= T_ADD && arithType <= T_DIV) {
            double[] out = new double[lhs.getDimension()];
            double[] lhsData = lhs.getData();
            double[] rhsData = rhs.getData();
            for (int i = 0; i < lhs.getDimension(); i++) {
                switch (arithType) {
                case T_ADD:
                    out[i] = lhsData[i] + rhsData[i];
                    break;
                case T_SUB:
                    out[i] = lhsData[i] - rhsData[i];
                    break;
                case T_MUL:
                    out[i] = lhsData[i] * rhsData[i];
                    break;
                case T_DIV:
                    out[i] = lhsData[i] / rhsData[i];
                    break;
                }
            }

            return new Vector(out);
        } else {
            return null;
        }
    }

    protected int mDimension;

    protected double[] mData;

    public Vector(double x, double y) {
        mDimension = 2;
        mData = new double[2];
        mData[0] = x;
        mData[1] = y;
    }

    public Vector(double x, double y, double z) {
        mDimension = 3;
        mData = new double[3];
        mData[0] = x;
        mData[1] = y;
        mData[2] = z;
    }

    public Vector(double[] data) {
        mDimension = data.length;
        mData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            mData[i] = data[i];
        }
    }

    public Vector(float[] data) {
        mDimension = data.length;
        mData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            mData[i] = data[i];
        }
    }

    public Vector(int dimension) {
        mDimension = dimension;
        mData = new double[mDimension];
        for (int i = 0; i < mDimension; i++) {
            mData[i] = 0.;
        }
    }

    public Vector(int[] data) {
        mDimension = data.length;
        mData = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            mData[i] = data[i];
        }
    }

    public void add(Vector rhs) {
        arithmetic(rhs, T_ADD);
    }

    public void copyFrom(Vector other) {
        mDimension = other.getDimension();
        mData = other.getData();
    }

    public void div(Vector rhs) {
        arithmetic(rhs, T_DIV);
    }

    public double dotProduct(Vector rhs) throws IllegalArithmeticException {
        if (rhs == null || rhs.getDimension() != mDimension) {
            throw new IllegalArithmeticException(
                    "Only vectors with the same dimen can calculate a dot product.");
        } else {
            double dotProduct = 0;
            double[] rhsData = rhs.getData();
            for (int i = 0; i < mDimension; i++) {
                dotProduct += mData[i] * rhsData[i];
            }

            return dotProduct;
        }
    }

    public static Vector negation(Vector original) {
        int dimen = original.getDimension();
        double[] data = original.getData();
        double[] out = new double[dimen];
        for (int i = 0; i < dimen; i++) {
            out[i] = -data[i];
        }

        return new Vector(out);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Vector) {
            return Arrays.equals(mData, ((Vector) o).getData());
        } else {
            return false;
        }
    }

    public double[] getData() {
        return mData;
    }

    public int getDimension() {
        return mDimension;
    }

    public double getValueOnDimension(int dimen)
            throws DimensionOutOfRangeException {
        if (dimen < 1 || dimen > mDimension) {
            throw new DimensionOutOfRangeException(String.format(
                    "Dimension %d out of vector dimension %d", dimen,
                    mDimension));
        } else {
            return mData[dimen - 1];
        }
    }

    public double length() {
        double sum = 0;
        for (double value : mData) {
            sum += value * value;
        }

        return Math.sqrt(sum);
    }

    public void mul(double factor) {
        for (int i = 0; i < mDimension; i++) {
            mData[i] = mData[i] * factor;
        }
    }

    public void mul(Vector rhs) {
        arithmetic(rhs, T_MUL);
    }

    public void normalize() {
        double len = length();

        for (int i = 0; i < mDimension; i++) {
            mData[i] = mData[i] / len;
        }
    }

    public void sub(Vector rhs) {
        arithmetic(rhs, T_SUB);
    }

    private void arithmetic(Vector rhs, int arithType) {
        if (rhs != null && rhs.getDimension() == mDimension
                && arithType >= T_ADD && arithType <= T_DIV) {
            double[] rhsData = rhs.getData();
            for (int i = 0; i < mDimension; i++) {
                switch (arithType) {
                case T_ADD:
                    mData[i] = mData[i] + rhsData[i];
                    break;
                case T_SUB:
                    mData[i] = mData[i] - rhsData[i];
                    break;
                case T_MUL:
                    mData[i] = mData[i] * rhsData[i];
                    break;
                case T_DIV:
                    mData[i] = mData[i] * rhsData[i];
                    break;
                }
            }
        }
    }
}
