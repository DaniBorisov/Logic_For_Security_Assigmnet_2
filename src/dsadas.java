import java.util.ArrayList;

public class dsadas {
public void VaccinatePatient(User doctor, User user, Vaccination v) // S0_  | S0_ <=  S2_ |  S0_ <= {shs:shs}
{
    if(doctor.getRole() == "Doctor") {  // { S2_  |  S2_ <= S1_ /\ s3_   |  S2_ <= {shs:shs} /\ {shs:shs}| {shs:shs} <= {shs:shs}
        if (!user.isVaccinated()) { //  S1_ | S1_ <= s1 /\ s2  | S1_ <= {(shs:shs), (User: user, shs)} /\  {shs:shs}
                                    // | {(shs:shs), (User: user, shs)} <= {shs:shs}
             //s1
            // s1_  = a_ /\ b_ /\ c_ /\ d_
            DatabaseVaccination.put(user, new ArrayList<>());   //  a_ | {(shs:shs), (User: user, shs)} <= a_
            DatabaseVaccination.get(user).add(v);               // b_  | {(shs:shs), (User: user, shs)} <= b_
            user.setVaccinated(true);                           // c_  | {(shs:shs), (User: user, shs)} <= c_
            this.VaccinatedPatients += 1;                       // d_  | {shs:shs} <= d_
        } else {
            // s2_ = e_
            DatabaseVaccination.get(user).get(0).setNumberOfShots();  // e_ |  {(shs:shs), (User: user, shs)} <= e_
        }
    }
    else
       // s3_   | {shs:shs} <= s3_
        System.out.println(doctor.getUsername() + " does not have permission to vaccinate " + user.getUsername());
}
// {(shs:shs), (User: user, shs)} <= a_
// {(shs:shs), (User: user, shs)} <= b_
// {(shs:shs), (User: user, shs)} <= c_
// {shs:shs} <= d_
// {(shs:shs), (User: user, shs)} <= e_
// {shs:shs} <= s3_

//  s1_  <= a_ /\ b_ /\ c_ /\ d_  -> {(shs:shs), (User: user, shs)} /\ {(shs:shs), (User: user, shs)}
//                                    /\ {(shs:shs), (User: user, shs)}  /\ {shs:shs} | s1_<= {shs:shs} |
//  s2_ <= e_   ->   s2_ <= {(shs:shs), (User: user, shs)}
// S1_ <= s1_ /\ s2_  ->  {shs:shs} /\ {(shs:shs), (User: user, shs)} -> S1_ <= {shs:shs}
// S2_ <= S1_ /\ s3_  ->  {shs:shs} /\ {shs:shs} -> S2_ <= {shs:shs}
// S0_ <=  S2_ |  S0_ <= {shs:shs}



public void TestPatient(User doctor,User user, Testing t) // S0_  | S0_ <=  S1_ |  S0_ <= {shs:shs}
{
    if(doctor.getRole() == "Doctor") { // {shs: shs} // S1_ | S1_ <= s2_ /\ s3_
        //s2 <= s1_ /\ c_ /\ d_
        if (!user.isTestedBefore() ) { // s1_ <= a_ /\ b_
            DatabaseTesting.put(user, new ArrayList<Testing>());   //  a_ | {(shs:shs), (User: user, shs)} <= a_
            user.setTestedBefore(true);                            //  b_ | {(shs:shs), (User: user, shs)} <= b_
        }
        DatabaseTesting.get(user).add(t);                          //  c_ | {(shs:shs), (User: user, shs)} <= c_
        this.TotalTestedPatient += 1;                              //  d_ | {shs:shs} <= d_
    }
    else
        // s3_ | {shs:shs} <= s3_
        System.out.println(doctor.getUsername() + " does not have permission to test " + user.getUsername());
}
// {(shs:shs), (User: user, shs)} <= a_
// {(shs:shs), (User: user, shs)} <= b_
// {(shs:shs), (User: user, shs)} <= c_
// {shs:shs} <= d_
// {shs:shs} <= s3_

// s1_ <= a_ /\ b_ -> s1_ <= {(shs:shs), (User: user, shs)} /\ {(shs:shs), (User: user, shs)}  | s1_ <= {(shs:shs), (User: user, shs)}
// s2 <= s1_ /\ c_ /\ d_ ->  s2 <= {(shs:shs), (User: user, shs)} /\ {(shs:shs), (User: user, shs)} /\ {shs:shs} | s2_ <= {shs:shs}
// S1_ <= s2_ /\ s3_  -> S1_ <= {shs:shs} /\  {shs:shs} | S1_ <= {shs:shs}
// S0_ <=  S1_ |  S0_ <= {shs:shs}



public void setUserTestResultPositive(User doctor, User user, int id)  // S0  | S0_ <=  S3_ /\ b_
{
    int counter = 0; // b_  | {shs:shs} <= b_
    if(doctor.getRole() == "Doctor") { //S3_ = S2 /\ c_ /\ s2_ | S3_  <= {shs:shs} /\ {shs:shs} /\ {shs:shs}-> S2_  {shs:shs} <= {shs:shs}
        for (int i = 0; i < DatabaseTesting.get(user).size(); i++) // S2_ = S1 |  S2_ <= S1 ->  S2_  {} <= {shs:shs}
        {
            if (DatabaseTesting.get(user).get(i).getId() == id) // S1_ =  s1 | S1_ <= s1  | {(shs:shs), (User: user, shs)} <= SHS:SHS}
            {
            // s1_
                DatabaseTesting.get(user).get(i).setResult(true);   // a_  | {(shs:shs), (User: user, shs)} <= a_
                counter += 1;                                       // b_  | {shs:shs} <= b_
            }
        }
        this.PossitiveTested = counter;  // c_ |   {shs:shs} <= c_
    }
    else
        // s2_ | {shs:shs} <= s2_
        System.out.println(doctor.getUsername() + " does not have permission to set test results to " + user.getUsername());
}

// {} <= i_
// {shs:shs} <= a_
// {shs:shs} <= b_
// {shs:shs} <= c_
// {shs:shs} <= s2_

// S1_ <= a_ /\ b_ ->   {shs:shs} /\ {shs:shs} -> S1_<= {shs:shs}   |{SHS:SHS} <= {SHS:SHS}
// S2_ <= S1 ->  S2_ <= {shs:shs} | {SHS:SHS} <= {SHS:SHS}
// S3_ = S2 /\ c_ /\ s2_ ->  {shs:shs} /\ {shs:shs} /\ {shs:shs} -> S3_  <= {shs:shs}  | {SHS:SHS} <= {shs:shs}
// S0_ <=  S3_ /\ b_  -> {shs:shs} /\ {shs:shs} S0 <= {shs:shs}

