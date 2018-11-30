/////  Assignment Question 3 //////////


/*
 * methods declared public in superclass must be public in subclasses
 * methods declared protected in superclass must be protected or public in subclasses
 */
public class Class_B extends Class_A{
	public  void TearDown(){
		System.out.println("this is a tear down method in Class B");
	}
	
	public void Hello() {
		System.out.println("Class B");
	}

	public static void main(String[] args) {
	
Class_A obj = new Class_A();
obj.TearDown();
obj.Hello();

Class_B obj1= new Class_B();
obj1.TearDown();
obj1.Hello();


	}

}
