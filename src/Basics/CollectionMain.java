package Basics;

import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {

        //ArraysList
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.forEach(e-> System.out.println(e)); //output:  1 2 3
        list.set(0,10);
        list.forEach(e-> System.out.println(e)); // output 10 2 3

        //HashSet ==> no specified order
        Set<Integer> set = new HashSet<>();//set doesn't accept duplicate values
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set.add(1);set.add(5);set.add(4);
        System.out.println(set.add(14)); //will print true ==> 14 will be added
        System.out.println(set.add(1)); //will print false ==> 1 will not be added because it already exists
        set.add(null); //Hashset accept null values
        System.out.println(set);
        //compare in hashset uses equals method


        //TreeSet ==> sorted order
        Set<Integer>  treeSet = new TreeSet<>();
        Set<Integer>  treeSet2 = new TreeSet<>();
        treeSet.add(10);treeSet.add(1);treeSet.add(12);
        //treeSet.add(null); ==> will throw NullPointerException: TreeSet doesn't accept null values
        System.out.println(treeSet);
        //compare in treeset uses compare method

        //SortedSet

        //LinkedHashset

        //NavigableSet

    }
}
