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
    private User debtor;

    private Debt debt;

    private Date date;

    private String conditions;

    public Contract(Long id, User debtor, Debt debt, Date date, String conditions) {
        this.id = id;
        this.debtor = debtor;
        this.debt = debt;
        this.date = date;
        this.conditions = conditions;
    }

    public Long getId() {
        return id;
    }

    public User getDebtor() {
        return debtor;
    }

    public void setDebtorId(User debtor) {
        this.debtor = debtor;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
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
