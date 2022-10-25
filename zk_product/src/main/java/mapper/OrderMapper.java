package mapper;

import models.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: zk_product
 * @Author: ywc
 * @CreateTime: 2022-07-23 13:05
 * @Description: 订单操作类
 */
@Mapper
@Component
public interface OrderMapper {

    //生成订单
    @Insert("insert into `order` (id,pid,userid) values (#{id},#{pid},#{userid})")
    int insert( Order order);
}
