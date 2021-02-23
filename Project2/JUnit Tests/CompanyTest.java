import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * JUnit Test class for Company(), tests add, remove, and setHours methods.
 @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings({"FieldMayBeFinal", "IfCanBeSwitch"})
public class CompanyTest
{
    private Company company = new Company();

    @Test
    @DisplayName("Testing the addition of Employee objects to Company.")
    void add()
    {
        String[] types = {"E", "P", "F", "M", "E", "P", "F", "M"};
        String[] names = {"Maximillian,Bartholomew", "Charles,Celine",
                "Leong,Sen", "Reynolds,Dennis", "Maximillian,Bartholomew",
                "Charles,Celine", "Leong,Sen", "Reynolds,Dennis"};
        String[] departments = {"CS", "ECE", "IT", "CS",
                "CS", "ECE", "IT", "CS"};
        String[] dates = {"1/19/2020", "4/19/2019", "8/30/2015",
                "8/18/1976", "1/19/2020", "4/19/2019", "8/30/2015",
                "8/18/1976"};
        boolean[] expected = {true, true, true, true,
                false, false, false, false};

        for (int i = 0; i < types.length; i++)
        {
            Employee testE = new Employee();
            if (types[i].equals("P"))
                testE = new Parttime();
            else if (types[i].equals("F"))
                testE = new Fulltime();
            else if (types[i].equals("M"))
                testE = new Management();

            Profile testP = new Profile(names[i], departments[i],
                    new Date(dates[i]));
            testE.setProfile(testP);

            assertEquals(expected[i], company.add(testE));
        }
    }

    @Test
    @DisplayName("Testing the removal of Employee objects from Company.")
    void remove()
    {
        String[] types = {"E", "P", "F", "M", "E", "P", "F", "M"};
        String[] names = {"Maximillian,Bartholomew", "Charles,Celine",
                "Leong,Sen", "Reynolds,Dennis", "Queens of the Stone Age",
                "Michaels,Jillian", "Dijkstra,Edsger", "Hopper,Grace"};
        String[] departments = {"CS", "ECE", "IT", "CS",
                "CS", "PHYSED", "CS", "CS"};
        String[] dates = {"1/19/2020", "4/19/2019", "8/30/2015",
                "8/18/1976", "1/19/2020", "4/19/2019", "DINING/PHILOSOPHERS",
                "1/1/1"};
        boolean[] expected = {true, true, true, true,
                false, false, false, false};

        for (int i = 0; i < types.length; i++)
        {
            Employee testE = new Employee();
            if (types[i].equals("P"))
                testE = new Parttime();
            else if (types[i].equals("F"))
                testE = new Fulltime();
            else if (types[i].equals("M"))
                testE = new Management();

            Profile testP = new Profile(names[i], departments[i],
                    new Date(dates[i]));
            testE.setProfile(testP);
            company.add(testE);

            assertEquals(expected[i], company.remove(testE));
        }
    }

    @Test
    @DisplayName("Testing the assignment of " +
            "hours to Parttime employees within Company.")
    void setHours()
    {
        String[] types = {"E", "P", "F", "M", "P", "P", "M", "M"};
        String[] names = {"Maximillian,Bartholomew", "Charles,Celine",
                "Leong,Sen", "Reynolds,Dennis", "Homme,Josh",
                "Michaels,Jillian", "Dijkstra,Edsger", "Hopper,Grace"};
        String[] departments = {"CS", "ECE", "IT", "CS",
                "IT", "IT", "CS", "CS"};
        String[] dates = {"1/19/2020", "4/19/2019", "8/30/2015",
                "8/18/1976", "05/17/1973", "02/18/1974", "5/11/1930",
                "12/9/1906"};
        int[] hours = {30, 20, 10, 20 , 30, -1, 101, 30, 50};
        boolean[] expected = {false, true, false, false,
                true, false, false, false};

        for (int i = 0; i < types.length; i++)
        {
            Employee testE = new Employee();
            if (types[i].equals("P")) {
                testE = new Parttime();
                ((Parttime) testE).setHoursWorked(hours[i]);
            }
            else if (types[i].equals("F"))
                testE = new Fulltime();
            else if (types[i].equals("M"))
                testE = new Management();

            Profile testP = new Profile(names[i], departments[i],
                    new Date(dates[i]));
            testE.setProfile(testP);
            company.add(testE);

            assertEquals(expected[i], company.setHours(testE));
        }
    }
}
