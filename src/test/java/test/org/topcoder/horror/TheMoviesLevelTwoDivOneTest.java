package test.org.topcoder.horror;

import java.util.Arrays;

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
      
      movie = new TheMoviesLevelTwoDivOne.Movie(0, 100, 1);
      
      assertTrue(movie.works(74));
      
      movie = new TheMoviesLevelTwoDivOne.Movie(1, 100, 99);
      assertFalse(movie.works(74));
    }
    
    
    
    public void test0() {
      int [] ret =  movieTester.find(new int [] {100, 50}, new int [] {1, 1});
      System.out.print("ret is ");
      for (int i = 0; i < ret.length; i++) System.out.print("" + ret[i] + " ");
      System.out.println("");
      assertTrue(Arrays.equals(new int [] {0, 1}, ret));

    }
}
