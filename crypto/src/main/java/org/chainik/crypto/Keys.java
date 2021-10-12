package org.chainik.crypto;

import java.security.*;
import java.security.KeyPair;
import java.security.spec.ECGenParameterSpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.chainik.utils.*;


public class Keys {

    public static final int PRIVATE_KEY_SIZE = 32;
    public static final int PUBLIC_KEY_SIZE = 64;
    public static final int ADDRESS_SIZE = 160;

    public static final int PUBLIC_KEY_LENGTH_IN_HEX = PUBLIC_KEY_SIZE << 1;
    public static final int ADDRESS_LENGTH_IN_HEX = ADDRESS_SIZE >> 2;


    static {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new BouncyCastleProvider());
        }
    }

    private Keys() {}

    /**
     * Create a keypair using SECP-256k1 curve.
     *
     * Private keypairs are encoded using PKCS8
     *
     * Private keys are encoded using X.509
     */
    static KeyPair createSecp256k1KeyPair(SecureRandom random)
            throws NoSuchProviderException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDSA", "BC");
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256k1");
        if (random != null) {
            keyPairGenerator.initialize(ecGenParameterSpec, random);
        } else {
            keyPairGenerator.initialize(ecGenParameterSpec);
        }
        return keyPairGenerator.generateKeyPair();
    }

    public static ECKeyPair createEcKeyPair()
            throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            NoSuchProviderException {
        return createEcKeyPair(new SecureRandom());
    }

    public static ECKeyPair createEcKeyPair(SecureRandom random)
            throws InvalidAlgorithmParameterException, NoSuchAlgorithmException,
            NoSuchProviderException {
        KeyPair keyPair = createSecp256k1KeyPair(random);
        return ECKeyPair.create(keyPair);
    }

    /**
     * Get a public address for an account by taking the last
     * 20 bytes of the Keccak-256 hash of the public key and adding 0x to the beginning
     * */
    public static String getAddress(String publicKey) {
        String publicKeyNoPrefix = Numeric.cleanHexPrefix(publicKey);

        if (publicKeyNoPrefix.length() < PUBLIC_KEY_LENGTH_IN_HEX) {
            publicKeyNoPrefix =
                    Strings.zeros(PUBLIC_KEY_LENGTH_IN_HEX - publicKeyNoPrefix.length())
                            + publicKeyNoPrefix;
        }
        String hash = Hash.sha3(publicKeyNoPrefix);
        return hash.substring(hash.length() - ADDRESS_LENGTH_IN_HEX);
    }
}
