import java.util.ArrayList;

public class dsadas {


    public void VaccinatePatient(User doctor, User user, Vaccination v)
    {
        if(doctor.getRole() == "Doctor") { // { S2_  | S1_ /\ s3_   doctor.getRole() == "Doctor" <= S1_ /z s3_ |  {shs:shs} <=  {shs:shs} /\ {shs:shs}
            if (!user.isVaccinated()) { //  S1_  s1 /\ s2 | !user.isVaccinated() <= s1/\ s2

                // s1_  = a_ /\ b_ /\ c_ /\ d_
                DatabaseVaccination.put(user, new ArrayList<>());  //    a_  | {shs:shs} <= a_          // Flow implicit  {shs:shs} -> {shs:shs}
                                                                                                        // Flow Explicit, implicit: {user: user, shs} -> {shs:shs}
// either declass or give ownership to user
                DatabaseVaccination.get(user).add(v);               //  b_  |   {shs:shs}  <= b_                      // Flow implicit: {shs:shs} -> {shs:shs}
                // Flow Explicit, implicit: {(user: user, shs) , (shs:shs)} -> {shs:shs}/ not all

                user.setVaccinated(true);                       // c_ | {(User:user,shs) , (SHS:SHS)}  <= c_                                                            //  -||-   {User:suer,shs} -> {user:user ,shs}  | {shs:shs} -> {User:user , shs}
                this.VaccinatedPatients += 1;                   //d_ |  {} <= d_                                                                // Explicit: {⊥} -> {⊥}, Implicit: {shs: shs}-> {⊥}, {user:user,shs} -> {⊥}
             //  {shs:shs} /\   {(User:user,shs) = { (shs:shs) ,(User:shs,user) } \/  {}  {(User:shs) , (shs:shs) }
            } else {
                // s2_ = e_
                DatabaseVaccination.get(user).get(0).setNumberOfShots();  // e_ |  {shs:shs} <= e_

                //  Explicit: {shs: shs} -> {shs: shs}, implicit: {user: shs}, {shs: shs} -> {shs: shs},
            }
        }
        else
            s3_
            System.out.println(doctor.getUsername() + " does not have permission to vaccinate " + user.getUsername()); //{shs:shs} -> {shs:shs}
    }

    {shs:shs} <= a_
    {shs:shs}  <= b_
    {User:user,shs}  <= c_
    {⊥} <= d_

    S1_ = !user.isVaccinated() <= s1/\ s2

     s1 = {shs} {user} {}   = {}
     s2 = {shs}  {shsLshs}  = {shs:Shs}

    S1_  <= {} /\ {shs:shs}
    {User:user,shs} <= {}









public void setUserTestResultPositive(User doctor, User user, int id)  // S0  | S0_ <=  S3_ /\ b_
{
    int counter = 0; // b_  | {shs:shs} <= b_
    if(doctor.getRole() == "Doctor") { //S3_ = S2 /\ c_ /\ s2_ | S3_  <= {shs:shs} /\ {shs:shs} /\ {shs:shs}-> S2_  {shs:shs} <= {shs:shs}
        for (int i = 0; i < DatabaseTesting.get(user).size(); i++) // S2_ = S1 |  S2_ <= S1 ->  S2_  {} <= {shs:shs}
        {
            if (DatabaseTesting.get(user).get(i).getId() == id) // S1_ =  s1 | S1_ <= s1
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






















