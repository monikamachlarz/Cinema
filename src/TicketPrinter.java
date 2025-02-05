public class TicketPrinter {
    private Multiplex multiplex;

    public TicketPrinter(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

    public void printTicket(Ticket t) {
        Showtime s = findShowtime(t);
        System.out.printf("Ticket for %s at %s.%n", s.getMovie(), s.getTime());
        System.out.println("Seat number: " + t.getSeat());
        if(t.getCustomer() != null) {
            System.out.println("Customer: " + t.getCustomer().getName());
        }
    }

    private Showtime findShowtime(Ticket t) {
        for (Cinema cinema : multiplex.getCinemas()) {
            for (Showtime sh : cinema.getShowTimes()) {
                if (sh.getTickets().contains(t)) {
                    return sh;
                }
            }
        }
        return null;
    }
}
