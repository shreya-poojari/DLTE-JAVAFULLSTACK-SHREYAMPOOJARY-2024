package basics.service;
import java.util.*;
public class map {
    public static void main(String args[])
    {
        // Creating an empty HashMap
        Map<String, Integer> hmap
                = new HashMap<String, Integer>();

        // Inserting pairs in above Map
        // using put() method
        hmap.put("a", new Integer(100));
        hmap.put("b", new Integer(200));
        hmap.put("c", new Integer(300));
        hmap.put("d", new Integer(400));

        // Traversing through Map using for-each loop
        for (Map.Entry<String, Integer> hashmap : hmap.entrySet()) {

            // Printing keys
            System.out.print(hashmap.getKey() + ":");
            System.out.println(hashmap.getValue());
        }
    }

}
