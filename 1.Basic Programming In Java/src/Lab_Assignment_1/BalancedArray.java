package Lab_Assignment_1;

public class BalancedArray {
	public static int balanced(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0 && arr[i] % 2 != 0) {
                return 0;
            } else if (i % 2 != 0 && arr[i] % 2 == 0) {
                
                return 0;
            }
        }
        
        return 1;
}
	public static void main(String[] args) {
    // Example usage
    int[] arr1 = {2, 3, 6, 7};
    int[] arr2 = {2, 4, 6, 8};
    
    int result1 = balanced(arr1); // Should return 1
    int result2 = balanced(arr2); // Should return 0
    
    System.out.println("Result 1: " + result1);
    System.out.println("Result 2: " + result2);
}
}

