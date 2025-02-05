public abstract class AbstractMovie implements IMovie {
    private String title;
    private int duration;

    public AbstractMovie(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
