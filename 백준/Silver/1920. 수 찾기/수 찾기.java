
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(arr1);
        while (st.hasMoreTokens()) {
            sb.append(binarySearch(arr1, Integer.parseInt(st.nextToken()), 0, arr1.length - 1)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] == target) {
            return 1;
        }
        while (start < end) {
            if (arr[mid] > target) {
                return binarySearch(arr, target, start, mid - 1);
            } else {
                return binarySearch(arr, target, mid + 1, end);
            }
        }
        return 0;
    }
}
