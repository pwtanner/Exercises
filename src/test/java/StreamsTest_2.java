import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class StreamsTest_2 {

    public static void main(String[] args) {

        List<String> names_1 = Arrays.asList("Don","Alexandra","Adam","Rama","Abhijeet");

        List<String> names_2 = Arrays.asList("Sharon","Trevor","Susan","Aaron","Jen");

        names_1.stream().filter(s->s.endsWith("a")).forEach(s->System.out.println(s.toUpperCase(Locale.ROOT)));

        System.out.println();

        names_1.stream().filter(s->s.endsWith("a")).map(s->s.toUpperCase(Locale.ROOT)).forEach(s->System.out.println(s));

        System.out.println();

        names_1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase(Locale.ROOT)).forEach(s->System.out.println(s));

        System.out.println();

        Stream names_3 = Stream.concat(names_1.stream(), names_2.stream());

        names_3.sorted().forEach(s->System.out.println(s));


    }

}
