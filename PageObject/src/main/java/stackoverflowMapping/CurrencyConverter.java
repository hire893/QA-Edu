package stackoverflowMapping;

import java.util.Arrays;
import java.util.List;

public class CurrencyConverter {


    private static String value;

    public static double euroToDollar(String value){
        CurrencyConverter.value = value;
        double salary = 0;
        if(value.contains("-")){
            List<String> s1;
            s1 = Arrays.asList(value.split("k"));
            salary = Double.parseDouble(s1.get(0).replace("€",""));
        }
        return salary*1.18;
    }

    public static double funtToDollar(String value){
        CurrencyConverter.value = value;
        double salary = 0;
        if(value.contains("-")){
            List<String> s2;
            s2 = Arrays.asList(value.split("k"));
            salary = Double.parseDouble(s2.get(0).replace("£",""));
        }
        return salary*1.3;
    }

    public static double dollarToDollar(String value){
        CurrencyConverter.value = value;
        double salary = 0;
        if(value.contains("-")){
            List<String> s3;
            s3 = Arrays.asList(value.split("k"));
            salary = Double.parseDouble(s3.get(0).replace("$",""));
        }
        return salary;
    }

}
