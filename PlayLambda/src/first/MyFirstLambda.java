package first;

public class MyFirstLambda {
	
	public static void main(String[] args) {
		
		MyFirstLambda m = new MyFirstLambda();

		m.notLambda();
		m.lambda();
	}
	
	private void notLambda() {
		MyInterface mi = new MyInterface() {
			@Override
			public void greet(String str) {
				System.out.println("hello " + str);
			}
		};
		mi.greet("not Lamdba...");
	}

	
	private void lambda() {
		MyInterface mi = str -> System.out.println("hello " + str);
		mi.greet("Lamdba!!");
	}
}
