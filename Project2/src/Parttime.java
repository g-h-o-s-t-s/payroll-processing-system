/**
 * Object class which represents a part-time worker, is of type Employee.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Parttime extends Employee
{
    //object fields
    private double payRate;
    private double periodEarnings;
    private int hoursWorked;

    //TO-DO: add methods as needed

    /**
     * Default constructor for Parttime.
     */
    public Parttime()
    {
        super();
        hoursWorked = 0;
    }

    /**
     * Parameterized constructor for Parttime.
     * @param p Profile which contains personal Parttime data
     */
    public Parttime(Profile p, int pr, String tw, int hw)
    {
        super(p, pr, tw);
        hoursWorked = hw;
    }

    /**
     * Returns a message formatting the contents of Parttime object.
     * @return String literal containing Parttime field values
     */
    @Override
    public String toString()
    {
        return super.toString() + Consts.HOURLYPAY_MSG + payRate
                + "::Hours worked this period: " + hoursWorked;
    }

    /**
     * Compares all fields between two Parttime objects.
     * @param obj Object which must be of type Parttime
     * @return true if both objects have identical fields, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    /**
     * Determines Parttime compensation based on data fields.
     */
    @Override
    public void calculatePayment()
    {
        int overtime = hoursWorked % Consts.FULLHOURS;
        int regularTime = hoursWorked - overtime;
        double overtimeRate = Consts.OVERTIME_RATE * payRate;
        this.periodEarnings = (payRate * regularTime)
                + (overtimeRate * overtime);
    }
}
