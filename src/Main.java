import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {


        Map<User,Record> Database = new HashMap<>();

        User u1 = new User("Daniel",123,"Doctor");
        User u2 = new User("Aleberto",987,"patient");
        User u3 = new User("Niels",741,"patient");

        Record r1 = new

            System.out.print("Enter username: ");
            username = scanner.nextLine();  // Read user input
            System.out.print("Enter password: ");
            pass = scanner.nextLine();  // Read user input
            if (logIn.LogIn(username,pass)) {
                loggedIn = true;
                System.out.println("LOGIN_SUCCESSFUL");  // Output user input
                System.out.println("Printers names: p1 -- p2 -- p3.");
            } else {
                System.out.println("USER_DOES_NOT_EXISTS OR PASSWORD_INCORRECT");  // Output user input
            }
        } catch (Exception e) {
            System.err.println("Client exception" + e);
            e.printStackTrace();
        }
    }

    boolean isRunning = true;
            while (isRunning && loggedIn)
    {
        System.out.println("Enter command - enter 'help' for command list.");
        String command = scanner.nextLine();  // Read user input
        System.out.println("Command is: " + command);  // Output user input
        String printer;
        switch (command)
        {
            case "help":
                System.out.println("""
                                ########################################
                                print - prints file filename on a specified printer
                                queue - lists the print queue for a given printer
                                topQueue - moves job to the top of the queue
                                start - starts the print server
                                stop - stops the print server
                                restart - stops the print server, clears the print queue and starts the print server again
                                status - prints the status of a printer
                                readConfig - prints the value of the parameter
                                setConfig - sets the parameter to value
                                quit - exit system
                                ########################################""");
                break;
            case "print":
                System.out.print("What file you want to print? ");
                String file = scanner.nextLine();  // Read user input
                System.out.print("Which printer you want to use? ");
                printer = scanner.nextLine();  // Read user input
                System.out.println(service.print(file, printer, username));
                break;
            case "queue":
                System.out.print("Which printer you want to check? ");
                printer = scanner.nextLine();  // Read user input
                System.out.println(service.queue(printer,username));
                break;
            case "start":
                System.out.println(service.start(username));
                break;
            case "topQueue":
                System.out.print("Which printer's queue you want to modify? ");
                printer = scanner.nextLine();  // Read user input
                System.out.print("Which job you want? ");
                int job = scanner.nextInt();
                System.out.println(service.topQueue(printer, job, username));
                break;
            case "stop":
                System.out.println(service.stop(username));
                break;
            case "restart":
                System.out.println(service.restart(username));
                break;
            case "status":
                System.out.print("Which printer's status you want to know? ");
                printer = scanner.nextLine();  // Read user input
                System.out.println(service.status(printer,username));
                break;
            case "readConfig":
                System.out.print("Which parameter's value you want to see? ");
                String parameter = scanner.nextLine();  // Read user input
                System.out.println(service.readConfig(parameter,username));
                break;
            case "setConfig": System.out.print("What param you want to set? ");
                parameter = scanner.nextLine();  // Read user input
                System.out.print("To what value you want to set it? ");
                String value = scanner.nextLine();System.out.println(service.setConfig(parameter, value,username));
                break;
            case "quit" :
                isRunning = false;
                break;
            default:
                System.out.println("Command unclear - Try again.");
        }

    }



}
