package comp3350.go2fit.PersistenceLayer;

import java.util.Map;

import comp3350.go2fit.Models.UserModel;

/**user persistence interface**/
public interface UserPersistence
{
    void      add(final UserModel progress);
    boolean   update(UserModel user);
    UserModel getUser(int userId);
    Map<Integer, UserModel>   getAllUsers();
}
