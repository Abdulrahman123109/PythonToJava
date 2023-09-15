public class Reduce {
    public static int main(int n) {
        int r = getDd(n);
        return r;
    }
    private static int getDd(int n) {
        int dd =0;
        while(n != 0){
            if (n %2 == 0){
                n = n /2;
                dd++;
            }
            else {
                n = n - 1;
                dd++;
            }
        }
        return dd;
    }
}

