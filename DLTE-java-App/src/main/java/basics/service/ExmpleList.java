package basics.service;
import java.util.*;
import java.util.Collections;
public class ExmpleList {
        public static void main(String[] args)
        {
            // Creating an object
            List<Integer> list1 = new ArrayList<Integer>();
            list1.add(0, 1);
            list1.add(1, 2);
            System.out.println(list1);

            //creating another object of the List
            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(1);
            list2.add(3);
            list2.add(2);

            //  add list l2 from 1 index
            list1.addAll(1, list2);
            System.out.println(list1);

            // Removes element from index 1
            list1.remove(1);
            System.out.println(list1);

            // Prints element at index 3 in list 1
            System.out.println(list1.get(3));

            // Replace 0th element with 5
            list1.set(0, 5);
            System.out.println(list1);

            Collections.sort(list2);
            System.out.println(list2);
        }
    }

