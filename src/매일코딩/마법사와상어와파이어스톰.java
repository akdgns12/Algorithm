package 古析坪漁;
//
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 陥献 依精 析鋼 bfs庚薦人 滴惟 陥研 依戚 蒸澗汽 壕伸 噺穿馬澗 採歳戚 嬢形頗陥 ばば 
森穿拭 廃 腰 背坐辞 右諾畏走 梅澗汽 呪俳 域至聖 公馬畏嬢辞せせせせせ
掩戚亜 4析凶
湛 伸税 室稽匝
2
1
5
7
聖 湛 楳税 亜稽匝稽 幻級奄 是背辞 
2	1	5	7
亜稽匝税 伸 腰硲人 楳腰硲研 sx, sy虞澗 痕呪研 魚稽 幻級嬢辞 装亜獣徹壱 
湛 伸税 室稽匝精 for庚税 痕呪研 宜軒澗 号縦生稽 背早陥.
鎧析精 壕伸宜軒奄庚薦研 熱檎辞 宜軒澗 尻柔 岨 背醤畏陥. 誌失 奄窒拭辞 河 蟹神澗 依 旭陥.
+ 杖製 褐戚澗 杏 叔呪梅澗汽 廃 員拭辞 昔羨廃 員 3鯵戚雌昔走 域至背辞 褐戚壱 暁 陥製 牒 褐戚壱 戚君檎 照吉陥ぞぞ
廃 腰拭 褐聖 員聖 陥 域至廃 板拭 廃襖腰拭 褐食醤吉陥.
蟹澗 arraylist拭 褐聖 員税 疎妊研 隔嬢層 板 廃 腰拭 褐食早陥.
 */

/*
 * // 獣拙繊聖 説奄 是敗(姥蝕聖 蟹干聖 凶 図楕 薦析 性採歳生稽 獣拙繊聖 説焼層陥)
		for(int startRow = 0; startRow < M; startRow += len) {
			for(int startCol = 0; startCol < M; startCol += len) {
				// 噺穿                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// 坦製 伸税 葵精 衣引 楳税 葵生稽
						// 衣引 伸税 葵精  = 楳税 呪 - 坦製 楳税 葵 - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
 */
public class 原狛紫人雌嬢人督戚嬢什嶋{
	static class Pos{
		int  y,x;
		
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int n,q,m;
	static int[][] map;
	static int[] xpos= {0,0,1,-1};
	static int[] ypos= {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		q=sc.nextInt();
		m=(int) Math.pow(2, n);
		map=new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		int[] level=new int[q];
		for (int i = 0; i < q; i++) {
			level[i]=sc.nextInt();
		}
		
		//舘域拭 魚虞辞 設虞辞 壕伸 宜軒壱 褐戚奄
		for (int l = 0; l <q; l++) {
			int len=(int)Math.pow(2,level[l]);
			rotate(len);
			
		}
        //害精 杖製 杯域
		int sum=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				sum+=map[i][j];
			}
		}
		System.out.println(sum);
		
		biggest();
		
				
	}
    //杖製 浦増 亜舌 笛 員 達奄
	private static void biggest() {
		int max=0;
		boolean[][] vis=new boolean[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j]!=0) {
					int cnt=1;
					Queue<Pos> q=new LinkedList<>();
					q.add(new Pos(i,j));
					vis[i][j]=true;
					while(q.size()!=0) {
						Pos cur=q.poll();
						int y=cur.y;
						int x=cur.x;
						for (int k = 0; k < 4; k++) {
							int yy=y+ypos[k];
							int xx=x+xpos[k];
							if(yy<0 || xx<0 || yy>=m || xx>=m)continue;
							if(map[yy][xx]==0)continue;
							if(vis[yy][xx])continue;
							vis[yy][xx]=true;
							cnt+=1;
							q.add(new Pos(yy,xx));
						}
					}
					if(max<cnt)max=cnt;
				}
			}
		}
		System.out.println(max);
	}
	private static void rotate(int len) {
		int[][] map2=new int[m][m];
		
		// 壕伸 90亀 獣域号狽 噺穿獣徹奄
		for(int startRow = 0; startRow < m; startRow += len) {
			for(int startCol = 0; startCol < m; startCol += len) {
				// 噺穿                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
				for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
						// 坦製 伸税 葵精 衣引 楳税 葵生稽
						// 衣引 伸税 葵精  = 楳税 呪 - 坦製 楳税 葵 - 1 
						map2[startRow + j][startCol + len - 1 - i] = map[startRow+i][startCol+j];
					}
				}
			}	
		}
		//褐析 杖製税 疎妊亜 級嬢亜澗 軒什闘
		ArrayList<Pos> arr=new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				if(map2[i][j]==0)continue;
				int cnt=0;//昔羨  杖製 鯵呪 
				for (int k = 0; k < 4; k++) {
					int y=i+ypos[k];
					int x=j+xpos[k];
					if(x<0 || y<0 || x>=m || y>=m)continue;
					if(map2[y][x]!=0) {
						cnt++;
					}
				}
				if(cnt<3) {
                //褐析 員戚艦 軒什闘拭 隔嬢捜
					arr.add(new Pos(i,j));
				}
			}
		}
		//廃襖腰拭 褐食層陥.
		for (int i = 0; i < arr.size(); i++) {
			int y=arr.get(i).y;
			int x=arr.get(i).x;
			map2[y][x]-=1;
		}
		
		
		//据掘 壕伸拭 置曽 痕井 葵 陥獣 煽舌馬奄
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
	}