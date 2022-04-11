import java.util.*;

public class Control {

    Map<User, ArrayList<Testing>> DatabaseTesting = new HashMap<>();
    Map<User, ArrayList<Vaccination>> DatabaseVaccination = new HashMap<>();
    private int TotalTestedPatient = 0;
    private int VaccinatedPatients = 0;
    private int PossitiveTested = 0;

    public Control() {

    }

    public void VaccinatePatient(User doctor, User user, Vaccination v)
    {
        if(doctor.getRole() == "Doctor") {
            if (user.isVaccinated() != true) {
                DatabaseVaccination.put(user, new ArrayList<>());
                DatabaseVaccination.get(user).add(v);
                user.setVaccinated(true);
                this.VaccinatedPatients += 1;
            } else {
                DatabaseVaccination.get(user).get(0).setNumberOfShots();
            }
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to vaccinate " + user.getUsername());

    }

    public void TestPatient(User doctor,User user, Testing t)
    {

        if(doctor.getRole() == "Doctor") {
            if (user.isTestedBefore() != true) {
                DatabaseTesting.put(user, new ArrayList<Testing>());
                user.setTestedBefore(true);
            }
            DatabaseTesting.get(user).add(t);
            this.TotalTestedPatient += 1;
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to test " + user.getUsername());
    }

    public void setUserTestResultPossitive(User doctor,User user,int id)
    {
        if(doctor.getRole() == "Doctor") {
            for (int i = 0; i < DatabaseTesting.get(user).size(); i++) {
                if (DatabaseTesting.get(user).get(i).getId() == id) {
                    DatabaseTesting.get(user).get(i).setResult(true);
                    this.PossitiveTested += 1;
                }
            }
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to set test results to " + user.getUsername());
    }

    public void getUserTestInfo(User checker, User patient)    {
        if(checker.getCPR() == patient.getCPR() || checker.getRole() == "Doctor") {
            if (patient.isTestedBefore() != true)
                System.out.println(patient.getUsername() + " is not Tested before");
            else
                System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString());
        }
        else
            System.out.println("You dont have permission do check that patient!");
    }

    public void getUserVaccineInfo(User checker, User user)    {
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {
            if (user.isVaccinated() != true)
                System.out.println(user.getUsername() + " is not Vaccinated");
            else
                System.out.println(user.getUsername() + " is " + DatabaseVaccination.get(user).toString());
        }else
            System.out.println("You dont have permission do check that patient!");
    }

    public void getUserInfo(User checker,User user)
    {
        getUserTestInfo(checker,user);
        getUserVaccineInfo(checker,user);
        getUserAppointments(checker,user);
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

    public void getUserAppointments(User checker,User user)
    {
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {
            if (!user.getAppointment().isEmpty())
                System.out.println(user.getUsername() + " has appointment for " + user.getAppointment());
            else
                System.out.println(user.getUsername() + " has no active appointments.");
        }
        else
            System.out.println("You dont have permission do check that patient!");
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
