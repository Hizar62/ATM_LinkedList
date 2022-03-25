import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.text.SimpleDateFormat;

public class Atm {
    public static void main(String[] args) throws IOException,InterruptedException{

        Scanner sc = new Scanner(System.in);

        String FilePath = "C:\\Users\\hizar\\Documents\\Project\\";

        boolean b = true;
        // Menu for register,login and to exit
        while (b) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t\t\t\t*   ****************************  * ");
            System.out.println("\t\t\t\t\t*   -------WELCOME TO ATM-----    *");
            System.out.println("\t\t\t\t\t*   1. Register New User          *");
            System.out.println("\t\t\t\t\t*   2. Login for existing user    *");
            System.out.println("\t\t\t\t\t*   3. Exit Program               *");
            System.out.println("\t\t\t\t\t*    **************************** *  ");
            System.out.print("\t\t\t\t\tEnter Choice : ");

            int choice = 3;

            if(sc.hasNextInt()){
                choice= sc.nextInt();
            }


            brea: {
                // Register with name,username, password, phone and check if account already
                // exist
                if (choice == 1) {

                    System.out.print("\t\t\t\t\tEnter Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    if (!name.matches("^[a-zA-Z\\s]*$")){
                        System.out.println("\t\t\t\t\tName must be in Alphabetic Character!");
                        System.out.println("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }

                    System.out.print("\t\t\t\t\tEnter Username : ");
                    String username = sc.nextLine();
                     if (!username.matches("^[a-zA-Z\\s]*$")) {
                        System.out.println("\t\t\t\t\tUsername must be in Alphabetic Character!");
                        System.out.print("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }

                    File file = new File(FilePath + username + ".txt");
                    if (file.exists()) {
                        System.out.println("\t\t\t\t\tUsername Already Taken !");
                        System.out.print("\n\t\t\t\t\tPress enter to continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {
                        }
                        break brea;
                    }

                    Console console = System.console();
                    if (console == null) {
                        System.out.println("\t\t\t\t\tCouldn't get Console instance");
                        System.exit(0);
                    }

                    char[] passwordArr = console.readPassword("\t\t\t\t\tEnter Your Password!");
                    String passwor = new String(passwordArr);
                    if (passwor.matches("[a-zA-Z]+")) {
                        System.out.println("\t\t\t\t\tPassword Number Should be Digits!");
                        System.out.print("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }

                    Integer passcode = Integer.parseInt(passwor);

                    System.out.print("\t\t\t\t\tEnter Phone Number : ");
                    String number = sc.nextLine();

                    if (number.matches("[a-zA-Z]+")) {
                        System.out.println("\t\t\t\t\tPhone Number Should be Digits!");
                        System.out.print("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    } else if (isValidMobileNo(number)) {
                    } else {
                        System.out.println("\t\t\t\t\tNumber should be 11 digits");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }

                    long numbe = Long.parseLong(number);

                    System.out.print("\t\t\t\t\tEnter Your address : ");
                    String address = sc.nextLine();
                    if (!address.matches("[a-zA-Z]+")) {
                        System.out.println("\t\t\t\t\tAddress Must be Characters!");
                        System.out.print("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }

                    System.out.print("\t\t\t\t\tEnter Your CNIC number : ");
                    String cni = sc.nextLine();
                    if (cni.matches("[a-zA-Z]+")) {
                        System.out.println("\t\t\t\t\tCNIC Must be Numbers!");
                        System.out.print("\t\t\t\t\tPress Enter to Continue");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    } else if (isValidateCNIC(cni)) {
                        System.out.println();

                    } else {
                        System.out.println("\t\t\t\t\tCNIC Must be 13 Digit only and must start with 3 and 4");
                        System.out.print("\t\t\t\t\tPress Enter To continue!");
                        try {
                            System.in.read();
                        } catch (Exception e) {

                        }
                        break brea;
                    }
                    long cnic = Long.parseLong(cni);
                    handle.insert(name, username, passcode, numbe, address, cnic, "TRANSACTION:0");
                    new handle(name, username, passcode, numbe, address, cnic, "TRANSACTION:0", FilePath);
                    handle.delete();
                    // handle.message();

                    System.out.println("\n\t\t\t\t\tPress enter to continue");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }

                }

                // Login with username and password
                else if (choice == 2) {
                    System.out.println();
                    String username;
                    System.out.print("\t\t\t\t\tEnter Username : ");
                    sc.nextLine();
                    loop: {
                        username = sc.nextLine();
                        if (!username.matches("[a-zA-Z]+")) {
                            System.out.println("\t\t\t\t\tInvalid Input!");
                            System.out.print("\t\t\t\t\tPress Enter to Continue");
                            try {
                                System.in.read();
                            } catch (Exception e) {

                            }
                            break loop;
                        }

                        Console console = System.console();
                        if (console == null) {
                            System.out.println("\t\t\t\t\tCouldn't get Console instance");
                            System.exit(0);
                        }
                        char[] passwordArray = console
                                .readPassword("\t\t\t\t\tEnter your secret password:");
                        String password = new String(passwordArray);

                        boolean bool = true;

                        File file = new File(FilePath + username + ".txt");
                        // If login successful
                        if (file.exists()) {
                            try {
                                // Take file data in variables
                                Scanner dataReader = new Scanner(file);
                                String money = dataReader.nextLine();
                                int login_money = Integer.parseInt(money);
                                String login_name = dataReader.nextLine();
                                String login_username = dataReader.nextLine();
                                String login_password = dataReader.nextLine();
                                String number = dataReader.nextLine();
                                long login_number = Long.parseLong(number);
                                String Address = dataReader.nextLine();
                                String CNIC = dataReader.nextLine();
                                long login_CNIC = Long.parseLong(CNIC);
                                String login_transaction = dataReader.nextLine();
                                if (username.equals(login_username) && password.equals(login_password)) {

                                    // -----------------------------------------------------------------

                                    boolean bo = true;
                                    // Menu for logged in customers
                                    while (bo) {
                                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                        System.out.println("\t\t\t\t\t*******************************");
                                        System.out.println("\t\t\t\t\t\tWelcome " + login_name + " !");
                                        System.out.println("\t\t\t\t\t*=============================*");
                                        System.out.println("\n\t\t\t\t\t*     OPERATIONS              *");
                                        System.out.println("\t\t\t\t\t* 1. Deposit Money            *");
                                        System.out.println("\t\t\t\t\t* 2. Withdraw Money           *");
                                        System.out.println("\t\t\t\t\t* 3. View Details/Balance     *");
                                        System.out.println("\t\t\t\t\t* 4. View Transaction History *");
                                        System.out.println("\t\t\t\t\t* 5. Change Your Password     *");
                                        System.out.println("\t\t\t\t\t* 6. Transfer to other account*");
                                        System.out.println("\t\t\t\t\t* 7. Logout                   *");
                                        System.out.print("\t\t\t\t\tEnter Choice : ");
                                        int choice2 = 7;
                                        // int choice2 = sc.nextInt();
                                        if (sc.hasNextInt()) {
                                            choice2 = sc.nextInt();
                                        } else {
                                            System.out.println("\t\t\t\t\tInvalid Input!");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {

                                            }
                                            break brea;
                                        }
                                        System.out.println();

                                        // Deposit Method
                                        if (choice2 == 1) {
                                            System.out.print("\t\t\t\t\tEnter Amount to Deposit : (Limit : 50,000)");
                                            int amount = sc.nextInt();
                                            // Validation
                                            if (amount < 0 || amount > 50000) {
                                                System.out.println("\t\t\t\t\tEnter correct amount !");
                                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            } else {
                                                try {
                                                    // Open file, Replace original amount with updated with time also
                                                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                    String old_money = Integer.toString(login_money);
                                                    login_money += amount;
                                                    int temp = amount;
                                                    String to_be_deposited = Integer.toString(login_money);
                                                    modifyFile(FilePath + username
                                                            + ".txt", old_money, to_be_deposited);

                                                    SimpleDateFormat formatter = new SimpleDateFormat(
                                                            "dd/MM/yyyy HH:mm:ss");
                                                    Date date = new Date();
                                                    f0.write("\t\t\t\t\tRs.(+" + temp + ") :: " + formatter.format(date)
                                                            + " :: Self Deposit " + "\n");

                                                    login_transaction = "TRANSACTION:1";
                                                    modifyFile(FilePath + username + ".txt", "TRANSACTION:0",
                                                            "TRANSACTION:1");

                                                    System.out.println("\t\t\t\t\tRs. " + temp + " Deposited !");

                                                    System.out.println("\n\t\t\t\t\tPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }

                                                    f0.close();
                                                } catch (IOException e) {
                                                    System.out.println("\t\t\t\t\tUser Data not found !");
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        // Withdraw method
                                        else if (choice2 == 2) {
                                            System.out.print(
                                                    "\t\t\t\t\tEnter Amount to Withdraw : (Limit : 0 to " + login_money + ")");
                                            int amount_withdraw = sc.nextInt();
                                            // Validation
                                            if (amount_withdraw < 0 || amount_withdraw > login_money) {
                                                System.out.println("\t\t\t\t\tEnter correct amount !");
                                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            } else {
                                                try {
                                                    // Open file, Replace original amount with updated with time also
                                                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                    String old_money = Integer.toString(login_money);
                                                    login_money -= amount_withdraw;
                                                    int temp1 = amount_withdraw;
                                                    String to_be_withdrawed = Integer.toString(login_money);
                                                    modifyFile(FilePath + username + ".txt", old_money,
                                                            to_be_withdrawed);

                                                    SimpleDateFormat formatter = new SimpleDateFormat(
                                                            "dd/MM/yyyy HH:mm:ss");
                                                    Date date = new Date();
                                                    f0.write("\t\t\t\t\tRs.(-" + temp1 + ") :: " + formatter.format(date)
                                                            + " :: Self Withdraw" + "\n");

                                                    login_transaction = "TRANSACTION:1";
                                                    modifyFile(FilePath + username + ".txt", "TRANSACTION:0",
                                                            "TRANSACTION:1");

                                                    System.out.println("\t\t\t\t\tRs. " + temp1 + " Withdrawed !");

                                                    System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }

                                                    f0.close();
                                                } catch (IOException e) {
                                                    System.out.println("\t\t\t\t\tUser Data not found !");
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                        // Show all details from variables that we stored file contents
                                        else if (choice2 == 3) {
                                            System.out.println("\n\t\t\t\t\tDetails :");
                                            System.out.println("\t\t\t\t\t1. Name      : " + login_name);
                                            System.out.println("\t\t\t\t\t2. Username  : " + login_username);
                                            System.out.printf("\t\t\t\t\t3. Password  : ");
                                            for (int i = 0; i < login_password.length(); i++) {
                                                System.out.printf("*");
                                            }
                                            System.out.println();
                                            System.out.println("\t\t\t\t\t4. Phone No. : " + login_number);
                                            System.out.println("\t\t\t\t\t5. Address   : " + Address);
                                            System.out.println("\t\t\t\t\t5. CNIC  No. : " + login_CNIC);
                                            System.out.println("\t\t\t\t\t6. Balance   : " + login_money + " Rs.");

                                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        }
                                        // Transaction history (Show only if TRANSACTION:1 is there, Don't show if
                                        // TRANSACTION:0 is there in file variable)
                                        else if (choice2 == 4) {
                                            try {
                                                File f1 = new File(FilePath + username + ".txt");
                                                dataReader = new Scanner(f1);
                                                System.out.println("\t\t\t\t\tTransaction History : ");
                                                String temp = "TRANSACTION:0";
                                                if (login_transaction.equals(temp)) {
                                                    System.out.println("\t\t\t\tNo Transaction History is there !");
                                                    System.out.print("\n\t\t\t\tPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }
                                                } else {
                                                    for (int j = 0; j < 7; j++) {
                                                        dataReader.nextLine();
                                                    }
                                                    while (dataReader.hasNextLine()) {
                                                        String fileData = dataReader.nextLine();
                                                        System.out.println(fileData);
                                                    }
                                                    System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }
                                                }
                                                dataReader.close();
                                            } catch (FileNotFoundException exception) {
                                                System.out.println("\t\t\t\t\tUnexcpected error occurred!");
                                                exception.printStackTrace();
                                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            }
                                        } else if (choice2 == 5) {
                                            File f1 = new File(FilePath + username + ".txt");
                                            try (Scanner dataReader1 = new Scanner(f1)) {
                                                Console con = System.console();
                                                if (con == null) {
                                                    System.out.println("\t\t\t\t\tCouldn't get Console instance");
                                                    System.exit(0);
                                                }

                                                char[] passwordArr = con.readPassword("\t\t\t\t\tEnter Your new Password!");
                                                String passwor = new String(passwordArr);

                                                modifyFile(FilePath + username + ".txt", login_password, passwor);
                                                System.out.println("\t\t\t\t\tPassword is Successfully changed!");
                                                Integer passcode = Integer.parseInt(passwor);
                                                Stack s1 = new Stack();

                                                try {

                                                   s1.Push(passcode);

                                                FileWriter f8 = new FileWriter(FilePath + username + ".txt", true);
                                                System.out.println("\t\t\t\t\tChanged Password!");
                                                SimpleDateFormat formatter = new SimpleDateFormat(
                                                        "dd/MM/yyyy HH:mm:ss");
                                                Date date = new Date();
                                                f8.write("\t\t\t\t\tNew Password is : " + passcode + " :: " + formatter.format(date)
                                                        + " :: Changed!" + "\n");

                                                f8.close();
                                               


                                                
                                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                            }
                                        
                                            } catch (Exception e) {
                                                
                                            }

                                            
                                            

                                        }
                                    }
                                        // Transfer to other account with username and update amount and transaction
                                        // history in both user account
                                        else if (choice2 == 6) {
                                            System.out.println();
                                            System.out.print("\t\t\t\t\tEnter Username of other account: ");
                                            sc.nextLine();
                                            String username_to_transfer = sc.nextLine();

                                            File file_to_transfer = new File(FilePath + username_to_transfer + ".txt");
                                            if (file_to_transfer.exists()) {
                                                dataReader = new Scanner(file_to_transfer);
                                                Scanner dataReader2 = new Scanner(file_to_transfer);
                                                String money_old = dataReader2.nextLine();
                                                String name_transfer = dataReader2.nextLine();
                                                int money_old_user = Integer.parseInt(money_old);
                                                System.out.print(
                                                        "\t\t\t\t\tEnter Amount to Transfer : (Limit : 0 to " + login_money
                                                                + ")");
                                                int amount_transfer_update = sc.nextInt();

                                                if (amount_transfer_update <= 0
                                                        || amount_transfer_update > login_money) {
                                                    System.out.println("\t\t\t\t\tEnter correct amount !");
                                                    System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                    try {
                                                        System.in.read();
                                                    } catch (Exception e) {
                                                    }
                                                } else {
                                                    String to_upd = Integer.toString(login_money);
                                                    login_money -= amount_transfer_update;
                                                    String to_upd2 = Integer.toString(login_money);
                                                    modifyFile(FilePath + username + ".txt", to_upd, to_upd2);

                                                    String to_update = Integer.toString(money_old_user);
                                                    money_old_user += amount_transfer_update;
                                                    String to_update_2 = Integer.toString(money_old_user);
                                                    modifyFile(FilePath + username_to_transfer + ".txt", to_update,
                                                            to_update_2);
                                                    modifyFile(FilePath + username_to_transfer + ".txt",
                                                            "TRANSACTION:0",
                                                            "TRANSACTION:1");
                                                    try {
                                                        FileWriter f11 = new FileWriter(
                                                                FilePath + username_to_transfer + ".txt", true);
                                                        SimpleDateFormat formatter = new SimpleDateFormat(
                                                                "dd/MM/yyyy HH:mm:ss");
                                                        Date date = new Date();
                                                        f11.write("\t\t\t\t\tRs.(+" + amount_transfer_update + ") :: "
                                                                + formatter.format(date) + " :: Transferred from "
                                                                + username + " (" + login_name + ")\n");
                                                        f11.close();

                                                        FileWriter f12 = new FileWriter(FilePath + username + ".txt",
                                                                true);
                                                        SimpleDateFormat formatter2 = new SimpleDateFormat(
                                                                "dd/MM/yyyy HH:mm:ss");
                                                        Date date2 = new Date();
                                                        f12.write("\t\t\t\t\tRs.(-" + amount_transfer_update + ") :: "
                                                                + formatter2.format(date2) + " :: Transferred to "
                                                                + username_to_transfer + " (" + name_transfer + ")\n");
                                                        f12.close();

                                                        System.out.println("\t\t\t\t\tRs.(" + amount_transfer_update
                                                                + ") Transferred to " + username_to_transfer + " ( "
                                                                + name_transfer + " )");
                                                        System.out.print("\n\t\t\t\t\tPress enter to continue");
                                                        try {
                                                            System.in.read();
                                                        } catch (Exception e) {
                                                        }

                                                    } catch (IOException e) {
                                                        System.out.println("\t\t\t\t\tUser Data not found !");
                                                        e.printStackTrace();
                                                    }
                                                }

                                                dataReader2.close();
                                            } else {
                                                System.out.println("\t\t\t\t\tUSER DON'T EXISTS !");
                                                System.out.print("\n\t\t\t\t\tPress enter to continue");

                                                try {
                                                    System.in.read();
                                                } catch (Exception e) {
                                                }
                                            }
                                        } else if(choice2==7){
                                            System.out.println("\t\t\t\t\tLOGOUT!");
                                            System.out.print("\t\t\t\t\tPress Enter To Continue!");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                                
                                            }
                                            break brea;
                                        }
                                        else{
                                            System.out.println("\t\t\t\t\tPlease Enter Correct Choice");
                                            System.out.print("\t\t\t\t\tPress enter to continue");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {
                                                
                                            }
                                            break brea;
                                        }
                                    }
                                    sc.close();

                                    // -------------------------------------------------------------------

                                    bool = false;
                                    break brea;
                                }

                                dataReader.close();
                            } catch (FileNotFoundException e) {
                                System.out.println("\t\t\t\t\tFile not found !");
                                e.printStackTrace();
                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                try {
                                    System.in.read();
                                } catch (Exception f) {
                                }
                            }
                        } else {
                            System.out.println("\t\t\t\t\tUser not registered!");

                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                            try {
                                System.in.read();
                            } catch (Exception e) {
                            }
                        }

                        if (bool) {
                            System.out.println("\t\t\t\t\tUsername or Password Incorrect !\n\t\t\t\t\tPlease Try Again");
                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                            try {
                                System.in.read();
                            } catch (Exception e) {
                            }
                            break brea;
                        }

                    }
                } else if (choice == 3) {
                    System.out.println("\n\t\t\t\t\t***** Thank you for using ATM *****");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                    b = false;
                    sc.close();
                    break brea;

                } else {
                    System.out.println("\t\t\t\t\tEnter correct number input !");
                    System.out.print("\n\t\t\t\t\tPress enter to continue");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }

                }
                
            }
            System.out.println();

        }

    }

    // Replacing string in file function (static)
    static void modifyFile(String filePath, String oldString, String newString) {
        // File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        // FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            // Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }
            // Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceFirst(oldString, newString);

            // Rewriting the input text file with newContent
            new FileWriter(filePath, false).close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the resources
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public static boolean isValidMobileNo(String str) {

        // (0/91): number starts with (0/92)
        // [3]: starting of the number may only contain a digit 3
        // [0-9]: then contains digits 0 to 9
        Pattern ptrn = Pattern.compile("(0|92)?[3][0-9]{9}");

        Matcher match = ptrn.matcher(str);

        return (match.find() && match.group().equals(str));
    }

    public static boolean isValidateCNIC(String str) {

        // (0/91): number starts with (0/92)
        // [3]: starting of the number may only contain a digit 3
        // [0-9]: then contains digits 0 to 9
        Pattern ptrn = Pattern.compile("[3][0-9]{12}");

        Matcher match = ptrn.matcher(str);

        return (match.find() && match.group().equals(str));
    }
}