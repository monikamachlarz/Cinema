import java.util.LinkedHashSet;

public class CinemaHall {
    private LinkedHashSet<Seat> seats;

    public CinemaHall(int number, int capacity) {
        this.seats = new LinkedHashSet<>();
        for (int i = 1; i <= capacity; i++) {
            seats.add(new Seat(i));
        }
    }

    public LinkedHashSet<Seat> getSeats() {
        return new LinkedHashSet<>(seats);
    }
}
