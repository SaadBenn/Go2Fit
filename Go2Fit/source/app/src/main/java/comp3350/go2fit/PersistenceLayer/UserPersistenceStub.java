package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.UserModel;

public class UserPersistenceStub implements UserPersistence{
    private HashMap<Integer, UserModel> users;
    private Integer nextId;

    public UserPersistenceStub() {
        users = new HashMap<Integer, UserModel>();
        nextId = 0;
    }

    public void initializeDatabase() {

        //create 4 users
        UserModel tempData1 = new UserModel();
        UserModel tempData2 = new UserModel();
        UserModel tempData3 = new UserModel();
        UserModel tempData4 = new UserModel();


        tempData1.setCurrentChallenge(0);
        tempData1.setId(nextId);
        users.put(tempData1.getId(), tempData1);
        nextId++;

        tempData2.setCurrentChallenge(1);
        tempData2.setId(nextId);
        users.put(tempData2.getId(), tempData2);
        nextId++;

        tempData3.setCurrentChallenge(2);
        tempData3.setId(nextId);
        users.put(tempData3.getId(), tempData3);
        nextId++;

        tempData4.setCurrentChallenge(3);
        tempData4.setId(nextId);
        users.put(tempData4.getId(), tempData4);
        nextId++;
        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase() { System.out.println("Closing the database"); }

    public void add(UserModel userModel)
    {
        userModel.setId(nextId);
        this.users.put(userModel.getId(), userModel);
        nextId++;
    }

    public UserModel getProgress(int userId)
    {
        return users.get(userId);
    }

    public HashMap<Integer, UserModel> getAllChallenges() {
        return users;
    }

    public UserModel getUser(int userId)
    {
        return users.get(userId);
    }

    public void clearStubDatabase() { users.clear(); }
}
