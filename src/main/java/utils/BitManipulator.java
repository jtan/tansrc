package utils;

/**
 * @author jtan
 * @version 8/8/13
 */

public class BitManipulator {

    public BitManipulator() {}

    public static int getBit(int num, int index) {
        return (num >> index) & 1;
    }

    public static int setBit(int num, int index) {
        return  num | (1 << index);
    }

    public static int clearBit(int num, int index) {
        return num & ~(1 << index);
    }

    public static int clearBitsMSBThruIndex(int num, int index) {
        return num & ((1 << index) - 1);
    }

    public static int clearBitsLSBThruIndex(int num, int index) {
        return num & (~(1 << index) - 1);
    }

    public static int updateBit(int num, int index, int value) {
        int numWithBitCleared = clearBit(num, index);
        return numWithBitCleared | (value << index);
    }

    public static int insertTargetBits(int original, int target, int indexStart, int indexEnd) {
        // clear bits between indexes
        for (int i = indexStart; i <= indexEnd; i++) {
            clearBit(original, i);
        }

        return original | (target << indexStart);
    }
}