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
}
