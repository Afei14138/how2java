/**
 * @Description: 发布者订阅者模式$
 * @Author: wpf
 * @Date: $
 */
package rabbitmq.ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.simplequeue.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    public static final String EXCHANGE_NAME = "test_exchange_fanout";
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtil.getConnection();

        Channel channel = connection.createChannel();

        //参数一，交换机名称，参数二，交换机模式
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String msg = "hello ps";

        channel.basicPublish(EXCHANGE_NAME,"", null, msg.getBytes());
        System.out.println("Send" + msg);
        channel.close();
        connection.close();
    }

}