                        //  {user: user, shs} {user: user, shs}
public void getUserTestInfo(User checker, User patient)  { // S0_ | S0_ <= S2_
    if(checker.getCPR() == patient.getCPR()) { // S2_ | S2_ <= S1_
        if (!patient.isTestedBefore()) //   S1_ | S1_ <= a /\ b
            System.out.println(patient.getUsername() + " is not Tested before");    // {(shs:shs), (User: user, shs)} <= a_
        else
            System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString()); // {(shs:shs), (User: user, shs)} <= b_
    }
    else
        System.out.println("You dont have permission do check that patient!");
}

// {User: user} <= a_
// {(shs:shs), (User: user, shs)} <= b_
// S1_ <= a /\ b  ->  S1_ <=  {(shs:shs), (User: user, shs)}  /\ {(shs:shs), (User: user, shs)} | S1_ <= {(shs:shs), (User: user, shs)}
// S2_ <= S1_
// S0_ <= S2_ -> S0_ <= {(shs:shs), (User: user, shs)}


                                // {shs: shs}   {user: user,  shs}
public void getUserTestInfoDoctor(User checker, User patient)    { // S0_ | S0_ <= S2_
    if(checker.getRole() == "Doctor") {    // S2_ | S2_ <= S1_
       if (!patient.isTestedBefore()) // S1_ | S1_ <= a /\ b
            System.out.println(patient.getUsername() + " is not Tested before"); // {(shs:shs), (User: user, shs)} <= a_
        else
            System.out.println(patient.getUsername() + " is " + DatabaseTesting.get(patient).toString()); // {(shs:shs), (User: user, shs)} <= b_
    }
    else
        System.out.println("You dont have permission do check that patient!");
}
// {User: user} <= a_
// {(shs:shs), (User: user, shs)} <= b_
// S1_ <= a /\ b  ->  S1_ <=  {(shs:shs), (User: user, shs)}  /\ {(shs:shs), (User: user, shs)} | S1_ <= {(shs:shs), (User: user, shs)}
// S2_ <= S1_
// S0_ <= S2_ -> S0_ <= {(shs:shs), (User: user, shs)}


            // [{user: user, shs} , {shs:shs}] , {user: user, shs}
