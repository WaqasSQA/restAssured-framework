package Tests;

import Helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testDELETEPerson {
    private PersonServiceHelper personServiceHelper;
    @BeforeClass

    public void init(){
        personServiceHelper = new PersonServiceHelper();
    }
    @Test
    public void delete_Person(){
        personServiceHelper.deletePerson(5);
    }
}
