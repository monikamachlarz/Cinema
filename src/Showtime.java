import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Showtime {
    private final CinemaHall cinemaHall;
    private LocalDateTime time;
    private IMovie movie;
    private boolean isVIP;
    private boolean is3D;
    private Set<Reservation> reservations;

    private Set<Ticket> tickets;

    public Showtime(LocalDateTime time, IMovie movie, boolean isVIP, boolean is3D, CinemaHall cinemaHall) {
        this.time = time;
        this.movie = movie;
        this.isVIP = isVIP;
        this.is3D = is3D;
        this.cinemaHall = cinemaHall;
        this.reservations = new HashSet<>();
        this.tickets = new HashSet<>();
    }

    public Reservation addReservation(Customer customer, Seat seatToReserve) {
        Reservation r = new Reservation(customer, seatToReserve);
        reservations.add(r);
        return r;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public IMovie getMovie() {
        return movie;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public boolean is3D() {
        return is3D;
    }

    public Seat getFirstAvailableSeat() {
        for (Seat seat : cinemaHall.getSeats()) {
            boolean isReserved = false;
            for (Reservation reservation : reservations) {
                if (reservation.getSeat().getSeatNumber() == seat.getSeatNumber()) {
                    isReserved = true;
                    break;
                }
            }
            if (!isReserved) {
                for (Ticket ticket : tickets) {
                    if (ticket.getSeat().getSeatNumber() == seat.getSeatNumber()) {
                        isReserved = true;
                        break;
                    }
                }

            }
            if (!isReserved) {
                return seat;
            }
        }
        return null;
    }

    public void addTicket(Ticket t) {
        tickets.add(t);
    }

    public Set<Ticket> getTickets() {
        return Collections.unmodifiableSet(tickets);
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "time='" + time + '\'' +
                ", movie=" + movie +
                '}';
    }
}
