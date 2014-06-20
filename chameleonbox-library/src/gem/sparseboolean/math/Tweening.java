package gem.sparseboolean.math;

public class Tweening {
    public static double backEaseIn(double t, double b, double c, double d,
            double s) {
        t /= d;
        return c * t * t * ((s + 1) * t - s) + b;
    }

    public static double backEaseOut(double t, double b, double c, double d,
            double s) {
        t = t / d - 1;
        return c * (t * t * ((s + 1) * t + s) + 1) + b;
    }

    public static double backEaseInOut(double t, double b, double c, double d,
            double s) {
        if ((t /= d / 2) < 1) {
            s *= (1.525);
            return c / 2 * (t * t * ((s + 1) * t - s)) + b;
        }

        s *= 1.525;
        t -= 2.0;
        return c / 2 * (t * t * ((s + 1) * t + s) + 2) + b;
    }

    public static double bounceEaseOut(double t, double b, double c, double d) {
        if ((t /= d) < (1 / 2.75)) {
            return c * (7.5625 * t * t) + b;
        } else if (t < (2 / 2.75)) {
            t -= (1.5 / 2.75);
            return c * (7.5625 * t * t + .75) + b;
        } else if (t < (2.5 / 2.75)) {
            t -= (2.25 / 2.75);
            return c * (7.5625 * t * t + .9375) + b;
        } else {
            t -= (2.625 / 2.75);
            return c * (7.5625 * t * t + .984375) + b;
        }
    }

    public static double bounceEaseIn(double t, double b, double c, double d) {
        return c - bounceEaseOut(d - t, 0, c, d) + b;
    }

    public static double bounceEaseInOut(double t, double b, double c, double d) {
        if (t < d / 2.0) {
            return bounceEaseIn(t * 2, 0, c, d) * .5 + b;
        } else {
            return bounceEaseOut(t * 2 - d, 0, c, d) * .5 + c * .5 + b;
        }
    }

    public static double circEaseIn(double t, double b, double c, double d) {
        t /= d;
        return -c * (Math.sqrt(1 - t * t) - 1) + b;
    }

    public static double circEaseOut(double t, double b, double c, double d) {
        t = t / d - 1.0;
        return c * Math.sqrt(1.0 - t * t) + b;
    }

    public static double circEaseInOut(double t, double b, double c, double d) {
        if ((t /= d / 2) < 1) {
            return -c / 2 * (Math.sqrt(1 - t * t) - 1) + b;
        }

        t -= 2.0;
        return c / 2 * (Math.sqrt(1.0 - t * t) + 1) + b;
    }

    public static double cubicEaseIn(double t, double b, double c, double d) {
        t /= d;
        return c * t * t * t + b;
    }

    public static double cubicEaseOut(double t, double b, double c, double d) {
        t = t / d - 1.0;
        return c * (t * t * t + 1.0) + b;
    }

    public static double cubicEaseInOut(double t, double b, double c, double d) {
        if ((t /= d / 2) < 1) {
            return c / 2 * t * t * t + b;
        }

        t -= 2.0;
        return c / 2 * (t * t * t + 2) + b;
    }

    public static double elasticEaseIn(double t, double b, double c, double d,
            double a, double p) {
        double s = 0;

        if (t == 0) {
            return b;
        }

        if ((t /= d) == 1)
            return b + c;

        if (p != 0) {
            p = d * .3;
        }

        if (a == 0 || a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * Math.PI) * Math.asin(c / a);
        }

