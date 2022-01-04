package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 풀이 생각
 * 1. 바이러스(2)인 수를 전부 virusList에 넣기
 * 2. nCm 형식으로 모든 경우에 대한 시간 계산
 * 3. m번 반복하며 BFS로 바이러스 확산처리
 */
public class 연구소3 {
	private static int n, m;
    private static int[][] map;
    private static boolean[] visit;

    private static int result = Integer.MAX_VALUE;
    private static int emptyCnt = 0;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static ArrayList<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    emptyCnt++;//0개수
                } else if (map[i][j] == 2) {
                    virusList.add(new Virus(i,j));
                }
            }
        }

        visit = new boolean[virusList.size()];

        dfs(0,0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }//main
    
    // count(현재까지 뽑은 수), start(현재 가리키는 번호)
    private static void dfs(int start, int count) {

        if (count == m) {

            //조합 끝, 확산시작
            result = Math.min(result, spreadVirus());

        } else {

            for (int i=start; i<virusList.size(); i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    dfs(i+1, count+1);
                    visit[i] = false;
                }
            }

        }

    }

    private static int spreadVirus() {

        Queue<Virus> q = new LinkedList<>();

        boolean[][] visited = new boolean[n+1][n+1];

        //방문처리된 리스트만 큐에 담기
        for (int i=0; i<virusList.size(); i++) {
            if (visit[i]) {
                q.add(new Virus(virusList.get(i).x, virusList.get(i).y, 0));
            }
        }

        //변수 하나 만들어 최댓값 구하기(만약 이전 최댓값보다 크게 나오면 메서드 종료)
        int value = 0;//시간
        int zeroCnt = 0;//0개수

        while (!q.isEmpty()) {
            Virus v = q.poll();

            for (int i=0; i<dx.length; i++) {
                int nx = v.x + dx[i];
                int ny = v.y + dy[i];

                if (nx < 1 || ny < 1 || nx > n || ny > n) {
                    continue;
                }
                if (map[nx][ny] == 1 || visited[nx][ny]) {
                    continue;
                }
 
                if (map[nx][ny] != 1 && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        //0일때 0개수+1, 시간 : 이전시간+1
                        zeroCnt++;
                        value = v.time+1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Virus(nx,ny,v.time+1));
                }
            }
        }

        if (emptyCnt == zeroCnt) {
            //0의 개수가 같으면 모두 확산된 것이므로 최대시간 반환
            return value;
        }

        //0 남으면 맥스값 반환
        return Integer.MAX_VALUE;

    }//spreadVirus


    static class Virus {
        int x, y, time;
        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
