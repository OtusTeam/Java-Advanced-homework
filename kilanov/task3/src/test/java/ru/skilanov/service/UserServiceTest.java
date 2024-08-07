package ru.skilanov.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import ru.skilanov.cache.Cache;
import ru.skilanov.domain.Users;
import ru.skilanov.dto.UserCreateDto;
import ru.skilanov.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceImpl.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private Cache<Long, Users> cache;

    UserCreateDto dto;
    Users entityToSave;
    Users savedEntity;

    @BeforeEach
    public void setUp() {
        dto = new UserCreateDto("test", "login");

        entityToSave = new Users();
        entityToSave.setLogin("test");
        entityToSave.setPassword("login");

        savedEntity = new Users();
        savedEntity.setId(1L);
        savedEntity.setLogin("test");
        savedEntity.setPassword("login");
    }

    @Test
    public void whenCreateUserThenItCreated() {
        when(userRepository.save(entityToSave)).thenReturn(savedEntity);

        var userDto = userService.create(dto);

        assertEquals(dto.getLogin(), userDto.getLogin());
    }
}
