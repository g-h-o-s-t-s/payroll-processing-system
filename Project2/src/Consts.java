/**
 * The Consts class houses all immutable constant values.
 @author Michael Choe, Sagnik Mukherjee
 */
@SuppressWarnings("WeakerAccess")
public class Consts
{
    /* Company() class constants */


    /* Date() class constants - reused from Project1 */
    public static final int INVALID = -1;
    //Used to determine if given date is leap year.
    public static final int QUADRENNIAL = 4;
    public static final int CENTURY = 100;
    public static final int QUARTERCENTENNIAL = 400;
    //Used to determine max amount of days given month should have.
    public static final int ALTMAXDAYS = 30;
    public static final int FEBDAYSLEAP = 29;
    public static final int FEBDAYS = 28;
    public static final int DEFAULTMAXDAYS = 31;
    //Used to represent earliest year possible for a given Date object.
    public static final int YEARMIN = 1900;

    /* Employee() class constants */


    /* Fulltime() class constants */


    /* Management() class constants */


    /* Parttime() class constants */


    /* PayrollProcessing() class constants - Client */


    /* Profile() class constants */



    /**
     * Constructor prevents other classes from instantiating objects of
     * type Consts when calling this class.
     */
    private Consts()
    {
        throw new AssertionError();
    }
}
