package s4v.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import s4v.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test on authenticated user info
 */
class AuthenticatedVolunteerInfoTest extends TestData {
    AuthenticatedVolunteerInfo empty;
    AuthenticatedVolunteerInfo full;

    @BeforeEach
    void setUp() {
        empty = new AuthenticatedVolunteerInfo();
        full = new AuthenticatedVolunteerInfo(new VolunteerInfo(NAME), ID);
    }

    /**
     * Check instances are available
     */
    @Test
    void constructor() {
        assertNotNull(empty);
        assertNotNull(full);
    }

    /**
     * Check private key
     */
    @Test
    void getPrivateKey() {
        assertEquals(ID, full.getPrivateKey());
    }
}