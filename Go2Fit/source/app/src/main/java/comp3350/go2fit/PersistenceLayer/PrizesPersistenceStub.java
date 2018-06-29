package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.R;

public class PrizesPersistenceStub implements PrizesPersistence {
    private HashMap<Integer, PrizesModel> prizes;
    private Integer nextId = 0;

    public PrizesPersistenceStub()
    {
        this.prizes = new HashMap<>();
    }

    public void initializeDatabase()
    {
        PrizesModel temp1 = new PrizesModel();
        PrizesModel temp2 = new PrizesModel();
        PrizesModel temp3 = new PrizesModel();
        PrizesModel temp4 = new PrizesModel();
        PrizesModel temp5 = new PrizesModel();
        PrizesModel temp6 = new PrizesModel();

        temp1.setImage(R.drawable.calories);
        temp1.setId(nextId);
        prizes.put(temp1.getId(), temp1);
        nextId++;

        temp2.setImage(R.drawable.calories);
        temp2.setId(nextId);
        prizes.put(temp2.getId(), temp2);
        nextId++;

        temp3.setImage(R.drawable.calories);
        temp3.setId(nextId);
        prizes.put(temp3.getId(), temp3);
        nextId++;

        temp4.setImage(R.drawable.calories);
        temp4.setId(nextId);
        prizes.put(temp4.getId(), temp4);
        nextId++;

        temp5.setImage(R.drawable.calories);
        temp5.setId(nextId);
        prizes.put(temp5.getId(), temp5);
        nextId++;

        temp6.setImage(R.drawable.calories);
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
