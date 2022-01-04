package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * �Ʊ� ����� �ʱ� ũ��� 2, �����¿� ������ �� �ִ�
 * �ڽ��� ũ�⺸�� ���� ����⸸ ���� �� �ְ�, �ڽź��� ū ����� �ִ� ĭ�� ������ �� ����.
 * ���� ũ���� ���� �� ������ ������ �� �ִ�.
 * �ڽ��� ũ��� ���� ���� ����⸦ ���� �� ���� ũ�Ⱑ 1 ����
 * 
 * ���� ���� : �Ʊ� �� �� �� ���� ���� ���� ������ ��û���� �ʰ� ����⸦ ��Ƹ��� �� �ִ��� ���϶�
 */
// 1. BFS�� �����غ���
/*
 * ����
 * ���� 1�ʿ� �� �������� ������ �� �ְ� �̶� �����¿쿡 ���� �� �ִ� ����Ⱑ 
 * �����Ѵٸ� ����Ʈ�� ��� �����ϱ�� ������
 * �׸��� ���� �� �ִ� ����Ⱑ �������� �����Ѵٸ� ������� ���� ���� ����⸦
 * �����ؾ� �ϱ� ������ ����� �� ��ġ���� ���� ����� ����⸦ ����ؾ���.
 * ���� BFS�� �̿��Ͽ� ����⸶���� �Ÿ��� �����صΰ� �Ÿ��� ���� ����� 
 * ����⸦ ����ϴ� ������ ����
 * �� �� �������� ������ ���Ǵ�� ���κ��� �Ÿ��� ���� ����Ⱑ �����Ѵٸ� ���� ��,
 * ���� ���� ����⸦ �����ؾ� �ϹǷ� X��ǥ�� ���� �߰����� �񱳰� �ʿ��ϴٰ� �Ǵ���.
 */
/*
 * 1. �ִܰ��
 * ��� ���������� �ִ� �Ÿ��� ���� ���ΰ�
 * 2. �ڷᱸ��
 * ��� ������ ��ġ������ ������ ���ΰ�
 * 3. �̵�
 * ��� �����¿�� 1ĭ�� ������ ���ΰ�
 * 4. ���� �Ÿ��� ª�� ����Ⱑ ���������� ���
 * ��� ���� ����, ���� ���� ����⸦ ã�� ���ΰ�
 * 
 */

public class �Ʊ���{

    public static final int max_val = 401, max_int = 21;
    public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
    public static int [][] a, check; //a�迭�� ������ ������ ����, check �迭�� �̵��Ÿ��� ����
    public static int [] dx = {0, 0, 1, -1}, dy = {-1, 1, 0, 0};
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n + 1][n + 1];
        check = new int[n+1][n+1];

        // Input
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());

                // �Ʊ� ����� ���
                if(a[i][j] == 9){
                    // x,y ��ǥ�� ���� �������ְ�
                	shark_x = i;
                    shark_y = j;
                    // �����󿡼� 0���� ����ش� -> ���� : �� ����⸦ ������ �� ĭ�� �� ĭ�� ��
                    a[i][j] = 0;
                }
            }
        }

        // �ݺ��� ����
        while(true){
            // BFS ������ ���� ���� �ʱ�ȭ
        	init_check();

        	// ���� Ž������ ���� �� �ִ� ����⸦ ã�´�
            bfs(shark_x, shark_y);

            //���� �� �ִ� ����⸦ ã�� ���
            if(min_x != max_int && min_y != max_int){
                // �̵��ð��� �����ش�
            	result += check[min_x][min_y];

            	// ����� ���� ���� 1������Ų��
                eat_cnt++;

                // ���� ���� ����� ���� ����� ũ��� ���ٸ�
                if(eat_cnt == shark_size){
                    // ����� ũ�⸦ 1������Ű��, ���� ����� ���� 0���� �ʱ�ȭ�����ش�
                	shark_size++;
                    eat_cnt = 0;
                }

                // ���� ������� ��ġ�� 0=��ĭ���� �������ش�.
                a[min_x][min_y] = 0;

                // ����� ��ġ�� �������ش�
                shark_x = min_x;
                shark_y = min_y;
            }
            
            // ���� �� �ִ� ����Ⱑ ���� ��� �ݺ����� ������
            else{
                break;
            }
        }
        
        // ����� ��� = �̵��� �ɸ� �ð�
        System.out.println(result);
    }

    // BFS������ ���� ���� �ʱ�ȭ
    public static void init_check(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        // �� �κ��� ���ذ��ȵ�.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                check[i][j] = -1;        
            }
        }
    }

    // ���� Ž��(BFS) ����
    public static void bfs(int x, int y){
    	//BFS�� ����� ť�� ����
        Queue<info> q = new LinkedList<info>();
        // ����� ù ��ġ�� �ð��� 0���� �ʱ�ȭ
        check[x][y] = 0;
        q.add(new info(x, y));

        while(!q.isEmpty()){
        	// ť���� ���� �տ� �ִ� ��ü�� ����
            info cur = q.poll();
            x = cur.x;
            y = cur.y;

            // 4������ Ž��
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // ���� ������ �Ѿ�� ��� �ǳʶڴ�
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                // 1) �̹� �湮�߰ų�, 2) ����� ũ�⺸�� ū ������� ��� �ǳʶڴ�
                if(check[nx][ny] != -1 || a[nx][ny] > shark_size) continue;

                // (nx, ny)�� �ִ� ���������� �̵��Ÿ��� �������ش�
                check[nx][ny] = check[x][y] + 1;

                // ���� �� �ִ� ������� ���
                if(a[nx][ny] != 0 && a[nx][ny] < shark_size){
                	
                	// ���� ���� ���������� �̵��ð��� �� ª�� ���
                    if(min_dist > check[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = check[nx][ny];
                    }
                    // ���� ���� ���������� �̵��ð��� ������ 1) ���� ����, ���� ������ ã�´�
                    else if(min_dist == check[nx][ny]){
                        if(min_x == nx){
                            if(min_y > ny){
                                min_x = nx;
                                min_y = ny;
                            }
                        }else if(min_x > nx){
                            min_x = nx;
                            min_y = ny;
                        }
                    }
                }
                
                // ������� ��ġ�� ť�� �־��ش�
                q.add(new info(nx, ny));
            }
        }

    }
}


// ��� �Ǵ� ������� ��ǥ(x,y)�� ������ ����ü ����
class info{
    int x, y;

    info(int x, int y){
        this.x = x;
        this.y = y;
    }
};
