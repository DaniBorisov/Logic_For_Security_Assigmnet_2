public class User {

    private String Username;
    private String Password;
    private int CPR;
    private String Role;

    public User (String username, int CPR, String Role)
    {
        this.Username = username;
        this.CPR = CPR;
        this.Role = Role;
    }

    public String getUsername()
    {
        return this.Username;
    }
    public String getRole()
    {
        return this.Role;
    }
    public int getCPR()
    {
        return this.CPR;
    }
}
