package com.huabrother.plm;

import com.huabrother.plm.pojo.Girl;
import com.huabrother.plm.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\8\27 0027
 * 18:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Resource
    private GirlService  girlService;

    @Test
    public void findOne(){
        Girl girl = girlService.findOne(20);
        Assert.assertEquals(new Integer(15),girl.getAge());
    }
}
