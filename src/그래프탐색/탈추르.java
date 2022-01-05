package ±×·¡ÇÁÅ½»ö;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//

public class Å»Ãß¸£ {
	static class Pos{
		int y,x,time;
			
			public Pos(int y, int x) {
				super();
				this.y = y;
				this.x = x;
			}
			
			public Pos(int y, int x,int time) {
				super();
				this.y = y;
				this.x = x;
				this.time=time;
			}
		}
	static int r,c;
	static int[] xpos= {0,0,1,-1};
	static int[] ypos= {1,-1,0,0};
	static int answer=Integer.MAX_VALUE;
	static char[][] map=new char[r][c];
	static Queue<Pos> q=new LinkedList<Pos>();
	static Queue<Pos> water=new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		r=sc.nextInt();
		c=sc.nextInt();
		map=new char[r][c];
		for (int i = 0; i < r; i++) {
			String s=sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j]=s.charAt(j);
				if(map[i][j]=='S') {
					q.add(new Pos(i,j,0));
				}else if(map[i][j]=='*') {
					water.add(new Pos(i,j));
				}
			}
		}
		
		go();
		
		System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
		
		
	}
	private static void go() {
		
		while(q.size()!=0) {
			int len=water.size();
			//¹° ÆÛ¶ß¸²
			for (int i = 0; i < len; i++) {
				Pos cur=water.poll();
				int y=cur.y;
				int x=cur.x;
				for (int k = 0; k < 4; k++) {
					int yy=y+ypos[k];
					int xx=x+xpos[k];
					if(xx<0 || yy<0 || xx>=c || yy>=r)continue;
					if(map[yy][xx]=='D' || map[yy][xx]=='X' || map[yy][xx]=='*')continue;
					map[yy][xx]='*';
					water.add(new Pos(yy,xx));
				}
				
			}
			
			len=q.size();
			for (int i = 0; i < len; i++) {
				// °í½¿ µµÄ¡ ÀÌµ¿
				Pos cur=q.poll();
				int y=cur.y;
				int x=cur.x;
				int time=cur.time;
				for (int k = 0; k < 4; k++) {
					int yy=y+ypos[k];
					int xx=x+xpos[k];
					if(xx<0 || yy<0 || xx>=c || yy>=r)continue;
					if(map[yy][xx]=='D') {
						answer=Math.min(answer, time+1);
						return;
					}else if(map[yy][xx]=='.') {
						map[yy][xx]='S';
						q.add(new Pos(yy,xx,time+1));
					}
				}
			}
			

		}
		
	}
}
