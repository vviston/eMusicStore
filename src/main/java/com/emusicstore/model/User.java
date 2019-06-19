package com.emusicstore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String comsi;
    private Date startDate;
    private String room;
    private String team;

    @Transient //no serialization to the DB but store in resources
    private MultipartFile userPhoto;
}