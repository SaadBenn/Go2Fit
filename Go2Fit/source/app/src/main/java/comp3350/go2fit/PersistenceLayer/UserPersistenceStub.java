package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.UserModel;

/**user persistence stub**/
public class UserPersistenceStub implements UserPersistence
{
    private HashMap<Integer, UserModel> users;
    private Integer nextId;

    public UserPersistenceStub()
    {
        users = new HashMap<Integer, UserModel>();
        nextId = 0;
    }

    public void initializeDatabase()
    {

        //create 4 users
        UserModel tempData1 = new UserModel();
        UserModel tempData2 = new UserModel();
        UserModel tempData3 = new UserModel();
        UserModel tempData4 = new UserModel();


        tempData1.setId(nextId);
        tempData1.setName("s");
        tempData1.setPassword("a");
        users.put(tempData1.getId(), tempData1);
        nextId++;

        tempData2.setId(nextId);
        tempData2.setName("e");
        tempData2.setPassword("s");
        users.put(tempData2.getId(), tempData2);
        nextId++;

        tempData3.setId(nextId);
        tempData3.setName("Saad");
        users.put(tempData3.getId(), tempData3);
        nextId++;

        tempData4.setId(nextId);
        tempData4.setName("Soni");
        users.put(tempData4.getId(), tempData4);
        nextId++;

        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void add(UserModel userModel)
    {
        userModel.setId(nextId);
        this.users.put(userModel.getId(), userModel);
        nextId++;
    }

    public HashMap<Integer, UserModel> getAllUsers() {
        return this.users;
    }

    public UserModel getUser(int userId)
    {
        return this.users.get(userId);
    }

    public boolean update(UserModel user)
    {
        boolean result = false;
        this.users.put(user.getId(), user);
        result = true;
        return result;
    }

    public void clearStubDatabase()
    {
        this.users.clear();
    }
}
