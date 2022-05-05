public class Main {

    public static void main(String[] args) {

        Hospital hospital = new Hospital();
        User u1 = new User("Daniel",123,"Doctor");
        User u2 = new User("Aleberto",987,"patient");
        User u3 = new User("Niels",741,"patient");

        Testing t1 = new Testing("Rapid","02.05.22", 123);
        Testing t2= new Testing("PCR", "15.15.22",321);

        Vaccination v1 = new Vaccination("Moderna","05.04.21");

        Testing t3 = new Testing("Rapid","02.05.22", 963);
        Testing t4= new Testing("PCR", "15.15.22",456);
        Testing t5 = new Testing("Rapid","02.05.22", 789);
        Testing t6= new Testing("PCR", "15.15.22",741);

        Vaccination v2 = new Vaccination("Moderna","05.04.21");

        hospital.TestPatient(u1,u1,t1);
        hospital.TestPatient(u1,u1,t2);

        hospital.TestPatient(u1,u2,t3);
        hospital.TestPatient(u1,u2,t4);
        hospital.TestPatient(u1,u2,t5);
        hospital.TestPatient(u1,u2,t6);


        hospital.VaccinatePatient(u1,u1,v1);
        hospital.VaccinatePatient(u1,u1,v1);

        hospital.VaccinatePatient(u2,u3,v2);
        hospital.VaccinatePatient(u1,u3,v2);
        hospital.VaccinatePatient(u1,u3,v2);

        hospital.setUserTestResultPositive(u1,u1,321);


        hospital.setUserTestResultPositive(u1,u2,963);
        hospital.setUserTestResultPositive(u1,u2,741);

        hospital.setUserAppointments(u1,"10.10.22");

        hospital.getUserTestInfoDoctor(u2,u1);
        hospital.getUserInfo(u1,u1);
        hospital.getUserInfo(u1,u2);
        hospital.getUserInfo(u3,u3);

        hospital.getStatistics();
    }

}
