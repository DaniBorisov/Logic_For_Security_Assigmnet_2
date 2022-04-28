import java.util.*;
// ⊥
public class Control {

    Map<User, ArrayList<Testing> > DatabaseTesting = new HashMap<>();
    Map<User, ArrayList<Vaccination>> DatabaseVaccination = new HashMap<>(); // User { } , Test {shs: shs}
    private int TotalTestedPatient = 0;
    private int VaccinatedPatients = 0;
    private int PossitiveTested = 0; // [p:p] ?? label

    public Control() {

    }
                                //    {shs:shs , p:pshs , p:p,shs }
    public void VaccinatePatient(User doctor, User user, Vaccination v)
    {
        if(doctor.getRole() == "Doctor") { // {shs: shs}
            if (!user.isVaccinated()) { // {user: user, shs}
                DatabaseVaccination.put(user, new ArrayList<>());           // implicit  {shs:shs} -> {shs:shs}
                                                                            // Explicit, implicit: {user: user, shs} -> {shs:shs}
                DatabaseVaccination.get(user).add(v);                       // implicit: {shs:shs} -> {shs:shs}
                                                                            // Explicit, implicit: {user: user, shs} -> {shs:shs}

                user.setVaccinated(true); //  -||-
                this.VaccinatedPatients += 1; // Explicit: {⊥} -> {⊥}, Implicit: {shs: shs}-> {⊥},
            } else {
                DatabaseVaccination.get(user).get(0).setNumberOfShots(); // Explicit: {shs: shs} -> {shs: shs}, implicit: {user: shs}, {shs: shs} -> {shs: shs},
            }
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to vaccinate " + user.getUsername()); //{shs:shs} -> {shs:shs}

    }
                            // {shs: shs} {user: user, shs} {user: user, shs}
    public void TestPatient(User doctor,User user, Testing t)
    {
        if(doctor.getRole() == "Doctor") { // {shs: shs}
            if (!user.isTestedBefore() ) {  // {user: user, shs}
                DatabaseTesting.put(user, new ArrayList<Testing>());    // implicit  {shs:shs} -> {shs:shs}
                                                                        // Explicit, implicit: {user: user, shs} -> {shs:shs}

                user.setTestedBefore(true);                             // implicit: {shs:shs} -> {shs:shs}
                                                                        // Explicit, implicit: {user: user, shs} -> {shs:shs}
            }
            DatabaseTesting.get(user).add(t);                            // implicit: {shs:shs} -> {shs:shs}
                                                                        // Explicit, implicit: {user: user, shs} -> {shs:shs}
            this.TotalTestedPatient += 1;          // Explicit: {⊥} -> {⊥}, Implicit: {shs: shs}-> {⊥},
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to test " + user.getUsername());       //{shs:shs} -> {shs:shs}
    }
                                           // {shs: shs} {user: user, shs} {user: user, shs}
    public void setUserTestResultPositive(User doctor, User user, int id)
    {
        int counter = 0; //[shs:shs]
        if(doctor.getRole() == "Doctor") {      // {shs: shs}
            for (int i = 0; i < DatabaseTesting.get(user).size(); i++) {
                if (DatabaseTesting.get(user).get(i).getId() == id) {
                    DatabaseTesting.get(user).get(i).setResult(true);   // Explicit: {user: shs} -> {shs: shs},
                                                                        // Explicit, implicit: {user: user, shs} -> {shs: shs}
                    counter += 1;           // Explicit  {shs:shs} -> {shs:shs}
                                            // implicit  {user: shs}, {shs:shs} -> {shs:shs}
                }
            }
//             if_act_for(counter,shs)  declassification  positiveTested = declassify(count) [{shs, shs} - > {⊥}]
            this.PossitiveTested = counter;  // {⊥} -> {⊥}
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to set test results to " + user.getUsername()); //{shs:shs} -> {shs:shs}
    }
                    //  {user: user, shs} {user: user, shs}
    public void getUserTestInfo(User checker, User patient)    {
        if(checker.getCPR() == patient.getCPR()) { //  {user: user, shs}
            if (!patient.isTestedBefore())
                System.out.println(patient.getUsername() + " is not Tested before");  //2x implicit: {user: user, shs} -> {shs: shs}
            else
                System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString()); //2x implicit: {shs: shs} -> {shs: shs},
        }
        else
            System.out.println("You dont have permission do check that patient!");          //implicit: {shs:shs} -> {shs:shs}
    }
                                     // {shs: shs}   {user: user,  shs}
    public void getUserTestInfoDoctor(User checker, User patient)    {
        if(checker.getRole() == "Doctor") {     // {shs: shs}
            if (!patient.isTestedBefore())
                System.out.println(patient.getUsername() + " is not Tested before");    // implicit: {shs: shs} -> {shs: shs}
                                                                                        // implicit: {user: user, shs} -> {shs: shs}
            else
                System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString()); // implicit: {shs: shs} -> {shs: shs},
        }                                                                                                     // implicit: {user: user, shs} -> {shs: shs}
        else
            System.out.println("You dont have permission do check that patient!");      //implicit: {shs:shs} -> {shs:shs}
    }
                    // [{user: user, shs} , {shs:shs}] , {user: user, shs}
    public void getUserVaccineInfo(User checker, User user)    {
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") { //  {user: user, shs}  | {shs:shs}
            if (user.isVaccinated() != true)
                System.out.println(user.getUsername() + " is not Vaccinated");
            // 2x  implicit: {user: user, shs} -> {shs: shs} | implicit: {shs: shs} -> {shs: shs}
            // explicit: {User:user, shs} -> {user:user}     | explicit: {User:user, shs} -> {shs: shs}, implicit: {user: user, shs} -> {shs: shs}
            else
                System.out.println(user.getUsername() + " is " + DatabaseVaccination.get(user).toString());
            // 2x  implicit: {user: user, shs} -> {shs: shs} |  implicit: {shs: shs} -> {shs: shs},
            //     explicit: {User:user, shs} -> {user:user} |  explicit: {User:user, shs} -> {shs: shs},  implicit: {user: user, shs} -> {shs: shs}
        }else
            System.out.println("You dont have permission do check that patient!");  // //implicit: {shs:shs} -> {shs:shs}
    }

