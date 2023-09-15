public class Multiples {
    public static int main(int n, int a, int b) {
        return Multiples(n, a, b);
    }

    public static int main() {

        return Multiples(1000, 3, 5);
    }

    public static int Multiples(int n, int b, int a) {
        int counter = 0;
        for (int i = 1; i < n; i++){
            if (i % a == 0){
                counter++;
            } else if (i % b == 0) {
                counter++;
            }
        }
        return counter;
    }
}


