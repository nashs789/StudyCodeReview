import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class arrayStreamTest {
    public static void main(String[] args) {

    }

    // Arrays.stream().allMatch
    public static boolean isEvenNumberArray(int[] arr){
        return Arrays.stream(arr).allMatch(element -> element % 2 == 0);
    }

    // Arrays.stream().noneMatch
    public static boolean hasNotAnyZero(int[] arr){
        return Arrays.stream(arr).noneMatch(element -> element == 0);
    }

    // Arrays.stream().anyMatch
    public static boolean hasAnyMultipleOfTen(int[] arr){
        return Arrays.stream(arr).anyMatch(element -> element % 10 == 0);
    }

    // Intstream.range()
    public static boolean isSortedArray(int[] arr){
        return IntStream.range(0, arr.length - 1).allMatch(idx -> arr[idx] < arr[idx + 1]);
    }

    // merge Array
    public static Integer[] combineTwoArray(int[] arr1, int[] arr2){
        Integer[] newArray1 = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Integer[] newArray2 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);

        Integer[] newArray = Stream.of(newArray1, newArray2).flatMap(Stream::of).toArray(Integer[]::new);

        System.out.println("Arrays.toString(newArray) = " + Arrays.toString(newArray));

        return newArray;
    }
}
