package ru.project.collection_agency.entities;

public class FullName
{
    private String firstName;

    private String lastName;

    private String patronymic;

    public FullName(String firstName, String lastName, String patronymic)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPatronymic()
    {
        return patronymic;
    }

    public void setPatronymic(String patronymic)
    {
        this.patronymic = patronymic;
    }

    @Override
    public String toString()
    {
        return String.format("ФИО: %s %s %s ", firstName, lastName, patronymic);
    }
}

