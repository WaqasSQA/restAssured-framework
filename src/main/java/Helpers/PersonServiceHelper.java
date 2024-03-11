package Helpers;

import Constants.Endpoints;
import Models.Person;
import Utils.ConfigurationManager;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.lang.reflect.Type;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PersonServiceHelper {

    //private static final String BASE_URL = ConfigurationManager.getInstance().getString("baseURL");
    //private static final String PORT = ConfigurationManager.getInstance().getString("port");

    public PersonServiceHelper() {
        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.useRelaxedHTTPSValidation();

    }

    public List<Person> getAllPerson() {
        Response response = RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALl_PERSONS)
                .andReturn();
        Type type = new TypeReference<List<Person>>() {
        }.getType();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        List<Person> personList = response.as(type);
        return personList;
    }

    public Response createPerson() {
        Person person = new Person();
        person.setId(5);
        person.setTitle("Sameer");
        person.setAuthor("Ghani");

       Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .body(person)
               .post(Endpoints.CREATE_PERSON)
               .andReturn();

       assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
       return response;
    }

    public Response updatePerson(Integer id){
        Person person = new Person();
        person.setTitle("Safeer");
        person.setAuthor("Khatak");

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .body(person)
                .patch(Endpoints.UPDATE_PERSON)
                .andReturn();

        assertTrue((response.getStatusCode() == HttpStatus.SC_OK));

        return response;
    }

    public void deletePerson(Integer id){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .delete(Endpoints.GET_SINGLE_PERSON)
                .andReturn();
        assertTrue(response.getStatusCode() == HttpStatus.SC_OK);

    }

}
