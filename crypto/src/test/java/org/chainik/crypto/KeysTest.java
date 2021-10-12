package org.chainik.crypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class KeysTest {

    @Test
    public void testCreateEcKeyPair() throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();

        assertNotNull(ecKeyPair);

        assertEquals(ecKeyPair.getPublicKey().signum(), (1));
        assertEquals(ecKeyPair.getPrivateKey().signum(), (1));
    }

    @Test
    public void testGetAddressString() {
        assertEquals(Keys.getAddress(MockKeys.PUBLIC_KEY_STRING), (MockKeys.ADDRESS_NO_PREFIX));
    }

    // TODO implement test cases from https://github.com/ethereum/EIPs/blob/master/EIPS/eip-55.md#test-cases

}
