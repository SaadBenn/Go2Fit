package comp3350.go2fit;

public class UserInfo {
    String currentChallenge;
    String name;

    public UserInfo(String currentChallenge, String name)
    {
        this.currentChallenge = currentChallenge;
        this.name = name;
    }

    public void setCurrentChallenge(String currentChallenge)
    {
        this.currentChallenge = currentChallenge;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getCurrentChallenge()
    {
        return currentChallenge;
    }
    public String getName()
    {
        return name;
    }
}
