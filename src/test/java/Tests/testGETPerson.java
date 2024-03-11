package Tests;

import Helpers.PersonServiceHelper;
import Models.Person;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;

import static org.testng.Assert.assertNotNull;

public class testGETPerson {

private PersonServiceHelper personServiceHelper;

@BeforeClass
    public void init(){
    personServiceHelper = new PersonServiceHelper();

}
@Test
    public void testGETPersons(){
    List <Person> personList = personServiceHelper.getAllPerson();
    assertNotNull(personList, "Person is not empty");
}
}
