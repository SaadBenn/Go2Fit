package comp3350.go2fit.Models;

public class UserModel {
    int currentChallengeId;
    String name;
    int id;

    public UserModel()
    {
        currentChallengeId = 0;
        id = 0;
    }

    public void setCurrentChallenge(int currentChallengeId)
    {
        this.currentChallengeId = currentChallengeId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public int getCurrentChallenge()
    {
        return currentChallengeId;
    }
    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}
