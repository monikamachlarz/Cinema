import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Multiplex {
    private final Set<Cinema> cinemas = new HashSet<>();
    private final Set<IMovie> movies = new HashSet<>();

    public void addMovie(IMovie m) {
        movies.add(m);
    }

    public void addCinema(Cinema c) {
        cinemas.add(c);
    }

    public Set<Cinema> getCinemas() {
        return Collections.unmodifiableSet(cinemas);
    }

    public Set<IMovie> getMovies() {
        return Collections.unmodifiableSet(movies);
    }
}
