package gem.sparseboolean.math;

public class Line3D {
    private double mXStart;
    private double mYStart;
    private double mZStart;
    private double mXEnd;
    private double mYEnd;
    private double mZEnd;

    public Line3D() {
        mXStart = 0;
        mYStart = 0;
        mZStart = 0;
        mXEnd = 0;
        mYEnd = 0;
        mZEnd = 0;
    }

    public Line3D(Line3D other) {
        mXStart = other.getXStart();
        mYStart = other.getYStart();
        mZStart = other.getZStart();
        mXEnd = other.getXEnd();
        mYEnd = other.getYEnd();
        mZEnd = other.getZEnd();
    }

    public Line3D(double x_start, double y_start, double z_start, double x_end,
            double y_end, double z_end) {
        mXStart = x_start;
        mYStart = y_start;
        mZStart = z_start;
        mXEnd = x_end;
        mYEnd = y_end;
        mZEnd = z_end;
    }

    public Line3D(Vector3 pt, Vector3 v) {
        mXStart = pt.getX();
        mYStart = pt.getY();
        mZStart = pt.getZ();

        mXEnd = mXStart + v.getX();
        mYEnd = mYStart + v.getY();
        mZEnd = mZStart + v.getZ();
    }

    public void copyValueFrom(Line3D other) {
        mXStart = other.getXStart();
        mYStart = other.getYStart();
        mZStart = other.getZStart();
        mXEnd = other.getXEnd();
        mYEnd = other.getYEnd();
        mZEnd = other.getZEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Line3D) {
            Line3D other = (Line3D) o;
            return mXStart == other.getXStart() && mYStart == other.getYStart()
                    && mZStart == other.getZStart() && mXEnd == other.getXEnd()
                    && mYEnd == other.getYEnd() && mZEnd == other.getZEnd();
        } else {
            return false;
        }
    }

    public double length() {
        return Math.sqrt((mXEnd - mXStart) * (mXEnd - mXStart)
                + (mYEnd - mYStart) * (mYEnd - mYStart) + (mZEnd - mZStart) * (mZEnd - mZStart));
    }

    public Vector3 getDirectionVector() {
        return new Vector3(mXEnd - mXStart, mYEnd - mYStart, mZEnd - mZStart);
    }

    public Vector3 getStartPoint() {
        return new Vector3(mXStart, mYStart, mZStart);
    }

    public Vector3 getEndPoint() {
        return new Vector3(mXEnd, mYEnd, mZEnd);
    }

    public double getXStart() {
        return mXStart;
    }

    public double getYStart() {
        return mYStart;
    }

    public double getZStart() {
        return mZStart;
    }

    public double getXEnd() {
        return mXEnd;
    }

    public double getYEnd() {
        return mYEnd;
    }

    public double getZEnd() {
        return mZEnd;
    }
}
