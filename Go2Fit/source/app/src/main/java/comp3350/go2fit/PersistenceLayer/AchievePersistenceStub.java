package comp3350.go2fit.PersistenceLayer;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.AchieveModel;

public class AchievePersistenceStub implements AchievePersistence {

    private LinkedHashMap<Integer, AchieveModel> achieve;
        private Integer nextId;

        public AchievePersistenceStub()
        {
            this.achieve = new LinkedHashMap<>();
            this.nextId = 0;
        }

        public void initializeDatabase()
        {

            AchieveModel achieve1 = new AchieveModel();
            AchieveModel achieve2 = new AchieveModel();
            AchieveModel achieve3 = new AchieveModel();
            AchieveModel achieve4 = new AchieveModel();


            achieve1.setAchieveName("Baby Steps");
            achieve1.setAchieveType("speed");
            achieve1.setStepsRequired(5);
            achieve1.setTime(876543);
            achieve1.setId(nextId);
            achieve.put(achieve1.getId(), achieve1);
            nextId++;

            achieve2.setAchieveName("100 meter dash");
            achieve2.setAchieveType("strength");
            achieve2.setStepsRequired(100);
            achieve2.setTime(999999);
            achieve2.setId(nextId);
            achieve.put(achieve2.getId(), achieve2);
            nextId++;

            achieve3.setAchieveName("A grand old time");
            achieve3.setAchieveType("weight");
            achieve3.setStepsRequired(1000);
            achieve3.setTime(1001001);
            achieve3.setId(nextId);
            achieve.put(achieve3.getId(), achieve3);
            nextId++;

            achieve4.setAchieveName("Mission walker");
            achieve4.setAchieveType("calorie");
            achieve4.setStepsRequired(2000);
            achieve4.setTime(1002002);
            achieve4.setId(nextId);
            achieve.put(achieve4.getId(), achieve4);
            nextId++;

            // print to the console
            System.out.println("Initialized the database of Achievement Info.");
        }

        public void closeStubDatabase()
        {
            System.out.println("Closing the database");
        }

        public boolean add(AchieveModel achieveModel)
        {
            achieveModel.setId(nextId);
            this.achieve.put(achieveModel.getId(), achieveModel);
            nextId++;
            return true;
        }

        /**Accessors**/
        public AchieveModel getAchieve(int userId)
        {
            return this.achieve.get(userId);
        }

        public LinkedHashMap<Integer, AchieveModel> getAllAchieve()
        {
            return this.achieve;
        }

        public void clearStubDatabase()
        {
            this.achieve.clear();
        }
    }

