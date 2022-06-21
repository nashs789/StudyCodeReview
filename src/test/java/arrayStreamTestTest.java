import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class arrayStreamTestTest {
    private int[][] arrs1 = {{2, 4, 6, 8, 10}, {46, 100, 14, 36, 92}, {90, 58, 44, 26,84}};
    private int[][] arrs2 = {{2, 4, 6, 8, 10}, {14,36, 46, 92, 100}, {26, 44, 58 ,84, 90}};

    @Test
    void 배열합치기() {
        for(int[] arr1 : arrs1){
            for(int[] arr2 : arrs2){
                arrayStreamTest.combineTwoArray(arr1, arr2);
            }
        }
    }

    @Test
    void 짝수테스트() {
        for(int[] arr : arrs1){
            assertTrue(arrayStreamTest.isEvenNumberArray(arr));
        }
    }

    @Test
    void 십의배수테스트() {
        for(int[] arr : arrs1){
            assertTrue(arrayStreamTest.hasAnyMultipleOfTen(arr));
        }
    }

    @Test
    void 제로테스트() {
        for(int[] arr : arrs1){
            assertTrue(arrayStreamTest.hasNotAnyZero(arr));
        }
    }

    @Test
    void 정렬테스트() {
        for(int[] arr : arrs2){
            assertTrue(arrayStreamTest.isSortedArray(arr));
        }
    }
}