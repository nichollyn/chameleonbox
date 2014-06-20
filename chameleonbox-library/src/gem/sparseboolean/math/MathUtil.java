package gem.sparseboolean.math;

public class MathUtil {
    public static final int multiplyDeBruijnBitPosition[] = new int[] { 0, 1,
            28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23,
            21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9 };

    public static final int powersOfTen[] = new int[] { 1, 10, 100, 1000,
            10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

    public static double align(double ptr, int alignment) {
        return (double) (((int) ptr + alignment - 1) & ~(alignment - 1));
    }

    public static float align(float ptr, int alignment) {
        return (float) (((int) ptr + alignment - 1) & ~(alignment - 1));
    }

    public static int align(int ptr, int alignment) {
        return (int) ((ptr + alignment - 1) & ~(alignment - 1));
    }

    public static long align(long ptr, int alignment) {
        return (long) (((int) ptr + alignment - 1) & ~(alignment - 1));
    }

    public static double binomialCoefficient(int n, int k) {

        if (k < 0 || k > n)
            return 0.0;

        double d = (double) factorial(n)
                / (double) (factorial(n - k) * factorial(k));
        return d;
    }

    // Compute parity in parallel
    public static int bitParity(int N) {
        int v = N; // word value to compute the parity of
        v ^= v >> 16;
        v ^= v >> 8;
        v ^= v >> 4;
        v &= 0xf;
        return (0x6996 >> v) & 1;
    }

    public static int byteArrayToInt(byte[] ar) {
        return (ar[3] & 0xff) | ((ar[2] & 0xff) << 8) | ((ar[1] & 0xff) << 16)
                | ((ar[0] & 0xff) << 24);
    }

    public static long byteArrayToLong(byte[] ar) {
        return (ar[7] & 0xff) | ((ar[6] & 0xff) << 8) | ((ar[5] & 0xff) << 16)
                | ((ar[4] & 0xff) << 24) | ((ar[3] & 0xff) << 32)
                | ((ar[2] & 0xff) << 40) | ((ar[1] & 0xff) << 48)
                | ((ar[0] & 0xff << 56));
    }

    public static short byteArrayToShort(byte[] ar) {
        return (short) (((ar[1] & 0xff) << 8) | (ar[0] & 0xff));
    }

    public static double clamp(double x, double min_value, double max_value) {
        return x < min_value ? min_value : x < max_value ? x : max_value;
    }

    public static float clamp(float x, float min_value, float max_value) {
        return x < min_value ? min_value : x < max_value ? x : max_value;
    }

    public static int clamp(int x, int min_value, int max_value) {
        return x < min_value ? min_value : x < max_value ? x : max_value;
    }

    public static long clamp(long x, long min_value, long max_value) {
        return x < min_value ? min_value : x < max_value ? x : max_value;
    }

    public static int clearLSBBit(int N) {
        return N & (N - 1);
    }

    // countNumBits(0x01001100) = 3
    public static int countNumBits(int N) {
        int v = N; // count the number of bits set in v
        int c; // c accumulates the total bits set in v

        for (c = 0; v != 0; c++) {
            v &= v - 1; // clear the least significant bit set
        }

        return c;
    }

    public static double crandom() {
        return 1. - 2 * Math.random();
    }

    public static int diffPointer(double x1, double x2) {
        return (int) Math.abs(x1 - x2);
    }

    public static int factorial(int n) {
        int i = 1;

        while (0 < n) {
            i *= n;
            n--;
        }

        return i;
    }

    public static int getLowerPowerOfTwoExponent(int x) {
        int count = 0;

        while (x > 1) {
            x >>= 1;
            count++;
        }

        return count;
    }

    public static byte[] intToByteArray(int a) {
        return new byte[] { (byte) ((a >> 24) & 0xff),
                (byte) ((a >> 16) & 0xff), (byte) ((a >> 8) & 0xff),
                (byte) (a & 0xff) };
    }

    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }

    // Find the log base 10 of an N-bit integer in O(lg(N))
    public static int log2(int N) {
        int v = N; // find the log base 2 of 32-bit v
        int r; // result

        v |= v >> 1;
        v |= v >> 2;
        v |= v >> 4;
        v |= v >> 8;
        v |= v >> 16;
        v = (v >> 1) + 1;

        r = multiplyDeBruijnBitPosition[(int) (v * 0x077CB531L) >> 27];
        return r;
    }

