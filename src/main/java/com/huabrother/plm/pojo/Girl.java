package com.huabrother.plm.pojo;

import javax.persistence.*;
import javax.validation.constraints.*;

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
    @Min(value = 18,message = "未成年禁止")
    @Max(value = 150,message = "超过年龄限制")
    private Integer age;

    @NotBlank(message = "cup为必填")
    private String cupSize;

    @NotNull(message = "金额必填")
    private Double money;

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", age=" + age +
                ", cupSize='" + cupSize + '\'' +
                ", money=" + money +
                '}';
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