        t -= 1.0;
        return -(a * Math.pow(2, 10 * t) * Math.sin((t * d - s) * (2 * Math.PI)
                / p))
                + b;
    }

    public static double elasticEaseOut(double t, double b, double c, double d,
            double a, double p) {
        double s = 0;

        if (t == 0) {
            return b;
        }

        if ((t /= d) == 1) {
            return b + c;
        }

        if (p != 0) {
            p = d * .3;
        }

        if (a == 0 || a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * Math.PI) * Math.asin(c / a);
        }

        return (a * Math.pow(2, -10 * t)
                * Math.sin((t * d - s) * (2 * Math.PI) / p) + c + b);
    }

    public static double elasticEaseInOut(double t, double b, double c,
            double d, double a, double p) {
        double s = 0;

        if (t == 0) {
            return b;
        }

        if ((t /= d / 2) == 2) {
            return b + c;
        }

        if (p != 0) {
            p = d * (.3 * 1.5);
        }

        if (a == 0 || a < Math.abs(c)) {
            a = c;
            s = p / 4;
        } else {
            s = p / (2 * Math.PI) * Math.asin(c / a);
        }

        if (t < 1.0) {
            t -= 1;
            return -0.5
                    * (a * Math.pow(2, 10.0 * t) * Math.sin((t * d - s)
                            * (2 * Math.PI) / p)) + b;
        }

        t -= 1;
        return a * Math.pow(2, -10 * t)
                * Math.sin((t * d - s) * (2 * Math.PI) / p) * .5 + c + b;
    }

    public static double expoEaseIn(double t, double b, double c, double d) {
        return (t == 0) ? b : c * Math.pow(2, 10 * (t / d - 1)) + b;
    }

    public static double expoEaseOut(double t, double b, double c, double d) {
        return (t == d) ? b + c : c * (-Math.pow(2, -10 * t / d) + 1) + b;
    }

    public static double expoEaseInOut(double t, double b, double c, double d) {
        if (t == 0) {
            return b;
        }

        if (t == d) {
            return b + c;
        }

        if ((t /= d / 2) < 1) {
            return c / 2 * Math.pow(2, 10 * (t - 1)) + b;
        }

        return c / 2 * (-Math.pow(2, -10 * --t) + 2) + b;
    }

    public static double linearEaseNone(double t, double b, double c, double d) {
        return c * t / d + b;
    }

    public static double linearEaseIn(double t, double b, double c, double d) {
        return c * t / d + b;
    }

    public static double linearEaseOut(double t, double b, double c, double d) {
        return c * t / d + b;
    }

    public static double linearEaseInOut(double t, double b, double c, double d) {
        return c * t / d + b;
    }

    public static double quadEaseIn(double t, double b, double c, double d) {
        t /= d;
        return c * t * t + b;
    }

    public static double quadEaseOut(double t, double b, double c, double d) {
        t /= d;
        return -c * t * (t - 2) + b;
    }

    public static double quadEaseInOut(double t, double b, double c, double d) {
        if ((t /= d / 2) < 1) {
            return c / 2 * t * t + b;
        }

        --t;
        return -c / 2 * (t * (t - 2) - 1) + b;
    }

    public static double quartEaseIn(double t, double b, double c, double d) {
        t /= d;
        return c * t * t * t * t + b;
    }

    public static double quartEaseOut(double t, double b, double c, double d) {
        t = t / d - 1;
        return -c * (t * t * t * t - 1) + b;
    }

    public static double quartEaseInOut(double t, double b, double c, double d) {
        if ((t /= d / 2) < 1) {
            return c / 2 * t * t * t * t + b;
        }

        t -= 2.0;
        return -c / 2 * (t * t * t * t - 2) + b;
    }

    public static double quintEaseIn(double t, double b, double c, double d) {
        t /= d;
        return c * t * t * t * t * t + b;
    }

    public static double quintEaseOut(double t, double b, double c, double d) {
        t = t / d - 1;
        return c * (t * t * t * t * t + 1) + b;
    }

    public static double quintEaseInOut(double t, double b, double c, double d) {
        if ((t /= d / 2) < 1) {
            return c / 2 * t * t * t * t * t + b;
        }

        t -= 2;
        return c / 2 * (t * t * t * t * t + 2) + b;
    }

    public static double sineEaseIn(double t, double b, double c, double d) {
        return -c * Math.cos(t / d * (Math.PI / 2)) + c + b;
    }

    public static double sineEaseOut(double t, double b, double c, double d) {
        return c * Math.sin(t / d * (Math.PI / 2)) + b;
    }

    public static double sineEaseInOut(double t, double b, double c, double d) {
        return -c / 2 * (Math.cos(Math.PI * t / d) - 1) + b;
    }
}
