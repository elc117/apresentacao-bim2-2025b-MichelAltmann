package model;

public class Achievement {

    private final String name;
    private final String title;
    private final String reason;

    public Achievement(String name, String title, String reason) {
        this.name = name;
        this.title = title;
        this.reason = reason;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getReason() {
        return reason;
    }

}
