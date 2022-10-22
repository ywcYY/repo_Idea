package com.ywc.service.impl;

import com.ywc.dao.PromotionSpaceMapper;
import com.ywc.domain.PromotionSpace;
import com.ywc.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;
    @Override
    public List<PromotionSpace> findAllPromotionSpace() {


        List<PromotionSpace> allPromotionSpace = promotionSpaceMapper.findAllPromotionSpace();


        return allPromotionSpace;


    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {


        //封装PromotionSpace
        UUID uuid = UUID.randomUUID();
        promotionSpace.setSpaceKey(uuid.toString());
        promotionSpace.setCreateTime(new Date());
        promotionSpace.setUpdateTime(new Date());
        promotionSpace.setId(0);
        //2.调用Mapper方法

        promotionSpaceMapper.savePromotionSpace(promotionSpace);

    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        promotionSpace.setUpdateTime(new Date());
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);


    }
}
