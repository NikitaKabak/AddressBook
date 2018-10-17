package kabak.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer iduser;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String comments;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String position;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Email> emailList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Telephonnumber> telephonnumberList = new ArrayList<>();

    public Users(){
    }


    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Email> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<Email> emailList) {
        this.emailList = emailList;
    }

    public List<Telephonnumber> getTelephonnumberList() {
        return telephonnumberList;
    }

    public void setTelephonnumberList(List<Telephonnumber> telephonnumberList) {
        this.telephonnumberList = telephonnumberList;
    }

    @Override
    public String toString() {
        return "Users{" +
                "iduser=" + iduser +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
