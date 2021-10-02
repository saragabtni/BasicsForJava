package Basics;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

/**
 * Explore some Arrays methods
 * Java 11
 */
public class ArraysMain {

    public static void main(String[] args) {
        //Arrays declaration & instantiation
        //we can't add new element to the arrays, if we want we use an other array , fill it and return the new array
        int[] firstArray = new int[]{20,30,40,30,60,20,20};
        int[] secondArray = new int[]{20,30,40,50};

        //Compare Method
        int i = Arrays.compare(firstArray,secondArray);
        System.out.println("result: "+i);
        int j = Arrays.compare(firstArray,0,6,secondArray,0,3);
        System.out.println("result: "+j);
        int k = Arrays.compare(secondArray,0,3,firstArray,0,6);
        System.out.println("result: "+k);

        //BinarySearch method
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

        //fill method
        int[] thirdArray = new int[10];
        Arrays.fill(thirdArray,20);
        for (int ir : thirdArray){
            System.out.println(ir);
        } //output : array filled with the value 20 (10times)

        //mismatch method
        //return the index of the element in which the 2 arrays are different
        System.out.println(Arrays.mismatch(firstArray,secondArray));

        //deepEquals vs equals methods
        Object[] obj1 = new Object[]{"30",new String[]{"one"}};
        Object[] obj2 = new Object[]{"30",new String[]{"one"}};
        System.out.println(Arrays.equals(obj1,obj2)); //false
        System.out.println(Arrays.deepEquals(obj1,obj2)); //true
        System.out.println(obj1.equals(obj2)); //false

        //parallelPrefix method
        int[] fourthArray = new int[]{20,30,40,50};
        IntBinaryOperator op = (i1, i2) -> i1 +i2; // i1,i2 are values from the array
        Arrays.parallelPrefix(fourthArray, op);
        Arrays.stream(fourthArray).sequential().forEach(e->{
            System.out.println("element: " + e);
        });//output: 20 50 90 140

      //  BinaryOperator<Integer> op2 = (i1, i2) -> i1 + 10;
      //  Arrays.parallelPrefix(fourthArray, (IntBinaryOperator) op2); // => classCastException

        // parallelSetAll method
        int[] fifthArray = new int[]{1,2,3,4};
        IntUnaryOperator uop = (o) -> {return o;}; //o is the index of each value in the array
        Arrays.parallelSetAll(fifthArray,uop);
        Arrays.stream(fifthArray).forEach(r->{
            System.out.println("elem: "+r);//output:  0 1 2 3
        });

        //setAll method
        IntUnaryOperator uop2 = (o) -> {return 20+o;}; //o is the index of each value in the array
        Arrays.setAll(fifthArray,uop2);
        Arrays.stream(fifthArray).forEach(r->{
            System.out.println("elem: "+r);//output: 20 21 22 23
        });

        //spliterator
        Spliterator.OfInt b = Arrays.spliterator(fifthArray);
        IntConsumer consumer = e -> System.out.println("res: "+e);
        b.forEachRemaining(consumer);

        // Multidimensional arrays
        String [][] multiString = new String[3][2];
        multiString[0] = new String[]{"a","b"};
        multiString[1] = new String[]{"aa","bb"};
        multiString[2] = new String[]{"aaa","bbb"};
        Arrays.stream(multiString).forEach(e-> System.out.println(e[0]+","+e[1]));

        int[][] multiInt = {{1,2},{3,4},{5,6}};
        Arrays.stream(multiInt).forEach(e-> System.out.println(e[0]+","+e[1]));

        int[][] other = new int[3][];
        other[0] = new int[2];
        other[0] = new int[5];
        other[0] = new int[1];




    }
}
