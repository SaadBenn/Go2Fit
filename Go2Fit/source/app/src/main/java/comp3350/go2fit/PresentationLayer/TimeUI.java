package comp3350.go2fit.PresentationLayer;

public class TimeUI {

    public static String convertToHMS(long milliseconds)
    {
        TimeUI time = new TimeUI();
        String hourString = time.determineHours(milliseconds);
        String minuteString = time.determineMinutes(milliseconds);
        String secondString = time.determineSeconds(milliseconds);

        return hourString + ":" + minuteString + ":" + secondString;
    }
    private String determineHours(long milliseconds)
    {
        String hours = Integer.toString((int)((milliseconds / (1000*60*60)) % 24));

        if(hours.length() == 1)
        {
            hours = "0" + hours;
        }
        return hours;
    }

    private String determineMinutes(long milliseconds)
    {
        String minutes = Integer.toString((int)((milliseconds / (1000*60)) % 60));

        if(minutes.length() == 1)
        {
            minutes = "0" + minutes;
        }
        return minutes;
    }

    private String determineSeconds(long milliseconds)
    {
        String seconds = Integer.toString((int)(milliseconds / 1000) % 60);

        if(seconds.length() == 1)
        {
            seconds = "0" + seconds;
        }
        return seconds;
    }

}
