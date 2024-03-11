package Tests;

import Helpers.PersonServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class testPATCHPerson {
    private PersonServiceHelper personServiceHelper;

    @BeforeClass
    public void init(){
        personServiceHelper = new PersonServiceHelper();

    }
    @Test
    public void updatePatchPerson(){
        String id = personServiceHelper.updatePerson(5).jsonPath().getString("id");
        System.out.println(id);
        assertNotNull(id, "Updated");
    }
}
