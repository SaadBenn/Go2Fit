package comp3350.go2fit.BuisnessLayer;

import java.util.HashMap;
import java.util.Set;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoUserFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.Models.UserModel;

public class UserService {

    public int findUser(HashMap map, String username) throws NoUserFoundException
    {
        Set<Integer> set = map.keySet();

        int index = -1;
        for(Integer value : set)
        {
            UserModel model = (UserModel) map.get(value);

            if(model.getName().equals(username))
            {
                index = value;
            }
        }
        if(index == -1)
        {
            throw new NoUserFoundException("This username doesnt exist!");
        }
        System.out.println("ADSADADFADSDASDASAD"+ index + "\n\n\n\n\n\n");
        return index;
    }

    public void validateNoUser(HashMap users, String username) throws UserExistsException
    {
        Set<Integer> set = users.keySet();

        for(Integer value : set)
        {
            UserModel model = (UserModel) users.get(value);
            if(model.getName().equals(username))
            {
                throw new UserExistsException("This username is already taken!");
            }
        }
    }
}
