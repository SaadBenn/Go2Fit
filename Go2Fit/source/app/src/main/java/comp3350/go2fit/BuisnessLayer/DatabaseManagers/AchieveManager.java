package comp3350.go2fit.BuisnessLayer.DatabaseManagers;

import java.util.LinkedHashMap;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.PersistenceLayer.AchievePersistence;

public class AchieveManager implements AchieveManagerInterface {
    private AchievePersistence  achieveDatabase;
    public AchieveManager()
    {
        this.achieveDatabase = Services.getAchievePersistence();
    }

    public AchieveManager(final AchievePersistence achievePersistence) {
        this();
        this.achieveDatabase = achievePersistence;
    }

    public AchieveModel getAchieve(int id) throws NullPointerException
    {
        return this.achieveDatabase.getAchieve(id);
    }

    public LinkedHashMap getAllAchieve() throws NullPointerException
    {
        return (LinkedHashMap)this.achieveDatabase.getAllAchieve();
    }
    public boolean addChallenge(AchieveModel challengesModel)
    {
        return this.achieveDatabase.add(challengesModel);
    }
    @Override
    public boolean addAchieve(AchieveModel achieveModel) {
        return false;
    }
}
