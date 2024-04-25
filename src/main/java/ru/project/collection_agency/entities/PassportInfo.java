package ru.project.collection_agency.entities;

import java.util.Date;

public class PassportInfo
{
    private Long series;

    private Integer number;

    private String issued;

    private Date dateOfIssue;

    private String departmentCode;

    private String location;

    public PassportInfo(Long series, Integer number, String issued, Date dateOfIssue, String departmentCode, String location)
    {
        this.series = series;
        this.number = number;
        this.issued = issued;
        this.dateOfIssue = dateOfIssue;
        this.departmentCode = departmentCode;
        this.location = location;
    }

    public long getSeries()
    {
        return series;
    }

    public void setSeries(Long series)
    {
        this.series = series;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(Integer number)
    {
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

    @Override
    public String toString()
    {
        return String.format("""
                Серия паспорта: %s\
                Номер паспорта: %s\
                Паспорт выдан: %s\
                Дата выдачи: %s\
                Код подразделения: %s\
                Место жительства: %s\
                """, series, number, issued, dateOfIssue, departmentCode, location);
    }
}

