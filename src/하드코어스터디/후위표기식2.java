package 하드코어스터디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2 {
	static int N;
	static double[] num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double[] operand = new double[n]; //숫자 피연산자를 저장
		char[] inputVal = br.readLine().toCharArray(); //후위 표기식을 저장
		Stack<Double> stack = new Stack<>(); //후위 표기식의 알파벳을 통해 도출한 숫자 피연산자를 저장
		for(int i=0; i<n; i++) {
			operand[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<inputVal.length; i++) {
			if(Character.isAlphabetic(inputVal[i])) {//알파벳이라면
				int index = (int)inputVal[i]-65;
				stack.push(operand[index]);
			}else {//연산자라면
				Double result = 0.d;
				Double pop1 = stack.pop();
				Double pop2 = stack.pop();
				if(inputVal[i]=='+') {
					result = pop2 + pop1;
				}
				if(inputVal[i]=='-') {
					result = pop2 - pop1;
				}
				if(inputVal[i]=='*') {
					result = pop2 * pop1;
				}
				if(inputVal[i]=='/') {
					result = pop2 / pop1;
				}
				stack.push(result);
			}
		}
		System.out.format("%.2f", stack.pop());
	}
}
