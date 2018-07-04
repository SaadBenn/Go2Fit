package comp3350.go2fit.tests.business;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import comp3350.go2fit.BuisnessLayer.AchieveService;
import comp3350.go2fit.Models.AchieveModel;

public class AchieveServiceTest extends TestCase {
    private AchieveService achieveService;

    @Test
    public void testForVerifyDistance() {
        System.out.println("Starting AchieveServiceTest: verifying Distance/Time");
        achieveService = new AchieveService();

        assertTrue(achieveService.verifyDistance("200"));
        System.out.println("Testing Valid time");
        assertTrue(achieveService.verifyTime(20, 10));

        System.out.println("Finished AchieveServiceTest: verifying Distance/Time");
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForIllegalArgumentException() {

        System.out.println("Starting AchieveServiceTest: Invalid Time");

        try {
            achieveService = new AchieveService();
            achieveService.verifyTime(-1,0);
        } catch (IllegalArgumentException e) {
            assert  true;
        }

        System.out.println("Finished AchieveServiceTest: Invalid Time");
    }

    @Test
    public void testForgetAllAchieveNames() {
        System.out.println("Starting AchieveServiceTest: GetAllAchieveNames");

        achieveService = new AchieveService();
        LinkedHashMap<Integer, AchieveModel> map = new LinkedHashMap<>();

        AchieveModel achieve1 = new AchieveModel();
        AchieveModel achieve2 = new AchieveModel();

        achieve1.setAchieveName("Baby Steps");
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
}
