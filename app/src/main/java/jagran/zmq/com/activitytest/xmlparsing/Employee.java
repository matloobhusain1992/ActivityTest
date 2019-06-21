package jagran.zmq.com.activitytest.xmlparsing;

/**
 * Created by zmq181 on 29/3/19.
 */

public class Employee {
    private String name;
    private int age;
    private String role;
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+role+" "+gender;
    }
}
