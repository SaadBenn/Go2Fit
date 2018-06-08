package comp3350.go2fit.PersistenceLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import comp3350.go2fit.Models.TrackProgressModel;

public class TrackProgressPersistenceStub implements TrackProgressPersistence {

    private HashMap<Integer, TrackProgressModel> progress;
    private Integer nextId = 0;

    public TrackProgressPersistenceStub() {
        progress= new HashMap<Integer, TrackProgressModel>();
    }

    public void initializeDatabase() {

        TrackProgressModel tempData = new TrackProgressModel();

        tempData.setDistance(21.3);
        tempData.setCalories(0.65);
        tempData.setNumSteps(70);
        tempData.setPercentageComplete(14);
        tempData.setUserId(0);
        tempData.setId(nextId);
        progress.put(tempData.getId(), tempData);

        nextId++;

        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase() { System.out.println("Closing the database"); }

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
        return progress.get(userId);
    }

    public void clearStubDatabase() { progress.clear(); }
}
