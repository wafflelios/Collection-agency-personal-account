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

    @OneToOne
    private Debt debt;

    private Date date;

    private String conditions;

    public Contract()
    {

    }

    public Contract(User contractor, Debt debt, Date date, String conditions) {
        this.contractor = contractor;
        this.debt = debt;
        this.date = date;
        this.conditions = conditions;
    }

    @Override
    public String toString()
    {
        return "ID: " + id + "<br>" +
               "ID дебитора: " + contractor.getId() + "<br>" +
                "ФИО дебитора: " + contractor.getFirstName() + " " + contractor.getLastName() + " " + contractor.getPatronymic() + "<br>" +
                "ID долга" + debt.getId() + "<br>" +
                "Дата заключения договора: " + date + "<br>" +
                "Условия договора: " + conditions;
    }

    public Long getId() {
        return id;
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

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }
}
