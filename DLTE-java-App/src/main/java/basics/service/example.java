package basics.service;

import java.util.*;

public class example {
        public static void main(String args[]) {
            // empty LinkedList
            Collection<String> list = new LinkedList<String>();
            // add elements in the list
            list.add("welcome");
            list.add("to");
            list.add("MY");
            System.out.println("The list is: " + list);
            // Adding new element
            list.add("Bank");
            // new list
            System.out.println("The new List is: " + list);
        }
    }

