package application.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class User implements IsSerializable {

    private int id, membertypeId, age, zipCode, phoneNumber;
    private String fname, lname, email, password, gender;

    public User (String fname, String lname, String email, String password, int zipCode, int phoneNumber, int membertypeId, String gender, int age) {
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return fname + " " + lname;
    }

}
