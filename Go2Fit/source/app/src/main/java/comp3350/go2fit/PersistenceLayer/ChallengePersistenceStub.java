
package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

import comp3350.go2fit.Models.ChallengesModel;

/**challenges persistence stub**/
public class ChallengePersistenceStub implements ChallengePersistence
{
    private LinkedHashMap<Integer, ChallengesModel> challenge;
    private Integer nextId;

    public ChallengePersistenceStub()
    {
        this.challenge = new LinkedHashMap<>();
        this.nextId = 0;
    }

    public void initializeDatabase()
    {

        ChallengesModel tempData1 = new ChallengesModel();
        ChallengesModel tempData2 = new ChallengesModel();
        ChallengesModel tempData3 = new ChallengesModel();
        ChallengesModel tempData4 = new ChallengesModel();


        tempData1.setChallengeName("Saads epic challenge!");
        tempData1.setChallengeType("Walking");
        tempData1.setStepsRequired(500);
        tempData1.setTime(876543);
        tempData1.setId(nextId);
        challenge.put(tempData1.getId(), tempData1);
        nextId++;

        tempData2.setChallengeName("Eddies IMPOSSIBLE challenge!!!");
        tempData2.setChallengeType("Running");
        tempData2.setStepsRequired(1000);
        tempData2.setTime(123456);
        tempData2.setId(nextId);
        challenge.put(tempData2.getId(), tempData2);
        nextId++;

        tempData3.setChallengeName("Soni's ultimate challenge!");
        tempData3.setChallengeType("Walking");
        tempData3.setStepsRequired(100);
        tempData3.setTime(1223232);
        tempData3.setId(nextId);
        challenge.put(tempData3.getId(), tempData3);
        nextId++;

        tempData4.setChallengeName("Shuo's INSANE challenge!!!");
        tempData4.setChallengeType("Running");
        tempData4.setStepsRequired(5000);
        tempData4.setTime(12345699);
        tempData4.setId(nextId);
        challenge.put(tempData4.getId(), tempData4);
        nextId++;

        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase()
    {
        System.out.println("Closing the database");
    }

    public boolean add(ChallengesModel challengeModel)
    {
        System.out.println("ID IS: "+nextId);
        challengeModel.setId(nextId);
        this.challenge.put(challengeModel.getId(), challengeModel);
        nextId++;
        return true;
    }

    /**Accessors**/
    public ChallengesModel getChallenge(int userId)
    {
        return this.challenge.get(userId);
    }

    public String getChallengeType(int userId)
    {
        return this.challenge.get(userId).getChallengeType();
    }

    public String getChallengeName(int userId)
    {
        return  this.challenge.get(userId).getChallengeName();
    }

    public ChallengesModel getProgress(int userId)
    {
        return this.challenge.get(userId);
    }

    public LinkedHashMap<Integer, ChallengesModel> getAllChallenges()
    {
        return this.challenge;
    }

    public void clearStubDatabase()
    {
        this.challenge.clear();
    }
}
