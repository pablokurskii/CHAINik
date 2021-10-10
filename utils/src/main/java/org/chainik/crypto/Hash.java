package org.chainik.crypto;

import java.nio.charset.StandardCharsets;
import org.bouncycastle.jcajce.provider.digest.Keccak;

import org.chainik.utils.Numeric;

/** Cryptographic hash functions. */
public class Hash {
    private Hash() {}

    /**
     * Keccak-256 hash function.
     *
     * @param input binary encoded input data
     * @return hash value
     */
    public static byte[] sha3(byte[] input) {
        Keccak.Digest256 digest256 = new Keccak.Digest256();
        return digest256.digest(input);
    }

    /**
     * Keccak-256 hash function that operates on a UTF-8 encoded String.
     *
     * @param utf8String UTF-8 encoded string
     * @return hash value as hex encoded string
     */
    public static String sha3String(String utf8String) {
        return Numeric.toHexString(sha3(utf8String.getBytes(StandardCharsets.UTF_8)));
    }
}
