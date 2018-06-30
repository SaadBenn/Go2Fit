package comp3350.go2fit.PersistenceLayer;

import java.util.LinkedHashMap;

import comp3350.go2fit.Models.AchieveModel;

public interface AchievePersistence {
    void initializeDatabase();
    void clearStubDatabase();
    void closeStubDatabase();
    boolean add(AchieveModel achieve);
    AchieveModel getAchieve(int userId);
    LinkedHashMap getAllAchieve();
}
