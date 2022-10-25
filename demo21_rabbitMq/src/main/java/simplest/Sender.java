package simplest;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ywc
 * @ClassName Sender
 * @Description TODO
 * @date 2022-11-01 17:11
 * @Version 1.0
 */
public class Sender {




        public static void main(String[] args) throws Exception {
            String msg = "hello，RabbitMq1";
            //1.获取连接
            Connection connection = ConnectionUtil.getConnection();


            //2.在连接中创建通道（信道）
            Channel channel = connection.createChannel();

            //3、创建消息队列
            /*
            * 参数1：队列的名称
            * 参数二：队列中的数据是否持久化
            * 参数三：是否排外（是否支持扩展，当前队列只能自己用，不能给别人用）
            *参数四：是否自动删除（当队列的连接数为0时，队列会销毁，不管队列是否还保存数据）
            * 参数五：队列参数（没有参数为null）
            * */
            channel.queueDeclare("queue1",false,false,false,null);
            //4.向指定的队列发送消息
            /*
             * 向指定队列发送消息
             *  参数一：交换机名称 ，当前是简单模式，也即是p2p模式，没有交换机，所以名称为“ ”
             * 参数二：目标队列的名称
             * 参数三：设置消息的属性 （没有属性则为null）
             * 参数四：消息的内容 （只接受字节数据）
             * */
            channel.basicPublish("","queue1",null,msg.getBytes());
            System.out.println("发送"+msg);

            //5.释放资源
            channel.close();
            connection.close();
        }

    }

