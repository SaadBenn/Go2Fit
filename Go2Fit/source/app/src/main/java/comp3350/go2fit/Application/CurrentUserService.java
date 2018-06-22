package comp3350.go2fit.Application;

public class CurrentUserService {
    private static int userId;

    public static void setUserId(int id)
    {
        userId = id;
    }
    public static int getUserId()
    {
        return userId;
    }
}
