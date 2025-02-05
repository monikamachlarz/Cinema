public class Reservation {
    private final Customer customer;
    private final Seat seat;

    public Reservation(Customer customer, Seat seat) {
        this.customer = customer;
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Seat getSeat() {
        return seat;
    }

}
