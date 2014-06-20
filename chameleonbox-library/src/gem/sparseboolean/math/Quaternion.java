package gem.sparseboolean.math;

public class Quaternion {
    public static Quaternion add(Quaternion lhs, Quaternion rhs) {
        Quaternion result = new Quaternion();
        result.x = lhs.x + rhs.x;
        result.y = lhs.y + rhs.y;
        result.z = lhs.z + rhs.z;
        result.w = lhs.w + rhs.w;
        return result;
    }
    public static Quaternion div(Quaternion original, double f) {
        Quaternion result = new Quaternion();
        result.x = original.x / f;
        result.y = original.y / f;
        result.z = original.z / f;
        result.w = original.w / f;
        return result;
    }
    public static double dotProduct(Quaternion lhs, Quaternion rhs) {
        return lhs.x * rhs.x + lhs.y * rhs.y + lhs.z * rhs.z + lhs.w * rhs.w;
    }
    public static Quaternion mul(Quaternion original, double f) {
        Quaternion result = new Quaternion();
        result.x = original.x * f;
        result.y = original.y * f;
        result.z = original.z * f;
        result.w = original.w * f;
        return result;
    }

    public static Quaternion mul(Quaternion lhs, Quaternion rhs) {
        Quaternion result = new Quaternion();
        double x1, x2, y1, y2, z1, z2, w1, w2;

        x1 = lhs.x;
        y1 = lhs.y;
        z1 = lhs.z;
        w1 = lhs.w;
        x2 = rhs.x;
        y2 = rhs.y;
        z2 = rhs.z;
        w2 = rhs.w;

        result.x = w1 * x2 + x1 * w2 - z1 * y2 + y1 * z2;
        result.y = w1 * y2 + y1 * w2 + z1 * x2 - x1 * z2;
        result.z = w1 * z2 + z1 * w2 + x1 * y2 - y1 * x2;
        result.w = w1 * w2 - x1 * x2 - y1 * y2 - z1 * z2;

        return result;
    }

    public static Quaternion negation(Quaternion original) {
        Quaternion result = new Quaternion();
        result.x = -original.x;
        result.y = -original.y;
        result.z = -original.z;
        result.w = -original.w;
        return result;
    }

    public static Quaternion slerp(double t, Quaternion lhs, Quaternion rhs) {
        // the slerp of a pair of unit quaterions is the weighted
        // interpolation between them, where the interpolation weight is
        // given by t = [0, 1.0]
        //
        // the trick to slerping is that we find the angle between the two
        // quats by treating them as a pair of four vectors and getting the
        // cosine [as the dot product].
        //
        // then the slerp between two quaternions A and B is:
        //
        //       A * (upper_weight) + B * (lower_weight)
        //
        //  where the weights are the sines of the t-weighted angle
        //  divided by the sine of the angle.
        //
        // the resulting quaternion is also a unit quaternion.

        // find the angle between the two quats by treating
        // them as 4-length vectors -- V1.V2 = cos(theta)

        double cosine_angle, angle_over_two;
        double coef1, coef2;
        Quaternion result = new Quaternion();
        Quaternion lhs_n = new Quaternion();
        Quaternion rhs_n = new Quaternion();

        lhs_n = lhs;
        rhs_n = rhs;
        lhs_n.normalize();
        rhs_n.normalize();

        cosine_angle = lhs_n.dotProduct(rhs_n); // = cos(angle_over_two)

        // adjust signs (if necessary)
        if (cosine_angle < 0.0) {
            cosine_angle = -cosine_angle;
            rhs_n.negate();
        }

        angle_over_two = Math.acos(cosine_angle);

        if ((1 - cosine_angle) > 0.000001) {
            coef1 = Math.sin(angle_over_two * (1 - t))
                    / Math.sin(angle_over_two);
            coef2 = Math.sin(angle_over_two * t) / Math.sin(angle_over_two);
        } else {
            // lhs and rhs are very close ... so we can do a linear interpolation
            coef1 = 1 - t;
            coef2 = t;
        }

        result = Quaternion.add(Quaternion.mul(lhs_n, coef1),
                Quaternion.mul(rhs_n, coef2));
        return result;
    }

    public static Quaternion sub(Quaternion lhs, Quaternion rhs) {
        Quaternion result = new Quaternion();
        result.x = lhs.x - rhs.x;
        result.y = lhs.y - rhs.y;
        result.z = lhs.z - rhs.z;
        result.w = lhs.w - rhs.w;
        return result;
    }

    public double x;

    public double y;

    public double z;

    public double w;

    public Quaternion() {
        x = y = z = w = 0.0;
    }

    public Quaternion(double euler_x, double euler_y, double euler_z) {
        fromEulerZXY(euler_x, euler_y, euler_z);
    }

    public Quaternion(double axis_x, double axis_y, double axis_z,
            double angle_radian) {
        fromAngleAxis(axis_x, axis_y, axis_z, angle_radian);
    }

    public Quaternion(Quaternion other) {
        copyValueFrom(other);
    }

    public Quaternion(Vector3 vec, double angle) {
        //copyValueFrom(other);
    }

    public Quaternion(Vector4 vec) {
        fromAngleAxis(vec.getW(), vec.getX(), vec.getY(), vec.getZ());
    }

    public void add(Quaternion rhs) {
        x += rhs.x;
        y += rhs.y;
        z += rhs.z;
        w += rhs.w;
    }

    public void conjugate() {
        x = -x;
        y = -y;
        z = -z;
    }

    public void copyValueFrom(Quaternion other) {
        x = other.x;
        y = other.y;
        z = other.z;
        w = other.w;
    }

