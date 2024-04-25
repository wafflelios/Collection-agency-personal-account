package ru.project.collection_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Contract
{
    @Id
    @GeneratedValue
    private Long id;

    private Long debtorId;

    private Long debtId;

    private Date date;

    private String conditions;
}
