package cucumber.steps;

import com.sir.soir.sir2022.controller.PersonController;
import com.sir.soir.sir2022.model.Person;
import com.sir.soir.sir2022.repository.PersonRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestConfiguration.class)
public class PersonStepdefs {

    private Person person;
    private ResponseEntity<Person> response;
    private ResponseEntity<List<Person>> listResponse;

    private List<Person> persons;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    PersonController personController;

    @When("I POST the person to the {string} endpoint")
    public void iPOSTThePersonToTheEndpoint(String endPoint) {
        response = personController.savePerson(person);
    }

    @Given("I have a new person with name {string} and email {string}")
    public void iHaveANewPersonWithNameAndEmail(String name, String email) {
        person = new Person(name, email);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statutCode) {
        assertEquals(statutCode, response.getStatusCode().value());
    }

    @And("the response body should contain the person with name {string} and email {string}")
    public void theResponseBodyShouldContainThePersonWithNameAndEmail(String name, String email) {
        Person personResponse = response.getBody();
        assertNotNull(personResponse);
        assertEquals(name, personResponse.getName());
        assertEquals(email, personResponse.getEmail());
    }

    @Given("there are persons with names {string}, {string}, and {string} in the database")
    public void thereArePersonsWithNamesAndInTheDatabase(String name1, String name2, String name3) {
        persons = List.of(new Person(name1, name1+ "@gmail.com"),
                new Person(name2, name2 + "@gmail.com"),
                new Person(name3, name3 + "@gmail.com"));

        personRepository.saveAll(persons);

    }

    @When("I GET the {string} endpoint")
    public void iGETTheEndpoint(String arg0) {
        listResponse = personController.getAllPersons();
    }

    @Then("the list response status code should be {int}")
    public void theListResponseStatusCodeShouldBe(int statutCode) {
        assertEquals(statutCode, listResponse.getStatusCode().value());
    }

    @And("the response body should contain a list of {int} persons with names {string}, {string}, and {string}")
    public void theResponseBodyShouldContainAListOfPersonsWithNamesAnd(int number, String name1, String name2, String name3) {
        List<Person> personList =  listResponse.getBody();

        assertNotNull(personList);
        assertTrue(personList.size() >= number);
        assertTrue(personList.stream().anyMatch(person -> person.getName().equals(name1)));
        assertTrue(personList.stream().anyMatch(person -> person.getName().equals(name2)));
        assertTrue(personList.stream().anyMatch(person -> person.getName().equals(name3)));

    }

    @Given("there is a person with name {string} and email {string} in the database")
    public void thereIsAPersonWithNameAndEmailInTheDatabase(String name, String email) {
        person = personRepository.save(new Person(name, email));
    }

    @When("I PUT the person with name {string} and email {string} to the {string} endpoint")
    public void iPUTThePersonWithNameAndEmailToTheEndpoint(String name, String email, String arg2) {
        person.setName(name);
        person.setEmail(email);
        response = personController.updatePerson(person);
    }
}
