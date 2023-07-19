package s4v.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import s4v.TestData;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest extends TestData {
    static final long MAX_TIME = 3;

    Message empty;
    Message full;

    @BeforeEach
    void setUp() {
        empty = new Message();
        full = new Message(ID, TEXT);
    }

    /**
     * Empty message hasn't a from but the full one has
     */
    @Test
    void getFrom() {
        assertAll(
                () -> assertNull(empty.getFrom()),
                () -> assertEquals(ID, full.getFrom())
        );
    }

    /**
     * Empty message hasn't a text but the full one has
     */
    @Test
    void getText() {
        assertAll(
                () -> assertNull(empty.getText()),
                () -> assertEquals(TEXT, full.getText())
        );

    }

    /**
     * Dates of test messages must be a few milliseconds ago
     */
    @Test
    void getDate() {
        final String message = "Dates of test messages must be a few milliseconds ago";
        final Date now = new Date();

        assertAll(
                () -> {
                    long diff = now.getTime() - empty.getDate().getTime();
                    assertTrue(diff >= 0 && diff < MAX_TIME, message);
                },
                () -> {
                    long diff = now.getTime() - full.getDate().getTime();
                    assertTrue(diff >= 0 && diff < MAX_TIME, message);
                }
        );
    }

    /**
     * Message instances are equals to themselves.
     * Two messages with the same from ID, with the same text,
     * created at the same time, are equal.
     */
    @Test
    void equals() {
        assertAll(
                () -> assertEquals(empty, empty),
                () -> assertEquals(full, full),
                () -> assertEquals(new Message(ID, TEXT), new Message(ID, TEXT))
        );
    }

    /**
     * The hashCode() method was redefined
     */
    @Test
    void checkHashCode() {

        assertEquals(Objects.hash(full.getFrom(), full.getText(), full.getDate()),
                full.hashCode(),
                "did you implement equals() and hasCode()?\n" +
                        "Use Code | Generate on IDEA ");
    }

}