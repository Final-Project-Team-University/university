package domain;

public class Club {
    protected int id;
    protected String name;
    protected String description;

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
    public Club(int id, String name, String description){
        super();
        this.id=id;
        this.name=name;
        this.description=description;
    }
    public Club() {
    }
    public Club(String name, String description){
        super();
        this.name=name;
        this.description=description;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

