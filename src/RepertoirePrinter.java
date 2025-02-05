import java.time.LocalDateTime;

public class RepertoirePrinter {
    private Multiplex multiplex;

    public RepertoirePrinter(Multiplex multiplex) {
        this.multiplex = multiplex;
    }

    public void printRepertoireForNextWeek() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nextWeek = now.plusDays(7);
        System.out.println("Next week repertoire:");
        for (Cinema cinema : multiplex.getCinemas()) {
            for (Showtime showtime : cinema.getShowTimes()) {
                LocalDateTime shTime = showtime.getTime();
                if (shTime.isAfter(now) && shTime.isBefore(nextWeek)) {
                    System.out.println(showtime);
                }
            }
        }
    }
}
