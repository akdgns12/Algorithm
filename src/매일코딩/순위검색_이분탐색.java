package �����ڵ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class �����˻�_�̺�Ž�� {
	import java.util.*;
	// ������ �����ϴ� ��� �� ���� ���� X�� �̻� ���� ����� ����ΰ�?
	// �������� �������ǿ� �´� ������� ���ڸ� ������� �迭�� ��� return

	/*
	Ǯ�� 
	�̺�Ž��
	�Է¹��� �������� ������� ����� �� �� �ִ� ��� ����� ���� ���� �˰����� ����Ͽ� map�� ����ش�.
	�� ����� ���� ���յ� ���ڿ��� key��, ������ value�� �ȴ�
	������ �Ϸ�Ǹ� �̺�Ž���� ���� ������ �������� �����͸� �����ϰ�,
	�̺�Ž���� ���� ������ answer�迭�� ����
	*/
	class Solution {
	    static HashMap<String, ArrayList<Integer>> map;
	    
	    public int[] solution(String[] info, String[] query) {
	        int[] answer = new int[query.length];
	        map = new HashMap<>();
	        
	        for(String str : info){
	            String[] infoArr = str.split(" ");
	            combi("", 0, infoArr);
	        }
	        
	        int queryIdx = 0; 
	        for(String q : query){
	            String str = q.replace(" and ", "");
	            String[] tmp = str.split(" "); // key, value : ���ڿ�, ���� �����ֱ� ���� ���� ���� split 
	            // tmp[0] = ���ڿ�, tmp[1] = ����
	            Collections.sort(map.get(tmp[0])); // �ش� ���ڿ��� �´� key�� ���� ���� ����Ʈ �������� ���� 
	            answer[queryIdx++] = binarySearch(tmp[0], Integer.parseInt(tmp[1]));
	        }
	        
	        return answer;
	    }
	    
	    public static void combi(String str, int depth, String[] arr){
	        if(depth == 4){
	            int score = Integer.parseInt(arr[4]);
	            if(map.containsKey(str)) { // �� �κ� ���ذ� ��
	                // map�� str������ ������
	                // ����Ʈ ������ ���� ����Ʈ�� ���� �߰����� 
	                map.get(str).add(score);
	            }else{
	                ArrayList<Integer> temp = new ArrayList<>();
	                temp.add(score);
	                map.put(str, temp);
	            }
	            return;
	        }
	        
	        combi(str + "-", depth + 1, arr);
	        combi(str + arr[depth], depth + 1, arr);
	    }
	    
	    public static int binarySearch(String query, int score){
	        if(!map.containsKey(query))
	            return 0;
	        ArrayList<Integer> tmpList = map.get(query);
	        int start = 0, end = tmpList.size()-1;
	        
	        while(start <= end){
	            int mid = (start + end) / 2;
	            
	            if(score > tmpList.get(mid))
	                start = mid + 1;
	            else end = mid -1;
	        }
	        return tmpList.size() - start;
	    }
	}
}
