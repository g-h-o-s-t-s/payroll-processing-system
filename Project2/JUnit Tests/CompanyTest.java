import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
/**
 * JUnit Test class for Company(), tests add, remove, and setHours methods.
 @author Sagnik Mukherjee, Michael Choe
 */
public class CompanyTest
{
    private static Company company;

    @BeforeAll
    static void setup()
    {
        company = new Company();
    }

    @Test
    @DisplayName("Testing the addition of Employee objects to Company.")
    void add()
    {
        //Proper constructors used, results depend on validity of values.
        Date date = new Date("1/19/2020");
        Profile profile = new Profile("Matthews,Connor",
                "CS", date);
        Employee employee1 = new Employee(profile,38000,"FULL TIME");
        assertTrue(company.add(employee1),
                "Employee added, fields valid, should be true.");

        date = new Date("4/19/2099");
        profile = new Profile("Charles,Celine",
                "CS", date);
        Fulltime fulltime1 = new Fulltime(profile,51000,"FULL TIME");
        assertFalse(company.add(fulltime1),
                "Fulltime added, date invalid, should be false.");

        date = new Date("8/30/2015");
        profile = new Profile("Leong M.,Seng",
                "ECE", date);
        Parttime parttime1 = new Parttime(profile,28.99,
                "PART TIME",85);
        assertTrue(company.add(parttime1),
                "Parttime added, fields valid, should be true.");

        date = new Date("8/30/2015");
        profile = new Profile("Reynolds,Dennis",
                "IT", date);
        Parttime parttime1B = new Parttime(profile,26.99,
                "PART TIME",110);
        assertFalse(company.add(parttime1B),
                "Parttime added, >100 hours, should be false.");

        date = new Date("5/12/1990");
        profile = new Profile("King,Regina",
                "IT", date);
        Management management1 = new Management(profile,129000,
                "FULL TIME",99);
        assertFalse(company.add(management1),
                "Management added, fields valid, should be true.");

        //Default constructors used, should fail.
        Employee employee2 = new Employee();
        assertFalse(company.add(employee2),
                "Using default constructor, should return false.");

        Fulltime fulltime2 = new Fulltime();
        assertFalse(company.add(fulltime2),
                "Using default constructor, should return false.");

        Parttime parttime2 = new Parttime();
        assertFalse(company.add(parttime2),
                "Using default constructor, should return false.");

        Management management2 = new Management();
        assertFalse(company.add(management2),
                "Using default constructor, should return false.");
    }

    @Test
    @DisplayName("Testing the removal of Employee objects from Company.")
    void remove()
    {
        //Results will match those of the add() tests.
        Date date = new Date("1/19/2020");
        Profile profile = new Profile("Matthews,Connor",
                "CS", date);
        Employee employee1 = new Employee(profile,38000,"FULL TIME");
        company.add(employee1);
        assertTrue(company.remove(employee1),
                "Employee is already in emplist, should be true.");

        date = new Date("4/19/2099");
        profile = new Profile("Charles,Celine",
                "CS", date);
        Fulltime fulltime1 = new Fulltime(profile,51000,"FULL TIME");
        company.add(fulltime1);
        assertFalse(company.remove(fulltime1),
                "Fulltime is not in emplist, should be false.");

        date = new Date("8/30/2015");
        profile = new Profile("Leong M.,Seng",
                "ECE", date);
        Parttime parttime1 = new Parttime(profile,28.99,
                "PART TIME",85);
        company.add(parttime1);
        assertTrue(company.remove(parttime1),
                "Parttime is in emplist, should be true.");

        date = new Date("8/30/2015");
        profile = new Profile("Reynolds,Dennis",
                "IT", date);
        Parttime parttime1B = new Parttime(profile,26.99,
                "PART TIME",110);
        company.add(parttime1B);
        assertFalse(company.remove(parttime1B),
                "Parttime not in emplist, should be false.");

        date = new Date("5/12/1990");
        profile = new Profile("King,Regina",
                "IT", date);
        Management management1 = new Management(profile,129000,
                "FULL TIME",99);
        company.add(management1);
        assertFalse(company.remove(management1),
                "Management in emplist, should be true.");

        //Default constructors used, should fail.
        Employee employee2 = new Employee();
        company.add(employee2);
        assertFalse(company.remove(employee2),
                "Using default constructor, should return false.");

        Fulltime fulltime2 = new Fulltime();
        company.add(fulltime2);
        assertFalse(company.remove(fulltime2),
                "Using default constructor, should return false.");

        Parttime parttime2 = new Parttime();
        company.add(parttime2);
        assertFalse(company.remove(parttime2),
                "Using default constructor, should return false.");

        Management management2 = new Management();
        company.add(management2);
        assertFalse(company.remove(management2),
                "Using default constructor, should return false.");
    }

    @Test
    @DisplayName("Testing the assignment of " +
            "hours to Parttime employees within Company.")
    void setHours()
    {
        //Will only return true for valid Parttime objects.
        Date date = new Date("1/19/2020");
        Profile profile = new Profile("Matthews,Connor",
                "CS", date);
        Employee employee1 = new Employee(profile,38000,"FULL TIME");
        company.add(employee1);
        assertFalse(company.setHours(employee1),
                "Employee is not a Parttime, should be false.");

        date = new Date("4/19/2099");
        profile = new Profile("Charles,Celine",
                "CS", date);
        Fulltime fulltime1 = new Fulltime(profile,51000,"FULL TIME");
        company.add(fulltime1);
        assertFalse(company.setHours(fulltime1),
                "Not a Parttime, should be false.");

        date = new Date("8/30/2015");
        profile = new Profile("Leong M.,Seng",
                "ECE", date);
        Parttime parttime1 = new Parttime(profile,28.99,
                "PART TIME",85);
        company.add(parttime1);
        assertTrue(company.setHours(parttime1),
                "Parttime is in emplist, should be true.");

        date = new Date("8/30/2015");
        profile = new Profile("Reynolds,Dennis",
                "IT", date);
        Parttime parttime1B = new Parttime(profile,26.99,
                "PART TIME",110);
        company.add(parttime1B);
        assertFalse(company.setHours(parttime1B),
                "Parttime not in emplist, should be false.");

        date = new Date("5/12/1990");
        profile = new Profile("King,Regina",
                "IT", date);
        Management management1 = new Management(profile,129000,
                "FULL TIME",99);
        company.add(management1);
        assertFalse(company.setHours(management1),
                "Management in emplist, should be true.");

        //Default constructors used, should fail.
        Employee employee2 = new Employee();
        company.add(employee2);
        assertFalse(company.setHours(employee2),
                "Using default constructor, should return false.");

        Fulltime fulltime2 = new Fulltime();
        company.add(fulltime2);
        assertFalse(company.setHours(fulltime2),
                "Using default constructor, should return false.");

        Parttime parttime2 = new Parttime();
        company.add(parttime2);
        assertFalse(company.setHours(parttime2),
                "Using default constructor, should return false.");

        Management management2 = new Management();
        company.add(management2);
        assertFalse(company.setHours(management2),
                "Using default constructor, should return false.");
    }
}