    public static byte[] longToByteArray(long a) {
        return new byte[] { (byte) ((a >> 56) & 0xff),
                (byte) ((a >> 48) & 0xff), (byte) ((a >> 40) & 0xff),
                (byte) ((a >> 32) & 0xff), (byte) ((a >> 24) & 0xff),
                (byte) ((a >> 16) & 0xff), (byte) ((a >> 8) & 0xff),
                (byte) (a & 0xff) };
    }

    public static double minMod(double a, double b) {
        return a * b <= 0 ? 0 : (a > 0 ? (a < b ? a : b) : (a < b ? b : a));
    }

    public static double modulo(double x, double m) {
        return x - m * Math.floor(x / m);
    }

    public static int moduloInt(int x, int m) {
        return x >= 0 ? x % m : ((x % m != 0) ? m + x % m : 0);
    }

    // Compute the next highest power of 2 of 32-bit v
    public static int nextPowerOfTwo(int x) {
        x = x - 1;
        x = x | (x >> 1);
        x = x | (x >> 2);
        x = x | (x >> 4);
        x = x | (x >> 8);
        x = x | (x >> 16);
        return x + 1;
    }

    public static int powerOfTwo(int i) {
        int e = 0;
        int power = 1;

        while (e < i) {
            power = power << 1;
            e++;
        }

        return power;
    }

    // Return a random variable using a gaussian distribution and a variance of 1.
    /*
     *  @return a random double value in the range [-1, 1[.
     */
    public static double randomGaussian() {
        return Math.sqrt(-2
                * Math.log((double) (1e-10 + (1 - 2e-10) * Math.random())))
                * Math.cos((double) (2 * Math.PI * Math.random()));
    }

    public static int reverseByteOrdering(int before) {
        byte[] beforeBytes = intToByteArray(before);
        byte[] afterBytes = new byte[4];
        afterBytes[0] = beforeBytes[3];
        afterBytes[1] = beforeBytes[2];
        afterBytes[2] = beforeBytes[1];
        afterBytes[3] = beforeBytes[0];

        return byteArrayToInt(afterBytes);
    }

    public static long reverseByteOrdering(long before) {
        byte[] beforeBytes = longToByteArray(before);
        byte[] afterBytes = new byte[8];
        afterBytes[0] = beforeBytes[7];
        afterBytes[1] = beforeBytes[6];
        afterBytes[2] = beforeBytes[5];
        afterBytes[3] = beforeBytes[4];
        afterBytes[4] = beforeBytes[3];
        afterBytes[5] = beforeBytes[2];
        afterBytes[6] = beforeBytes[1];
        afterBytes[7] = beforeBytes[0];

        return byteArrayToLong(afterBytes);
    }

    public static short reverseByteOrdering(short before) {
        byte[] beforeBytes = shortToByteArray(before);
        byte[] afterBytes = new byte[2];
        afterBytes[0] = beforeBytes[1];
        afterBytes[1] = beforeBytes[0];

        return byteArrayToShort(afterBytes);
    }

    // Bitwise rotation on the left.
    public static int rol(int a, int n) {
        return (a << n) | (a >> (4 << 3 - n));
    }

    // Bitwise rotation on the right.
    public static int ror(int a, int n) {
        return (a >> n) | (a << (4 << 3 - n));
    }

    public static byte[] shortToByteArray(short a) {
        return new byte[] { (byte) ((a >> 8) & 0xff), (byte) (a & 0xff) };
    }

    public static int sign(double x) {
        return (x < 0) ? -1 : (x == 0 ? 0 : 1);
    }

    // Count the consecutive zero bits (trailing) on the right by binary search
    public static int trailingZeroRight(int N) {
        int v = N; // 32-bit word input to count zero bits on right
        int c; // c will be the number of zero bits on the right,
        // so if v is 1101000 (base 2), then c will be 3
        // NOTE: if 0 == v, then c = 31.
        if ((v & 0x1) != 0) {
            // special case for odd v (assumed to happen half of the time)
            c = 0;
        } else {
            c = 1;

            if ((v & 0xffff) == 0) {
                v >>= 16;
                c += 16;
            }

            if ((v & 0xff) == 0) {
                v >>= 8;
                c += 8;
            }

            if ((v & 0xf) == 0) {
                v >>= 4;
                c += 4;
            }

            if ((v & 0x3) == 0) {
                v >>= 2;
                c += 2;
            }

            c -= v & 0x1;
        }

        return c;
    }
}
