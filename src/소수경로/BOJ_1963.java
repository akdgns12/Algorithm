package 소수경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 입력은 항상 네자리 소수만.
 * 입력에 주어진 네자리 소수 A에서 B로 바꾸는 과정에 필요한 최소 횟수
 * 한자리씩 바꿔야함.
 * 바뀌는 과정도 모두 소수를 유지해야함.
 * '네 자리 수'이기 때문에 0039, 1000미만의 숫자는 허용 x
 */

// 소수 체크 알고리즘은 *에라토스테네스의 체 * 사용
public class BOJ_1963 {
	static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int N;
    static int M;
    static int count = 0;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start_x = Integer.parseInt(st.nextToken());
        int start_y = Integer.parseInt(st.nextToken());
        int start_dir = Integer.parseInt(st.nextToken());
 
        int[][] arr = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //--------------입력--------------
        
        Search(arr, start_x, start_y, start_dir);    //청소 실행 함수
        Check(arr);    //청소한 칸의 개수를 구함
        System.out.println(count);
    }
 
    public static void Search(int[][] arr, int start_x, int start_y, int start_dir) {
        Queue<Dot> q = new LinkedList<Dot>();
        arr[start_x][start_y] = 9;
        q.add(new Dot(start_x, start_y, start_dir));
        while (!q.isEmpty()) {
            Dot d = q.poll();
            int currentX = d.x;    //현재 x좌표
            int currentY = d.y;    //현재 y좌표
            int currentD = d.dir;    //현재 방향
            Boolean flags = false;    //4방향이 다 청소돼있거나 벽일 경우를 판단해줌.
            int nextX;
            int nextY;
            int nextD;
 
            for (int i = 0; i < 4; i++) {
                currentD = (currentD + 3) % 4;    //다음 이동할 방향
                nextX = currentX + (dx[currentD]);    //다음 이동할 X좌표
                nextY = currentY + (dy[currentD]);    //다음 이동할 Y좌표
 
                Dot nextDot = new Dot(nextX, nextY, currentD);
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //다음 이동할 위치가  청소되지 않은 곳이라면 간다.
                if (arr[nextX][nextY] == 0) {
                    q.add(nextDot);
                    arr[nextX][nextY] = 9;
                    flags = true;
                    break;
                }
            }
            //4방향다 청소됐거나 벽일 경우에는 후진해야한다.
            if (!flags) {
                nextD = (currentD + 2) % 4;
                nextX = currentX + dx[nextD];
                nextY = currentY + dy[nextD];
 
                //만약 후진할 곳이 벽이 아니라면, 이동 그렇지 않다면 종료한다.
                if (arr[nextX][nextY] != 1) {
                    arr[nextX][nextY] = 9;
                    q.add(new Dot(nextX, nextY, currentD));
                }
            }
        }
    }
 
    //청소한 칸의 개수를 구하는 함수
    public static void Check(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 9)
                    count++;
                //System.out.print(arr[i][j] + "\t");
            }
            //System.out.println();
        }
    }
}
 
class Dot {
    int x;
    int y;
    int dir;
 
    Dot(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
}
