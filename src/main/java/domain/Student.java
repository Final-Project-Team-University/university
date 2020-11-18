package domain;

public class Student extends User{

    public Student(int id, String firstname, String lastname, String email, String password, String url, String number, String group, String major, String year) {
        super.id = id;
        super.firstname = firstname;
        super.lastname = lastname;
        super.email = email;
        super.password = password;
        super.url = url;
        super.number = number;
        super.group = group;
        super.major = major;
        super.year = year;
    }

    public Student(String firstname, String lastname, String email, String password, String url, String number, String group, String major, String year) {
        super.id = id;
        super.firstname = firstname;
        super.lastname = lastname;
        super.email = email;
        super.password = password;
        super.url = url;
        super.number = number;
        super.group = group;
        super.major = major;
        super.year = year;
    }

    public Student() {
    }

    @Override
    public int compareTo(Object o) {
        int id = ((Student)o).getId();
        return this.getId()-id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", number='" + number + '\'' +
                ", group='" + group + '\'' +
                ", major='" + major + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
