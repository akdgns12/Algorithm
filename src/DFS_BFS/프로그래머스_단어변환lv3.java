package DFS_BFS;

public class 프로그래머스_단어변환lv3 {
	//단어의 최대 수가 50개밖에 안되기 때문에 DFS를 사용하여 조건에 부합하는 문자를
	//찾아 DFS를 이용하는 식으로 문제를 풀었다.
	/*
	 * 1. 첫 번 째 조건인 한번에 한 개의 알파벳만 바꿀 수 있다고 하여 words에 있는 단어 중
	 * 조건에 부합하는 단어를찾는 메서드 check를 만듦
	 * 2. DFS를 사용하여 바뀐 단어와 target단어가 같으면 answer 값을 업데이트시켜주고
	 * 사용한 단어를 체크하기 위한 used 배열과 count 매개변수를 사용하여 DFS를 재귀로 구현
	 */
    int answer;                        //최소 단계
    boolean[] used;                    //단어를 사용 중인지를 판단하는 visited와 같은 역할을 하는 배열
    public int solution(String begin, String target, String[] words) {
        answer = 51;                //단어 최대값이 50이므로
        used = new boolean[words.length];
        dfs(begin, target, 0, words);
        return answer == 51 ? 0 : answer;    //answer이 51이면 target과 같은 단어가 없는 것으로 판단.
    }
    
    public void dfs(String presentWord, String target, int count ,String[] words) {
        if(presentWord.equals(target)) {
            answer = (answer > count) ? count : answer;
            return;
        }
        
        for(int i = 0; i < words.length; i++) {       //탐색한 글자중 하나만 차이나고 탐색되지 않은 글자이 있다면. dfs 수행
            if(!used[i] && check(presentWord, words[i])) {
                used[i] = true;
                dfs(words[i],target,count+1, words);
                used[i] = false;
            }
        }
    }
    
    public boolean check(String presentWord, String nextWord) { //현재의 단어와 다음 단어가 바뀔 조건에 일치하는가를 체크
        int count = 0;
        for(int i = 0; i < presentWord.length(); i++) {
            if(presentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        return count == 1 ? true : false;
    }
}


출처: https://tosuccess.tistory.com/29 [EI_HJ]