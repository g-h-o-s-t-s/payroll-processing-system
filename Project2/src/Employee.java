/**
 * Object class which represents an employed individual.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("WeakerAccess")
public class Employee
{
    //object fields
    private Profile profile;
    private double payRate;
    private double periodEarnings;
    private String timeType;

    //TO-DO: add methods as needed

    /**
     * Default constructor for Employee.
     */
    public Employee()
    {
        profile = new Profile();
        payRate = 0.0;
        periodEarnings = 0.0;
        timeType = "FULL TIME";
    }

    /**
     * Parameterized constructor for Employee.
     * @param p Profile which contains personal Employee data
     */
    public Employee(Profile p, double pr, String tw)
    {
        profile = p;
        payRate = pr;
        calculatePayment();
        timeType = tw;
    }

    /**
     * Getter for Profile field of this Employee object.
     * @return Profile instance variable value
     */
    public Profile getProfile()
    {
        return profile;
    }

    /**
     * Returns a message formatting the contents of Employee object.
     * @return String literal containing Employee field values
     */
    @Override
    public String toString()
    {
        return profile.toString() + "::Payment $" + periodEarnings
                + "::" + timeType;
    }

    /**
     * Compares all fields between two Employee objects.
     * @param obj Object which must be of type Employee
     * @return true if both objects have identical fields, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        //check if invoking object & param are of the same class
        if (obj instanceof  Employee) //null if obj is not of type Employee
            return false;

        Employee that = (Employee) obj;
        return this.profile.equals(that.profile)
                && this.payRate == that.payRate
                && this.periodEarnings == that.periodEarnings
                && this.timeType.equals(that.timeType);
    }

    /**
     * Determines Employee compensation based on data fields.
     */
    public void calculatePayment()
    {
        //??? not the way to do this, likely
        this.periodEarnings = payRate / Consts.PAYPERIODS;
    }
}
