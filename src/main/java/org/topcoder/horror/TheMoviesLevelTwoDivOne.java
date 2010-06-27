package org.topcoder.horror;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TheMoviesLevelTwoDivOne 
{
    public static class Movie {
      public int id;
      public int length;
      public int scary;

      public Movie (int id, int length, int scary) {
        this.id = id;
        this.length = length;
        this.scary = scary;
      }
      
      public boolean equals(Object o) {
        Movie other = (Movie) o;
        return id == other.id;
      }
      
      public int hashCode() {
        return id;
      }
      
      public boolean works(int currentSleepiness) {
        // the sleepy minutes are before the scary minute, hence the -1
        return (currentSleepiness - (scary - 1) > THRESHOLD_SLEEPINESS) &&
          (currentSleepiness + SCARINESS_INCREMENT - length > THRESHOLD_SLEEPINESS);
      }
            
      
    }
    
    
    /**
     * We are to return in the lowest lexicographical order.  This compels us
     * to try the movies in order, front to back.
     * 
     * Have a loop that proceeds in order across a list of movies.  Take the
     * first movie off the list.  If this movie fails us, increment the loop.
     * If this movie works, recurse on the tail of the list.  If we empty the 
     * list, we are done!
     * 
     * 
     * @param length
     * @param scary
     * @return
     */
    
    public static final int INITIAL_SLEEPINESS = 74;
    
    public static final int THRESHOLD_SLEEPINESS = 0;
    
    public static final int SCARINESS_INCREMENT = 47;
    
    
    
    public boolean works(List moviesTaken, List moviesRemaining, int currentSleepiness) {
      
      if (moviesRemaining.size() == 0) return true;

      for (int m = 0; m < moviesRemaining.size(); m++) {
        Movie movie = (Movie) moviesRemaining.get(m);
        if (movie.works(currentSleepiness)) {
          int oldSleepiness = currentSleepiness;
          currentSleepiness = currentSleepiness - movie.length + SCARINESS_INCREMENT;
          moviesTaken.add(moviesRemaining.get(m));
          moviesRemaining.remove(m);
          
          currentMovieList.add(movie);
          
          if (currentMovieList.size() > bestSoFarMovieList.size())
            bestSoFarMovieList = (List) currentMovieList.clone();
          
          
          // recurse with moviesTaken and moviesRemaining adjusted
          if (works(moviesTaken, moviesRemaining, currentSleepiness))
            return true;
          
          // can't find solution for this movie, backtrack
          
          // put this back where we found it
          moviesRemaining.add(m, movie);
          moviesTaken.remove(movie);
          currentMovieList.remove(movie);

          currentSleepiness = oldSleepiness;
        }
      }
      
      return false;
    }
    
    private List bestSoFarMovieList;
    
    private ArrayList currentMovieList;
    
    
    public int [] find(int [] length, int [] scary) {
      
      int [] ret = new int[length.length];
      
      ArrayList movies = new ArrayList();
      bestSoFarMovieList = new ArrayList();
      currentMovieList = new ArrayList();
      List moviesCopy = (List) movies.clone();
      
      for (int m = 0; m < length.length; m++)
        movies.add(new Movie(m, length[m], scary[m]));
      
      List taken = new ArrayList();
      
      int awakedness = INITIAL_SLEEPINESS;
      works(taken, movies, awakedness);
      
      Iterator iter = taken.iterator();
      int m = 0;
      while (iter.hasNext()) {
        Movie movie = (Movie) iter.next();
        ret[m] = movie.id;
        moviesCopy.remove(movie);
        m++;
      }
      
      iter = moviesCopy.iterator();
      
      while (iter.hasNext()) {
        Movie movie = (Movie) iter.next();
        ret[m] = movie.id;
        m++;
      }
        
    
      return ret;
      
    }
}
