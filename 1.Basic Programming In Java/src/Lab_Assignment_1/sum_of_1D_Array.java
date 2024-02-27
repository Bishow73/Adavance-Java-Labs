package Lab_Assignment_1;

public class sum_of_1D_Array {
	public static int sum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;

    }
    public static void main(String[] args){
        int[] array = {1, 7, 3, 4, 2, 6};
        System.out.println("The sum Of array is  " +sum_of_1D_Array.sum(array));
    }
}
