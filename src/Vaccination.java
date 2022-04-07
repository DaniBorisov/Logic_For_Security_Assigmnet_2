import java.util.Date;

public class Vaccination extends Record{

    private String Type;
    private int numberOfShots=0;
    private boolean vaccinated=false;
    private Date date;

    public Vaccination(String Type,Date date)
    {
        this.Type = Type;
        this.date = date;
        this.vaccinated=true;
    }

    public String getType() {
        return Type;
    }

    @Override
    void setType() {

    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public Date getDate() {
        return date;
    }

    @Override
    void setDate() {

    }

    public void setType(String type) {
        Type = type;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