    public void div(double f) {
        x /= f;
        y /= f;
        z /= f;
        w /= f;
    }

    public double dotProduct(Quaternion rhs) {
        return x * rhs.x + y * rhs.y + z * rhs.z + w * rhs.w;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Quaternion) {
            Quaternion other = (Quaternion) o;
            return x == other.x && y == other.y && z == other.z && w == other.w;
        } else {
            return false;
        }
    }

    /*
     * Set the quaternion to define a rotation of angle_randian
     * around the vector define by (axis_x, axis_y, axis_z)
     */
    public void fromAngleAxis(double axis_x, double axis_y, double axis_z,
            double angle_radian) {
        double ax = axis_x;
        double ay = axis_y;
        double az = axis_z;

        double len = 1.0 / Math.sqrt(ax * ax + ay * ay + az * az);

        ax = ax * len;
        ay = ay * len;
        az = az * len;

        double sin_theta_over_two = Math.sin(angle_radian / 2.0);
        x = ax * sin_theta_over_two;
        y = ay * sin_theta_over_two;
        z = az * sin_theta_over_two;
        w = Math.cos(angle_radian / 2.0);
    }

    /*
     * Set the quaternion to define a Euler transform
     *
     * Parameters:     
     *      - euler_x: rotation angle around X axis (in radian)
     *      - euler_y: rotation angle around Y axis (in radian)
     *      - euler_z: rotation angle around Z axis (in radian)
     */
    public void fromEulerZXY(double euler_x, double euler_y, double euler_z) {
        double roll_axis[] = new double[] { 0.0, 0.0, 1.0 };
        double pitch_axis[] = new double[] { 1.0, 0.0, 0.0 };
        double yaw_axis[] = new double[] { 0.0, 1.0, 0.0 };

        Quaternion roll = new Quaternion(euler_z, roll_axis[0], roll_axis[1],
                roll_axis[2]);
        Quaternion pitch = new Quaternion(euler_x, pitch_axis[0],
                pitch_axis[1], pitch_axis[2]);
        Quaternion yaw = new Quaternion(euler_y, yaw_axis[0], yaw_axis[1],
                yaw_axis[2]);

        copyValueFrom(Quaternion.mul(Quaternion.mul(roll, pitch), yaw));
    }

    public double getAngleAxis(Vector3 axis) {
        Quaternion qt = new Quaternion();

        qt.x = x;
        qt.y = y;
        qt.z = z;
        qt.w = w;

        qt.normalize();
        double angle_radian = 2.0 * Math.acos(qt.w);
        double one_over_sin = 1.0 / Math.sqrt(qt.x * qt.x + qt.y * qt.y + qt.z
                * qt.z);

        axis.setX(qt.x * one_over_sin);
        axis.setY(qt.y * one_over_sin);
        axis.setZ(qt.z * one_over_sin);

        return angle_radian;
    }

    /* 
     * Return a Matrix4 object containing the rotation defined by the quaternion.
     */
    public Matrix4x4 getMatrix() {
        Matrix4x4 mat4x4 = new Matrix4x4();
        double s = 2.0 / Math.sqrt(x * x + y * y + z * z + w * w);

        mat4x4.m[0][0] = 1.0 - s * (y * y + z * z);
        mat4x4.m[0][1] = s * (x * y - w * z);
        mat4x4.m[0][2] = s * (x * z + w * y);
        mat4x4.m[0][3] = 0.0;

        mat4x4.m[1][0] = s * (x * y + w * z);
        mat4x4.m[1][1] = 1.0 - s * (x * x + z * z);
        mat4x4.m[1][2] = s * (y * z - w * x);
        mat4x4.m[1][3] = 0.0;

        mat4x4.m[2][0] = s * (x * z - w * y);
        mat4x4.m[2][1] = s * (y * z + w * x);
        mat4x4.m[2][2] = 1.0 - s * (x * x + y * y);
        mat4x4.m[2][3] = 0.0;

        mat4x4.m[3][0] = 0.0;
        mat4x4.m[3][1] = 0.0;
        mat4x4.m[3][2] = 0.0;
        mat4x4.m[3][3] = 1.0;

        return mat4x4;
    }

    public void inverse() {
        double len = Math.sqrt(x * x + y * y + z * z + w * w);
        conjugate();
        x = x / len;
        y = y / len;
        z = z / len;
        w = w / len;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z + w * w);
    }

    public void mul(double f) {
        x *= f;
        y *= f;
        z *= f;
        w *= f;
    }

    public void mul(Quaternion rhs) {
        double x1, x2, y1, y2, z1, z2, w1, w2;

        x1 = x;
        y1 = y;
        z1 = z;
        w1 = w;
        x2 = rhs.x;
        y2 = rhs.y;
        z2 = rhs.z;
        w2 = rhs.w;

        x = w1 * x2 + x1 * w2 - z1 * y2 + y1 * z2;
        y = w1 * y2 + y1 * w2 + z1 * x2 - x1 * z2;
        z = w1 * z2 + z1 * w2 + x1 * y2 - y1 * x2;
        w = w1 * w2 - x1 * x2 - y1 * y2 - z1 * z2;
    }

    public void negate() {
        x = -x;
        y = -y;
        z = -z;
        w = -w;
    }

    public void normalize() {
        double len = Math.sqrt(x * x + y * y + z * z + w * w);
        x = x / len;
        y = y / len;
        z = z / len;
        w = w / len;
    }

    public void sub(Quaternion rhs) {
        x -= rhs.x;
        y -= rhs.y;
        z -= rhs.z;
        w -= rhs.w;
    }
}
