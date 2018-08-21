package com.huabrother.plm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * chenwenhua
 * 2018\8\21 0021
 * 11:36
 */

@RestController
public class GirlController {

    @Resource
    private GirlRepository girlRepository;
    @Resource
    private GirlService girlService;

    @GetMapping(value = "/showAll")
    public List<Girl> showGirls(){
        return girlRepository.findAll();
    }

    //@RequestMapping(value = "/add",method = RequestMethod.POST)
    @PostMapping(value = "/add")
    public Girl add(@RequestParam String cupSize,@RequestParam Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
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

}
