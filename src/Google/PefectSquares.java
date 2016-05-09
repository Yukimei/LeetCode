package Google;
//key在于dp,第二层循环是看它的j * j 以及j * j 之前需要多少个数的square sum
public class PefectSquares {
    public int numSquares(int n) {
        if (n <= 2) {
            return n;
        }
        
        int[] store = new int[n + 1];
        store[0] = 0;
        for (int i = 1; i <= n; i++) {
            store[i] = i;
            for (int j = 1; j * j <= i; j++) {
                store[i] = Math.min(store[i], store[i - j * j] + 1);
            }
        }
        return store[n];
    }
}