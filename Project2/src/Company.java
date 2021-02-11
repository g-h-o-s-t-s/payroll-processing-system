/**
 * Container class, represents database list of employees.
 * Methods provided to lookup/add/remove employee, print out employee list,
 * set employee hours, and process payments.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Company
{
    private Employee[] emplist;
    private int numEmployee;

    private int find(Employee employee) { return -1;}
    private void grow() { }
    public boolean add(Employee employee) { return true;} //check the profile before adding
    public boolean remove(Employee employee) { return true;} //maintain the original sequence
    public boolean setHours(Employee employee) { return true;} //set working hours for a part time
    public void processPayments() { } //process payments for all employees
    public void print() { } //print earning statements for all employees
    public void printByDepartment() { } //print earning statements by department
    public void printByDate() { } //print earning statements by date hired
}
