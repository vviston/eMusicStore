package com.emusicstore.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date startDate;
    private String room;
    private String cluster;
    private String chapter;

    @Transient //no serialization to the DB but store in resources
    private MultipartFile userPhoto;
}