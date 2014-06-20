package gem.sparseboolean.math;


public class Point3D {
    private double mX;
    private double mY;
    private double mZ;

    public Point3D() {
        mX = 0;
        mY = 0;
        mZ = 0;
    }

    public Point3D(double x, double y, double z) {
        mX = x;
        mY = y;
        mZ = z;
    }

    public Point3D(Point3D other) {
        mX = other.getX();
        mY = other.getY();
        mZ = other.getZ();
    }

    public double getX() {
        return mX;
    }

    public double getY() {
        return mY;
    }

    public double getZ() {
        return mZ;
    }

    public void setValue(double x, double y, double z) {
        mX = x;
        mY = y;
        mZ = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Point3D) {
            Point3D other = (Point3D) o;
            return mX == other.getX() && mY == other.getY()
                    && mZ == other.getZ();
        } else {
            return false;
        }
    }
}
