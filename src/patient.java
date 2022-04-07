public class patient {

        private String Username;
        private String Password;
        private int CPR;
        private String[] commands;


        public patient (String username, String password, int CPR, String[] commands)
        {
            this.Password = password;
            this.Username = username;
            this.CPR = CPR;
            this.commands = commands;
        }

        public String getUsername()
        {
            return this.Username;
        }
        public String getPassword()
        {
            return this.Password;
        }
        public int getCPR()
    {
        return this.CPR;
    }
}
