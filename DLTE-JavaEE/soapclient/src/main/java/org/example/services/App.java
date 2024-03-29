package org.example.services;

import org.example.soappractice.Practice;
import org.example.soappractice.PracticeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      PracticeService service=new PracticeService();
        Practice source=service.getPracticePort();
        String acknowledge = source.addDeafulter("Sinchana");
        System.out.println(acknowledge);
    }
}
