
package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.ChallengesModel;

public class ChallengePersistenceStub implements ChallengePersistence{
    private HashMap<Integer, ChallengesModel> challenge;
    private Integer nextId = 0;

    public ChallengePersistenceStub() {
        challenge = new HashMap<Integer, ChallengesModel>();
    }

    public void initializeDatabase() {

        ChallengesModel tempData1 = new ChallengesModel();
        ChallengesModel tempData2 = new ChallengesModel();
        ChallengesModel tempData3 = new ChallengesModel();
        ChallengesModel tempData4 = new ChallengesModel();


        tempData1.setChallengeType("Walking");
        tempData1.setId(0);
        challenge.put(0, tempData1);

        tempData2.setChallengeType("Running");
        tempData2.setId(1);
        challenge.put(1, tempData2);

        tempData3.setChallengeType("yfty");
        tempData3.setId(0);
        challenge.put(2, tempData3);

        tempData4.setChallengeType("asdfg");
        tempData4.setId(1);
        challenge.put(3, tempData4);
        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase() { System.out.println("Closing the database"); }

    public void add(ChallengesModel userProgress)
    {
        userProgress.setId(nextId++);
        this.challenge.put(userProgress.getId(), userProgress);
    }

    public String getChallengeType(int userId){ return challenge.get(userId).getChallengeType();}

    public ChallengesModel getProgress(int userId)
    {
        return challenge.get(userId);
    }

    public HashMap<Integer, ChallengesModel> getAllChallenges() {
        return challenge;
    }

    public void clearStubDatabase() { challenge.clear(); }
}
