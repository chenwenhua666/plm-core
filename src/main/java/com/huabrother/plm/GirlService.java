package com.huabrother.plm;

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
}
