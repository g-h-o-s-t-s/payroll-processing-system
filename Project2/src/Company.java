/**
 * Container class, represents database list of employees.
 * Methods provided to lookup/add/remove employee, print out employee list,
 * set employee hours, and process payments.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings({"ManualArrayCopy"})
public class Company
{
    //object fields
    private Employee[] emplist;
    private int numEmployee;

    /**
     * Default constructor.
     */
    public Company()
    {
        emplist = new Employee[Consts.DEFAULT];
        numEmployee = 0;
    }

    /**
     * Method to determine if this Company is empty.
     * @return true if this.emplist is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return (this.numEmployee == 0);
    }

    /**
     * Searches through emplist for an object which matches parameter key.
     * @param employee key to be matched to an object within emplist
     * @return integer value which holds the index of the object in emplist
     */
    private int find(Employee employee)
    {
        for (int i = 0; i < emplist.length; i++)
            if ((emplist[i] != null) && emplist[i].equals(employee))
                return i;

        return -1;
    }

    /**
     * Grows the database list if the bag container emplist is full.
     * If add() is about to cause an IndexOutOfBoundsException by adding
     * to a full emplist[], grow() should first make room in the array for
     * an employee to be added safely.
     */
    private void grow()
    {
        Employee[] temp = new Employee[emplist.length + Consts.GROW];
        for (int i = 0; i < emplist.length; i++)
            temp[i] = emplist[i];

        emplist = temp;
    }

    /**
     * Adds an employee object to database. Verifies that the profile
     * information is valid.
     * @param employee object to be added to the database
     * @return true if add() succeeded, false otherwise
     */
    public boolean add(Employee employee)
    {
        //verify validity of Employee parameter first
        if (!employee.getProfile().isValid())
            return false;

        //bag is full, need to call grow()
        if (numEmployee >= emplist.length)
            grow();

        for (int i = 0; i < emplist.length; i++)
            if (emplist[i] == null)
            {
                emplist[i] = employee;
                break;
            }

        numEmployee++;
        return true;
    }

    /**
     * Takes the given Employee object out of database.
     * Maintains original sequence of employee list.
     * @param employee object within emplist which will be set to null
     * @return true if remove() succeeded, false otherwise
     */
    public boolean remove(Employee employee)
    {
        int removeThis = find(employee);
        if (removeThis == -1)
            return false;

        emplist[removeThis] = null;

        //shift successive elements to the right
        for (int i = removeThis + 1; i < emplist.length; i++)
        {
            int last = i - 1;
            try
            {
                emplist[last] = emplist[i];
            } catch (ArrayIndexOutOfBoundsException ex)
            {
                break;
            }
        }
        numEmployee--;
        return true;
    }

    /**
     * Sets working hours for a given part-time employee.
     * @param employee object whose hoursWorked field will be assigned
     * @return true if setHours() succeeded, false otherwise
     */
    public boolean setHours(Employee employee)
    {
        int setThis = find(employee);
        if (setThis == -1)
            return false;

        //verify type beforehand to avoid ClassCastException;
        //cast both Employee parameter and corresponding Employee in emplist
        //to Parttime class, set hours of Employee in emplist to the hours
        //of the Employee parameter
        if (emplist[setThis] instanceof Parttime
                && employee instanceof Parttime)
        ((Parttime) emplist[setThis]).setHoursWorked(
                ((Parttime) employee).getHoursWorked());
        else
            return false;

        return true;
    }

    /**
     * Processes payments for all employees in database.
     * This is achieved by calling calculatePayment() for each Employee.
     */
    public void processPayments()
    {
        for (Employee employee:emplist)
            if (employee != null)
                employee.calculatePayment();
    }

    /**
     * Prints earning statements for all employees.
     */
    public void print()
    {
        for (Employee employee:emplist)
            if (employee != null)
                System.out.println(employee.toString());
    }

    /**
     * Prints earning statements, sorted by department.
     */
    public void printByDepartment()
    {
        sortByDepartment(emplist);
        print();
    }

    /**
     * Helper method for printByDepartment().
     * Sorts array of Employees by department, alphabetically.
     * @param emplist array containing list of employees
     *
     */
    private void sortByDepartment(Employee[] emplist)
    {
        for (int i = 1; i < emplist.length; i++)
        {
            int j = i - 1;
            if (emplist[i] != null && emplist[j] != null)
            {
                Employee key = emplist[i];

                while (j >= 0 && emplist[j] != null
                        && emplist[j].getProfile().getDepartment().compareTo
                            (key.getProfile().getDepartment()) > 0)
                {
                    emplist[j + 1] = emplist[j];
                    j = j - 1;
                }
                emplist[j + 1] = key;
            }
        }
    }

    /**
     * Prints earning statements, sorted by date hired.
     */
    public void printByDate()
    {
        sortByDate(emplist);
        print();
    }

    /**
     * Helper method for printByDate().
     * Sorts array in ascending order of date that an Employee was hired.
     * @param emplist array containing list of employees
     *
     */
    private void sortByDate(Employee[] emplist)
    {
        //insertion sort, shift larger elements to the right as needed
        for (int i = 1; i < emplist.length; i++)
        {
            int j = i - 1;
            if (emplist[i] != null && emplist[j] != null)
            {
                Employee key = emplist[i];

                while (j >= 0 && emplist[j] != null
                        && (emplist[j].getProfile().getDateHired().compareTo
                        (key.getProfile().getDateHired()) > 0))
                {
                    emplist[j + 1] = emplist[j];
                    j = j - 1;
                }
                emplist[j + 1] = key;
            }
        }
    }
}
