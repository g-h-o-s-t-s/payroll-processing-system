import java.util.Scanner;
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
        int employeeCounter = 0;
        boolean loop = true;

        while(loop && scn.hasNextLine()) {
            input = scn.nextLine();
            if (input.equals(""))
                continue;
            if (input.equals(Consts.QUIT)) {
                loop = false;
                continue;
            }
            String command = inputs[Consts.SPLITONE];
            switch (command) {
                case Consts.ADDPARTTIME:
                    addPartTime(inputs, company);
                    employeeCounter++;
                    break;
                case Consts.ADDFULLTIME:
                    addFullTime(inputs, company);
                    employeeCounter++;
                    break;
                case Consts.ADDFULLROLE:
                    addFullRole(inputs, company);
                    employeeCounter++;
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
                    if(company.isEmpty()){
                        printout(Consts.ISEMPTY);
                    }else{
                        System.out.println(Consts.LISTHEADER);
                        company.print();
                    }
                    break;
                case Consts.PRINTHIRED:
                    if(company.isEmpty()){
                        printout(Consts.ISEMPTY);
                    }else{
                        System.out.println(Consts.LISTHEADER);
                        company.printByDate();
                    }
                    break;
                case Consts.PRINTDEPART:
                    if(company.isEmpty()){
                        printout(Consts.ISEMPTY);
                    }else{
                        System.out.println(Consts.LISTHEADER);
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
        if(inputs.length == Consts.FIVEINPUTS){
            String name = inputs[Consts.SPLITTWO];
            String department = inputs[Consts.SPLITTHREE];
            String date = inputs[Consts.SPLITFOUR];
            Profile newEmployee = new Profile(name, department, date);

            String pay = inputs[Consts.SPLITFIVE];
            String type = "PART TIME";


            Date check = new Date(date);
             if(check.isValid()){
                Employee addThis = new Employee(newEmployee, pay, type);
                company.add(addThis);
                printout("Employee added");
            }else {
                 printout("Invalid Date!");
             }
        }else{
            printout(Consts.INVALIDCOMMAND);
        }
    }

    /**
     * Helper method to execute "Add Full Time" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void addFullTime(String[] inputs, Company company){
        if(inputs.length == Consts.FIVEINPUTS){
            String name = inputs[Consts.SPLITTWO];
            String department = inputs[Consts.SPLITTHREE];
            String date = inputs[Consts.SPLITFOUR];
            String salary = inputs[Consts.SPLITFIVE];
            Date check = new Date(date);

            Profile newEmployee = new Profile(name, department, check);

            String pay = inputs[Consts.SPLITFIVE];
            String type = "FULL TIME";



            if(check.isValid()){
                Employee addThis = new Employee(newEmployee, pay, type);
                company.add(addThis);
                printout("Employee added");
            }else {
                printout("Invalid Date!");
            }
        }else{
            printout(Consts.INVALIDCOMMAND);
        }
    }

    /**
     * Helper method to execute "Add Full Time Management" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void addFullRole(String[] inputs, Company company){
        if(inputs.length == Consts.SIXINPUTS){
            String name = inputs[Consts.SPLITTWO];
            String department = inputs[Consts.SPLITTHREE];
            String date = inputs[Consts.SPLITFOUR];
            String salary = inputs[Consts.SPLITFIVE];
            Date check = new Date(date);

            Profile newEmployee = new Profile(name, department, check);

            String pay = inputs[Consts.SPLITFIVE];
            String type = "FULL TIME";

            if(check.isValid()){
                Employee addThis = new Employee(newEmployee, pay, type);
                company.add(addThis);
                printout("Employee added");
            }else {
                printout("Invalid Date!");
            }
        }else{
            printout(Consts.INVALIDCOMMAND);
        }

    }

    /**
     * Helper method to execute "Remove" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void removeEmployee(String[] inputs, Company company){
        if(inputs.length == Consts.FOURINPUTS){
            try{
                String name = inputs[Consts.SPLITTWO];
                String department = inputs[Consts.SPLITTHREE];
                String date = inputs[Consts.SPLITFOUR];
                Date check = new Date(date);

                Profile remove = new Profile(name, department, check);
                Employee key = new Employee();
                boolean removed = company.remove(key);

                if(removed){
                    printout("Employee removed.");
                }else{
                    printout("Employee doesn't exist.");
                }
            }catch(){
                printout(Consts.INVALIDCOMMAND);
            }
        }else{
            printout(Consts.INVALIDCOMMAND);
        }
    }

    /**
     * Helper method to execute "Calculate" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void calculate(String[] inputs, Company company) {

        printout("Calculation of employee payments is done.");
    }

    /**
     * Helper method to execute "Set" client command.
     * @param inputs String[] reference pass of return value of split()
     * @param company Company, reference pass of company bag container
     */
    private void setHours(String[] inputs, Company company) {
        for(int i = 0; i < company.length; i++){
            if(/*name matches*/){
                
            }
        }
        printout("Working hours set.");
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
