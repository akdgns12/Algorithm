package �����ڵ�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * ����
 * 1. ������ CCTV�� ���� ������ �����ش�.
 * 1-1 ���� ������ ������ �� CCTV���� ��Ģ�� ������ �����ؼ� ����
 * 2. ������ ������ �������� ���ÿ����� ǥ���Ѵ�.
 * 3. ���� �簢������ ������ ī��Ʈ ���ش�.
 * ó������ CCTV
 */
public class ����{
	static class CCTV{ // �� cctv�� ������ ���� ��ü
		int y, x, dir, type;
		
		CCTV(int y, int x, int dir, int type){
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.type = type;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}; // ��, ��, ��, �� -> �ݽð� �������� �ε����� ����� ����
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<CCTV> cctvList;
	static int result = Integer.MAX_VALUE;
	
		public static void main(String[] args) throws IOException{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cctvList = new ArrayList<>();
			map = new int[N][M];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] >=1 && map[i][j] <= 5) { //cctv�� ��츸 
						// y, x, ����, type
						cctvList.add(new CCTV(i, j, 0, map[i][j]));
					}
				}
			} // end of input
			// type���� CCTV�� ������ ������.
			selectCCTVdir(0, cctvList.size());
			System.out.println(result);
		}
		
		/*
		 * ��ü CCTV�� ������ ���� ���� DFS
		 * idx : cctv ī��Ʈ
		 * listsize : ��ü cctv ����
		 */
		public static void selectCCTVdir(int idx, int listsize) {
			if(idx == listsize) { // cctv ��ġ�Ϸ�
				int[][] copyMap = new int[N][M]; // �� �����ؼ� ���ž�
				initMap(copyMap); // �� ����
				setRoute(copyMap); // ���� ���� ����
				int cnt = findZero(copyMap); // 0ī��Ʈ
				
				result = Math.min(result, cnt); // �ּڰ� ����
				return;
			}
			
			int dir = 4; // 2�� ī�޶� ������ �������� 0, 1, 2, 3 ���� ��� �̿�
			for(int i=idx; i<listsize; i++) {
				CCTV cctv = cctvList.get(i);
				if(cctv.type == 5) { // 5�� ī�޶�� ���� ���� �ʿ� x
					selectCCTVdir(i+1, listsize);
					continue;
				}
				if(cctv.type == 2) dir = 2; // 2�� ī�޶�� ��, �� ������ �ȴ�.
				for(int d=0; d<dir; d++) {
					//���� ������ ��������
					cctv.dir = d;
					selectCCTVdir(i+1, listsize);
				}
			}
		}

		// 0�� ������ ī����
		public static int findZero(int[][] copyMap) {
			int res = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(copyMap[i][j] == 0) res++;
				}
			}
			return res;
		}
		// �ʺ���
		public static void initMap(int[][] copyMap) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
		}
		
		// CCTV�� ������ -1�� ä������
		public static void setRoute(int[][] copyMap) {
			// ��� CCTV�� ������ ������
			for(int i=0; i<cctvList.size(); i++) {
				CCTV curCCTV = cctvList.get(i);
				int ny = curCCTV.y;
				int nx = curCCTV.x;
				int dir = curCCTV.dir;
				int type = curCCTV.type;
				for(int d=0; d<4; d++) {
					if(type == 1) { // 1�� ī�޶�� �� ����
						if(d !=0 ) continue;
					}
					else if(type == 2) { // 2�� ī�޶�� ������ ���� + 180��  �� ����
						if(d == 1 || d == 2) continue;
					}
					else if(type == 3) { // 3�� ī�޶� ���� ���� + 90��
						if(d == 2 || d == 3) continue;
					}
					else if(type == 4) { // 4�� ī�޶� ���ù��� + 90�� + 180��
						if(d == 3) continue;
					}// 5�� ī�޶�� 4����
					ny += dy[(dir+d)%4]; // ������ �������� �ε��� ���
					nx += dx[(dir+d)%4];
					
					// ������ ����ų� ���� ���� ��쿡�� ���� �ڸ����� �ٸ� ���� ���
					if(rangeCheck(ny, nx) || copyMap[ny][nx] == 6) {
						ny = curCCTV.y;
						nx = curCCTV.x;
						continue;
					}
					
					// -1 ä������
					copyMap[ny][nx] = -1;
					d--; // bfs�� �ƴ϶� �� �������� ���ư����ϱ� ������ d--�� ������
				}
			}
		}
		
		// ����üũ
		public static boolean rangeCheck(int y, int x) {
			return y < 0 || y >= N || x < 0 || x >= M;
		}
		
}