public void getUserVaccineInfo(User checker, User user)    {  // S0_ | S0_ <= S2_
    if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {  // S2_ | S2_ <= S1_
        if (user.isVaccinated() != true)  // S1_ | S1_ <= a /\ b
            System.out.println(user.getUsername() + " is not Vaccinated"); // {(shs:shs), (User: user, shs)} <= a_
        else
            System.out.println(user.getUsername() + " is " + DatabaseVaccination.get(user).toString()); // {(shs:shs), (User: user, shs)} <= b_
    }else
        System.out.println("You dont have permission do check that patient!");
}
// {User: user} <= a_
// {(shs:shs), (User: user, shs)} <= b_
// S1_ <= a /\ b  ->  S1_ <=  {(shs:shs), (User: user, shs)}  /\ {(shs:shs), (User: user, shs)} | S1_ <= {(shs:shs), (User: user, shs)}
// S2_ <= S1_
// S0_ <= S2_ -> S0_ <= {(shs:shs), (User: user, shs)}




    public void getUserAppointments(User checker,User user)  // S0_ | S0_ <= S2_
    {
        if(checker.getCPR() == user.getCPR() || checker.getRole() == "Doctor") {   // S2_ | S2_ <= S1_
            if (!user.getAppointment().isEmpty()) // S1_ | S1_ <= a /\ b
                System.out.println(user.getUsername() + " has appointment for " + user.getAppointment()); // {User: user, shs} <= a_
            else
                System.out.println(user.getUsername() + " has no active appointments.");  // {User: user, shs} <= b_
        }
        else
            System.out.println("You dont have permission do check that patient!");
    }
// {User: user, shs} <= a_
// {User: user, shs} <= b_
// S1_ <= a /\ b  ->  S1_ <=  {User: user, shs}  /\ {User: user, shs} | S1_ <= {User: user, shs}
// S2_ <= S1_
// S0_ <= S2_ -> S0_ <= {User: user, shs}


    public void setUserAppointments(User user, String date) // S0_ | S0_ <= a_
    {
        user.setAppointment(date);  // {User: user, shs} <= a_
    }

// {User: user, shs} <= a_
// S0_ | S0_ <= a_


    public void getVaccinatedPatients()
    public void getNumberOfPositiveTested()

    public void getTotalTestedPatient() { // S0_ | S0_ <= s1_
    }
        //s1_ | {} <= s1_
        // if_act_for(this.TotalTestedPatient,shs)
        System.out.println( this.TotalTestedPatient); // declassify(this.TotalTestedPatient){} | valid_declass(shs,this.TotalTestedPatient_,{})
    //  this.TotalTestedPatient_ | {shs:shs} -> {}
        // end_act_for
    }

// {} <= s1_
// S0_ <= s1_


