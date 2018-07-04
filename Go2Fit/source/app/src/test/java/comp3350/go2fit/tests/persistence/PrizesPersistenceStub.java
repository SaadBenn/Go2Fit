package comp3350.go2fit.tests.persistence;

import java.util.HashMap;

import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.PersistenceLayer.PrizesPersistence;
import comp3350.go2fit.R;

public class PrizesPersistenceStub implements PrizesPersistence {
    private HashMap<Integer, PrizesModel> prizes;
    private Integer nextId = 0;

    public PrizesPersistenceStub()
    {
        this.prizes = new HashMap<>();
        initializeDatabase();
    }

    public void initializeDatabase()
    {
        PrizesModel temp1 = new PrizesModel();
        PrizesModel temp2 = new PrizesModel();
        PrizesModel temp3 = new PrizesModel();
        PrizesModel temp4 = new PrizesModel();
        PrizesModel temp5 = new PrizesModel();
        PrizesModel temp6 = new PrizesModel();

        temp1.setImage(R.drawable.runner_stickman);
        temp1.setDescription("50% off at sportscheck!");
        temp1.setPointsRequired(50000);
        temp1.setId(nextId);
        prizes.put(temp1.getId(), temp1);
        nextId++;

        temp2.setImage(R.drawable.calories);
        temp2.setDescription("25% off of all underarmor apparel!");
        temp2.setPointsRequired(10);
        temp2.setId(nextId);
        prizes.put(temp2.getId(), temp2);
        nextId++;

        temp3.setImage(R.drawable.footsteps_icon);
        temp3.setDescription("Any Nike shoes under $100!");
        temp3.setPointsRequired(75000);
        temp3.setId(nextId);
        prizes.put(temp3.getId(), temp3);
        nextId++;

        temp4.setImage(R.drawable.calories);
        temp4.setDescription("Free gym pass for 1 month!");
        temp4.setPointsRequired(15000);
        temp4.setId(nextId);
        prizes.put(temp4.getId(), temp4);
        nextId++;

        temp5.setImage(R.drawable.calories);
        temp5.setDescription("2 Tickets to an NHL game!");
        temp5.setPointsRequired(500000);
        temp5.setId(nextId);
        prizes.put(temp5.getId(), temp5);
        nextId++;

        temp6.setImage(R.drawable.calories);
        temp6.setDescription("20% off at sportscheck!");
        temp6.setPointsRequired(10000);
        temp6.setId(nextId);
        prizes.put(temp6.getId(), temp6);
        nextId++;

    }

    public boolean addPrize(PrizesModel model)
    {
        boolean result = false;
        model.setId(nextId);
        this.prizes.put(model.getId(), model);
        result = true;
        nextId++;
        return result;
    }

    public PrizesModel getGoal(int id)
    {
        return this.prizes.get(id);
    }

    public HashMap<Integer, PrizesModel> getAllPrizes() {
        return this.prizes;
    }

}
