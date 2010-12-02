import java.sql.*;

/**
 * Simple class to test JDBC Connections
 *
 * @author  Filippo Gadott
 * @version 1.0
 * @date 09/09/2008
 */
public class ConTest
{
    public ConTest(String driver, String url, String usr, String pass)
    {
    	Connection conn;
    	try
        {
            String a = null;
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, usr, pass);
            conn.close();
            System.out.println("Connection successful!");
        }    
        catch (ClassNotFoundException ex)
            {System.err.println("ClassNotFoundException error: " + ex.getMessage());}
        catch (IllegalAccessException ex)
            {System.err.println("IllegalAccessException error: " + ex.getMessage());}
        catch (InstantiationException ex)
            {System.err.println("InstantiationException error: " + ex.getMessage());}
        catch (SQLException ex)
            {System.err.println("SQLException error: " + ex.getMessage());}
    }

    public static void main(String[] args)
    {
        
        if (args.length != 4)
        {
            System.out.println("#################################################################\n");
            System.out.println("\tConnection Test for JDBC drivers\n");
            System.out.println("#################################################################\n");
            System.out.println("   $ java ConTest [driver string] [url] [user] [pass]\n");
            System.out.println("   [dirver string]");
            System.out.println("    The string param for the driver class");
            System.out.println("    e.g. for Oracle thin driver: oracle.jdbc.driver.OracleDriver");
            System.out.println("   [url] [user] [pass]");
            System.out.println("    e.g. for Oracle: jdbc:oracle:thin:@server:port:sid user pass\n");
            System.out.println("\n    *The driver being used must be in the classpath\n");
        }
        else
        {
            String driver = args[0];
            String url = args[1];
            String usr = args[2];
            String pass = args[3];
            new ConTest(driver, url, usr, pass);
        }
    }
  
}