
package lab1;

public class Class1 extends class2 implements int1{
	public Class1()
	{
		super();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class1 obj1 = new Class1();
		int k = obj1.M1(10, 20);
		System.out.println(k);
		Class1 obj2 = new Class1();
		Class1 obj3 = obj1;
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
	}
	
	@Override
	public int M1(int i, int j)
	{
		return i+j;
	}

}
