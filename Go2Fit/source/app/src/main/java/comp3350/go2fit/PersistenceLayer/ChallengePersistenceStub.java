
package comp3350.go2fit.PersistenceLayer;

import java.util.HashMap;

import comp3350.go2fit.Models.ChallengesModel;

public class ChallengePersistenceStub implements ChallengePersistence{
    private HashMap<Integer, ChallengesModel> challenge;
    private Integer nextId;

    public ChallengePersistenceStub() {
        challenge = new HashMap<Integer, ChallengesModel>();
        nextId = 0;
    }

    public void initializeDatabase() {

        ChallengesModel tempData1 = new ChallengesModel();
        ChallengesModel tempData2 = new ChallengesModel();
        ChallengesModel tempData3 = new ChallengesModel();
        ChallengesModel tempData4 = new ChallengesModel();


        tempData1.setChallengeType("Walking");
        tempData1.setStepsRequired(500);
        tempData1.setId(nextId);
        challenge.put(tempData1.getId(), tempData1);
        nextId++;

        tempData2.setChallengeType("Running");
        tempData2.setStepsRequired(1000);
        tempData2.setId(nextId);
        challenge.put(tempData2.getId(), tempData2);
        nextId++;

        tempData3.setChallengeType("yfty");
        tempData3.setStepsRequired(100);
        tempData3.setId(nextId);
        challenge.put(tempData3.getId(), tempData3);
        nextId++;

        tempData4.setChallengeType("asdfg");
        tempData4.setStepsRequired(5000);
        tempData4.setId(nextId);
        challenge.put(tempData4.getId(), tempData4);
        nextId++;
        // print to the console
        System.out.println("Initialized the database of Goal Info.");
    }

    public void closeStubDatabase() { System.out.println("Closing the database"); }

    public void add(ChallengesModel challengeModel)
    {
        System.out.println("ID IS: "+nextId);
        challengeModel.setId(nextId);
        this.challenge.put(challengeModel.getId(), challengeModel);
        nextId++;
    }

    public ChallengesModel getChallenge(int userId)
    {
        return challenge.get(userId);
    }

    public HashMap<Integer, ChallengesModel> getAllChallenges() {
        return challenge;
    }

    public void clearStubDatabase() { challenge.clear(); }
}
