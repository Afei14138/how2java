/**
 * @Description: 消费者$
 * @Author: wpf
 * @Date: $
 */
package rabbitmq.workqueuedemo;

import com.rabbitmq.client.*;
import rabbitmq.simplequeue.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static final String QUEUE_NAME = "test_queue_name";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.out.println("consumer[1] receive:" + msg);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("consumer[1] receive done");
                }
            }
        };

        channel.basicConsume(QUEUE_NAME, true, consumer);
    }




}
