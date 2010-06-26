package test.org.topcoder.horror;

import org.topcoder.horror.TheMoviesLevelTwoDivOne;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TheMoviesLevelTwoDivOneTest 
    extends TestCase
{
    private TheMoviesLevelTwoDivOne movieTester;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TheMoviesLevelTwoDivOneTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TheMoviesLevelTwoDivOneTest.class );
    }
    
    
    public void setUp() {
      this.movieTester = new TheMoviesLevelTwoDivOne();
    }
    
    public void tearDown() {
      this.movieTester = null;
    }

    /**
     * 
     */
    public void testWorks()
    {
      TheMoviesLevelTwoDivOne.Movie movie;
      TheMoviesLevelTwoDivOne movieTester = new TheMoviesLevelTwoDivOne();
      
      movie = new TheMoviesLevelTwoDivOne.Movie(0, 100, 1);
      
      assertTrue(movieTester.works(movie, 74));
      
      movie = new TheMoviesLevelTwoDivOne.Movie(1, 100, 99);
      assertFalse(movieTester.works(movie, 74));
    }
}
