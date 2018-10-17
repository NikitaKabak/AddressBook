package kabak.entity;


import javax.persistence.*;

@Entity
@Table(name = "telephon")
public class Telephonnumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtelephon;

    @ManyToOne
    @JoinColumn (name = "iduser")
    private Users user;

    @Column
    private String telephonnumber;

    public Telephonnumber(){
    }

    public Integer getIdtelephon() {
        return idtelephon;
    }

    public void setIdtelephon(Integer idtelephon) {
        this.idtelephon = idtelephon;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getTelephonnumber() {
        return telephonnumber;
    }

    public void setTelephonnumber(String telephonnumber) {
        this.telephonnumber = telephonnumber;
    }

    @Override
    public String toString() {
        return "Telephonnumber{" +
                "idtelephon=" + idtelephon +
                ", telephonnumber='" + telephonnumber + '\'' +
                '}';
    }
}
