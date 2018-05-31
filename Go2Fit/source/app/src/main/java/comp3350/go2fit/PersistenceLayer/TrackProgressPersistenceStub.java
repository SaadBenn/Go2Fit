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
        tempData.setPercentageComplete(70);
        tempData.setId(1);
        progress.put(1, tempData);

        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase() { System.out.println("Closing the database"); }

    public void add(TrackProgressModel userProgress)
    {
        userProgress.setId(nextId++);
        this.progress.put(userProgress.getId(), userProgress);
    }

    public TrackProgressModel getProgress(int userId)
    {
        return progress.get(userId);
    }

    public void clearStubDatabase() { progress.clear(); }
}
