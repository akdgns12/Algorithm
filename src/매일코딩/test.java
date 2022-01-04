package 매일코딩;

public class test {
	int value;
	
	test(int value){
		this.value = value;
	}
	
	private static void swap(test a, test b) {
		int temp = a.value;
		a.value = b.value;
		b.value = temp;
	}
	
	public static void main(String[] args) {
		test a = new test(1);
		test b = new test(2);
		
		System.out.println("a=> " + a.value);
		System.out.println("b=> " + b.value);
		
		swap(a,b);
		
		System.out.println("----------swap 후---------");
		 
		System.out.println("a=> " + a.value);
		System.out.println("b=> " + b.value);
	}
}
