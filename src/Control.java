import java.util.*;

public class Control {

    Map<User, ArrayList<Testing>> DatabaseTesting = new HashMap<>();
    Map<User, ArrayList<Vaccination>> DatabaseVaccination = new HashMap<>();
    private int TotalTestedPatient = 0;
    private int VaccinatedPatients = 0;
    private int PossitiveTested = 0;

    public Control() {
    }

//    public void VaccinatedPatient(User user, Vaccination v)
//    {
//        DatabaseVaccination.put(user,new ArrayList<Vaccination>());
//        DatabaseVaccination.get(user).add(v);
//    }
//
//    public void putNewVaccineShot(User user)
//    {
//        DatabaseVaccination.get(user).get(0).setNumberOfShots();
//    }


    public void VaccinatePatient(User user, Vaccination v)
    {
        if (user.isVaccinated() != true) {
            DatabaseVaccination.put(user,new ArrayList<>());
            DatabaseVaccination.get(user).add(v);
            user.setVaccinated(true);
            this.VaccinatedPatients +=1;
        }
        else
        {
            DatabaseVaccination.get(user).get(0).setNumberOfShots();
        }

    }

    public void TestPatient(User user, Testing t)
    {
        if (user.isTestedBefore() != true) {
            DatabaseTesting.put(user, new ArrayList<Testing>());
            user.setTestedBefore(true);
        }
        DatabaseTesting.get(user).add(t);
        this.TotalTestedPatient += 1;
    }

    public void setUserTestResultPossitive(User user,int id)
    {
        for (int i = 0; i < DatabaseTesting.get(user).size(); i++)
        {
            if(DatabaseTesting.get(user).get(i).getId() == id)
            {
                DatabaseTesting.get(user).get(i).setResult(true);
                this.PossitiveTested += 1;
            }
        }
    }

    public void getUserTestInfo(User user)    {
        if (user.isTestedBefore() != true)
            System.out.println(user.getUsername() + " is not Tested before");
        else
            System.out.println(user.getUsername() + " is " + DatabaseTesting.get(user).toString());
    }

    public void getUserVaccineInfo(User user)    {
        if (user.isVaccinated() !=true)
            System.out.println(user.getUsername() + " is not Vaccinated");
        else
            System.out.println(user.getUsername() + " is " + DatabaseVaccination.get(user).toString());
    }

    public void getUserInfo(User user)
    {
        getUserTestInfo(user);
        getUserVaccineInfo(user);
        getUserAppointments(user);
    }

    public void getTotalTestedPatient() {
        System.out.println( this.TotalTestedPatient);
    }

    public void getVaccinatedPatients() {
        System.out.println( this.VaccinatedPatients);
    }

    public void getNumberOfPositiveTested() {
        System.out.println( this.PossitiveTested);
    }

    public void getUserAppointments(User user)
    {
        if (!user.getAppointment().isEmpty())
            System.out.println(user.getUsername() + " has appointment for " + user.getAppointment());
        else
            System.out.println(user.getUsername() + " has no active appointments.");
    }

    public void setUserAppointments(User user, String date)
    {
        user.setAppointment(date);
    }

    public void getStatistics()
    {
        System.out.println("People vaccinated: " + this.VaccinatedPatients  + " | People Tested: " +this.TotalTestedPatient + " | Positive Tested: " + this.PossitiveTested);
    }
}
