import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsTest_3 {

    public static void main(String[] args) {

        List<String> names_1 = Arrays.asList("Don","Alexandra","Adam","Rama","Abhijeet");

        List<String> names_2 = Arrays.asList("Sharon","Trevor","Susan","Aaron","Jen");

        Stream names_3 = Stream.concat(names_1.stream(), names_2.stream());

        boolean flag = names_3.anyMatch(s->s.equals("Adam"));

        System.out.println(flag);

        Assert.assertTrue(flag);


    }

}
