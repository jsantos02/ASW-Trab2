package s4v.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import s4v.TestData;

import static org.junit.jupiter.api.Assertions.*;

class TaskInfoTest extends TestData {

    TaskInfo empty;
    TaskInfo full;

    @BeforeEach
    void setUp() throws SpotsForVolunteeringException {
        empty = new TaskInfo();
        full = new TaskInfo(ID, TASK_NAME, LATITUDE, LONGITUDE, START, END);
    }

    /**
     * Throws asn exception if end date is before start date
     */
    @Test
    void constructor_exception() {
        assertThrows(SpotsForVolunteeringException.class,
                () -> new TaskInfo(ID, TASK_NAME, LATITUDE, LONGITUDE, END, START),
                "start and end dates are reversed");
    }

    /**
     * IDs should be {@code null} on newly created instances
     */
    @Test
    void getId() {
        assertNull(empty.getId());
        assertNull(full.getId());
    }


    /**
     * IDs are changed using setter.
     */
    @ParameterizedTest
    @MethodSource("idStream")
    void setId(String id) {

        full.setId(id);

        assertEquals(id, full.getId(), "Not the set ID");
    }

    /**
     * Assigned IDs cannot be changed after being assigned
     *
     * @param id to test
     */
    @ParameterizedTest
    @MethodSource("idStream")
    void setId_twice(String id) {
        full.setId(ID);

        assertEquals(ID, full.getId());

        full.setId(id); // set id again

        assertEquals(ID, full.getId(), "ID cannot be changed after assigned");

    }

    /**
     * Check activity IDs set by constructors
     */
    @Test
    void getActivityId() {
        assertAll(
                () -> assertNull(empty.getActivityId()),
                () -> assertEquals(ID, full.getActivityId())
        );
    }

    /**
     * Change activity id and it is retrieved
     *
     * @param id to test
     */
    @ParameterizedTest
    @MethodSource("idStream")
    void setActivityId(String id) {
        full.setActivityId(id);

        assertEquals(id, full.getActivityId());
    }

    /**
     * Retrieve name assigned by constructor.
     */
    @Test
    void getName() {
        assertNull(empty.getName());

        assertEquals(TASK_NAME, full.getName());
    }

    /**
     * Names are changed with setter
     *
     * @param name to test
     */
    @ParameterizedTest
    @MethodSource("taskNameStream")
    void setName(String name) {
        empty.setName(name);

        assertEquals(name, empty.getName());
    }

    /**
     * Check latitudes assigned by constructors
     */
    @Test
    void getLatitude() {
        assertEquals( 0D , empty.getLatitude() );

        assertEquals( LATITUDE , full.getLatitude() );
    }

    /**
     * Latitudes can be changed using setter
     */
    @Test
    void setLatitude() {
        empty.setLatitude( LATITUDE );

        assertEquals( LATITUDE , empty.getLatitude() );
    }

    /**
     * Check longitudes assigned by constructors
     */
    @Test
    void getLongitude() {
        assertAll(
                () -> assertEquals(0D, empty.getLongitude()),
                () -> assertEquals(LONGITUDE, full.getLongitude())
        );
    }

    /**
     * Longitudes can be changed using setter.
     */
    @Test
    void setLongitude() {
        empty.setLongitude( LONGITUDE );

        assertEquals( LONGITUDE , empty.getLongitude() );
    }

    /**
     * Check start dates assigned by constructors
     */
    @Test
    void getStart() {
        assertAll(
                () -> assertNull(empty.getStart()),
                () -> assertEquals(START, full.getStart()));
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
        assertAll(
                () -> assertNull(empty.getEnd()),
                () -> assertEquals(END, full.getEnd())
        );
    }

    /**
     * End dates can be changed using setter.
     */
    @Test
    void setEnd() {
        empty.setEnd(END);

        assertEquals(END, empty.getEnd());
    }

    /**
     * A similar task info is equals
     */
    @Test
    void equals() throws SpotsForVolunteeringException {
        assertEquals(full, new TaskInfo(ID, TASK_NAME, LATITUDE, LONGITUDE, START, END), "Equals to a similar task");
    }
}