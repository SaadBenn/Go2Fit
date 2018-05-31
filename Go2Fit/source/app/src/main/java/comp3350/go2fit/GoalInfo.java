package comp3350.go2fit;

class GoalInfo {

private String goalInfo;
private String durationTime;
private String day;
private int distance;
private double calories;
private int pointsEarned;
private int requiredNumberOfSteps;
private int currentStepsCompleted;
private double percentageOfChallenge;
private double caloriesLostPerChallenge;


public GoalInfo(String goalInfo, String durationTime, String day, int distance, int pointsEarned, int requiredNumberOfSteps, int currentStepsCompleted, double percentageOfChallenge, double caloriesLostPerChallenge) {
        this.goalInfo = goalInfo;
        this.durationTime = durationTime;
        this.day = day;
        this.distance = distance;
        this.requiredNumberOfSteps = requiredNumberOfSteps;
        this.currentStepsCompleted = currentStepsCompleted;
        this.percentageOfChallenge = percentageOfChallenge;
        this.caloriesLostPerChallenge = caloriesLostPerChallenge;
        }

// mutators
public void setGoalInfo(String goalInfo) { this.goalInfo = goalInfo; }
public void setDurationTime(String durationTime) { this.durationTime = durationTime; }
public void setDay(String day) { this.day = day; }
public void setDistance(int distance) { this.distance = distance; }
public void setrequiredNumberOfSteps(int requiredNumberOfSteps) { this.requiredNumberOfSteps = requiredNumberOfSteps; }
public void setcurrentStepsCompleted(int currentStepsCompleted) { this.currentStepsCompleted = currentStepsCompleted; }
public void setpercentageOfChallenge(double percentageOfChallenge) { this.percentageOfChallenge = percentageOfChallenge; }
public void setcaloriesLostPerChallenge(double caloriesLostPerChallenge) { this.caloriesLostPerChallenge = caloriesLostPerChallenge; }

// accessors
public String getGoalInfo() { return this.goalInfo; }
public String getDurationTime() { return this.durationTime; }
public String getDay() { return this.day; }
public int getDistance() { return this.distance; }
public int getrequiredNumberOfSteps() { return requiredNumberOfSteps; }
public int getcurrentStepsCompleted() { return currentStepsCompleted; }
public double getpercentageOfChallenge() { return percentageOfChallenge; }
public double getcaloriesLostPerChallenge() { return caloriesLostPerChallenge; }
        }
