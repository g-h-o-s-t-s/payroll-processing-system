/**
 * Object class which contains company-relevant information of an employee.
 @author Sagnik Mukherjee, Michael Choe
 */
public class Profile
{
    //object fields
    private String name; //employee’s name in the form “lastname,firstname”
    private String department; //department code: CS, ECE, IT
    private Date dateHired;

    //TO-DO: add methods as needed

    /**
     * Returns a message formatting the contents of Profile object.
     * @return String literal containing Profile field values
     */
    @Override
    public String toString()
    {
        return name + "::" + department + "::" + dateHired;
    }

    /**
     * Compares all three fields between two Profile objects.
     * @param obj Object which must be of type Profile
     * @return true if both objects have identical fields, false otherwise
     */
    @Override
    public boolean equals(Object obj)
    {
        //equals() first confirms invoking object & param are of the same class
        if (getClass() != obj.getClass())
            return false;

        Profile that = (Profile) obj;
        return this.name.equals(that.name)
                && this.department.equals(that.department)
                && this.dateHired.equals(that.dateHired);
    }
}
