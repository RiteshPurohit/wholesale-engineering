package com.project.account.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ExceptionHandlerAdviceTest {

  @InjectMocks
  private ExceptionHandlerAdvice unit;

  @Test
  public void handleResourceNotFoundException_returnsNotFound_whenResourceNotFoundException(){
    //given
    ResourceNotFoundException resourceNotFoundException = new ResourceNotFoundException("message");
    //when
    ResponseEntity<String> responseEntity = unit.handleResourceNotFoundException(resourceNotFoundException);
    //then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(responseEntity.getBody()).isEqualTo("message");
  }
}
