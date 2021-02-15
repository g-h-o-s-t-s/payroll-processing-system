/**
 * Object class which represents those in management, is of type Employee.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Management extends Fulltime
{
    //object fields
    private double payRate;
    private double periodEarnings;
    private double bonusPay;
    private int code;

    //TO-DO: add methods as needed

    /**
     * Default constructor for Management.
     */
    public Management()
    {
        super();
        code = Consts.MA_CODE;
        bonusPay = Consts.MANAGER_BONUS;
    }

    /**
     * Parameterized constructor for Management.
     * @param p Profile which contains personal Management data
     */
    public Management(Profile p, double pr, String tw, int c)
    {
        super(p, pr, tw);
        code = c;
        if (code == Consts.MA_CODE)
            bonusPay = Consts.MANAGER_BONUS;
        else if (code == Consts.DH_CODE)
            bonusPay = Consts.DEPHEAD_BONUS;
        else if (code == Consts.DI_CODE)
            bonusPay = Consts.DIRECTOR_BONUS;
        else
            bonusPay = 0.0;
    }

    /**
     * Returns a message formatting the contents of Management object.
     * @return String literal containing Management field values
     */
    @Override
    public String toString()
    {
        if (code == Consts.MA_CODE)
            return super.toString() + "::Manager Compensation $" + bonusPay;
        else if (code == Consts.DH_CODE)
            return super.toString()
                    + "::DepartmentHead Compensation $" + bonusPay;
        else if (code == Consts.DI_CODE)
            return super.toString() + "::Director Compensation $" + bonusPay;

        return super.toString();
    }

    /**
     * Compares all fields between two Management objects.
     * @param obj Object which must be of type Management
     * @return true if both objects have identical fields, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    /**
     * Determines Management compensation based on data fields.
     */
    @Override
    public void calculatePayment()
    {
        this.periodEarnings = payRate / Consts.PAYPERIODS + bonusPay;
    }
}
