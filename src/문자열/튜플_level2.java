package 문자열;
import java.util.*;

public class 튜플_level2 {
	public int[] solution(String s) {
		
		int[] answer = {};
		//trim() 메서드  -> 문자열 앞뒤의 공백을 제거해줌, 문자열 내의 공백은 제거하지 x
		String [] strs = s.replaceAll("[{}]", " ").trim().split(" ,");
        answer = new int[strs.length];
        HashSet<Integer> hs = new HashSet<Integer>(); //중복체크하면서 넣어준다
        Arrays.sort(strs, (a,b)->(a.length()-b.length()));
        int i = 0;
        for(String str : strs){
            for(String st : str.split(",")){
                int a  = Integer.parseInt(st.trim());
                if(hs.contains(a))continue;
                hs.add(a);
                answer[i++] = a;
            }
        }
        return answer;
    }
}
