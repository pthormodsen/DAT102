public class Fakultet {
    public static void main(String[] args) {
        System.out.println("5! = " + fakultet(5));
    }

    public static int fakultet(int n) {

        if( n <= 1) { // Basissteget
            return 1;
        } else {
            return fakultet(n-1) * n;
        }

    }
}
