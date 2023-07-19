package dev.gracialab.glab.model;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.sql.Time;
// import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column
    private java.sql.Time hour;

    @Column
    private Boolean state;

    @Column
    private String reserve_type;

    @Column
    private Integer number_of_people;

    @Column
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id") //referencedColumnName
    private User user_id;

    


    public Reserve(Long id, Date date, Time hour, Boolean state, String reserve_type, Integer number_of_people,
            String note, User user_id) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.state = state;
        this.reserve_type = reserve_type;
        this.number_of_people = number_of_people;
        this.note = note;
        this.user_id = user_id;
    }
    
    

    public Reserve() {
    }

    public Reserve(Date date, Time hour, Boolean state, String reserve_type, Integer number_of_people, String note,
            User user_id) {
        this.date = date;
        this.hour = hour;
        this.state = state;
        this.reserve_type = reserve_type;
        this.number_of_people = number_of_people;
        this.note = note;
        this.user_id = user_id;
    }

    
    public Reserve(Long id, Date date, Time hour, Boolean state, String reserve_type, Integer number_of_people,
            String note) {
        this.id = id;
        this.date = date;
        this.hour = hour;
        this.state = state;
        this.reserve_type = reserve_type;
        this.number_of_people = number_of_people;
        this.note = note;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public java.sql.Time getHour() {
        return hour;
    }

    public void setHour(java.sql.Time hour) {
        // this.hour = new java.sql.Time(hour.getTime());
        this.hour = hour;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getReserve_type() {
        return reserve_type;
    }

    public void setReserve_type(String reserve_type) {
        this.reserve_type = reserve_type;
    }

    public Integer getNumber_of_people() {
        return number_of_people;
    }

    public void setNumber_of_people(Integer number_of_people) {
        this.number_of_people = number_of_people;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public User getUser_id() {
        return user_id;
    }

    public Long getUserId() {
        
        return user_id.getId();
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    // public User getUser_mail() {
    //     return user_id;
    // }

}
