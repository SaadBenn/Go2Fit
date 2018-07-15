package comp3350.go2fit.Models;


/**Challenges Model**/
public class AchieveModel
{
    private String achieveName;
    private String achieveType;
    private long   time;
    private int    stepsRequired;
    private int    calories;
    private int    id;

    /**Empty constructor**/
    public  AchieveModel() { }

    /**Constructor overloading**/
    public AchieveModel(String achieveName, String achieveType, int stepsRequired, long time)
    {
        this.achieveName = achieveName;
        this.achieveType = achieveType;
        this.stepsRequired = stepsRequired;
        this.time          = time;
    }
    public double menCalorieBurn(int age,double weight,int heartRate, int timeMinutes){
        return ((age*0.2017)-weight*0.09036+heartRate*0.6309-55.0969)*timeMinutes/4.184;
    }
    public double womenCalorieBurn(int age,double weight,int heartRate, int timeMinutes){
        return ((age*0.074)-weight*0.05741+heartRate*0.4472-20.4022)*timeMinutes/4.184;
    }

    /**Accessors**/
    public String getAchieveName()
    {
        return this.achieveName;
    }

    public String getAchieveType()
    {
        return this.achieveType;
    }

    public int getStepsRequired()
    {
        return this.stepsRequired;
    }

    public long getTime()
    {
        return this.time;
    }

    public int getId()
    {
        return this.id;
    }

    public int getCalories()
    {
        return calories;
    }

    /**Mutators**/
    public void setCalories(int calories)
    {
        this.calories = calories;
    }

    public void setAchieveName(String achieveName)
    {
        this.achieveName = achieveName;
    }

    public void setAchieveType(String achieveType)
    {
        this.achieveType = achieveType;
    }

    public void setStepsRequired(int stepsRequired)
    {
        this.stepsRequired = stepsRequired;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
