package ru.project.collection_agency.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "users", schema = "public")
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String email;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles = new HashSet<>();

    private String firstName;

    private String lastName;

    private String patronymic;

    private Date birthDate;

    private Gender gender;

    private Long series;

    private Integer number;

    private String issued;

    private Date dateOfIssue;

    private String departmentCode;

    private String location;

    @OneToMany(mappedBy = "debtor")
    private List<Debt> debts = new ArrayList<>();

    @OneToMany(mappedBy = "contractor")
    private List<Contract> contracts = new ArrayList<>();

    public User()
    {

    }

    public User(String username, String password, String email, boolean active, Role role, String firstName,
                String lastName, String patronymic, Date birthDate, Gender gender, Long series, Integer number,
                String issued, Date dateOfIssue, String departmentCode, String location, List<Debt> debts,
                List<Contract> contracts)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.active = active;
        roles.add(role);
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.gender = gender;
        this.series = series;
        this.number = number;
        this.issued = issued;
        this.dateOfIssue = dateOfIssue;
        this.departmentCode = departmentCode;
        this.location = location;
        this.debts = debts;
        this.contracts = contracts;
    }

    @Override
    public String toString()
    {
        List<Long> debtsId = new ArrayList<>();
        List<Long> contractsId = new ArrayList<>();
        Double debtsSum = 0.0;
        Double debtsSumLeft = 0.0;
        for (int i = 0; i < debts.size(); i++)
        {
            if (!debts.get(i).isRepaid()) debtsSumLeft += debts.get(i).getAmount();
            debtsSum += debts.get(i).getAmount();
            debtsId.add(debts.get(i).getId());
            contractsId.add(contracts.get(i).getId());
        }
        return "ID: " + id + "<br>" +
                "Username: " + username + "<br>" +
                "Email: " + email + "<br>" +
                "Active: " + active + "<br>" +
                "Roles: " + roles + "<br><br>" +
                "ФИО: " + "<br>" +
                "Имя: " + firstName + "<br>" +
                "Фамилия: " + lastName + "<br>" +
                "Отчество: " + patronymic + "<br><br>" +
                "Дата рождения: " + birthDate + "<br><br>" +
                "Пол: " + gender + "<br><br>" +
                "Паспортные данные: " + "<br>" +
                "Серия: " + series + "<br>" +
                "Номер: " + number + "<br>" +
                "Кем выдан: " + issued + "<br>" +
                "Дата выдачи: " + dateOfIssue + "<br>" +
                "Код подразделения: " + departmentCode + "<br>" +
                "Место рождения: " + location + "<br><br>" +
                "ID контрактов: " + contractsId + "<br>" +
                "ID долгов: " + debtsId + "<br>" +
                "Общая сумма долга: " + debtsSumLeft + "<br>" +
                "Всего погашено: " + (debtsSum - debtsSumLeft);
    }

    public Long getId() {
        return id;
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

    public List<Debt> getDebts() {
        return debts;
    }

    public void setDebts(List<Debt> debtsId) {
        this.debts = debtsId;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
