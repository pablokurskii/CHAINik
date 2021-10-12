package org.chainik.sample;

import org.chainik.crypto.*;
import org.chainik.utils.Numeric;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Main {

    public static void main(String[] args) {
        // TODO learn this
        String hash = Hash.sha3String("hello world");
        System.out.println(hash);

        try {
            /*
             * STEP 1: GET KEY PAIR
             * */
            //Generate Elliptic Curve Digital Signature Algorithm key pair with secp256k1
            ECKeyPair ecKeyPair = Keys.createEcKeyPair();

            //Generated Private Key with 64 HEX || 32 bytes
            String ECPrivateKey = Numeric.toHexString(ecKeyPair.getPrivateKey().toByteArray());
            System.out.println("Private Key: " + ECPrivateKey);

            //Generated Private Key with 128 bit || 64 bytes
            String ECPublicKey = Numeric.toHexString(ecKeyPair.getPublicKey().toByteArray());
            System.out.println("Public Key: " + ECPublicKey);

            /*
             * STEP 2: GET ADDRESS
             * */

            String ECAddress = Keys.getAddress(ECPublicKey);
            System.out.println("Address: " + ECAddress);

            /*
             * STEP 3: GET SIGN
             * */

        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }


    }

}
