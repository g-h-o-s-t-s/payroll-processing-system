import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
/**
 * Client class, handles interaction with program user.
 * @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("WeakerAccess")
public class PayrollProcessing
{
    /**
     * Driver method to run Kiosk commands.
     */
    public void run()
    {
        printout(Consts.STARTUP);
        Company company = new Company();
        Scanner scn = new Scanner(System.in);
        String input;
        String[] inputs;
        boolean loop = true;

        while (loop && scn.hasNextLine())
        {
            input = scn.nextLine();
            if (input.equals(""))
                continue;
            if (input.equals(Consts.QUIT)) {
                loop = false;
                continue;
            }

            inputs = input.split(" ");
            String command = inputs[Consts.SPLITONE];
            switch (command) {
                case Consts.ADDPARTTIME:
                    addPartTime(inputs, company);
                    break;
                case Consts.ADDFULLTIME:
                    addFullTime(inputs, company);
                    break;
                case Consts.ADDFULLROLE:
                    addFullRole(inputs, company);
                    break;
                case Consts.REMOVE:
                    removeEmployee(inputs, company);
                    break;
                case Consts.CALCULATE:
                    calculate(inputs, company);
                    break;
                case Consts.SET:
                    setHours(inputs, company);
                    break;
                case Consts.PRINTALL:
                    if (company.isEmpty())
                        printout(Consts.ISEMPTY);
                    else {
                        System.out.println(Consts.PRINT_HEADER);
                        company.print();
                    }
                    break;
                case Consts.PRINTHIRED:
                    if (company.isEmpty())
                        printout(Consts.ISEMPTY);
                    else {
                        System.out.println(Consts.PRINTDATE_HEADER);
                        company.printByDate();
                    }
                    break;
                case Consts.PRINTDEPART:
                    if (company.isEmpty())
                        printout(Consts.ISEMPTY);
                    else {
                        System.out.println(Consts.PRINTDEP_HEADER);
                        company.printByDepartment();
                    }
                    break;

                default:
                    printout(Consts.INVALIDCOMMAND);
                    break;
            }
        }
        printout(Consts.SHUTDOWN);
    }

    /**
     * Helper method to execute "Add Part Time" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void addPartTime(String[] inputs, Company company){
        if (inputs.length == Consts.FIVEINPUTS){
            try {
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String dateStr = inputs[Consts.SPLITFOUR];
                double pay = Double.parseDouble(inputs[Consts.SPLITFIVE]);

                Date date = new Date(dateStr);
                Profile newEmployee = new Profile(name, department, date);
                String type = Consts.PARTTIME;

                 if (date.isValid()){
                    Employee addThis = new Employee(newEmployee, pay, type);
                    company.add(addThis);
                    printout("Employee added");
                } else
                     printout("Invalid Date!");

            } catch (InputMismatchException | NumberFormatException ex) {
                printout(Consts.INVALIDCOMMAND);
            }
        }
        else
            printout(Consts.INVALIDCOMMAND);
    }

    /**
     * Helper method to execute "Add Full Time" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void addFullTime(String[] inputs, Company company){
        if (inputs.length == Consts.FIVEINPUTS) {
            try {
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String dateStr = inputs[Consts.SPLITFOUR];
                double pay = Double.parseDouble(inputs[Consts.SPLITFIVE]);

                Date date = new Date(dateStr);
                Profile newEmployee = new Profile(name, department, date);
                String type = Consts.FULLTIME;

                if (date.isValid()) {
                    Employee addThis = new Employee(newEmployee, pay, type);
                    company.add(addThis);
                    printout("Employee added");
                } else
                    printout("Invalid Date!");

            } catch (InputMismatchException | NumberFormatException ex) {
                printout(Consts.INVALIDCOMMAND);
            }
        }
        else
            printout(Consts.INVALIDCOMMAND);
    }

    /**
     * Helper method to execute "Add Full Time Management" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void addFullRole(String[] inputs, Company company){
        if (inputs.length == Consts.SIXINPUTS)
        {
            try {
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String date = inputs[Consts.SPLITFOUR];
                double pay = Double.parseDouble(inputs[Consts.SPLITFIVE]);

                Date check = new Date(date);
                Profile newEmployee = new Profile(name, department, check);
                String type = Consts.FULLTIME;

                if (check.isValid()){
                    Employee addThis = new Employee(newEmployee, pay, type);
                    company.add(addThis);
                    printout("Employee added");
                }
                else
                    printout("Invalid Date!");

            } catch (InputMismatchException | NumberFormatException ex) {
                printout(Consts.INVALIDCOMMAND);
            }
        }
        else
            printout(Consts.INVALIDCOMMAND);
    }

    /**
     * Helper method to execute "Remove" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void removeEmployee(String[] inputs, Company company){
        if (inputs.length == Consts.FOURINPUTS){
            try{
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String dateStr = inputs[Consts.SPLITFOUR];
                Date date = new Date(dateStr);

                Profile profile = new Profile(name, department, date);
                Employee key = new Employee();
                key.setProfile(profile);

                if (company.remove(key))
                    printout("Employee removed.");
                else
                    printout("Employee doesn't exist.");

            } catch (InputMismatchException | NumberFormatException ex) {
                printout(Consts.INVALIDCOMMAND);
            }
        }
        else
            printout(Consts.INVALIDCOMMAND);

    }

    /**
     * Helper method to execute "Calculate" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void calculate(String[] inputs, Company company)
    {
        if (inputs.length == Consts.ONEINPUT) {
            company.processPayments();
            printout("Calculation of employee payments is done.");
        }
        else
            printout(Consts.INVALIDCOMMAND);
    }

    /**
     * Helper method to execute "Set" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void setHours(String[] inputs, Company company) {
        if (inputs.length == Consts.FIVEINPUTS) {
            try {
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String dateStr = inputs[Consts.SPLITFOUR];
                int hoursToSet = Integer.parseInt(inputs[Consts.SPLITFIVE]);

                Date date = new Date(dateStr);
                Profile profile = new Profile(name, department, date);
                Parttime key = new Parttime();
                key.setProfile(profile);
                key.setHoursWorked(hoursToSet);

                if (company.remove(key))
                    printout("Employee removed.");
                else
                    printout("Employee doesn't exist.");

            } catch (InputMismatchException | NumberFormatException ex) {
                printout(Consts.INVALIDCOMMAND);
            }
        }
    }

    /**
     * Helper method to print given string.
     * Reduces the repetitions of "System.out.println" in PayrollProcessing.
     * @param str String literal to be printed
     */
    private void printout(String str){
        System.out.println(str);
    }
}
