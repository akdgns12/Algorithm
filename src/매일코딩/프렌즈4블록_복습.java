import java.util.*;

class Solution {
    static char[][] map;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char[m][n];
        for(int i=0; i<m; i++){
                map[i] = board[i].toCharArray();
        }
        
        while(true){
            int cnt = checkBlock(m, n);
            if(cnt == 0){
                break;
            }
            
            answer += cnt;
            dropBlock(m, n);
                
        }
        
        return answer;
    }
    
    public int checkBlock(int m, int n){
        boolean[][] visited = new boolean[m][n];
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(map[i][j] != '.'){
                    char cur = map[i][j];
                    if(cur == map[i-1][j-1] && cur == map[i][j-1] && cur == map[i-1][j]){
                        visited[i-1][j-1] = true;
                        visited[i][j-1] = true;
                        visited[i-1][j] = true;
                        visited[i][j] = true;
                    }
                }
            }
        }
        return countBlock(m,n,visited);
    }
    
    // 2*2 블록이 몇개인지
    public int countBlock(int m, int n, boolean[][] visited){
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]){
                    count+=1;
                    map[i][j] = '.'; // . 으로 마킹
                }
            }
        }
        return count;
    }
    
    // 빈 블록 아래로 내리는 과정 
    // 이 과정 주의해서 진행해보고 이해하자
    public  void dropBlock(int m, int n){
        for(int i=m-1; i>0; i--){
            for(int j=0; j<n; j++){
                if(map[i][j] == '.'){
                    for(int k=i-1; k>=0; k--){
                        if(map[k][j] != '.'){
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}	