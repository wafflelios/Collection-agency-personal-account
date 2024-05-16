package ru.project.collection_agency.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "debts", schema="public")
public class Debt
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User debtor;

    private Double amount;

    private String creditor;

    public Debt(User debtor, Double amount, String creditor)
    {
        this.debtor = debtor;
        this.amount = amount;
        this.creditor = creditor;
    }

    public Long getId() {
        return id;
    }

    public User getDebtor()
    {
        return debtor;
    }

    public void setDebtorId(User debtor)
    {
        this.debtor = debtor;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    @Override
    public String toString()
    {
        return String.format("""
                ID: %s\
                Дебитора: %s\
                Величина долга (в руб.): %s\
                Кредитор: %s\
                """, id, debtor.getFullName(), amount, creditor);
    }
}
