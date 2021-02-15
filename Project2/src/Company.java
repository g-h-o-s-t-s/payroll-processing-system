/**
 * Container class, represents database list of employees.
 * Methods provided to lookup/add/remove employee, print out employee list,
 * set employee hours, and process payments.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Company
{
    //object fields
    private Employee[] emplist;
    private int numEmployee;

    /**
     * Searches through emplist for an object which matches key.
     * @param employee key to be matched to an object within emplist
     * @return integer value which holds the index of the object in emplist
     */
    private int find(Employee employee) { return -1;}

    /**
     * Grows the database list if the bag container emplist is full.
     * If add() is about to cause an IndexOutOfBoundsException by adding
     * to a full emplist[], grow() should first make room in the array for
     * an employee to be added safely.
     */
    private void grow() { }

    /**
     * Adds an employee object to database. Verifies that the profile
     * information is valid.
     * @param employee object to be added to the database
     * @return true if add() succeeded, false otherwise
     */
    public boolean add(Employee employee) { return true;}

    /**
     * Takes the given Employee object out of database.
     * Maintains original sequence of employee list.
     * @param employee object within emplist which will be set to null
     * @return true if remove() succeeded, false otherwise
     */
    public boolean remove(Employee employee) { return true;}

    /**
     * Sets working hours for a given part-time employee.
     * @param employee object whose hoursWorked field will be assigned
     * @return true if setHours() succeeded, false otherwise
     */
    public boolean setHours(Employee employee) { return true;}

    /**
     * Processes payments for all employees in database.
     */
    public void processPayments() { }

    /**
     * Prints earning statements for all employees.
     */
    public void print() { }

    /**
     * Prints earning statements by department.
     */
    public void printByDepartment() { }

    /**
     * Prints earning statements by date hired.
     */
    public void printByDate() { }
}
