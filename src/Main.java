import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Tworzymy filmy
        ActionMovie movie1 = new ActionMovie("StarWars", 120);
        ActionMovie movie2 = new ActionMovie("Titanic", 200);

        //Tworzymy mulitipleks
        Multiplex multiplex = new Multiplex();

        //Dodajemy do niego filmy
        multiplex.addMovie(movie1);
        multiplex.addMovie(movie2);

        //Internetowe biuro biletowe
        TicketOffice globalTicketOffice = new TicketOffice(multiplex);

        //Tworzymy kina
        Cinema cinema1 = new Cinema("CinemaCity", "Katowice");
        Cinema cinema2 = new Cinema("CinemaCity", "Chorzów");

        //I dodajemy je do multipleksu
        multiplex.addCinema(cinema1);
        multiplex.addCinema(cinema2);

        //Dodajemy sale kinowe do kin
        CinemaHall cinema_hall1 = new CinemaHall(1, 100);
        CinemaHall cinema_hall2 = new CinemaHall(2, 150);
        cinema1.addCinemaHall(cinema_hall1);
        cinema1.addCinemaHall(cinema_hall2);

        //Tworzymy seans
        LocalDateTime today1800 = LocalDate.now().atTime(18, 0);
        Showtime showtime1 = new Showtime(today1800.plusDays(1), movie1, true, true, cinema_hall1);
        Showtime showtime2 = new Showtime(today1800.plusDays(2), movie2, false, false, cinema_hall2);
        Showtime showtime3 = new Showtime(today1800.plusDays(10), movie2, false, false, cinema_hall2);
        cinema1.addShowTime(showtime1);
        cinema1.addShowTime(showtime2);
        cinema1.addShowTime(showtime3);

        //Klient rezerwuje miejsce
        Customer customer = new Customer("John Doe", "john.doe@example.com");
        //przygotujmy system wydruku
        TicketPrinter ticketPrinter = new TicketPrinter(multiplex);
        //Nie chcemy, żeby dwóch klientów przypadkowo zostało przypisanych do tego samego miejsca
        synchronized (showtime1) {
            Seat seatToReserve = showtime1.getFirstAvailableSeat(); //Klient rezerwuje pierwsze dostępne miejsce
            Reservation reservation = showtime1.addReservation(customer, seatToReserve);
            Ticket ticket = globalTicketOffice.sellTicket(showtime1, reservation);
            ticketPrinter.printTicket(ticket);
        }

        //Drugi klient kupuje bilet bez rezerwacji
        synchronized (showtime1) {
            Seat seatToReserve = showtime1.getFirstAvailableSeat();
            Ticket ticket = globalTicketOffice.sellTicket(showtime1, customer, seatToReserve);
            ticketPrinter.printTicket(ticket);
        }

        //Trzeci klient jest anonimowy
        synchronized (showtime1) {
            Seat seatToReserve = showtime1.getFirstAvailableSeat();
            Ticket ticket = globalTicketOffice.sellTicket(showtime1, null, seatToReserve);
            ticketPrinter.printTicket(ticket);
        }

        //Repertuar na najbliższy tydzień
        new RepertoirePrinter(multiplex).printRepertoireForNextWeek();

        //Użytkownik chce sprawdzić swoje bilety
        System.out.printf("Bilety użytkownika %s: %n", customer);
        globalTicketOffice.getTicketsForCustomer(customer).stream().forEach(t -> ticketPrinter.printTicket(t));
    }
}