package com.huabrother.plm.controller;

import com.huabrother.plm.pojo.Girl;
import com.huabrother.plm.repository.GirlRepository;
import com.huabrother.plm.service.GirlService;
import com.huabrother.plm.utils.ResultUtil;
import com.huabrother.plm.vo.Result;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * chenwenhua
 * 2018\8\21 0021
 * 11:36
 */

@RestController
public class GirlController {
    private  final static Logger log = LoggerFactory.getLogger(GirlController.class);

    @Resource
    private GirlRepository girlRepository;
    @Resource
    private GirlService girlService;

    @GetMapping(value = "/showAll")
    public List<Girl> showGirls(){
        log.info("显示全部");
        return girlRepository.findAll();
    }

    //@RequestMapping(value = "/add",method = RequestMethod.POST)
    @PostMapping(value = "/add")
    public Result add(@Valid Girl girl , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return null;
         //  return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        girl.setMoney(girl.getMoney());
        return  ResultUtil.success(girlRepository.save(girl));
    }

    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public Girl findOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null);
    }

    @PutMapping(value = "/update/{id}")
    public Girl update(@PathVariable Integer id,
                       @RequestParam String cupSize,
                       @RequestParam Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setId(id);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete (@PathVariable Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/findAge/{age}")
    public List<Girl> findByAge(@PathVariable Integer age){
        return  girlRepository.findByAge(age);
    }

    @GetMapping(value = "/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
