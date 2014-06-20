package gem.sparseboolean.math;

public class Trigonometry {
    public static Vector3 cartesianToSphericalXBaseRadius(double x, double y, double z) {
        double r = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.atan(y / x);
        double phi = Math.acos(z / r);

        return new Vector3(r, theta, phi);
    }

    public static Vector3 cartesianToSphericalZBaseDegree(double x, double y, double z) {
        double r = Math.sqrt(x * x + y * y + z * z);
        double theta = Math.atan(x / z);
        double phi = Math.acos(y / r);

        return new Vector3(r, theta, phi);
    }

    // Assume the spherical coordinate system relatively to a right handed xyz,
    // with Z pointing up.
    // 0 <= phi < 180
    // 0 <= theta < 360 ->>> along X axis, theta = 0.
    public static Vector3 sphericalToCartesianXBaseDegree(double r, double theta,
            double phi) {
        Vector3 result = new Vector3();
        result.setX(r * Math.cos(theta * Math.PI / 180.0)
                * Math.sin(phi * Math.PI / 180.0));
        result.setY(r * Math.sin(theta * Math.PI / 180.0)
                * Math.sin(phi * Math.PI / 180.0));
        result.setZ(r * Math.cos(phi) * Math.PI / 180.0);

        return result;
    }

    public static Vector3 sphericalToCartesianXBaseRadius(double r, double theta,
            double phi) {
        Vector3 result = new Vector3();
        result.setX(r * Math.cos(theta) * Math.sin(phi));
        result.setY(r * Math.sin(theta) * Math.sin(phi));
        result.setZ(r * Math.cos(phi));

        return result;
    }

    // Assume the spherical coordinate system relatively to a right handed xyz,
    // with Y pointing up.
    // 0 <= phi < 180
    // 0 <= theta < 360 ->>> along Z axis, theta = 0.
    public static Vector3 sphericalToCartesianZBaseDegree(double r, double theta,
            double phi) {
        Vector3 result = new Vector3();
        result.setZ(r * Math.cos(theta * Math.PI / 180.0)
                * Math.sin(phi * Math.PI / 180.0));
        result.setX(r * Math.sin(theta * Math.PI / 180.0)
                * Math.sin(phi * Math.PI / 180.0));
        result.setY(r * Math.cos(phi) * Math.PI / 180.0);

        return result;
    }

    public static Vector3 sphericalToCartesianZBaseRadius(double r, double theta,
            double phi) {
        Vector3 result = new Vector3();
        result.setZ(r * Math.cos(theta) * Math.sin(phi));
        result.setX(r * Math.sin(theta) * Math.sin(phi));
        result.setY(r * Math.cos(phi));

        return result;
    }
}
