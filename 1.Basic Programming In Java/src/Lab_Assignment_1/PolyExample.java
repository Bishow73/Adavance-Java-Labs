package Lab_Assignment_1;
class Example1 implements Message { 
	   String name;
	   public void method(String name) { 
	      System.out.println("Hello " + name);
	   }
	}
	class Example2 implements Message {
	   String name;
	   public void method(String name) { 
	      System.out.println("Hello " + name);
	   }
	}
	public class PolyExample {
	   public static void main(String []args){
	      Message msg;
	      msg = new Example1();
	      msg.method("Bishow Khatri"); 
	      msg = new Example2();
	      msg.method("Bipin Paudel"); 
	   }
	}

