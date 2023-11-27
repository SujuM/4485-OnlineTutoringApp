package com.tutoring.springdatajpa.entities;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

import java.util.Collection;

@Entity(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column
    private boolean enabled;

    @Column
    private Boolean isTutor = false;

    @Column
    private Boolean isCriminal = false;

    @OneToMany
    private List <User> favoriteTutorList;

    @Column
    private int totalHours;




    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, Boolean isTutor, Boolean isCriminal) {
        this.username = username;
        this.password = password;
        this.isTutor = isTutor;
        this.isCriminal = isCriminal;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){this.password = password;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public Boolean isTutor() {return isTutor;}

    public void setIsTutor(boolean isTutor){this.isTutor = isTutor;}

    public Boolean isCriminal(){return isCriminal;}
    public void setIsCriminal(boolean isCriminal){this.isCriminal = isCriminal;}

    public void setTotalHours(int totalHours){this.totalHours = totalHours;}
    public void addTotalHours(int hours){this.totalHours += hours;}
    public List<User> getFavoriteTutorList(){return favoriteTutorList;}

    public void addTutorToFavorites(User tutor)
    {
        if(favoriteTutorList.contains(tutor) == false)
        {
            favoriteTutorList.add(tutor);
        }
    }
    public int getTotalHours(){return totalHours;}
    public void removeTutorFromFavorites(User tutor)
    {
        if(favoriteTutorList.contains(tutor) == true)
        {
            favoriteTutorList.remove(tutor);
        }
    }
}
