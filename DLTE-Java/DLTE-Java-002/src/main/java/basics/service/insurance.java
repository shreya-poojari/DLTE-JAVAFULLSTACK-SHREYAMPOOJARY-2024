package basics.service;
import java.util.*;
public class insurance {
    public static void main(String[] args){
    String[] MetlifeInc ={"sharing risk","co-operative devices","good customer service"};
    String[] AflacInc ={"sharing risk","product quality","clarity"};
    String[] HumanInc ={"no claim bonus","value of risk","sharing risk"};
    String userPrompt="";
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
}
