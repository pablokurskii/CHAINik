package org.chainik.crypto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashTest {

    @Test
    public void testSha3String() {
        assertEquals(
                Hash.sha3String("hello world"),
                ("0x47173285a8d7341e5e972fc677286384f802f8ef42a5ec5f03bbfa254cb01fad"));

        assertEquals(
                Hash.sha3String("EVWithdraw(address,uint256,bytes32)"),
                ("0x953d0c27f84a9649b0e121099ffa9aeb7ed83e65eaed41d3627f895790c72d41"));
    }
}

