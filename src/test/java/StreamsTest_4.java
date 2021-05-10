import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest_4 {

    public static void main(String[] args) {

        List<String> ls = Stream.of("Don","Alexandra","Adam","Rama","Abhijeet","Sharon","Trevor","Susan","Aaron","Jen").filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());

        System.out.println(ls.get(0));

        System.out.println();

        List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
        // distinct values only
        // sort the array
        // print the third item in the resulting list
        List<Integer> li = values.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(li.get(2));

    }

}
