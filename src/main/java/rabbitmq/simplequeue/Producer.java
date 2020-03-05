package rabbitmq.simplequeue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    private static final String QUEUE_NAME = "test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException {

        //链接MQ
        Connection connection = ConnectionUtil.getConnection();

        //创建一个通道
        Channel channel = connection.createChannel();

        //创建队列声明
        channel.queueDeclare(QUEUE_NAME, false,false, false, null);

        String msg = "Hello RabbitMQ";

        channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());

        channel.close();

        connection.close();

    }
}
