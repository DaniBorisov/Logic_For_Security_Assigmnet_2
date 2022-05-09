import java.util.*;

public class Hospital {

    Map<User, ArrayList<Testing> > DatabaseTesting = new HashMap<>(); //  DatabaseVaccination_ = {(shs:shs), (User: user, shs)}
    Map<User, ArrayList<Vaccination>> DatabaseVaccination = new HashMap<>(); //  DatabaseVaccination_ = {(shs:shs), (User: user, shs)}
    private int TotalTestedPatient = 0; // {shs:shs}
    private int VaccinatedPatients = 0; // {shs:shs}
    private int PossitiveTested = 0;    // {shs:shs}

    public Hospital() {

    }
    //                            {shs:shs}, {shs:shs} {user:user,shs}, {shs:shs} {user:user,shs}
    public void VaccinatePatient(User doctor, User user, Vaccination v) {
        // (Outer)
        if (doctor.getRole() == "Doctor") { // {shs: shs}

            // if_act_for(VaccinatePatient,shs)
            // declassify(user.isVaccinated()){{user:user,shs}}
            // (Inner)
            if (!user.isVaccinated()) { // {(shs:shs)}
                DatabaseVaccination.put(user, new ArrayList<>());         // Flow  outer implicit  {shs:shs} -> {(shs:shs), (User: user, shs)}
                // Flow inner implicit: {(shs:shs)} -> {(shs:shs), (User: user, shs)}
                // Explicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}

                DatabaseVaccination.get(user).add(v);                    // Flow outer implicit: {shs:shs} -> {(shs:shs), (User: user, shs)}
                // Flow inner implicit: {(shs:shs)} -> {(shs:shs), (User: user, shs)}
                // Explicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}

                user.setVaccinated(true); //                             // Flow outer implicit: {shs:shs} -> {(shs:shs), (User: user, shs)}
                // Flow inner implicit: {(shs:shs)} -> {(shs:shs), (User: user, shs)}
                // Explicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}

                this.VaccinatedPatients += 1;                            // Flow outer implicit:  {shs:shs} -> {shs:shs}
                // Flow  inner implicit: {(shs:shs)} -> {shs:shs},
                // Explicit: {shs: shs} -> {shs: shs}
            } else {
                DatabaseVaccination.get(user).get(0).setNumberOfShots();    // Flow inner implicit: {shs: shs} -> {{(shs:shs), (User: user, shs)}
                // Flow outer implicit: {shs:shs} -> {{(shs:shs), (User: user, shs)}
                // Explicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}
            }
        } else
            System.out.println(doctor.getUsername() + " does not have permission to vaccinate " + user.getUsername());
        // Flow outer implicit {shs:shs} -> {(shs:shs), (User: user, shs)}
    }


                            // {shs: shs}, {(shs: shs) ,(user: user, shs)}
    public void TestPatient(User doctor,User user, Testing t)
    {
        // (Outer)
        if(doctor.getRole() == "Doctor") { // {shs: shs}
            if (!user.isTestedBefore() ) {  // {user: user, shs}
                DatabaseTesting.put(user, new ArrayList<Testing>());    // implicit  {shs:shs} -> {shs:shs}
                                                                        // Explicit, implicit: {user: user, shs} -> {shs:shs}

                user.setTestedBefore(true);                             // Flow outer implicit: {shs:shs} -> {(shs:shs), (User: user, shs)}
                                                                        // Flow inner implicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}
                                                                        // Explicit: {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}
            }
            DatabaseTesting.get(user).add(t);                           // Flow outer implicit: {shs:shs} -> {(shs:shs), (User: user, shs)}
                                                                        // Explicit {(shs:shs), (User: user, shs)} -> {(shs:shs), (User: user, shs)}

            this.TotalTestedPatient += 1;           // Flow outer implicit: {shs: shs}-> {shs: shs}
                                                    // Explicit: {shs: shs} -> {shs: shs}
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to test " + user.getUsername()); // Flow outer implicit {shs:shs} -> {(shs:shs), (User: user, shs)}
    }


                                           // {shs: shs} {user: user, shs} {user: user, shs}
    public void setUserTestResultPositive(User doctor, User user, int id)
    {
        int counter = 0; // {(shs:shs)}
        // (Outer)
        if(doctor.getRole() == "Doctor") {      // {shs: shs}
            // for loop
            for (int i = 0; i < DatabaseTesting.get(user).size(); i++) { // {}

                // if_act_for(setUserTestResultPositive,shs)
                // DatabaseTesting // declassify(DatabaseTesting){user:user,shs}
                // end_act_for

                // (Inner)
                if (DatabaseTesting.get(user).get(i).getId() == id) {
                    DatabaseTesting.get(user).get(i).setResult(true);   // for_loop implicit {} ->  {shs:shs}
                                                                        // outer implicit:  {shs: shs} -> {shs:shs}
                                                                        // inner implicit: {shs:shs} -> {shs:shs}
                                                                        // Explicit: {shs:shs} -> {shs:shs}

                    counter += 1;                           // for_loop implicit {} ->  {shs: shs}
                                                            // outer implicit  {shs:shs} -> {shs:shs}
                                                            // inner implicit  {shs:shs} -> {shs:shs} | explicit:  {shs:shs} -> {shs:shs}
                }
            }
            this.PossitiveTested = counter;  // {shs: shs} -> {shs: shs}
        }
        else
            System.out.println(doctor.getUsername() + " does not have permission to set test results to " + user.getUsername());
            // outer implicit {shs:shs} -> {(shs:shs), (User: user, shs)}

    }


                    // {(shs: shs) ,(user: user, shs)}, {(shs: shs) ,(user: user, shs)}
    public void getUserTestInfo(User checker, User patient)    {
        // (Outer)
        if(checker.getCPR() == patient.getCPR()) { //  {shs: shs} {user: user, shs}
            // (Inner)
            if (!patient.isTestedBefore())
                System.out.println(patient.getUsername() + " is not Tested before");    // Flow outer implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
                                                                                        // Flow inner implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
            else
                System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString());
                // Flow outer implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
                // Flow inner implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
        }
        else
            System.out.println("You dont have permission do check that patient!");  //implicit: {shs:shs} -> {shs: shs} {user: user, shs}
    }

