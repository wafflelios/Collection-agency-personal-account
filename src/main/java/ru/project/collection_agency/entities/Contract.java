package ru.project.collection_agency.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "contracts", schema="public")
public class Contract
{
    @Id
    @GeneratedValue
    private Long id;

    private Long debtorId;

    private Long debtId;

    private Date date;

    private String conditions;

    public Contract(Long id, Long debtorId, Long debtId, Date date, String conditions) {
        this.id = id;
        this.debtorId = debtorId;
        this.debtId = debtId;
        this.date = date;
        this.conditions = conditions;
    }

    public Long getId() {
        return id;
    }

    public Long getDebtorId() {
        return debtorId;
    }

    public void setDebtorId(Long debtorId) {
        this.debtorId = debtorId;
    }

    public Long getDebtId() {
        return debtId;
    }

    public void setDebtId(Long debtId) {
        this.debtId = debtId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
