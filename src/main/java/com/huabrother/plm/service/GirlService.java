package com.huabrother.plm.service;

import com.huabrother.plm.enums.ResultEnum;
import com.huabrother.plm.exception.GirlException;
import com.huabrother.plm.pojo.Girl;
import com.huabrother.plm.repository.GirlRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\8\21 0021
 * 13:28
 */
@Service
public class GirlService {

    @Resource
    public GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(20);
        girlB.setCupSize("BBBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOLE);
        } else if (age >10 && age <16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOLE);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findById(id).orElse(null);
    }
}
