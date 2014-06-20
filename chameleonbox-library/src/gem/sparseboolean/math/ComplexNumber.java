package gem.sparseboolean.math;

public final class ComplexNumber {
    private double mReal;
    private double mImaginary;

    public ComplexNumber(double real, double imaginary) {
        mReal = real;
        mImaginary = imaginary;
    }

    public ComplexNumber(ComplexNumber other) {
        mReal = other.mReal;
        mImaginary = other.mImaginary;
    }

    public double getReal() {
        return mReal;
    }

    public void setReal(float real) {
        mReal = real;
    }

    public double getImaginary() {
        return mImaginary;
    }

    public void setImaginary(float imaginary) {
        mImaginary = imaginary;
    }

    public void conjugue() {
        mImaginary = -mImaginary;
    }

    public double absolute() {
        double x, y, result;

        x = Math.abs(mReal);
        y = Math.abs(mImaginary);

        if (x == 0.0) {
            result = y;
        } else {
            if (y == 0.0) {
                result = x;
            } else {
                double temp;
                if (x > y) {
                    temp = y / x;
                    result = x * Math.sqrt(1.0 + temp * temp);
                } else {
                    temp = x / y;
                    result = y * Math.sqrt(1.0 + temp * temp);
                }
            }
        }

        return result;
    }

    public boolean isNull() {
        if (mReal == 0 && mImaginary == 0) {
            return true;
        }

        return false;
    }

    public void add(ComplexNumber rhs) {
        mReal += rhs.getReal();
        mImaginary += rhs.getImaginary();
    }

    public static ComplexNumber add(ComplexNumber lhs, ComplexNumber rhs) {
        double real = lhs.getReal() + rhs.getReal();
        double imaginary = lhs.getImaginary() + rhs.getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    public void sub(ComplexNumber rhs) {
        mReal -= rhs.getReal();
        mImaginary -= rhs.getImaginary();
    }

    public static ComplexNumber sub(ComplexNumber lhs, ComplexNumber rhs) {
        double real = lhs.getReal() - rhs.getReal();
        double imaginary = lhs.getImaginary() - rhs.getImaginary();

        return new ComplexNumber(real, imaginary);
    }

    public void mul(ComplexNumber rhs) {
        double newReal = mReal * rhs.getReal() - mImaginary * rhs.mImaginary;
        double newImaginary = mImaginary * rhs.getReal() + mReal
                * rhs.getImaginary();

        mReal = newReal;
        mImaginary = newImaginary;
    }

    public static ComplexNumber mul(ComplexNumber lhs, ComplexNumber rhs) {
        double real = lhs.getReal() * rhs.getReal() - lhs.getImaginary()
                * rhs.mImaginary;
        double image = lhs.getImaginary() * rhs.getReal() + lhs.getReal()
                * rhs.getImaginary();

        return new ComplexNumber(real, image);
    }

    public void div(ComplexNumber rhs) {
        double inv_denominator = (double) 1.0
                / (rhs.getReal() * rhs.getReal() + rhs.getImaginary()
                        * rhs.getImaginary());
        double newReal = inv_denominator
                * (mReal * rhs.getReal() + mImaginary * rhs.getImaginary());
        double newImaginary = inv_denominator
                * (mImaginary * rhs.getReal() - mReal * rhs.getImaginary());

        mReal = newReal;
        mImaginary = newImaginary;
    }

    public static ComplexNumber div(ComplexNumber lhs, ComplexNumber rhs) {
        double inv_denominator = (float) 1.0
                / (rhs.getReal() * rhs.getReal() + rhs.getImaginary()
                        * rhs.getImaginary());
        double newReal = inv_denominator
                * (lhs.getReal() * rhs.getReal() + lhs.getImaginary()
                        * rhs.getImaginary());
        double newImaginary = inv_denominator
                * (lhs.getImaginary() * rhs.getReal() - lhs.getReal()
                        * rhs.getImaginary());

        return new ComplexNumber(newReal, newImaginary);
    }
}
