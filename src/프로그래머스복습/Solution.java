package 프로그래머스복습;

import java.util.*;
class Solution{
public int solution(int money, int minratio, int maxration, int ranksize, int threshold, int months) {
	int answer = -1;
	
	int temp = 0;
	
	for(int i=months; i>0; i--) {
		money = (money/100)*100;
		if(money < threshold) continue;
		
		
		if(money >= threshold && money <= (threshold + ranksize - 1) ) {
			money -= money * (0.01);
		}
			break;
	}
	
	return money;	
}
}