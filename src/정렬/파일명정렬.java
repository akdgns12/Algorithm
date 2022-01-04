import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        
        // ���ǿ� ���� ������ �ϱ� ���� Comparator ����
        // compare ���ϰ��� ����� �� ��ü�� �ڸ��� �ٲ���
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                // ���� �պκ��� �߶� head ����
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                // compareTo�� ����� �񱳸� ���ؼ��� �ҹ��ڷ� ���� �� ��
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                
                if(result == 0){ // ���� ������ ��� ���ڷ� ��
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                }
                
                return result;
            }
        });
        
        return files;
    }
    
    public int convertNum(String str, String head){
        str = str.substring(head.length()); // head ���̸�ŭ �߶� ���ں��� �����ϰ� ����
        String result = "";
        for(char c : str.toCharArray()){
            if(Character.isDigit(c) && result.length() < 5) // �������� �׸��� result ���̰� 5�ȳѴ��� Ȯ��
                result += c;
            else
                break;
        }
        return Integer.valueOf(result);
    }
}