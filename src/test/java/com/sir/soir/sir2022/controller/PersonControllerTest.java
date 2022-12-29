package com.sir.soir.sir2022.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    void getAllPersons() throws Exception {
        //Given
        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/person")
                .contentType(MediaType.APPLICATION_JSON); // "application/json"

        //When
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        // Then
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void getPersonById() {
        //TODO
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