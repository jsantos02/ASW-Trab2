package s4v.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import s4v.TestData;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for {@link VolunteerInfo}
 */
class VolunteerInfoTest extends TestData {

    final static ContactType PHONE = ContactType.PHONE;
    VolunteerInfo empty;
    VolunteerInfo named;

    @BeforeEach
    void setUp() {
        empty = new VolunteerInfo();
        named = new VolunteerInfo(NAME);
    }

    /**
     * By default IDs are {@code null}
     */
    @Test
    void getId() {
        assertNull(empty.getId());
        assertNull(named.getId());
    }

    @ParameterizedTest
    @MethodSource("idStream")
    void setId(String id) {
        empty.setId(id);
        assertEquals(id, empty.getId());

        empty.setId(null);
        assertEquals(id, empty.getId(), "Cannot be unset");

        empty.setId("SOME OTHER THING");
        assertEquals(id, empty.getId(), "Cannot be changed");
    }


    /**
     * Check names of volunteers:
     * 1) {@code empty} should have a null name
     * 2) {code full} should return NAME
     */
    @Test
    void getName() {
        assertNull(empty.getName());
        assertEquals(NAME, named.getName());
    }

    /**
     * Set a name and confirm it was changed
     */
    @ParameterizedTest
    @MethodSource("nameStream")
    void setName(String name) {
        empty.setName(name);
        assertEquals(name, empty.getName());
    }

    /**
     * By default, info should have an empty contact list
     */
    @Test
    void getContacts() {
        List<Contact> contacts = empty.getContacts();

        assertNotNull(contacts);
        assertEquals(0, contacts.size());
    }

    /**
     * Add a contact; expect it in the list of contacts
     */
    @ParameterizedTest
    @EnumSource(ContactType.class)
    void addContact(ContactType type) {
        Contact contact = new Contact(ADDRESS, type);

        assertEquals(0, empty.getContacts().size());

        empty.addContact(contact);

        assertEquals(1, empty.getContacts().size());

        assertEquals( contact , empty.getContacts().get(0) );
    }

    /**
     * Add a and address and its type; expect them the list of contacts
     */
    @Test
    void addContact2() {
        assertEquals(0, empty.getContacts().size());

        empty.addContact(ADDRESS, PHONE);

        assertEquals(1, empty.getContacts().size());

        Contact contact = empty.getContacts().get(0);

        assertEquals(ADDRESS, contact.address);
        assertEquals(PHONE, contact.type);
    }

    /**
     * Get a phone contact on an empty volunteer and get null
     * Add a phone contact and check it is retrieved.
     */
    @ParameterizedTest
    @MethodSource("addresseStream")
    void getContact(String address) {
        Contact contact = new Contact(address, PHONE);

        assertNull(empty.getContact(PHONE));

        empty.addContact(contact);

        assertEquals(address, empty.getContact(PHONE));
    }

    /**
     * Remove a contact by address after adding it
     */
    @ParameterizedTest
    @EnumSource(ContactType.class)
    void removeContactWithAddress(ContactType type) {
        Contact contact = new Contact(ADDRESS, type);

        empty.addContact(contact);

        empty.removeContactWithAddress(ADDRESS);

        assertNull( empty.getContact( type) );
    }
}
