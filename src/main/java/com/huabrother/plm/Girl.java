package com.huabrother.plm;

import javax.persistence.*;

/**
 * chenwenhua
 * 2018\8\20 0020
 * 0:46
 */
@Entity
@Table(name = "girlCup")
public class Girl {
    @Id
    @GeneratedValue
    private  Integer id;

    @Column(name = "grilAge")
    private Integer age;

    private String cupSize;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }
}
