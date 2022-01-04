package DFS_BFS;

public class ���α׷��ӽ�_�ܾȯlv3 {
	//�ܾ��� �ִ� ���� 50���ۿ� �ȵǱ� ������ DFS�� ����Ͽ� ���ǿ� �����ϴ� ���ڸ�
	//ã�� DFS�� �̿��ϴ� ������ ������ Ǯ����.
	/*
	 * 1. ù �� ° ������ �ѹ��� �� ���� ���ĺ��� �ٲ� �� �ִٰ� �Ͽ� words�� �ִ� �ܾ� ��
	 * ���ǿ� �����ϴ� �ܾã�� �޼��� check�� ����
	 * 2. DFS�� ����Ͽ� �ٲ� �ܾ�� target�ܾ ������ answer ���� ������Ʈ�����ְ�
	 * ����� �ܾ üũ�ϱ� ���� used �迭�� count �Ű������� ����Ͽ� DFS�� ��ͷ� ����
	 */
    int answer;                        //�ּ� �ܰ�
    boolean[] used;                    //�ܾ ��� �������� �Ǵ��ϴ� visited�� ���� ������ �ϴ� �迭
    public int solution(String begin, String target, String[] words) {
        answer = 51;                //�ܾ� �ִ밪�� 50�̹Ƿ�
        used = new boolean[words.length];
        dfs(begin, target, 0, words);
        return answer == 51 ? 0 : answer;    //answer�� 51�̸� target�� ���� �ܾ ���� ������ �Ǵ�.
    }
    
    public void dfs(String presentWord, String target, int count ,String[] words) {
        if(presentWord.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {       //Ž���� ������ �ϳ��� ���̳��� Ž������ ���� ������ �ִٸ�. dfs ����
            if(!used[i] && check(presentWord, words[i])) {
                used[i] = true;
                dfs(words[i],target,count+1, words);
                used[i] = false;
            }
        }
    }
    
    public boolean check(String presentWord, String nextWord) { //������ �ܾ�� ���� �ܾ �ٲ� ���ǿ� ��ġ�ϴ°��� üũ
        int count = 0;
        for(int i = 0; i < presentWord.length(); i++) {
            if(presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}


��ó: https://tosuccess.tistory.com/29 [EI_HJ]