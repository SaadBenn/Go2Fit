package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.Map;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.PersistenceLayer.PrizesPersistence;

public class PrizesManager {
    private PrizesPersistence prizesDatabase;

    public PrizesManager()
    {
        this.prizesDatabase = Services.getPrizesPersistence();
    }

    public PrizesManager(final PrizesPersistence prizesPersistence) {
        this();
        this.prizesDatabase = prizesPersistence;
    }

    public Map<Integer, PrizesModel> getAllPrizes(){ return this.prizesDatabase.getAllPrizes(); }
}
