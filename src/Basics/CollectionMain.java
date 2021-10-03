package Basics;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

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
        //TreeSet class implements NavigableSet interface, NavigableSet extends SortedSet interface , SortedSet extends Set interface
        Set<Integer>  treeSet = new TreeSet<>();
        Set<Integer>  treeSet2 = new TreeSet<>();
        treeSet.add(10);treeSet.add(1);treeSet.add(12);
        //treeSet.add(null); ==> will throw NullPointerException: TreeSet doesn't accept null values
        System.out.println(treeSet);
        //compare in TreeSet uses compare method

        // ConcurrentSkipListSet class implements NavigableSet interface
        NavigableSet<Integer> nav = new ConcurrentSkipListSet<>();
        // ==> it's thread safe
        nav.add(1);nav.add(10);nav.add(20);nav.add(30);nav.add(50);
        System.out.println(nav.ceiling(25)); //output : 30 ==> the least element greater or equals to the parameter
        System.out.println(nav.floor(25)); //output : 20 ==> the least element less or equals to the parameter
        System.out.println(nav.higher(20)); //output : 30 ==> the least element greater than the parameter
        System.out.println(nav.lower(20)); //output : 10 ==> the least element less  to the parameter


        //LinkedHashset
        Set<Integer> lst = new LinkedHashSet<>();
        //LinkedHashset maintains the elements ordered oh their insertion
        lst.add(1);

        //Map
        System.out.println("                ********************************** MAP ********************************               ");
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");

        Map<Integer,String> sortedMap = new TreeMap<>();
        sortedMap.put(12,"aa");
        sortedMap.put(2,"bb");

        map.putAll(sortedMap);
        map.putIfAbsent(1,"c");
        map.computeIfPresent(2,(i,j)-> {return "map:"+i+j;});
        map.computeIfPresent(3,(i,j)-> {return "map:"+i+"**"+j;}); // will not compute it because key 3 doesn't exist
        map.computeIfAbsent(4, (i)-> {return i+"test";});
        map.computeIfAbsent(1, (i)-> {return i+"test";});// will not compute it because key 1 already exists
        map.forEach((e,t)-> System.out.println(map.get(e)));
        System.out.println(map.entrySet()); // output a set: [1=a, 2=map:2bb, 4=4test, 12=aa]
        System.out.println(map.keySet()); // [1, 2, 4, 12]

        //Iterator



    }
}
