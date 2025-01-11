package preparing.interview;

import java.util.Arrays;

public class ProductsOfArrayExceptSelf {

  public static void main(String[] args) {
    int[] arr = {-1,0,1,2,3};

    ProductsOfArrayExceptSelf productsOfArrayExceptSelf = new ProductsOfArrayExceptSelf();

    int[] products = productsOfArrayExceptSelf.productExceptSelf(arr);

    System.out.println(Arrays.toString(products));
  }

  public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      int count = 1;

      for(int j = 0; j < nums.length; j++) {
        if(i != j) {
          count *= nums[j];
        }
      }

      output[i] = count;
    }

    return output;
  }

}
