import java.util.HashSet;
import java.util.Set;

public class TicketOffice {
    private final Multiplex multiplex;

    public TicketOffice(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

    public Ticket sellTicket(Showtime showtime, Reservation reservation) {
        Ticket t = new Ticket(reservation.getSeat(), reservation.getCustomer());
        showtime.addTicket(t);
        return t;
    }

    public Ticket sellTicket(Showtime showtime, Customer customer, Seat seat) {
        Ticket t = new Ticket(seat, customer);
        showtime.addTicket(t);
        return t;
    }

    public Set<Ticket> getTicketsForCustomer(Customer c) {
        return new HashSet<>(
                multiplex.getCinemas().stream().flatMap(ci->ci.getShowTimes().stream()).flatMap(s->s.getTickets().stream()).filter(t->c.equals(t.getCustomer())).toList()
        );
    }
}
