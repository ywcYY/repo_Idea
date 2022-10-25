package service;

/**
 * @BelongsProject: zk_product
 * @Author: ywc
 * @CreateTime: 2022-07-23 13:06
 * @Description: 商品服务
 */
public interface ProductService {

    //减库存
    void reduceStock(int id) throws Exception;

}
