package 매일코딩;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 빛의경로사이클_프로그래머스lv2 {
	static class Pair{
		int x,y,d;
		
		public Pair(int x, int y, int d) {
			this.x = x;
			this.y =y;
			this.d = d;
		}
	}
	static int row;
	static int col;
	static int[] dx = {0,1,0,-1}; // 우하좌상
	static int[] dy = {1,0,-1,0};
	static char[][] map;
	
	    public int[] solution(String[] grid) {
	        ArrayList<Integer> list = new ArrayList<>();
	        row = grid.length;
	        col = grid[0].length();
	       
	        map = new char[row][col];
	        
	        int idx = 0;
	        for(String x : grid) {
	        	map[idx] = x.toCharArray();
	        	idx++;
	        }
	        
	        boolean[][][] visited = new boolean[4][row][col];
	        
	        for (int xx = 0; xx < row; xx++) {
	            for (int yy = 0; yy < col; yy++) {
	                for (int i = 0; i < 4; i++) {
	                    Queue<Pair> q = new LinkedList<>();
	                    q.offer(new Pair(xx, yy, i));
	                    int count = 0;
	                    if (!visited[i][xx][yy]) {
	                        visited[i][xx][yy] = true;
	                        while (!q.isEmpty()) {
	                            Pair p = q.poll();
	                            int x = p.x;
	                            int y = p.y;
	                            int d = p.d;
	                            count++;
	                            int nx;
	                            int ny;
	                            int dirD;
	                            if (map[x][y] == 'S') {
	                                nx = dx[d] + x;
	                                ny = dy[d] + y;
	                                dirD = d;
	                                if (!isPossible(nx, ny)) {
	                                    if (nx < 0) {
	                                        nx = row - 1;
	                                    } else if (nx >= row) {
	                                        nx = 0;
	                                    } else if (ny < 0) {
	                                        ny = col - 1;
	                                    } else {
	                                        ny = 0;
	                                    }
	                                }
	                            } else if (map[x][y] == 'L') {
	                                nx = dx[dirL(d)] + x;
	                                ny = dy[dirL(d)] + y;
	                                dirD = dirL(d);
	                                if (!isPossible(nx, ny)) {
	                                    if (nx < 0) {
	                                        nx = row - 1;
	                                    } else if (nx >= row) {
	                                        nx = 0;
	                                    } else if (ny < 0) {
	                                        ny = col - 1;
	                                    } else {
	                                        ny = 0;
	                                    }
	                                }
	                            } else {
	                                nx = dx[dirR(d)] + x;
	                                ny = dy[dirR(d)] + y;
	                                dirD = dirR(d);
	                                if (!isPossible(nx, ny)) {
	                                    if (nx < 0) {
	                                        nx = row - 1;
	                                    } else if (nx >= row) {
	                                        nx = 0;
	                                    } else if (ny < 0) {
	                                        ny = col - 1;
	                                    } else {
	                                        ny = 0;
	                                    }
	                                }
	                            }
	                            if (!visited[dirD][nx][ny]) {
	                                q.offer(new Pair(nx, ny, dirD));
	                                visited[dirD][nx][ny] = true;
	                            }
	                        }
	                        
	                        list.add(count);
	              
	                    }
	                }
	            }
	        }// end for
	        int[] answer = new int[list.size()];
	        int i= 0;
	        for(int x : list) {
	        	answer[i++] = x;
	        }
	        Arrays.sort(answer);
	        return answer;
	    }
	    
	    public static boolean isPossible(int x, int y) {
	    	if(x < 0 || x>= row || y < 0 || y >= col) {
	    		return false;
	    	}
	    	return true;
	    }
	    
	    // 0 1 2 3
	    // 우 하 좌 상
	   public static int dirL(int d) {
		   if(d == 0) {
			   return 3;
		   }else if(d == 1) {
			   return 0;
		   }else if(d == 2) {
			   return 1;
		   }else  {
			   return 2;
		   }
	   }
	   
	   public static int dirR(int d) {
		   if(d == 0) {
			   return 3;
		   }else if(d == 1) {
			   return 2;
		   }else if(d == 2) {
			   return 1;
		   }else{
			   return 0;
		   }
	   }
	   
	   
	}

