package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.response.MessageDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.digitalinnovationone.personapi.utils.PersonUtils.createFakeDTO;
import static com.digitalinnovationone.personapi.utils.PersonUtils.createFakeEntity;
import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage(){
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);
        MessageDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MessageDTO successMessage =  personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageDTO createExpectedMessageResponse(Long id){
        return MessageDTO
                .builder()
                .message("Created person with id " + id)
                .build();
    }

}
