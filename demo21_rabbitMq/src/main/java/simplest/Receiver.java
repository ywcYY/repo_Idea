package simplest;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;

/**
 * @Author ywc
 * @ClassName Recever
 * @Description TODO
 * @date 2022-11-01 17:42
 * @Version 1.0
 */
public class Receiver {
    public static void main(String[] args) throws Exception {

        //1.获得链接

        Connection connection = ConnectionUtil.getConnection();

        //2.获得通道
        Channel channel = connection.createChannel();
        //3.从信道中获得数据
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override//交付处理（收件人信息，包裹上的快递标签，协议的配置。消息）
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //body就是从队列中获得的消息
                String s = new String(body);

                System.out.println("接受"+s);

                //手动确认(收件人信息，是否同时确认多个消息)
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };

        //4.监听队列
        channel.basicConsume("queue1",false,defaultConsumer);

    }
    }

