package com.hellokoding.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.hellokoding.auth.model.Role;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.RoleRepository;
import com.hellokoding.auth.repository.UserRepository;
import com.hellokoding.auth.service.UserServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class TestUserService {

  private static final String MOCK_ENCODED_PASSWORD = "MOCK_ENCODED_STRING";

  @Mock
  private UserRepository mockUserRepository;

  @Mock
  private RoleRepository mockRoleRepository;

  @Mock
  private BCryptPasswordEncoder mockPasswordEncoder;

  @InjectMocks
  private UserServiceImpl userService;


  @Test
  public void saveUser_whenRoleRepositoryReturnsRoles_userSavedInUserRepoWithEncryptedPassword() {
    User user = new User();
    user.setId(1234L);
    user.setPassword("ORIGINAL_PASSWORD");
    user.setUsername("USERNAME");

    when(mockRoleRepository.findAll()).thenReturn(getMockRoles());

    when(mockPasswordEncoder.encode(anyString())).thenReturn(MOCK_ENCODED_PASSWORD);

    userService.save(user);

    ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
    verify(mockUserRepository).save(argument.capture());

    User sentValue = argument.getValue();

    assertEquals(MOCK_ENCODED_PASSWORD, sentValue.getPassword());
    assertEquals("USERNAME", sentValue.getUsername());
    assertEquals(1, sentValue.getRoles().size());
  }

  private List<Role> getMockRoles() {
    Role role = new Role();
    role.setId(1234L);
    role.setName("MockRole");
    List<Role> mockList = new ArrayList<Role>();
    mockList.add(role);
    return mockList;
  }
}
