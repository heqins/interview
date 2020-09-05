package interview;

public class sqrt {
    public static double sqrt(double t, Double precise) {
        double low = 0, high = t, middle, squre,
                prec = precise != null ? precise : 1e-7;
        if ( t < 0 ) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }

        while ( high - low > prec ) {
            middle = ( low + high ) / 2;
            squre = middle * middle;

            if ( squre > t ) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return ( low + high ) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sqrt.sqrt(5.0, 1e-7));
    }
}
