package basics.service;
import java.util.*;
public class insurance {
    public static void main(String[] args) {
        String[] MetLifeInc = {"sharing risk", "co-operative devices", "good customer service"};
        String[] AflacInc = {"sharing risk", "product quality", "clarity"};
        String[] HumanInc = {"no claim bonus", "value of risk", "sharing risk"};
        int match[] = {0, 0, 0, 0};
        for (int index = 0; index<args.length;index++){
            for (int index1 = 0; index1 < 2; index1++){
                if (args[index].equals(MetLifeInc[index1])){
                    match[0]++;
                }
                if (args[index].equals(AflacInc[index1])){
                    match[1]++;
                }
                if (args[index].equals(HumanInc[index1])){
                    match[2]++;
                }
            }
        }
        int maxValue = Integer.MIN_VALUE,returnIndex = -1;
        for (int index = 0;index<3; index++){
            if (match[index] >= maxValue){
                maxValue = match[index];
                returnIndex = index;
            }
        }
        if (returnIndex == 0){
            System.out.println("MetLifeInc is suggested");
        }else if (returnIndex == 1){
            System.out.println("AflacInc is suggested");
        }else {
            System.out.println("HumanInc is suggested");
        }
    }
}
    /* String userPrompt="";
    Scanner scanner=new Scanner(System.in);
        System.out.println("enter need");
        userPrompt=scanner.nextLine();
        System.out.println("userPrompt");
    if (MetlifeInc.equals(userPrompt));{
            System.out.println("user can have MetlifInc insurance policy");
        }
        if (AflacInc.equals(userPrompt));
        {
            System.out.println("user can have AflacInc insurance policy");
        }
        if (HumanInc.equals(userPrompt));{
            System.out.println("user can have HumanInc insurance policy");
        }
    }
}*/