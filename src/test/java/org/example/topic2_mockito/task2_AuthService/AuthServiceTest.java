package org.example.topic2_mockito.task2_AuthService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Пользователь успешно аутентифицирован")
    void authSuccess() {
        User user = new User("user", "admin");
        when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        boolean rsl = authService.authenticateUser(user.getUsername(), user.getPassword());

        Assertions.assertTrue(rsl);
        verify(userRepository).findUserByUsername(user.getUsername());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("Неверный пароль пользователя")
    void authFail() {
        User user = new User("user", "admin");
        when(userRepository.findUserByUsername(user.getUsername())).thenReturn(user);

        boolean rsl = authService.authenticateUser(user.getUsername(), "admint123");

        Assertions.assertFalse(rsl);
        verify(userRepository).findUserByUsername(user.getUsername());
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    @DisplayName("Отказ в авторизации, пользователя не существует")
    void userNotFound() {
        String unknownName = "unknownUser";
        when(userRepository.findUserByUsername(unknownName)).thenReturn(null);

        boolean rsl = authService.authenticateUser(unknownName, "");

        Assertions.assertFalse(rsl);
        verify(userRepository).findUserByUsername(unknownName);
        verifyNoMoreInteractions(userRepository);
    }
}