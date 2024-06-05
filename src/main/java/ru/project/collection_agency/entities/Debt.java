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

    @OneToOne(mappedBy = "debt")
    private Contract contract;

    private Double amount;

    private String creditor;

    private boolean repaid;

    public Debt()
    {

    }

    public Debt(User debtor, Contract contract, Double amount, String creditor, boolean repaid)
    {
        this.debtor = debtor;
        this.contract = contract;
        this.amount = amount;
        this.creditor = creditor;
        this.repaid = repaid;
    }

    @Override
    public String toString()
    {
        return "ID: " + id + "<br>" +
                "ID дебитора: " + debtor.getId() + "<br>" +
                "ФИО дебитора: " + debtor.getFirstName() + " " + debtor.getLastName() + " " + debtor.getPatronymic() + "<br>" +
                "ID договора: " + contract.getId() + "<br>" +
                "Сумма долга: " + amount + "<br>" +
                "Кредитор: " + creditor + "<br>" +
                "Погашен: " + repaid;
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public boolean isRepaid() {
        return repaid;
    }

    public void setRepaid(boolean repaid) {
        this.repaid = repaid;
    }
}
