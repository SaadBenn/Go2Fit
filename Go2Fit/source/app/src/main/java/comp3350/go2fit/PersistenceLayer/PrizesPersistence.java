package comp3350.go2fit.PersistenceLayer;

import java.util.Map;

import comp3350.go2fit.Models.PrizesModel;

public interface PrizesPersistence {
    void         initializeDatabase();
    boolean      addPrize(PrizesModel model);
    PrizesModel getGoal(int id);
    Map<Integer, PrizesModel> getAllPrizes();

}
