package utils;
import java.lang.NullPointerException;
import java.util.Arrays;

/**
 * @author jtan
 * @version 8/8/13
 */

public class StringUtil {

    /**
     * Checks to see if all characters in a String are unique (ie. no repeats).  This also assumes that characters are ANSI.
     *
     * @param s
     * @return
     */
    public static boolean hasAllUniqueChars(String s) {
        boolean[] flaggedChars = new boolean[256];

        for (char c : s.toCharArray()) {
            if (flaggedChars[c]) {
                return false;
            } else {
                flaggedChars[c] = true;
            }
        }

        return false;
    }

    /**
     * Checks to see if target String is a permutation of original String.
     *
     * @param original
     * @param target
     * @return
     */
    public static boolean isPermutation(String original, String target) {
        if (original == null || target == null) throw new NullPointerException();

        char[] originalCharArray = original.toCharArray();
        char[] targetCharArray = target.toCharArray();

        Arrays.sort(originalCharArray);
        Arrays.sort(targetCharArray);

        return Arrays.toString(originalCharArray).equals(Arrays.toString(targetCharArray));
    }

    /**
     * Returns a reversed version of String.
     *
     * @param s
     * @return
     */
    public static String reverse(String s) {
        char[] charArray = s.toCharArray();

        int mid = (charArray.length - 1) / 2;
        if (charArray.length % 2 != 0) {
            mid = mid + 1;
        }

        for(int i = 0; i < mid; i++) {
            swapChar(charArray, i, (charArray.length - 1) - i);
        }

        return Arrays.toString(charArray);
    }

    /**
     * Returns a reversed version of String using a recursive algorithm.
     *
     * @param s
     * @return
     */
    public static String reverseUsingRecursion(String s) {
        char[] charArray = s.toCharArray();
        swapCharRecursive(charArray, 0);
        return Arrays.toString(charArray);
    }

    /**
     * Returns a new String the has spaces replaced with the designated characters.
     *
     * @param s
     * @param chars
     * @return
     */
    public static String replaceSpace(String s, String chars) {
        StringBuffer buffer = new StringBuffer();
        char[] charArray = s.toCharArray();

        for (char c: charArray) {
            if (c == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(c);
            }
        }

        return buffer.toString();
    }

    /**
     * Returns a "compressed" version of the string where consecutive chars are replaced with number counts.  For example,
     * "aabbbcccc" would become "a2b3c4".
     *
     * @param s
     * @return
     */
    public static String compress(String s) {
        StringBuffer buffer = new StringBuffer();
        char[] charArray = s.toCharArray();

        int counter = 0;
        char previousChar = charArray[0];

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];

            if (previousChar == currentChar) {
                counter++;
            } else {
                buffer.append(previousChar);
                buffer.append(counter);

                previousChar = currentChar;
                counter = 0;
            }
        }

        return buffer.toString();
    }

    private static void swapCharRecursive(char[] charArray, int index) {
        int mid = (charArray.length - 1) / 2;
        if (charArray.length % 2 != 0) {
            mid = mid + 1;
        }

        if (index < mid) {
            swapChar(charArray, index, (charArray.length - 1) - index);
            swapCharRecursive(charArray, index + 1);
        } else {
            return;
        }
    }

    private static void swapChar(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}