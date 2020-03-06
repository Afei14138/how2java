/**
 * @Description: work queue生产者$
 * @Author: wpf
 * @Date: $
 */
package rabbitmq.workfairqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.simplequeue.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static final String QUEUE_NAME = "test_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //每个消费者在确认消息之前，消息队列不发送下一个消息到消费者，一次只发送一个
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);

        for (int i = 0; i < 50; i++) {
            String msg = "hello" + i;
            channel.basicPublish("", QUEUE_NAME,null, msg.getBytes());
            System.out.println("producer send" + i);
            Thread.sleep(i *20);

        }

        channel.close();
        connection.close();

    }


}
