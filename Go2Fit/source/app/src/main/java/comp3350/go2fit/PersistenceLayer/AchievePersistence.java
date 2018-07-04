package comp3350.go2fit.PersistenceLayer;

import java.util.Map;

import comp3350.go2fit.Models.AchieveModel;

public interface AchievePersistence {
    boolean add(AchieveModel achieve);
    AchieveModel getAchieve(int userId);
    Map getAllAchieve();
}
