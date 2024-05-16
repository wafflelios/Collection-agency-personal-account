package ru.project.collection_agency.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    @Convert(converter = FullNameAttributeConverter.class)
    private FullName fullName;

    private Date birthDate;

    private Gender gender;

    @Convert(converter = PassportInfoAttributeConverter.class)
    private PassportInfo passportInfo;

    @OneToMany(mappedBy = "debtor")
    private List<Debt> debts = new ArrayList<>();

    @OneToMany(mappedBy = "contractor")
    private List<Contract> contracts = new ArrayList<>();

    public User(String firstName, String lastName, String patronymic, Date birthDate, Gender gender,
                Long passportSeries, Integer passportNumber, String passportIssued, Date dateOfIssue,
                String departmentCode, String location, List<Debt> debts, List<Contract> contracts)
    {
        fullName = new FullName(firstName, lastName, patronymic);
        this.birthDate = birthDate;
        this.gender = gender;
        passportInfo = new PassportInfo(passportSeries, passportNumber, passportIssued, dateOfIssue, departmentCode,
                location);
        this.debts = debts;
        this.contracts = contracts;
    }

    public Long getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PassportInfo getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(PassportInfo passportInfo) {
        this.passportInfo = passportInfo;
    }

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debtsId) {
        this.debts = debtsId;
    }

    @Override
    public String toString()
    {
        return String.format("""
                ID: %s\
                ФИО: %s\
                Дата рождения: %s\
                Пол: %s\
                Паспортные данные: %s\
                """, id, fullName.toString(), birthDate, gender, passportInfo.toString());
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
