package com.ywc.controller;

import com.ywc.domain.PromotionSpace;
import com.ywc.domain.ResponseResult;
import com.ywc.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;


@RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){

    List<PromotionSpace> allPromotionSpace = promotionSpaceService.findAllPromotionSpace();


    return new ResponseResult(true,200,"响应成功",allPromotionSpace);


}

@RequestMapping("saveOrUpdatePromotionSpace")
public ResponseResult savePromotionSpace(@RequestBody PromotionSpace promotionSpace){

    if(promotionSpace.getId() ==null){
        //新增
        promotionSpaceService.savePromotionSpace(promotionSpace);

        return new ResponseResult(true,200,"save响应成功",null);

    }
    else{
        promotionSpaceService.updatePromotionSpace(promotionSpace);

        return new ResponseResult(true,200,"update响应成功",null);





    }










}





}
