package 매일코딩;

import java.util.Arrays;
import java.util.PriorityQueue;
/*
 * ReadyQueue는 우선순위 큐를 사용하여 실행시간이 짧은 순서대로 정렬해주고
 * 기존의 jobs는 시작시간 순서대로 정렬해준다.
 * 
 * 반복문을 사용하여 현재 시간에서 처리할 수 있는 작업을 모두 q에 넣어주고
 * 짧은 시간 순서대로 처리해줬다. 만약 q가 비어있다면 현재 처리할 수 있는
 * 작업이 없으므로 다음 작업의 시작시간으로 넘어간다.
 * 
 * q가 비어있지 않다면 q에 맨 앞에있는 작업을 꺼내어 실행시킨 후
 * 각 작업의 요청 ~ 종료 시간을 계산해줘야한다. 요청 시간은 작업의 시작시간
 * 과 동일하고, 종료시간은 현재 시간에서 작업이 끝나는 시간을 더해준다. 그리고
 * 종료 시간에서 요청시간을 빼줘서 구한다. 작업이 끝나고 시작시간을
 * 다시 계산햅준다.
 * 
 * 요청 ~ 종료 시간 구하는 방법 예시
 * 문제의 예시중 C를 예를 들면 [2,6]
 * 2는 요청시간을, 6은 실행시간을 의미한다. 그리고 현재 시간은
 * A작업이 끝난 3이된다. 이때 C작업의 요청 ~ 종료 시간은
 * 3(현재시간) + 6(C의 요청시간) - 2(C의 요청시간) = 7이 된다.
 */
public class 프로그래머스_디스크컨트롤러 {
	public int solution(int[][] jobs) {
		 PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]); //처리시간 순서대로
	        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); //시작시간 순서대로 
	        
	        int answer = 0;
	        int end = 0; // 수행되고난 직후의 시간
	        int jobsIdx = 0; // jobs배열의 인덱스
	        int count = 0; // 수행된 요청 갯수
	        
	        // 요청이 모두 수행될 때까지 반복
	        while(count < jobs.length) {
	        	
	        	// 하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청을 큐에 넣음
	        	while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
	        		pq.offer(jobs[jobsIdx++]);
	        	}
	        	
	        	// 큐가 비어있다면 작업 완료(end) 이후에 다시 요청이 들어온다는 의미
	        	// (end를 요청의 가장 처음으로 맞춰줌)
	        	if(pq.isEmpty()) {
	        		end = jobs[jobsIdx][0];
	        		
	        		// 작업이 끝나기 전(end 이전) 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
	        	}else {
	        		int[] temp = pq.poll();
	        		answer += temp[1] + end - temp[0];
	        		end += temp[1];
	        		count++;
	        	}
	        	
	        }
	        
	        
	        return answer / jobs.length;
    }
}
