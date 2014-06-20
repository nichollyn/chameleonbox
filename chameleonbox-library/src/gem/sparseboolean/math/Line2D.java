package gem.sparseboolean.math;

public class Line2D {
    private double mXStart;
    private double mYStart;
    private double mXEnd;
    private double mYEnd;

    public Line2D() {
        mXStart = 0;
        mYStart = 0;
        mXEnd = 0;
        mYEnd = 0;
    }

    public Line2D(Line2D other) {
        mXStart = other.getXStart();
        mYStart = other.getYStart();
        mXEnd = other.getXEnd();
        mYEnd = other.getYEnd();
    }

    public Line2D(double x_start, double y_start, double x_end, double y_end) {
        mXStart = x_start;
        mYStart = y_start;
        mXEnd = x_end;
        mYEnd = y_end;
    }

    public Line2D(Vector2 pt, Vector2 v) {
        mXStart = pt.getX();
        mYStart = pt.getY();

        mXEnd = mXStart + v.getX();
        mYEnd = mYStart + v.getY();
    }

    public void copyValueFrom(Line2D other) {
        mXStart = other.getXStart();
        mYStart = other.getYStart();
        mXEnd = other.getXEnd();
        mYEnd = other.getYEnd();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Line2D) {
            Line2D other = (Line2D) o;
            return mXStart == other.getXStart() && mYStart == other.getYStart()
                    && mXEnd == other.getXEnd() && mYEnd == other.getYEnd();
        } else {
            return false;
        }
    }

    public double length() {
        return Math.sqrt((mXEnd - mXStart) * (mXEnd - mXStart)
                + (mYEnd - mYStart) * (mYEnd - mYStart));
    }

    public Vector2 getDirectionVector() {
        return new Vector2(mXEnd - mXStart, mYEnd - mYStart);
    }

    public Vector2 getStartPoint() {
        return new Vector2(mXStart, mYStart);
    }

    public Vector2 getEndPoint() {
        return new Vector2(mXEnd, mYEnd);
    }

    public double getXStart() {
        return mXStart;
    }

    public double getYStart() {
        return mYStart;
    }

    public double getXEnd() {
        return mXEnd;
    }

    public double getYEnd() {
        return mYEnd;
    }
}
