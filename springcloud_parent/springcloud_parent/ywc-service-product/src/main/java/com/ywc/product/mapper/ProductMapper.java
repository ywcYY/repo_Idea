package com.ywc.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.ywc.common.pojo.Products;

/**
 * @Author ywc
 * @ClassName ProductMapper
 * @Description TODO
 * @date 2022-11-09 17:30
 * @Version 1.0
 */
/**
 * @Author: ywc
 * @Description: TODO
 * @DateTime: 2022-11-09 17:32
 * @Params: 现在使用的是mybatis的加强版 mybatis-plus该组件能够与springBoot进行很好的整合
 * 对比mybatis的框架只有使用便捷的改变
 *
 * 没有具体功能的改变 ：让具体的mapper继承BaseMapper即可
 * @Return
 */

public interface ProductMapper extends BaseMapper<Products> {


}
