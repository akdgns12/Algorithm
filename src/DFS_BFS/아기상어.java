package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 아기 상어의 초기 크기는 2, 상하좌우 움직일 수 있다
 * 자신의 크기보다 작은 물고기만 먹을 수 있고, 자신보다 큰 물기고가 있는 칸은 지나갈 수 없다.
 * 같은 크기라면 먹을 순 없지만 지나갈 순 있다.
 * 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가
 * 
 * 최종 구현 : 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하라
 */
// 1. BFS로 구현해보자
/*
 * 착상
 * 상어는 1초에 네 방향으로 움직일 수 있고 이때 상하좌우에 먹을 수 있는 물고기가 
 * 존재한다면 리스트에 담아 관리하기로 결정함
 * 그리고 먹을 수 있는 물고기가 여러마리 존재한다면 운선순위에 따라 먹을 물고기를
 * 결정해야 하기 때문에 상어의 현 위치에서 가장 가까운 물고기를 계산해야함.
 * 따라서 BFS를 이용하여 물고기마다의 거리를 저장해두고 거리가 가장 가까운 
 * 물고기를 사냥하는 것으로 생각
 * 이 때 문제에서 제시한 조건대로 상어로부터 거리가 같은 물고기가 존재한다면 가장 위,
 * 가장 왼쪽 물고기를 선택해야 하므로 X좌표에 대한 추가적인 비교가 필요하다고 판단함.
 */
/*
 * 1. 최단경로
 * 어떻게 물고기까지의 최단 거리를 구할 것인가
 * 2. 자료구조
 * 어떻게 지도와 위치정보를 저장할 것인가
 * 3. 이동
 * 어떻게 상하좌우로 1칸씩 움직일 것인가
 * 4. 가장 거리가 짧은 물고기가 여러마리일 경우
 * 어떻게 제일 위쪽, 제일 왼쪽 물고기를 찾을 것인가
 * 
 */

public class 아기상어{

    public static final int max_val = 401, max_int = 21;
    public static int n, shark_x, shark_y, min_dist, min_x, min_y, result, eat_cnt = 0, shark_size = 2;
    public static int [][] a, check; //a배열은 지도의 정보를 저장, check 배열은 이동거리를 저장
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

                // 아기 상어일 경우
                if(a[i][j] == 9){
                    // x,y 좌표를 따로 저장해주고
                	shark_x = i;
                    shark_y = j;
                    // 지도상에서 0으로 비워준다 -> 조건 : 상어가 물고기를 먹으면 그 칸은 빈 칸이 됨
                    a[i][j] = 0;
                }
            }
        }

        // 반복문 수행
        while(true){
            // BFS 수행을 위한 정보 초기화
        	init_check();

        	// 완전 탐색으로 먹을 수 있는 물고기를 찾는다
            bfs(shark_x, shark_y);

            //먹을 수 있는 물고기를 찾은 경우
            if(min_x != max_int && min_y != max_int){
                // 이동시간을 더해준다
            	result += check[min_x][min_y];

            	// 물고기 먹은 수를 1증가시킨다
                eat_cnt++;

                // 만약 먹은 물고기 수가 상어의 크기와 같다면
                if(eat_cnt == shark_size){
                    // 상어의 크기를 1증가시키고, 먹은 물고기 수를 0으로 초기화시켜준다
                	shark_size++;
                    eat_cnt = 0;
                }

                // 먹은 물고기의 위치를 0=빈칸으로 갱신해준다.
                a[min_x][min_y] = 0;

                // 상어의 위치를 갱신해준다
                shark_x = min_x;
                shark_y = min_y;
            }
            
            // 먹을 수 있는 물고기가 없는 경우 반복문을 끝낸다
            else{
                break;
            }
        }
        
        // 결과값 출력 = 이동에 걸린 시간
        System.out.println(result);
    }

    // BFS수행을 위한 정보 초기화
    public static void init_check(){
        min_dist = max_val;
        min_x = max_int;
        min_y = max_int;

        // 이 부분이 이해가안됨.
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                check[i][j] = -1;        
            }
        }
    }

    // 완전 탐색(BFS) 수행
    public static void bfs(int x, int y){
    	//BFS에 사용할 큐를 선언
        Queue<info> q = new LinkedList<info>();
        // 상어의 첫 위치의 시간은 0으로 초기화
        check[x][y] = 0;
        q.add(new info(x, y));

        while(!q.isEmpty()){
        	// 큐에서 가장 앞에 있는 객체를 꺼냄
            info cur = q.poll();
            x = cur.x;
            y = cur.y;

            // 4방향을 탐색
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 지도 밖으로 넘어갔을 경우 건너뛴다
                if(nx < 1 || nx > n || ny < 1 || ny > n) continue;
                // 1) 이미 방문했거나, 2) 상어의 크기보다 큰 물고기인 경우 건너뛴다
                if(check[nx][ny] != -1 || a[nx][ny] > shark_size) continue;

                // (nx, ny)에 있는 물고기까지의 이동거리를 갱신해준다
                check[nx][ny] = check[x][y] + 1;

                // 먹을 수 있는 물고기일 경우
                if(a[nx][ny] != 0 && a[nx][ny] < shark_size){
                	
                	// 만약 현재 물고기까지의 이동시간이 더 짧은 경우
                    if(min_dist > check[nx][ny]){
                        min_x = nx;
                        min_y = ny;
                        min_dist = check[nx][ny];
                    }
                    // 만약 현재 물고기까지의 이동시간은 같으면 1) 가장 위쪽, 가장 왼쪽을 찾는다
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
                
                // 물고기의 위치를 큐에 넣어준다
                q.add(new info(nx, ny));
            }
        }

    }
}


// 상어 또는 물고기의 좌표(x,y)를 저장할 구조체 정의
class info{
    int x, y;

    info(int x, int y){
        this.x = x;
        this.y = y;
    }
};
