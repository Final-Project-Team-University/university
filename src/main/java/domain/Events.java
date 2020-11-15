package domain;

public class Events {
    protected int id;
    protected String name;
    protected String description;
    protected String date;


    public Events(){

    }

    public Events(int id, String name, String description, String date) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public Events(String name, String description, String date) {
        super();
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

}
