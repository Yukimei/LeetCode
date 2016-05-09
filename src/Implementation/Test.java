package Implementation;

public class Test {
	public static Object o = null;
	public static void main() {
		Test.o = new Object(1);
		
	}
	protected void ab() {
		System.out.println(" ");
	}
}

class Object {
	int j;
	public Object(int j) {
		this.j = j;
	}
}