package s4v.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import s4v.TestData;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ActivityInfoTest extends TestData {

    ActivityInfo empty;
    ActivityInfo full;

    @BeforeEach
    void setUp() throws SpotsForVolunteeringException {
        empty = new ActivityInfo();
        full = new ActivityInfo(ID, ACTIVITY_NAME, START, END);
    }

    /**
     * Throws asn exception if end date is before start date
     */
    @Test
    void constructor_exception() {
        assertThrows(SpotsForVolunteeringException.class,
                () -> new ActivityInfo(ID, ACTIVITY_NAME, END, START),
                "start and end dates are reversed");
    }


    /**
     * IDs should be {@code null} on newly created instances
     */
    @Test
    void getId() {
        assertNull( empty.getId() );
        assertNull( full.getId() );
    }

    /**
     * IDs ca be changed using the respective setter.
     * Assigned IDs cannot be changed after being assigned
     */
    @Test
    void setId() {

        for(ActivityInfo info: Arrays.asList(empty,full)) {
            info.setId(ID);

            assertEquals(ID,info.getId());

            info.setId("");

            assertEquals(ID,info.getId(),"ID cannot be changed after assigned");
        }
    }

    /**
     * Check owner id set by constructor
     */
    @Test
    void getOwnerId() {
        assertNull( empty.getOwnerId() );

        assertEquals( ID , full.getOwnerId() );
    }

    /**
     * Check names assigned by constructors.
     */
    @Test
    void getName() {
        assertNull( empty.getName() );

        assertEquals(ACTIVITY_NAME, full.getName());
    }

    /**
     * Names can be changed with setter
     */
    @ParameterizedTest
    @MethodSource("activityNameStream")
    void setName(String name) {
        empty.setName(name);

        assertEquals(name, empty.getName());
    }


    /**
     * Check start dates assigned by constructors
     */
    @Test
    void getStart() {

        assertNull( empty.getStart() );

        assertEquals( START , full.getStart() );
    }

    /**
     * Start dates can be changed using setter.
     */
    @Test
    void setStart() {
        empty.setStart( START );

        assertEquals( START , empty.getStart() );
    }

    /**
     * Check end dates assigned by constructors
     */
    @Test
    void getEnd() {

        assertNull( empty.getEnd() );

        assertEquals( END , full.getEnd() );
    }

    /**
     * End dates can be changed using setter.
     */
    @Test
    void setEnd() {
        empty.setEnd( END );

        assertEquals( END, empty.getEnd() );
    }
}