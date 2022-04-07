import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LogIn {
//
//    public boolean LogIn(String name, String password) throws NoSuchAlgorithmException, IOException {
//
//        System.out.println("User " + name + " is trying to log in!");
//        String response = null;
//        try {
//            response = userSearch(name, password);
//        } catch (InvalidKeySpecException e) {
//            e.printStackTrace();
//        }
//        System.out.println(response);
//        if (response.matches("LOGIN_SUCCESSFUL"))
//            return true;
//        return false;
//    }

//    private String userSearch(String username, String password) throws NoSuchAlgorithmException, IOException, InvalidKeySpecException {
//        String response = "";
//        String salt = dbase.getSalt(username);
//        String passPlusSalt = salt.concat(password);
//        String encPass = sha1(passPlusSalt);
//
//        if (encPass.equals(dbase.getHash(username))) {
//            response = "LOGIN_SUCCESSFUL";
//        }
//        else
//        {
//            response = "PASSWORD_INCORRECT";
//        }
//
//        return response;
//    }
}
