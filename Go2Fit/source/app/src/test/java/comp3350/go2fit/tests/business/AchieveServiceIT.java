package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import comp3350.go2fit.BuisnessLayer.AchieveService;
import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.tests.utils.TestUtils;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class AchieveServiceIT extends TestCase {

    private File tempDB;
    private AchieveService achieveService;

    @Before
    public void setUp() throws IOException
    {
        this.tempDB = TestUtils.copyDB();
        this.achieveService = new AchieveService();
    }

    @Test
    public void tests() {
        System.out.println("Starting AchieveServiceTest: verifying Distance/Time");

        assertTrue(achieveService.verifyDistance("200"));
        System.out.println("Testing Valid time");
        assertTrue(achieveService.verifyTime(20, 10));

        System.out.println("Finished AchieveServiceTest: verifying Distance/Time");

        System.out.println("Starting AchieveServiceTest: GetAllAchieveNames");
        LinkedHashMap<Integer, AchieveModel> map = new LinkedHashMap<>();

        AchieveModel achieve1 = new AchieveModel();
        AchieveModel achieve2 = new AchieveModel();

        achieve1.setAchieveName("Fuck the police");
        achieve1.setAchieveType("speed");
        achieve1.setStepsRequired(5);
        achieve1.setTime(876543);
        achieve1.setId(0);
        map.put(achieve1.getId(), achieve1);


        achieve2.setAchieveName("100 meter dash");
        achieve2.setAchieveType("strength");
        achieve2.setStepsRequired(100);
        achieve2.setTime(999999);
        achieve2.setId(1);

        map.put(achieve2.getId(), achieve2);

        ArrayList<String> list = achieveService.getAllAchieveNames(map);
        assertNotNull(list);
        assertTrue(list.size() > 0);

        System.out.println("Finished AchieveServiceTest: GetAllAchieveNames");
    }

    @After
    public void tearDown()
    {
        //reset DB
        this.tempDB.delete();
    }

//    @Before
//    public void setUp1() throws IOException
//    {
//        this.tempDB = TestUtils.copyDB();
//        this.achieveService = new AchieveService();
//    }
//
//    @Test (expected = IllegalArgumentException.class)
//    public void testIllegalArgumentException() {
//        System.out.println("Starting AchieveServiceTest: Invalid Time");
//        try {
//            achieveService.verifyTime(-1,0);
//        } catch (IllegalArgumentException e) {
//            assert true;
//        }
//        System.out.println("Finished AchieveServiceTest: Invalid Time");
//    }
//
//    @After
//    public void tearDown1()
//    {
//        //reset DB
//        this.tempDB.delete();
//    }
}
