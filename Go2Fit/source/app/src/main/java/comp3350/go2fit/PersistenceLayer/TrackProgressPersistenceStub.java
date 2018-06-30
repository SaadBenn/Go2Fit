package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.TrackProgressModel;

/**track progress persistence stub**/
public class TrackProgressPersistenceStub implements TrackProgressPersistence
{

    private HashMap<Integer, TrackProgressModel> progress;
    private Integer nextId = 0;

    public TrackProgressPersistenceStub()
    {
        progress= new HashMap<Integer, TrackProgressModel>();
    }

    public void initializeDatabase() {

        // print to the console
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
