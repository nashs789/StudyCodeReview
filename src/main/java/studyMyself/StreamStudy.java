package studyMyself;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamStudy {
    public static void main(String[] args) {
        // 1. 배열과 리스트를 스트림으로 같이 취급하는 방법

        Integer[] IntegerArray = {3, 2, 1};
        List<Integer> IntegerList = Arrays.asList(IntegerArray);

        // forEach는 최종연산으로 보임 => 이 뒤에는 다른 연산이 안되네
        // 중간 연산은 반환값이 Stream이기 때문에 계속해서 중간연산을 할 수 있다.
        // 최종 연산은 스트림을 소모하기 때문에 연산이 끝나면 연산이 불가능하다. ( 스트림은 일회성으로 소모된다. )
        Arrays.stream(IntegerArray).forEach( (ele) -> System.out.print(ele + " "));
        System.out.println();
        IntegerList.stream().forEach((ele) -> System.out.print(ele + " "));
        System.out.println();

        // 정렬까지 추가된 모습
        Arrays.stream(IntegerArray).sorted().forEach(System.out::print);
        System.out.println();
        IntegerList.stream().sorted().forEach(System.out::print);
        System.out.println();

        // Collection 객체로 다시 돌려 받을 수 있다
        List<Integer> IntegerList2 = Arrays.stream(IntegerArray).sorted().collect(Collectors.toList());
        IntegerList2.stream().sorted().forEach((ele) -> System.out.print(ele + " "));
    }
}
