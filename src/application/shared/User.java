package application.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {

    private int id, membertypeId;
    private String fname, lname, email, password, zipCode, phoneNumber, gender, age;

    public User (String fname, String lname, String email, String password, String zipCode, String phoneNumber, int membertypeId, String gender, String age) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.membertypeId = membertypeId;
        this.age = age;
    }

    // To login
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getMembertypeId() {
        return membertypeId;
    }

    public void setMembertypeId(int membertypeId) {
        this.membertypeId = membertypeId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return fname + " " + lname;
    }

}
