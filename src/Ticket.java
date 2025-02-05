public class Ticket {
    private Seat seat;
    private Customer customer;

    public Ticket(Seat seat, Customer customer) {
        this.seat = seat;
        this.customer = customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public Customer getCustomer() {
        return customer;
    }
}
