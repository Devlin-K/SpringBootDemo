package com.bootdemo.demo.Domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Person")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(name = "user_name")
    private String UserName;
    private String Password;
    private int Age;
    private int Sex;
    private String Describe;
    private boolean Status;
    private Date Create_Time;
}
