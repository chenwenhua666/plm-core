package com.huabrother.plm.controller;

import com.huabrother.plm.properties.GirlProperies;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * chenwenhua
 * 2018\8\18
 * 20:03
 */
@RestController
public class HelloController {

    @Resource
    private GirlProperies girlProperies;

   /* @RequestMapping(value = {"/hello/{id}","/hi/{id}"},method = RequestMethod.GET)
    public String say(@PathVariable Integer id, @RequestParam("ids") Integer myId){
       // return girlProperies.getCupSize()+girlProperies.getAge();
       // return "id:"+id;
        return "id:"+myId+id;
    }*/
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(@RequestParam(value = "id",required = true,defaultValue = "88") Integer myId){

        return "id:"+myId;
    }

}
