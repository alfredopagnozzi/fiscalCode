package com.example.demo.model;

import java.time.LocalDate;


public class Info {

    private LocalDate dateBirth;
    private Integer age;

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer  age) {
        this.age = age;
    }

    public Info(LocalDate  dateBirth, Integer age) {
        this.dateBirth = dateBirth;
        this.age = age;
    }

    public Info() {
    }
}
