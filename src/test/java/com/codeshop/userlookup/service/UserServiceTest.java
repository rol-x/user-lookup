package com.codeshop.userlookup.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.codeshop.userlookup.client.UserProvider;
import com.codeshop.userlookup.model.User;
import com.codeshop.userlookup.repository.RequestsRepository;
import com.codeshop.userlookup.repository.entity.LoginRequest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock UserProvider userProvider;
  @Mock RequestsRepository requestsRepository;
  @InjectMocks UserService uut;

  @Test
  void getUserData() {
    // Given
    var login = "any-user";
    var user = new User();
    var argumentCaptor = ArgumentCaptor.forClass(LoginRequest.class);
    when(userProvider.getUserData(login)).thenReturn(user);
    when(requestsRepository.findByLogin(login)).thenReturn(Optional.empty());

    // When
    var actualUser = uut.getUserData(login);

    // Then
    assertThat(actualUser).isEqualTo(user);
    verify(requestsRepository, times(1)).findByLogin(login);
    verify(requestsRepository, times(1)).save(argumentCaptor.capture());
    assertThat(argumentCaptor.getValue().getLogin()).isEqualTo(login);
    assertThat(argumentCaptor.getValue().getRequestCount()).isOne();
  }
}
