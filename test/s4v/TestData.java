package s4v;

import java.io.File;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Test data used by most test classes,
 * including methods used as sources for parametrized tests.
 * Declarations are static, protected and final.
 * Static methods are final since they cannot be redeclared
 * and are not explicitly declared as such.
 */
public abstract class TestData {

    /*----------------------*\
     *          IDs         *
    \*----------------------*/

    static protected final String[] IDS = {
            "123-456-789", "234-567-891", "345-678-912", "456-789-123"
    };
    static protected final String ID = IDS[0];


    static protected final String[] ACTIVITY_NAMES = {
            "My first activity", "Some Other activity", "Another activity", "Activities, activities, activities ..."
    };

    /*--------------------------*\
     *          Names           *
    \*--------------------------*/

    static protected final String[] NAMES = {
            "Jane Doe", "Jon Doe", "Another Name", "Yet Another Name"
    };
    static protected final String NAME = NAMES[0];

    static protected Stream<String> nameStream() {
        return Stream.of(NAMES);
    }
    static protected final String[] ADDRESSES = {"12345678", "joe@some.site.org"};

    static protected final String ACTIVITY_NAME = ACTIVITY_NAMES[0];
    static protected final String ADDRESS = ADDRESSES[0];

    static protected final String[] TASK_NAMES = {"My first task", "Some Other Task", "Another Task", "Tasks, tasks, tasks..."};
    static protected final String TASK_NAME = TASK_NAMES[0];
    static protected final String[] TEXTS = {
            "Some random text", "Another random text", "Yet another text",
            "A bit longer text, but not that much",
    };

    /*--------------------------*\
     *          Addresses       *
    \*--------------------------*/
    static protected final double LONGITUDE = -8.628305120381732;
    static final long DELAY = 10000L;
    static protected String TEXT = TEXTS[0];

    /*--------------------------*\
     *          Texts           *
    \*--------------------------*/

    static protected Stream<String> idStream() { return Stream.of(IDS); }

    static protected Stream<String> activityNameStream() {
        return Stream.of(ACTIVITY_NAMES);
    }

    //    static protected Stream<String> textStream() {return Stream.of(TEXTS); }

    /*-------------------------------*\
     *  Latitudes & Longitudes       *
    \*-------------------------------*/
    static protected final double LATITUDE = 41.15994591378216;

    static protected Stream<String> taskNameStream() {
        return Stream.of(TASK_NAMES);
    }


    /*------------------------------*\
     *              Dates           *
    \*------------------------------*/

    static protected final Date NOW = new Date();
    static protected final Date START = NOW;

    static protected Stream<String> addresseStream() {
        return Stream.of(ADDRESSES);
    }
    static protected final Date BEFORE = new Date(NOW.getTime() - DELAY);
    
    static protected final Date LONG_BEFORE = new Date(NOW.getTime() - 2 * DELAY);
    static protected final Date AFTER = new Date(NOW.getTime() + DELAY);
    static protected final Date END = AFTER;
    static protected final Date LONG_AFTER = new Date(NOW.getTime() + 2 * DELAY);

    /*------------------------------*\
     *              Files           *
    \*------------------------------*/

    protected static final String MY_BACKUP_FILENAME = "backup.ser";
    protected static final File MY_BACKUP_FILE = new File(MY_BACKUP_FILENAME).getAbsoluteFile();
}
