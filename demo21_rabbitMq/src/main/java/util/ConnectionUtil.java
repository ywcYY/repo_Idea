package util;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * @Author ywc
 * @ClassName ConnectionUtil
 * @Description TODO
 * @date 2022-11-01 16:39
 * @Version 1.0
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception{

        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.在工厂对象中设置MQ的连接信息（ ip， port,vhost,username,password）
        factory.setHost("192.168.231.131");
        factory.setPort(5672);
        factory.setVirtualHost("/ywc");
        factory.setUsername("ywc");
        factory.setPassword("123789");

        //3.通过工厂获得与MQ的连接
        Connection connection = factory.newConnection();

        return connection;



    }

    public static void main(String[] args) {
        Connection connection= null;
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }







}
