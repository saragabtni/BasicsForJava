package BasicArrays;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Arrays declaration & instantiation
        int[] firstArray = new int[]{20,30,40,30,60,20,20};
        int[] secondArray = new int[]{20,30,40,50};
        //we can't add new element to the arrays, if we want we use an other array , fill it and return the new array

        //Compare Method
        int i = Arrays.compare(firstArray,secondArray);
        System.out.println("result: "+i);
        int j = Arrays.compare(firstArray,0,6,secondArray,0,3);
        System.out.println("result: "+j);
        int k = Arrays.compare(secondArray,0,3,firstArray,0,6);
        System.out.println("result: "+k);

        //Binary search
        //the array must be sorted before applying binary search
        //if the array is not sorted we will get undefined result
        Arrays.sort(firstArray);
        int kk= Arrays.binarySearch(firstArray,40);
        System.out.println("result: "+kk); //output: 5
        int yy= Arrays.binarySearch(firstArray,0,6,40);
        System.out.println("result: "+yy); //output: 5

        //asList method
        //fixed size, we cannot add elements
        //but we can update values
        List<int[]> arr = Arrays.asList(firstArray);
        arr.set(0,new int[]{3});
        System.out.println(arr.get(0)[0]); //output: 3
        //the original array is not modified
        System.out.println(firstArray[0]); //output : 20

        //fill
        int[] thirdArray = new int[10];
        Arrays.fill(thirdArray,20);
        for (int ir : thirdArray){
            System.out.println(ir);
        } //output : array filled with the value 20 (10times)

        //mismatch
        //return the index of the element in which the 2 arrays are different
        System.out.println(Arrays.mismatch(firstArray,secondArray));
        
        //deepEquals vs equals


    }
}
