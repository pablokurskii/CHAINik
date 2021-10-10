package org.chainik.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.chainik.utils.Numeric.asByte;


public class NumericTest {
    // TODO learn this
    private static final byte[] HEX_RANGE_ARRAY =
            new byte[] {
                    asByte(0x0, 0x1),
                    asByte(0x2, 0x3),
                    asByte(0x4, 0x5),
                    asByte(0x6, 0x7),
                    asByte(0x8, 0x9),
                    asByte(0xa, 0xb),
                    asByte(0xc, 0xd),
                    asByte(0xe, 0xf)
            };

    private static final String HEX_RANGE_STRING = "0x0123456789abcdef";

    @Test
    public void testToHexString() {
        assertEquals(Numeric.toHexString(new byte[] {}), ("0x"));
        assertEquals(Numeric.toHexString(new byte[] {0x1}), ("0x01"));
        assertEquals(Numeric.toHexString(HEX_RANGE_ARRAY), (HEX_RANGE_STRING));
    }
}
