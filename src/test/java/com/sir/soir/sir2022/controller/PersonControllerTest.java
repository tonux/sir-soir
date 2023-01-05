package com.sir.soir.sir2022.controller;

import com.sir.soir.sir2022.model.Person;
import com.sir.soir.sir2022.services.PersonService;
import com.sir.soir.sir2022.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class PersonControllerTest {

    @Autowired
    PersonController personController;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    MockMvc mockMvc;

    @LocalServerPort
    int port;

    @MockBean
    PersonService personService;

    @Test
    void getAllPersons() throws Exception {
        //Given
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON); // "application/json"

        //when(personService.findAllPersons()).thenReturn(List.of(new Person(1L,"Fila", "fila@gmail.com")));

        //When
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // Then
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        // assertTrue(response.getContentAsString().contains("Fila"));
        assertTrue(response.getContentAsString().contains("[]"));
    }

    @Test
    void getAllPersonsWithService(){
        //Given
        when(personService.findAllPersons()).thenReturn(List.of(new Person(1L,"Fila", "fila@gmail.com")));

        //When
        ResponseEntity<List<Person>> response = personController.getAllPersons();

        //Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(personService, times(1)).findAllPersons();
        assertEquals(1, response.getBody().size());
    }

    @Test
    void getPersonById() {
        //TODO

        //Given
        final Long testId = 10l;
        when(personService.findById(testId)).thenReturn(new Person(10L, "Khalifa", "khalifa@gmail.com"));

        //When
        ResponseEntity<Person> response = personController.getPersonById(testId);

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(10L,response.getBody().getId());

    }

    @Test
    void savePerson() {
    }

    @Test
    void updatePerson() {
    }

    @Test
    void deletePerson() {
    }

    @Test
    void hello() {
        String name = "tonux";
        String url = "http://localhost:"+port+"/api/person/hello/"+name;
        String response = testRestTemplate.getForObject(url, String.class);
        assertEquals("Hello "+name, response);
    }
}