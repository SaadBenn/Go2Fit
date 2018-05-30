package comp3350.go2fit;

import java.util.ArrayList;

public class Challenge
{
    private String name;
    private String time;
    private String points;

    public Challenge(String name, String time, String points)
    {
        this.name   = name;
        this.time   = time;
        this.points = points;
    }

    public String getName()
    {
        return this.name;
    }
    public String getTime()
    {
        return this.time;
    }
    public String getPoints()
    {
        return this.points;
    }

    @Override
    public String toString()
    {
        return "name: " + this.name + ", time: " + this.time + ", points: " + this.points;
    }
}
