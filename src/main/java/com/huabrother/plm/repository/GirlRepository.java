package com.huabrother.plm.repository;

import com.huabrother.plm.pojo.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * chenwenhua
 * 2018\8\21 0021
 * 11:40
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    public List<Girl> findByAge(Integer id);
}
