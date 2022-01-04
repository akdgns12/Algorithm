package 알고리즘;

public class 투포인터_연속된배열의처리 {
/*
 * 선형 시간에 해결할 수 있다 -> O(N)의 시간복잡도
 * 
 * 1.투 포인터
 * 2.구간 합
 * 3.슬라이딩 윈도우 프로토콜
 * 
 * ex 1)
 * N개의 자연수로 구성된 수열이 있습니다.
 * 합이 M인 부분 연속 수열의 개수를 구해보세요.
 * 시간제한 O(N)
 * 
 * <문제 해결 방법>
 * 투 포인터 방법 : 리스트에 순차적으로 접근해야 할 때 두개의 점을 이용해 위치를 기록하면서 처리하는 기법
 * 1. 시작점(start)와 끝점(end)이 첫번째 인덱스를 가리키도록 한다.
 * 2. 현재 부분 합이 M과 같다면, 카운트한다.
 * 3. 현재 부분 합이 M보다 작거나 같다면, end를 1증가 시킨다.
 * 4. 현재 부분 합이 M보다 크다면, start를 1증가시킨다.
 * 5. 모든 경우를 확인할 때까지 2번부터 4번까지의 과정을 반복한다.
 *	
 * -배열에서의 연속된 위치에서의 어떤 구간합이나 구간에 대한 정보를 처리하기 위해서
 * 사용할 수 있는 기법 (투 포인터)
 * 
 * ex 2)
 * 구간 합 빠르게 계산하기
 * 아래와 같이 N개의 정수로 구성된 수열이 있습니다.
 * M개의 쿼리 정보가 주어집니다.
 *  - 각 쿼리는 L과 R로 구성됩니다
 *  - [L,R] 구간에 해당하는 데이터들의 합을 모두 구하는 문제입니다.
 *  시간 제한 : O(N+M)
 *  
 *  <문제 해결 방법>
 *  접두사 합(Prefix Sum)
 *  1. prefix sum을 계산하여 배열 P에 저장한다.
 *  2. 매 M개의 쿼리정보를 확인할 때, 구간합은 P[R] - P[L-1]이다.
 *  
 *  
 *  슬라이딩 윈도우 프로토콜
 *  
 *  - 앞에서부터 순섣로 보석들을 고르다가 중복된 보석이 나오면 시작 인덱스를 
 *  하나씩 밀어주는 방식
 */
}
