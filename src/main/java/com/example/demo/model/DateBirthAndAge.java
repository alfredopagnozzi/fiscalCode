package com.example.demo.model;

import java.util.Date;


public class DateBirthAndAge {

    private Date dateBirth;
    private Integer age;

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer  age) {
        this.age = age;
    }

    public DateBirthAndAge(Date  dateBirth, Integer age) {
        this.dateBirth = dateBirth;
        this.age = age;
    }

    public DateBirthAndAge() {
    }
}
