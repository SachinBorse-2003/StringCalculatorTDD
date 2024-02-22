import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static String add(String numbers) {
        if(numbers.isEmpty()) {
            return "0";
        }
        if(numbers.contains(",\n")){
            return "Number expected but '\\n' found at position " + numbers.indexOf(",\n");
        }
        if(numbers.contains("\n,")){
            return "Number expected but '\\n' found at position " + numbers.indexOf("\n,");
        }


        if(numbers.endsWith(",")){
            return "Number expected but EOF found.";
        }
        String[] arrOfStr = numbers.split("[,\n]+");
        if(arrOfStr.length==1){
            return numbers;
        }

        int sum=0;
        List<String> negativeNumbers = new ArrayList<>();
        for (String s : arrOfStr) {
            if(s.contains("-"))
            {
                negativeNumbers.add(s);
            }

            sum += Integer.parseInt(s);
        }
        if(!negativeNumbers.isEmpty()){
            return  "Negative not allowed : "+String.join(", ",negativeNumbers);
        }
        return Integer.toString(sum);
    }
}
