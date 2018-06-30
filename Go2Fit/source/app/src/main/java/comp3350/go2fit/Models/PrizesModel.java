package comp3350.go2fit.Models;

public class PrizesModel {
    private int image;
    private String description;
    private int pointsRequired;
    private int id;

    public int getImage()
    {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPointsRequired()
    {
        return this.pointsRequired;
    }

    public int getId() {
        return this.id;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPointsRequired(int pointsRequired) {
        this.pointsRequired = pointsRequired;
    }

    public void setId(int id) {
        this.id = id;
    }
}
