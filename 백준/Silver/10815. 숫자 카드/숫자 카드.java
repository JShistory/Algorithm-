
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static boolean binarySearch(int key, int low, int high, int[] arr) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                return binarySearch(key, low, mid - 1, arr);
            } else {
                return binarySearch(key, mid + 1, high, arr);
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] user1 = new int[N];
        for (int i = 0; i < N; i++) {
            user1[i] = Integer.parseInt(st1.nextToken());
        }
        Arrays.sort(user1);
        
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        while (st2.hasMoreTokens()) {
            if (binarySearch(Integer.parseInt(st2.nextToken()), 0, user1.length - 1, user1) == false) {
                sb.append("0 ");
            } else {
                sb.append("1 ");
            }
        }
        System.out.println(sb.toString());
    }
}
