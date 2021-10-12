package org.chainik.crypto;

import org.chainik.utils.Numeric;

/**
 * Keys generated for unit testing purposes.
 */
//TODO fulfill TBD
public class MockKeys {
    public static final String PRIVATE_KEY_STRING = "0x6c6c08656fb5254c1f68d9118312922cdf69d8d3036cc7adefb925e285ddf243";
    public static final String PUBLIC_KEY_STRING =
            "0x0091bb1e4fd82dc6fe7b7c372fd33288a65644fe0ead99d268827cbd8cf559ced2c5650803b63c0fa702fd303b76af68b810ef37cc75d50cb28ac47700eadd7bbf";
    public static final String ADDRESS = "0xf0bf1e22df1f59b7369998218d1bb2327e5bf38a";
    public static final String ADDRESS_NO_PREFIX = Numeric.cleanHexPrefix(ADDRESS);
}
