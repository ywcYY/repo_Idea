package com.ywc.service;

import com.ywc.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {




    public List<PromotionSpace>  findAllPromotionSpace();

    public void savePromotionSpace(PromotionSpace promotionSpace);

    public void updatePromotionSpace(PromotionSpace promotionSpace);


}
