import java.util.*;


public class Main {

    public static Map<User, ArrayList<Testing>> DatabaseTesting = new HashMap<>();
    public static Map<User, ArrayList<Vaccination>> DatabaseVaccination = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);  // Create a Scanner object

    public static void main(String[] args) {

        Control control = new Control();
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

        control.TestPatient(u1,u1,t1);
        control.TestPatient(u1,u1,t2);

        control.TestPatient(u1,u2,t3);         control.TestPatient(u1,u2,t4);         control.TestPatient(u1,u2,t5);         control.TestPatient(u1,u2,t6);


        control.VaccinatePatient(u1,u1,v1);
        control.VaccinatePatient(u1,u1,v1);

        control.VaccinatePatient(u2,u3,v2);         control.VaccinatePatient(u1,u3,v2);         control.VaccinatePatient(u1,u3,v2);

        control.setUserTestResultPossitive(u1,u1,321);


        control.setUserTestResultPossitive(u1,u2,963);  control.setUserTestResultPossitive(u1,u2,741);

        control.setUserAppointments(u1,"10.10.22");

        control.getUserInfo(u1,u1);
        control.getUserInfo(u1,u2);
        control.getUserInfo(u2,u3);

        control.getStatistics();
    }

}
