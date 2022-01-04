import java.util.Arrays;
import java.util.Scanner;

public class N��M11 {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder(); //�����ϸ� �ð��ʰ���

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        //������ ���� �����ϴ� ������� ����ؾ���
        Arrays.sort(nums);
        dfs(0,new int[M]);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[] arr) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (prev != nums[i]) { // �ߺ��Ǵ� ���� ������ ��µǴ°� ����
                prev = nums[i];
                arr[depth] = prev;
                dfs(depth + 1, arr);
            }
        }
    }
}