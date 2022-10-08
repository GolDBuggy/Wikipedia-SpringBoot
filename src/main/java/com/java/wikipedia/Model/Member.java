package com.java.wikipedia.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id")
    private String id;

    @Column(name = "username")
    private String username;


    @Column(name = "firstname")
    private String firstname;


    @Column(name = "lastname")
    private String lastname;

    @Column(name = "passw")
    private String password;

    @Column(name = "roles")
    private String roles;

}