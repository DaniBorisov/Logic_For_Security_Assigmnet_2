import java.util.ArrayList;

public class User {

    private String Username;
    private String Password;
    private int CPR;
    private String Role;
    private boolean isVaccinated = false;
    private boolean testedBefore = false;
    private ArrayList<String> appointments = new ArrayList<>();

    public User (String username, int CPR, String Role)
    {
        this.Username = username;
        this.CPR = CPR;
        this.Role = Role;
    }

    public String getUsername()
    {
        return this.Username;
    }
    public String getRole()
    {
        return this.Role;
    }
    public int getCPR()
    {
        return this.CPR;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public boolean isTestedBefore() {
        return testedBefore;
    }

    public void setTestedBefore(boolean testedBefore) {
        this.testedBefore = testedBefore;
    }

    public void setAppointment(String date)
    {
        appointments.add(date);
    }

    public ArrayList<String> getAppointment()
    {
        return (appointments);
    }

}
