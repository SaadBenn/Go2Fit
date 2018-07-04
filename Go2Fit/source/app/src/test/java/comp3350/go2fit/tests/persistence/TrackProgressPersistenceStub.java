package comp3350.go2fit.tests.persistence;

import java.util.HashMap;

import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;

/**track progress persistence stub**/
public class TrackProgressPersistenceStub implements TrackProgressPersistence
{

    private HashMap<Integer, TrackProgressModel> progress;
    private Integer nextId = 0;

    public TrackProgressPersistenceStub()
    {
        progress= new HashMap<Integer, TrackProgressModel>();
        this.initializeDatabase();
    }

    public void initializeDatabase() {

        // print to the console
        TrackProgressModel data = new TrackProgressModel();
        data.setDistance(100);
        data.setCalories(20);
        data.setNumSteps(10);
        data.setPercentageComplete(2);
        data.setUserId(0);
        data.setId(0);
        progress.put(data.getId(), data);
        System.out.println("Initialized the database of Goal Info.");
    }

    public boolean add(TrackProgressModel userProgress)
    {
        boolean result = false;
        userProgress.setId(nextId);
        this.progress.put(userProgress.getUserId(), userProgress);
        result = true;
        nextId++;
        return result;
    }

    public boolean update(TrackProgressModel userProgress)
    {
        boolean result = false;
        this.progress.put(userProgress.getUserId(), userProgress);
        result = true;

        return result;
    }

    public TrackProgressModel getProgress(int userId)
    {
        return this.progress.get(userId);
    }

    public boolean remove(int id)
    {
        this.progress.remove(id);
        return true;
    }
}
