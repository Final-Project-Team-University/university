package domain;

public interface IUser extends Comparable{
    int getId();
    void setId(int id);
    String getFirstname();
    void setFirstname(String firstname);
    String getLastname();
    void setLastname(String lastname);
    String getEmail();
    void setEmail(String email);
    String getPassword();
    void setPassword(String password);
    String getUrl();
    void setUrl(String url);
    String getNumber();
    void setNumber(String number);
    String getGroup();
    void setGroup(String group);
    String getMajor();
    void setMajor(String major);
    String getYear();
    void setYear(String year);
}
