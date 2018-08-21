package com.huabrother.plm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * chenwenhua
 * 2018\8\21 0021
 * 11:40
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer id);
}
