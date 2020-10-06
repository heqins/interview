public class 牛客浮点数求平方 {
    public static double sqrt_(double t, Double precise) {
        double x0 = t, x1, differ,
                prec = precise != null ? precise : 1e-7;

        while (true) {
            x1 = (x0 * x0 + t) / (2 * x0);
            differ = x1 * x1 - t;

            if (differ <= prec && differ >= -prec) {
                return x1;
            }
            x0 = x1;
        }

        /**
         * public static double sqrt(double t, Double precise) {
         * double low = 0, high = t, middle, squre,
         * 				prec = precise != null ? precise : 1e-7;
         * 		if ( t < 0 ) {
         * 			throw new RuntimeException("Negetive number cannot have a sqrt root.");
         *                }
         *
         * 		while ( high - low > prec ) {
         * 			middle = ( low + high ) / 2;
         * 			squre = middle * middle;
         *
         * 			if ( squre > t ) {
         * 				high = middle;
         *            } else {
         * 				low = middle;
         *            }
         *        }
         * 		return ( low + high ) / 2;
         */
    }
}
