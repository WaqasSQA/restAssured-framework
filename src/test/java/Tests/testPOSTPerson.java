package Tests;

import Helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class testPOSTPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();

    }
    @Test
    public void createPostPerson (){
        String id = personServiceHelper.createPerson().jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "Id is not null");
    }
}