                         //{shs: shs}, {(shs: shs) ,(user: user, shs)}
    public void getUserTestInfoDoctor(User checker, User patient)    {
        // (Outer)
        if(checker.getRole() == "Doctor") {     // {shs: shs}
            // (Inner)
            if (!patient.isTestedBefore())
                System.out.println(patient.getUsername() + " is not Tested before");    // Flow outer implicit: {shs:shs} -> {(shs: shs) ,(user: user, shs)}
                                                                                        // Flow inner implicit: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)}
            else
                System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString());
            // Flow outer implicit: {shs:shs} -> {shs: shs} {user: user, shs}
            // Flow inner implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
        }
        else
            System.out.println("You dont have permission do check that patient!");      //implicit: {shs:shs} -> {shs: shs}
    }


                    // {(shs: shs) ,(user: user, shs)} , {{(shs: shs) ,(user: user, shs)}  \\\ left side is when checker is a patient | right side is when checker is doctor
    public void getUserVaccineInfo(User checker, User user)    {
        // (Outer)
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") { //  {(shs: shs) ,(user: user, shs)}  | {shs:shs}
            // (Inner)
            if (user.isVaccinated() != true) // {(shs: shs) ,(user: user, shs)}
                System.out.println(user.getUsername() + " is not Vaccinated");
            // Flow outer implicit: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)} | {shs:shs} -> {(shs: shs) ,(user: user, shs)}
            // Flow inner implicit: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)} | {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)}
            else
                System.out.println(user.getUsername() + " is " + DatabaseVaccination.get(user).toString());
            // Flow outer implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs} | {shs:shs} -> {shs: shs} {user: user, shs}
            // Flow inner implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs} | {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
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
        // if_act_for(this.TotalTestedPatient,shs)
        System.out.println( this.TotalTestedPatient); // declassify(this.TotalTestedPatient){} | valid_declass(shs,this.TotalTestedPatient_,{})
        //  this.TotalTestedPatient_ | {shs:shs} -> {}
    }

    public void getVaccinatedPatients() {
        // if_act_for(this.VaccinatedPatients,shs)
        System.out.println( this.VaccinatedPatients); // declassify(this.VaccinatedPatients){} | valid_declass(shs,this.VaccinatedPatients_,{})
        //  this.VaccinatedPatients | {shs:shs} -> {}
    }

    public void getNumberOfPositiveTested() {
        // if_act_for(this.PossitiveTested,shs)
        System.out.println( this.PossitiveTested); // declassify(this.PossitiveTested){} | valid_declass(shs,this.PossitiveTested_,{})
        //  this.PossitiveTested | {shs:shs} -> {}
    }


            // {(shs: shs) ,(user: user, shs)} , {(shs: shs) ,(user: user, shs)}  \\\ left side is when checker is a patient | right side is when checker is doctor
     public void getUserAppointments(User checker,User user)
    {
        // (Outer)
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {  //  {(shs: shs) ,(user: user, shs)}  | {shs:shs}
            // (Inner)
            if (!user.getAppointment().isEmpty())
                System.out.println(user.getUsername() + " has appointment for " + user.getAppointment());
                // Flow outer implicit: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)} | {shs:shs} -> {(shs: shs) ,(user: user, shs)}
                // Flow inner implicit: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)} | {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)}
            else
                System.out.println(user.getUsername() + " has no active appointments.");
            // Flow outer implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs} | {shs:shs} -> {shs: shs} {user: user, shs}
            // Flow inner implicit: {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs} | {shs: shs} {user: user, shs} -> {shs: shs} {user: user, shs}
        }
        else
            System.out.println("You dont have permission do check that patient!");  // //implicit: {shs:shs} -> {shs:shs}
    }

    public void setUserAppointments(User user, String date)
    {
        user.setAppointment(date); // Explicit flow: {(shs: shs) ,(user: user, shs)} -> {(shs: shs) ,(user: user, shs)}

    }

    public void getStatistics()
    {                                               // {⊥}
        System.out.println("People vaccinated: " + this.VaccinatedPatients  + " | People Tested: " +this.TotalTestedPatient + " | Positive Tested: " + this.PossitiveTested);
    }
}
