package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 한 번의 이동에서 이미 합쳐진 블록은 또 합쳐질 수 없다
// 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸의 먼저 합쳐짐
// 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값 구하라

/*
 * 1. dfs 사용
 * 2. 4방향에 따라 이동 방향 생각
 * 3. 합쳐진 곳 또 방문 불가능
 */
import javax.swing.text.DefaultEditorKit.CopyAction;

/*
 * 생각의 방향잡기
 * void game() - 총 5번의 동작을 한다 매 동작 전 백트래킹이 가능하도록 map을 copy 배열에 복사해야함.
 * 재귀 끝나면 copy배열의 값 map으로 불러와 기존 값 복구
 * 
 * void move() - dir의 값에 따라 동작을 달리한다.
 * 상 하 좌 우
 * index는 값을 넣을 위치, block은 최근 블록의 수 저장
 */
public class 삼성기출_2048Easy {
	private static int n;
    private static int[][] map;
    private static int[][] temp;
    private static int[] direct;
    private static boolean[][] visit;

    private static int max = 0;

    private static int[] dx = {-1, 0, 1, 0};//상우하좌
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        map = new int[n+1][n+1];
        direct = new int[5];

        StringTokenizer st;
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(5,0);//5번
        System.out.println(max);

    }

    private static void dfs(int end, int index) {

        if (index == end) {

            //확인
            confirm();

        } else {
            for (int i=0; i<4; i++) {
                direct[index] = i;
                dfs(end, index+1);
            }
        }

    }//dfs

    private static void confirm() {

        temp = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            temp[i] = map[i].clone();
        }

        for (int d=0; d<direct.length; d++) {
            visit = new boolean[n+1][n+1];

            if (direct[d] == 0) {//상
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 2) {//하
                for (int i=n; i>=1; i--) {
                    for (int j=1; j<=n; j++) {
                        move(i,j,direct[d]);
                    }
                }
            } else if (direct[d] == 1) {//우
                for (int i=n; i>=1; i--) {
                    for (int j=1; j<=n; j++) {
                        //오른쪽부터 봐야함 (j,i로 보내기)
                        move(j,i,direct[d]);
                    }
                }
            } else {//좌
                for (int i=1; i<=n; i++) {
                    for (int j=1; j<=n; j++) {
                       //왼쪽부터 봐야함
                        move(j,i,direct[d]);
                   }
               }
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (temp[i][j] > max) {
                    max = temp[i][j];
                }
            }
        }

    }//confirm

    private static void move(int x, int y, int dir) {

        if (temp[x][y] == 0) {
            return;
        }

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || ny < 1 || nx > n || ny > n) {
                return;
            }
            if (visit[nx][ny]) {
                return;
            }
            if (temp[nx][ny] == temp[x][y]) {
                //같을때 합치기
                visit[nx][ny] = true;
                temp[nx][ny] *= 2;
                temp[x][y] = 0;
                return;
            } else if (temp[nx][ny] != 0) {
                //같지 않고 다른 수가 있을 때 못합침
                return;
            }

            temp[nx][ny] = temp[x][y];
            temp[x][y] = 0;
            x = nx;
            y = ny;

        }

    }//move
}
