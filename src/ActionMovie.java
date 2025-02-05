public class ActionMovie extends AbstractMovie {

    public ActionMovie(String title, int duration) {
        super(title, duration);
    }

    @Override
    public String getGenre() {
        return "Action";
    }
}
