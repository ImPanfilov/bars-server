package com.impanfilov.barsserver.model;

import lombok.Data;

import javax.persistence.*;
import java.time.ZonedDateTime;


@Entity
@Data
@Table(name = "contract")
public class Contract {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "number")
    String number;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", columnDefinition = "TIMESTAMP")
    ZonedDateTime date;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_last_modified", columnDefinition = "TIMESTAMP")
    ZonedDateTime dateLastModified;

}
