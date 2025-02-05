import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Cinema {
    private final Set<CinemaHall> cinemaHalls;

    private final Set<Showtime> showTimes;

    public Cinema(String name, String location) {
        cinemaHalls = new HashSet<>();
        showTimes = new HashSet<>();
    }

    public void addCinemaHall(CinemaHall cinemaHall) {
        cinemaHalls.add(cinemaHall);
    }

    public void addShowTime(Showtime s) {
        showTimes.add(s);
    }

    public Set<CinemaHall> getCinemaHalls() {
        return Collections.unmodifiableSet(cinemaHalls);
    }

    public Set<Showtime> getShowTimes() {
        return Collections.unmodifiableSet(showTimes);
    }


}
