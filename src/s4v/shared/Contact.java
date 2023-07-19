package s4v.shared;
import java.io.*;
import java.util.*;
/**
 * Class representing the contact of a volunteer, such as phone or an email.
 * Composed only by the class constructor.
 * @author José Santos (up202007059)
 * @author Miguel Gomes (up201905102)
 * @since April 2023
 *
 * @implements Serializable
 */

public class Contact implements Serializable {
    final String address;
    final ContactType type;

    /**
     * Constructor to create a contact
     * @param address of the contact
     * @param type of contact
     */
    public Contact(String address, ContactType type) {
        this.address = address;
        this.type = type;
    }

    /**
     * Get contact type
     * @return type
     */
    public ContactType getType() {
        return type;
    }

    /**
     * Get the contact address
     * @return address
     */
    public String getAddress() {
        return address;
    }
}

/**
 * Categorization of contacts.
 */
enum ContactType {
    PHONE, EMAIL, OTHER;
}