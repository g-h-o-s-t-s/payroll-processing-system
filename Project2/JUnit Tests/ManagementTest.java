import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * JUnit Test class for Management(), tests the calculatePayment method.
 @author Sagnik Mukherjee, Michael Choe
 */
public class ManagementTest
{
    @Test
    @DisplayName("Testing the calculation of paychecks for Management.")
    void calculatePayment()
    {
        String[] names = {"Maximillian,Bartholomew", "Charles,Celine",
                "Leong,Sen", "Reynolds,Dennis", "Homme,Josh",
                "Michaels,Jillian", "Dijkstra,Edsger", "Hopper,Grace"};
        String[] departments = {"CS", "ECE", "IT", "CS",
                "IT", "IT", "CS", "CS"};
        String[] dates = {"1/19/2020", "4/19/2019", "8/30/2015",
                "8/18/1976", "05/17/1973", "02/18/1974", "5/11/1930",
                "12/9/1906"};
        double[] salaries = {50000, 90000, 120000, 140000 ,
                12000, 73991, 59242.29, 23942.12, 50002};
        int[] codes = {1, 2, 2, 3, 3, 3, 2, 2, 1};
        double[] expected = {2115.39, 3826.92, 4980.76, 5846.16,
                923.08, 3307.35, 2643.93, 1286.23};

        for (int i = 0; i < names.length; i++)
        {
            Profile testP = new Profile(names[i], departments[i],
                    new Date(dates[i]));
            Management management =
                    new Management(testP, salaries[i], codes[i]);
            management.calculatePayment();

            assertEquals(expected[i],Math.round(
                    management.getPeriodEarnings()
                            * Consts.ROUNDING) / Consts.ROUNDING);
        }
    }
}