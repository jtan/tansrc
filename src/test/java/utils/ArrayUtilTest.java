package utils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author jtan
 * @version 8/8/13
 */

public class ArrayUtilTest {

    @Test
    public void testMergeSort() {
        int[] intArray = {6, 5, 3, 2, 1, 4};
        ArrayUtil.mergeSort(intArray);

        int[] expectedArray = {1, 2, 3, 4, 5, 6};
        assertEqualsArray(intArray, expectedArray);
    }

    private void assertEqualsArray(int[] a1, int[] a2) {
        assertEquals(a1.length, a2.length);

        for (int i = 0; i < a1.length; i++) {
            assertEquals(a1[i], a2[i]);
        }
    }
}