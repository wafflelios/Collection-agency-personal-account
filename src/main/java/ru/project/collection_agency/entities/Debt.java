package ru.project.collection_agency.entities;

import jakarta.persistence.*;

@Entity
public class Debt
{
    @Id
    @GeneratedValue
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    private Long debtorId;

    private Double amount;

    private String creditor;

    public Debt(Long debtorId, Double amount, String creditor)
    {
        this.debtorId = debtorId;
        this.amount = amount;
        this.creditor = creditor;
    }

    public Long getId() {
        return id;
    }

    public Long getDebtorId()
    {
        return debtorId;
    }

    public void setDebtorId(Long debtorId)
    {
        this.debtorId = debtorId;
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
                ID дебитора: %s\
                Величина долга (в руб.): %s\
                Кредитор: %s\
                """, id, debtorId, amount, creditor);
    }
}
