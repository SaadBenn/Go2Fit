package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.UserModel;

public interface UserPersistence {
    void initializeDatabase();
    void closeStubDatabase();
    void add(final UserModel progress);
    HashMap getAllChallenges();
    UserModel getUser(int userId);
    void clearStubDatabase();
}