    public void getUserInfo(User checker,User user)
    {
        getUserTestInfo(checker,user);
        getUserVaccineInfo(checker,user);
        getUserAppointments(checker,user);
    }

    public void getTotalTestedPatient() {
        System.out.println( this.TotalTestedPatient);//{⊥}
    }

    public void getVaccinatedPatients() {
        System.out.println( this.VaccinatedPatients);//{⊥}
    }

    public void getNumberOfPositiveTested() {
        System.out.println( this.PossitiveTested);//{⊥}
    }
                            // [ {user: user ,shs}, {shs:shs}]
    public void getUserAppointments(User checker,User user)
    {
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {    //  {user: user, shs}  | {shs:shs}
            if (!user.getAppointment().isEmpty())
                System.out.println(user.getUsername() + " has appointment for " + user.getAppointment());
            //2x implicit: {user: user, shs} -> {user:user, shs} | implicit: {shs: shs} -> {shs: shs}
            //   explicit: {user: user, shs} -> {user:user, shs} | explicit: {User:user, shs} -> {shs: shs}, implicit: {user: user, shs} -> {shs: shs}
            else
                System.out.println(user.getUsername() + " has no active appointments.");
        //2x implicit: {user: user, shs} -> {user:user, shs} | implicit: {shs: shs} -> {shs: shs}
        //   explicit: {user: user, shs} -> {user:user, shs} | explicit: {User:user, shs} -> {shs: shs}, implicit: {user: user, shs} -> {shs: shs}
        }
        else
            System.out.println("You dont have permission do check that patient!");  // //implicit: {shs:shs} -> {shs:shs}
    }

    public void setUserAppointments(User user, String date)
    {
        user.setAppointment(date);
    }

    public void getStatistics()
    {                                               // {⊥}
        System.out.println("People vaccinated: " + this.VaccinatedPatients  + " | People Tested: " +this.TotalTestedPatient + " | Positive Tested: " + this.PossitiveTested);
    }
}
