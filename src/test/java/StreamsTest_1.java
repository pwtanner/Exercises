import java.util.ArrayList;

public class StreamsTest_1 {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alexander");
        names.add("Adam");
        names.add("Raul");

        System.out.println("The number of names that start with A is: " + names.stream().filter(s->s.startsWith("A")).count());

        names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));

        System.out.println();

        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));

    }

}
