package work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

/**
 * @Author ywc
 * @ClassName Sender
 * @Description TODO
 * @date 2022-11-02 13:45
 * @Version 1.0
 */
public class Sender {



    public static void main(String[] args) throws Exception {
        String msg = "hello，RabbitMq1";
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("test_work_queue",false,false,false,null);
        for (int i=1;i<100;i++){
                String msg1="羊肉串-->"+i;
                    channel.basicPublish("","queue1",null,msg.getBytes());
                System.out.println("发送"+msg1);
                }
        channel.close();
        connection.close();
    }
}
