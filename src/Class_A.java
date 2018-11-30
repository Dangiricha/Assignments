/////  Assignment Question 3 //////////



/*
 * methods declared public in superclass must be public in subclasses
 * methods declared protected in superclass must be protected or public in subclasses
 */


public class Class_A {

	public void Setup(){
		System.out.println("this is a set up method");
		
	}
	public  void TearDown(){
		System.out.println("this is a tear down method in Class A");
	}
	
	protected void Hello() {
		System.out.println("Class A");
	}
}
