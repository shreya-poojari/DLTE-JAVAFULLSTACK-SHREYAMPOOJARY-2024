package basics.service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class regularExpressions {
    public static void main(String[] args) {
        String mobileExpression = "\\d{10}";
        Pattern pattern = Pattern.compile(mobileExpression);
        Matcher matcher = pattern.matcher(args[0]);
        if (matcher.matches()) {
            System.out.println("valid mobile number");
        } else {
            System.out.println("In-valid mobile number");
        }
    }


    }