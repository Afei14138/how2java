package entity;

public class User {
    private String name;
    private Integer phoneId;

    public User(String name, Integer phoneId) {
        this.name = name;
        this.phoneId = phoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }
}
