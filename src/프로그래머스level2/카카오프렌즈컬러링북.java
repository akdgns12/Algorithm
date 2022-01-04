package 프로그래머스level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 그림의 난이도 = 영역의 수
 * 영역 = (상하좌우로 연결된 같은 색상의 공간)
 * 
 * picture의 값 중 0인 경우는 색칠하지 않은 영역
 * 
 * 영역이 몇개있는지와 가장 큰 영역의 넓이 구하기
 * 
 */
/*
public class 카카오프렌즈컬러링북 {
		public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		int[] answer = new int[2];
		answer[0] = numberOfArea; //영역의 수
		answer[1] = maxSizeOfOneArea; //가장 많은 영역을 가지고 있는 영역의 수
		
		picture = new int[m][n]; 
		boolean[][] visited = new boolean[m][n]; //방문여부 체크
		// 방문했던 이전 픽셀로 돌아가기 위한 x,y좌표
		Stack<Integer> stackX = new Stack<>();
		Stack<Integer> stackY = new Stack<>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				// 같은 색상의 배열을 찾는 count 초기화
				int count = 0;
				
				//이중 for문의 좌표를 기준으로 색상이 존재하는 곳(0이 아닌)과 방문하지 않은 곳 찾기
				if(picture[i][j] > 0 && visited[i][j]==false) {
					//방문하지 않고 색상이 존재하는 처음 좌표를 stack좌표에 기록, 방문표시, 카운트, 색상영역 카운트
					stackX.add(j);
					stackY.add(i);
					visited[i][j] = true;
					count++;
					answer[0]++;
				}
				
				//인접한 동일한 색상을 갖은 좌표를 가지고 있으면 while문 반복
				while(!stackX.isEmpty()) {
					
					//가장 최근의 x,y좌표를 stack에서 pop()
					int x = stackX.pop();
					int y = stackY.pop();
					
					//stack좌표를 기준으로 위로 이동
					//바로 위에 배열이 존재 && 배열의 색상이 기준 좌표와 같음 && 방문하지 않았으면
					if(y > 0 && picture[y-1][x] == picture[i][j] && visited[y-1][x] == false) {
						stackX.add(x);
						stackY.add(y-1);
						visited[y-1][x] = true
								count++;
					}
					
					//stack좌표를 기준으로 좌로 이동
					//기준 좌표 왼쪽에 배열이 존재 && 배열의 색상이 기준 좌표와 같음 && 방문하지 않았으면
					if(x>0 && picture[y][x-1] == picture[i][j] && visited[y][x-1] == false) {
						stackX.add(x-1);
						stackY.add(y);
						visited[y][x-1] = true;
						count++;
					}
					//stack좌표를 기준으로 아래로 이동
					//기준 좌표 아래쪽에 배열이 ㅈㄴ재 && 배열의 생성이 기준 좌표와 같음 && 방문하지 않았으면
					if( y < m-1 && picture[y+1][x] == picture[i][j] && visited[y+1][x] == false) {
						stackX.add(x);
						stackY.add(y+1);
						visited[y+1][x]=true;
						count++;
					}
					
					//stack좌표를 기준으로 우측으로 이동
					//기준 좌표 우측에 배열이 존재 && 배열의 색상이 기준좌표와 같음 && 방문하지 않았으면
					if( x < n-1 && picture[y][x+1] == picture[i][j] && visited[y][x+1]==false) {
						stackX.add(x+1);
						stackY.add(y);
						visited[y][x+1]=true;
						count++;
					}
				}
				//while() stack에서 꺼낸 가장 최근 좌표를 기준으로 모든 방향을 탐색하고
				// 스택에 저장된 좌표들을 꺼내며 되돌아오면서 주변 배열을 탐색
				//stack에서 모든 좌표가 꺼내졌으면, for문의 기준 좌표들과 인접한 배열들을 모두 탐색을 마쳤고,
				//answer[1] 공간에 가장 큰 값만 남도록 Math.max(숫자, 숫자)를 이용하여 대입
				
				answer[1] = Math.max(answer[1], count);
			}
		}//이중 for문으로 색상이 존재하는 모든 배열을 방문을 마치면
		//'answer[0] : 영역의 수, answer[1] : 가장 많은 픽셀을 가지고 있는 영역의 픽셀 수'를 리턴
		
		
		
		return answer;
	}
}
*/
/*
public class 카카오프렌즈컬러링북 {
	class Point{
		int x,y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public int BFS(boolean[][] visited, int[][] picture, Point start) {
		Queue<Point> queue = new LinkedList<>();
		int[] dx = { -1, 1, 0, 0} , dy = {0,0,1,-1};
		int area = 1, nx, ny;
		
		visited[start.x][start.y] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for(int i=0; i<4; i++) {
				nx = dx[i] + cur.x;
				ny = dy[i] + cur.y;
				
				if( nx >=0 && nx < picture.length && ny >= 0 && ny < picture[0].length) {
					if(!visited[nx][ny] && picture[nx][ny] !=0 && picture[cur.x][cur.y] == picture[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Point(nx,ny));
						area++;
					}
				}
			}
		}
		return area;
	}
	public int[] solution(int m, int n, int[][] picture) {
		int[] answer = new int[2];
		boolean[][] visited = new boolean[m][n];
		
		for(int i=0; i<m; i++)
			Arrays.fill(visited[i], false);
		
		for(int x = 0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(visited[x][y] || picture[x][y] == 0)
					continue;
				
				answer[1] = Math.max(answer[1], BFS(visited, picture, new Point(x,y)));
				answer[0]++;
			}
		}
			return answer;
	}
}*/
public class 카카오프렌즈컬러링북{
	//변수 접근을 위한 전역 변수들
	static int numberOfArea; // 영역의 개수
	static int maxSizeOfOneArea; // 가장 많은 사이즈의  영역의 사이즈
	//한 영역의 수를 저장하는 변수
	static int temp_cnt = 0; 
	//좌표에서의 상,하,좌,우 탐색을 위한 배열
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	//DFS메소드
	public static void dfs(int x, int y, int[][] picture, boolean[][] check) {
		//6. 방문한 적 있는 좌표라면 DFS종료
		if(check[x][y]) return;
		
		//7.처음 방무시 방문처리.
		check[x][y] = true;
		//8. 한 영역의 수 증가.
		temp_cnt++;
		
		//9. 한 좌표에서 상,하,좌,우 탐색.
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			//10.picture배열의 범위를 벗어나면 continue.
			if( nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;
			
			//11. 현좌표의 색 == 상,하,좌,우 좌표의 색 && 방문한 적 없는 상,하,좌,우 좌표라면.
			if(picture[x][y] == picture[nx][ny] && !check[nx][ny]) {
				
				//12. DFS재귀호출
				dfs(nx,ny,picture, check);
			}
		}
	}
	public int[] solution(int m, int n, int[][] picture) {
		//1.초기화 꼭! 하기
		numberOfArea = 0;
		maxSizeOfOneArea = 0;
				
		int[] answer = new int[2];
		answer[0]=numberOfArea;
		answer[1]=maxSizeOfOneArea;
		
		//2.DFS시 방문여부를 체크 할 배열.
		boolean[][] check = new boolean[m][n];
		
		//3. 주어진 picture배열을 탐색
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				//4.원소가 0이 아니고, 방문한 적이 없다면.
				if(picture[i][j] !=0 && !check[i][j]) {
					//5.영역의 수가 1개 증가하며 DFS탐색 수행
					numberOfArea++;
					dfs(i,j,picture,check);
				}
				//13.한 영역의 탐색이 모두 끝났다면, 조건에 따라 최대 영역의 수를 변경
				if(temp_cnt > maxSizeOfOneArea) maxSizeOfOneArea = temp_cnt;
				//14. 한 영역의 수는 다시 초기화
				temp_cnt = 0;
			}
		}
		
		//15. 각 값을 answer 배열에 담아주고 끝
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		
		
		return answer;
	}
}