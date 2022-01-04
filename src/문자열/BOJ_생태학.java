package ���ڿ�;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
 
public class BOJ_������ {
    
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Double> map = new HashMap<String, Double>();    // key : ���� �̸�, value : �ش� ���� ����
        List<String> tree = new ArrayList<String>();                    // ���� �̸� ����
        
        double totalCnt = 0;        // �Է¹��� �� ����
        while (scan.hasNextLine()) {
            String input = scan.nextLine();
            // ó�� ����ִ� ���� ���
            if (map.get(input) == null) {
                map.put(input, 1.0);
                tree.add(input);
            } 
            // ������ �����Ұ�� ���� ����
            else {
                map.put(input, map.get(input) + 1.0);
            }
            
            totalCnt++;
        }
        // ������ ���� (��������)
        Collections.sort(tree);
        
        for (int i = 0; i < tree.size(); i++) {
            double cnt = map.get(tree.get(i));
            System.out.print(tree.get(i) + " ");
            //�Ҽ��� �ڸ� ���� ǥ����
            System.out.printf("%.4f\n", cnt / totalCnt * 100);
        }
        
        scan.close();
        
    }
    
 
}

