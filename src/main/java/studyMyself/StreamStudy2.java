package studyMyself;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy2 {
    public static void main(String[] args) {
        String[] stringArray = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "aa"};

        Stream<String> stream1 = Stream.of(stringArray);
        Stream<String> stream2 = Arrays.stream(stringArray);

        List<String> list1 = Stream.of(stringArray).sorted().collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        list1 = Stream.of(stringArray).sorted().distinct().collect(Collectors.toList());
        System.out.println("list1 = " + list1);

        stream1.filter( (ele) -> ele.equals("aa")).collect(Collectors.toList()).forEach(System.out::println);
        list1 = stream2.filter( (ele) -> ele.equals("aa")).collect(Collectors.toList()); // stream1은 이미 닫혀서 사용하면 에러남
        System.out.println("list1 = " + list1);

        Stream.of(stringArray).limit(5).forEach(System.out::println);
        long count = Stream.of(stringArray).count();
        System.out.println("count = " + count);


        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        list.stream().forEach(System.out::println);
    }
}
