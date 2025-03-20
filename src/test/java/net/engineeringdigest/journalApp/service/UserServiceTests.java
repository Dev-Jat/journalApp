package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "ram",
            "shyam",
            "Dev"
    })
    public void testFindByUserName1(String name) {
        assertNotNull(userRepository.findByUserName(name),"failed for: "+name);
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "shyam",
            "Dev"
    })
    public void testFindByUserName2(String name) {
        assertNotNull(userRepository.findByUserName(name),"failed for: "+name);
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUserName3(User user) {
        assertTrue(userService.saveNewUser(user));
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "2,2,4",
            "3,9,12",
            "3,6,9"
    }
    )
    public void test(int a, int b, int expected) {
        assertEquals(expected, a+b);
    }

}
