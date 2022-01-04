package �����ڵ�;

public class Solution {

    public int solution(int n, int[][] wires) {
        int answer = 100;
        int[] parent = new int[n + 1];
        // edge�� �ϳ���(except)���� union-find�� ����
        for (int except = 0; except < wires.length; except++) {
            for (int i = 1; i <= n; i++) { // �ʱ�ȭ
                parent[i] = i;
            }
            for (int i = 0; i < wires.length; i++) { //
                if(i == except){
                    continue;
                }
                union(wires[i][0], wires[i][1], parent);
            }

            // Ʈ�� 2���� �� �θ� 2���� ã��
            int[] p = new int[2];
            int start = 0;
            for (int i = 1; i <= n; i++) {
                if(i == parent[i]){
                    p[start++] = i;
                }
            }
            
            // �θ� ��� 2���� ������ ��
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
        } // End Outter For��
        
        return answer;
    }

    public int find(int v, int[] parent) {
        if(parent[v] == v){
            return v;
        }
        return find(parent[v], parent);
    }

    // �θ� ������ Ʈ���� ����
    public void union(int v1, int v2, int[] parent) {
        int p2 = find(v2, parent);
        parent[p2] = v1;// �������� �θ��� �θ� ���� ������ ��ü��Ŵ 
    }
}