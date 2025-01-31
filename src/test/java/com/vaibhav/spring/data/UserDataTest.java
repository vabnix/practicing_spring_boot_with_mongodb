package com.vaibhav.spring.data;

import com.vaibhav.spring.repositories.UserRepository;
import com.vaibhav.spring.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDataTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        UserData testUser = new UserData();
        testUser.setId("9b842737-0816-46c6-822b-6b6536b093cf");
        testUser.setFirstName("vaibhav");
        testUser.setLastName("srivastava");
        testUser.setLocation("texas");
    }

    @Test
    void getId() {
        UserData testUser = new UserData();
        testUser.setId("1");
        Assertions.assertEquals("1", testUser.getId());
    }

    @Test
    void setId() {
        UserData testUser = new UserData();
        testUser.setId("1");
        Assertions.assertEquals("1", testUser.getId());
    }

    @Test
    void getFirstName() {
        UserData testUser = new UserData();
        testUser.setFirstName("vaibhav");
        Assertions.assertEquals("vaibhav", testUser.getFirstName());
    }

    @Test
    void setFirstName() {
        UserData testUser = new UserData();
        testUser.setFirstName("vaibhav");
        Assertions.assertEquals("vaibhav", testUser.getFirstName());
    }

    @Test
    void getLastName() {
        UserData testUser = new UserData();
        testUser.setLastName("srivastava");
        Assertions.assertEquals("srivastava", testUser.getLastName());
    }

    @Test
    void getLocation() {
        UserData testUser = new UserData();
        testUser.setLocation("texas");
        Assertions.assertEquals("texas", testUser.getLocation());
    }

    @Test
    void setLocation() {
        UserData testUser = new UserData();
        testUser.setLocation("texas");
        Assertions.assertEquals("texas", testUser.getLocation());
    }


    @Test
    void createUser_ShouldSaveAndReturnUser() {
        UserData testUser = new UserData();
        when(userRepository.save(any(UserData.class))).thenReturn(testUser);

        UserData result = userService.createUser(testUser);

        verify(userRepository).save(testUser);
        assertThat(result).isEqualTo(testUser);
    }

    @Test
    void getUser_WhenUserExists_ShouldReturnUser() {
        UserData testUser = new UserData();
        when(userRepository.findById("9b842737-0816-46c6-822b-6b6536b093cf")).thenReturn(Optional.of(testUser));

        UserData result = userService.getUserById("9b842737-0816-46c6-822b-6b6536b093cf");

        assertThat(result).isEqualTo(testUser);
    }

    @Test
    void getUser_WhenUserNotFound_ShouldThrowException() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.getUserById("9b842737-0816-46c6-822b-6b6536b093cf"));
    }

    @Test
    void getAllUsers_ShouldReturnList() {
        UserData testUser = new UserData();
        List<UserData> users = List.of(testUser);
        when(userRepository.findAll()).thenReturn(users);

        List<UserData> result = userService.getAllUsers();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo(testUser);
    }
}