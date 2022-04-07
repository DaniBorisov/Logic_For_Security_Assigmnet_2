
import java.util.*;
public class test
{

    public static class User
    {

        private String Username;
        private String Password;

        public  User (String username, String password)
        {
            this.Password = password;
            this.Username = username;
        }
            public String getUsername()
            {
                return this.Username;
            }

            public String getPassword()
            {
                return this.Password;
            }
        }

    public static void main(String[] args)
    {
            // Initializing a Dictionary
            Map<User,tuple> geek = new HashMap<>() ;


            User us1 = new User("name","sdasdasdas");
            User us2 = new User("Nonamew","dasdas");
            // put() method
//		geek.put("123", "Code");
//        geek.put("555", us1);
        geek.put(us1,us2);
//		geek.put("456", "Program");

//        User p1 = geek.get(us1);
        geek.remove(us1);
        System.out.println(geek.get(us1));

            // elements() method :
//		for (Enumeration i = geek.elements(); i.hasMoreElements();)
//            {
//                System.out.println("Value in Dictionary : " + i.nextElement());
//            }

            // get() method :
		System.out.println("\nValue at key = 6 : " + geek.get("6"));
		System.out.println("Value at key = 456 : " + geek.get("123"));

//            // isEmpty() method :
//		System.out.println("\nThere is no key-value pair : " + geek.isEmpty() + "\n");
//
//            // keys() method :
//		for (Enumeration k = geek.keys(); k.hasMoreElements();)
//            {
//                System.out.println("Keys in Dictionary : " + k.nextElement());
//            }
            // remove() method :
		System.out.println("\nRemove : " + geek.remove("123"));
		System.out.println("Check the value of removed key : " + geek.get("123"));

		System.out.println("\nSize of Dictionary : " + geek.size());

        }
    }
