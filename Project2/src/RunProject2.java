/**
 * Driver class, calls Client class, PayrollProcessing().
 * @author Sagnik Mukherjee, Michael Choe
 */
@SuppressWarnings("WeakerAccess")
public class RunProject2
{
    /**
     * Main method to create instance of client class.
     * @param args The command line arguments.
     */
    public static void main(String[] args)
    {
        new PayrollProcessing().run();
    }
}