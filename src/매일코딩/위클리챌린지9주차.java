package 매일코딩;

public class Solution {

    public int solution(int n, int[][] wires) {
        int answer = 100;
        int[] parent = new int[n + 1];
        // edge를 하나씩(except)빼고 union-find를 진행
        for (int except = 0; except < wires.length; except++) {
            for (int i = 1; i <= n; i++) { // 초기화
                parent[i] = i;
            }
            for (int i = 0; i < wires.length; i++) { //
                if(i == except){
                    continue;
                }
                union(wires[i][0], wires[i][1], parent);
            }

            // 트리 2개의 각 부모 2개를 찾음
            int[] p = new int[2];
            int start = 0;
            for (int i = 1; i <= n; i++) {
                if(i == parent[i]){
                    p[start++] = i;
                }
            }
            
            // 부모 노드 2개의 개수를 셈
            int count1 = 0;
            int count2 = 0;
            for (int i = 1; i <= n; i++) {
                if (find(i,parent) == p[0]) {
                    count1++;
                } else {
                    count2++;
                }
            }
            
            answer = Math.min(Math.abs(count1 - count2), answer);
        } // End Outter For문
        
        return answer;
    }

    public int find(int v, int[] parent) {
        if(parent[v] == v){
            return v;
        }
        return find(parent[v], parent);
    }

    // 부모가 같으면 트리로 연결
    public void union(int v1, int v2, int[] parent) {
        int p2 = find(v2, parent);
        parent[p2] = v1;// 높은수의 부모의 부모를 낮은 값으로 교체시킴 
    }
}