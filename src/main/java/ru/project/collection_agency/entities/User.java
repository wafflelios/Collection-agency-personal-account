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

    //@OneToMany(mappedBy = "debtorId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Long> debtsId = new ArrayList<>();

    // private int[] contractsID;

    public User(String firstName, String lastName, String patronymic, Date birthDate, Gender gender,
                Long passportSeries, Integer passportNumber, String passportIssued, Date dateOfIssue,
                String departmentCode, String location, List<Long> debtsId)
    {
        fullName = new FullName(firstName, lastName, patronymic);
        this.birthDate = birthDate;
        this.gender = gender;
        passportInfo = new PassportInfo(passportSeries, passportNumber, passportIssued, dateOfIssue, departmentCode,
                location);
        this.debtsId = debtsId;
        // this.contractsID = contractsID;
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

    public List<Long> getDebts() {
        return debtsId;
    }

    public void setDebts(List<Long> debtsId) {
        this.debtsId = debtsId;
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
}
