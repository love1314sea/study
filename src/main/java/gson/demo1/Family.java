package gson.demo1;

/**
 * Created by wushang on 15/7/9.
 */
public class Family {
    private String phone;
    private String email;
    private Person person;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return email+":"+phone+":"+ person;
    }
}
