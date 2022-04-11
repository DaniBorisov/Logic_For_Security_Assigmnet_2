import java.util.Date;

public class Vaccination{

    private String Type;
    private int numberOfShots;
    private boolean vaccinated=false;
    private String date;

    public Vaccination(String Type,String date)
    {
        this.Type = Type;
        this.date = date;
        this.vaccinated=true;
        this.numberOfShots = 1;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setNumberOfShots() {
        this.numberOfShots +=1;
    }

    public String getDate() {
        return this.date;
    }

    public String getType() {
        return this.Type;
    }

    void setType(String type) {
        this.Type = type;
    }

    public String toString()
    {
        return "Vaccinated with " + this.Type + " at: " +this.date + "  number of shots: " + this.numberOfShots;
    }
}
