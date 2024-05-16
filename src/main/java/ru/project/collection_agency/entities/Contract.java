package ru.project.collection_agency.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contracts", schema="public")
public class Contract
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User contractor;

    private Long debtId;

    private Date date;

    private String conditions;

    public Contract(Long id, User contractor, Long debtId, Date date, String conditions) {
        this.id = id;
        this.contractor = contractor;
        this.debtId = debtId;
        this.date = date;
        this.conditions = conditions;
    }

    public Long getId() {
        return id;
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

    public User getContractor() {
        return contractor;
    }

    public void setContractor(User contractor) {
        this.contractor = contractor;
    }
}
