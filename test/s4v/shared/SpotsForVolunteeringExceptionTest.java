package s4v.shared;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import s4v.TestData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for {@link SpotsForVolunteeringException}
 */
class SpotsForVolunteeringExceptionTest extends TestData {

    SpotsForVolunteeringException exception;


    /**
     * Ensure that an exception can be instanced with a message
     */
    @ParameterizedTest
    @MethodSource("nameStream")
    void constructorString(String name) {

        exception = assertThrows(SpotsForVolunteeringException.class,
                () -> {
                    throw new SpotsForVolunteeringException(name);
                });

        assertEquals(name, exception.getMessage(), "same message expected (invoked super?)");
    }

    /**
     * Ensure that an exception can be instanced with a message and cause (throwable)
     */
    @ParameterizedTest
    @MethodSource("nameStream")
    void constructorStringThrowable(String name) {
        Throwable throwable = new Throwable();

        exception = assertThrows(SpotsForVolunteeringException.class,
                () -> {
                    throw new SpotsForVolunteeringException(name, throwable);
                });

        assertEquals(name, exception.getMessage(), "same message expected (invoked super?)");
        assertEquals(throwable, exception.getCause(), "cause of exception expected (invoked super?)");
    }

}