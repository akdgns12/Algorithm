package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * Ǯ�� ����
 * 1. ���̷���(2)�� ���� ���� virusList�� �ֱ�
 * 2. nCm �������� ��� ��쿡 ���� �ð� ���
 * 3. m�� �ݺ��ϸ� BFS�� ���̷��� Ȯ��ó��
 */
public class ������3 {
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
                    emptyCnt++;//0����
                } else if (map[i][j] == 2) {
                    virusList.add(new Virus(i,j));
                }
            }
        }

        visit = new boolean[virusList.size()];

        dfs(0,0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }//main
    
    // count(������� ���� ��), start(���� ����Ű�� ��ȣ)
    private static void dfs(int start, int count) {

        if (count == m) {

            //���� ��, Ȯ�����
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

        //�湮ó���� ����Ʈ�� ť�� ���
        for (int i=0; i<virusList.size(); i++) {
            if (visit[i]) {
                q.add(new Virus(virusList.get(i).x, virusList.get(i).y, 0));
            }
        }

        //���� �ϳ� ����� �ִ� ���ϱ�(���� ���� �ִ񰪺��� ũ�� ������ �޼��� ����)
        int value = 0;//�ð�
        int zeroCnt = 0;//0����

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
                        //0�϶� 0����+1, �ð� : �����ð�+1
                        zeroCnt++;
                        value = v.time+1;
                    }
                    visited[nx][ny] = true;
                    q.add(new Virus(nx,ny,v.time+1));
                }
            }
        }

        if (emptyCnt == zeroCnt) {
            //0�� ������ ������ ��� Ȯ��� ���̹Ƿ� �ִ�ð� ��ȯ
            return value;
        }

        //0 ������ �ƽ��� ��ȯ
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
