package com.vince.java.learn.entity;

/**
 * @author vince_zh
 */
public class User {
    private Long id;
    private String address;
    private String psw;
    private String name;
    private String telephone;
    public User() {
        super();
    }
    public User(Long id,String address,String psw,String name,String telephone) {
        super();
        this.id = id;
        this.address = address;
        this.psw = psw;
        this.name = name;
        this.telephone = telephone;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPsw() {
        return this.psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", psw='" + psw + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
