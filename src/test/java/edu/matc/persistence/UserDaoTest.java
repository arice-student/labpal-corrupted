//package edu.matc.persistence;
//
//import edu.matc.entity.User;
//import edu.matc.test.util.Database;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * The type User dao test.
// */
//class UserDaoTest {
//
//    GenericDao genericDao;
//
//    /**
//     * Creating the dao.
//     */
//    @BeforeEach
//    void setUp() {
//        genericDao = new GenericDao(User.class);
//
//        Database database = Database.getInstance();
//        database.runSQL("cleandb.sql");
//
//    }
//
//    /**
//     * Verifies gets all users successfully.
//     */
//    @Test
//    void getAllUsersSuccess() {
//        List<User> users = genericDao.getAll();
//        assertEquals(6, users.size());
//    }
//
//    /**
//     * Verifies a user is returned correctly based on id search
//     */
//    @Test
//    void getByIdSuccess() {
//        User retrievedUser = (User) genericDao.getById(3);
//        assertNotNull(retrievedUser);
//        User expectedUser = new User("Barney", "Curry",
//                "bcurry", LocalDate.of(1947, 11, 11));
//        expectedUser.setId(3);
//        assertEquals(expectedUser, retrievedUser);
//    }
//
//    /**
//     * Verify successful insert of a user
//     */
//    @Test
//    void insertSuccess() {
//
//        User newUser = new User("Fred", "Flintstone", "fflintstone", LocalDate.parse("1168-01-01"));
//        int id = genericDao.insert(newUser);
//        assertNotEquals(0,id);
//        User insertedUser = (User) genericDao.getById(id);
//        assertEquals(newUser, insertedUser);
//    }
//
//    /**
//     * Verify successful delete of user
//     */
//    @Test
//    void deleteSuccess() {
//        genericDao.delete(genericDao.getById(3));
//        assertNull(genericDao.getById(3));
//    }
//
//    /**
//     * Verify successful update of user
//     */
//    @Test
//    void updateSuccess() {
//        String newLastName = "Davis";
//        User userToUpdate = (User) genericDao.getById(3);
//        userToUpdate.setLastName(newLastName);
//        genericDao.saveOrUpdate(userToUpdate);
//        User retrievedUser = (User) genericDao.getById(3);
//        assertEquals(userToUpdate, retrievedUser);
//    }
//
//    /**
//     * Verify successful get by property (equal match)
//     */
//    @Test
//    void getByPropertyEqualSuccess() {
//        List<User> users = genericDao.getByPropertyEqual("lastName", "Curry");
//        assertEquals(1, users.size());
//        assertEquals(3, users.get(0).getId());
//    }
//
//    /**
//     * Verify successful get by property (like match)
//     */
//    @Test
//    void getByPropertyLikeSuccess() {
//        List<User> users = genericDao.getByPropertyLike("lastName", "c");
//        assertEquals(3, users.size());
//    }
//}