package comp3350.go2fit.Models;

public class ChallengesModel
{
    private String [] challenges;
    private String [] timeForChallenges;
    private String [] pointsForChallenges;

    public ChallengesModel()
    {
        this.challenges = new String[]{"run 10 km", "100 squats", "77 push-ups", "120 sit-ups", "Run from U of M to Pembina", "bike 25 km"
                ,"squat 5000 pounds", "sprint for 500 meters", "wrestle chuck norris", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups", "Over 9000 chin-ups"};

        this.timeForChallenges = new String[]{"1 hour", "15 minutes", "10 minutes", "15 minutes", "30 minutes", "1 hour"};

        this. pointsForChallenges = new String[]{"40 points", "30 points", "25 points", "25 points", "30 points", "100 points"};
    }

    public String getChallenge(int position)
    {
        assert(position >= 0);
        assert(position <= challenges.length);

        return this.challenges[position];
    }
    public String getTimeOfChallenge(int position)
    {
        assert(position >= 0);
        assert(position <= timeForChallenges.length);

        return this.timeForChallenges[position];
    }
    public String getPointsOfChallenge(int position)
    {
        assert(position >= 0);
        assert(position <= pointsForChallenges.length);

        return this.pointsForChallenges[position];
    }

    public String[] getChallenges()
    {
        return this.challenges;
    }

    public String[] getTimes()
    {
        return this.timeForChallenges;
    }

    public String[] getPoints()
    {
        return this.pointsForChallenges;
    }
}
