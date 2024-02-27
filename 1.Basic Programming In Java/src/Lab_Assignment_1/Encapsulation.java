package Lab_Assignment_1;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    public int getAge() {
        return age;
    }

    
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be a positive integer.");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        
        Student student = new Student("Bishow", 20);

        
        System.out.println("Student's Name: " + student.getName());
        System.out.println("Student's Age: " + student.getAge());

        student.setName("Binod");
        student.setAge(25);

        System.out.println("Updated Student's Name: " + student.getName());
        System.out.println("Updated Student's Age: " + student.getAge());

        student.setAge(-7); 
        
    }
}
