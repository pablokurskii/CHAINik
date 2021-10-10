package org.chainik.utils;

import org.bouncycastle.util.encoders.Hex;

public class Numeric {
    private static final String HEX_PREFIX = "0x";

    public static String toHexString(byte[] input) {
        final String output = new String(Hex.encode(input));;
        return new StringBuilder(HEX_PREFIX).append(output).toString();
    }

    public static byte asByte(int m, int n) {
        return (byte) ((m << 4) | n);
    }

}
