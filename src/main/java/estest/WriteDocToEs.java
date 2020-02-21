package estest;

import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.json.JSONException;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;


public class WriteDocToEs {
    public static void main(String[] args) throws JSONException, UnknownHostException {
        new WriteDocToEs().createDataToFile();
    }

    public void createDataToFile() throws JSONException, UnknownHostException {
        //设置集群名称等
        Settings settings = Settings.builder().put("cluster.name", "es-test").build();
        TransportClient client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.124.151.116"), 9300))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.124.151.117"), 9300))
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.124.151.118"), 9300));

        BulkProcessor bulkProcessor = BulkProcessor.builder(client, new BulkProcessor.Listener() {
            @Override
            public void beforeBulk(long l, BulkRequest bulkRequest) {
                System.out.println("bulk start");
            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, BulkResponse bulkResponse) {
                System.out.println("bulk processing");
            }

            @Override
            public void afterBulk(long l, BulkRequest bulkRequest, Throwable throwable) {
                System.out.println("bulk finish");
            }
            /* Listener methods */
        })
                .setBulkActions(10000)
                .setConcurrentRequests(0)
                .build();
        Map<String, String> map = new HashMap<>();
        map.put("test", "111");
        // Add your requests
        bulkProcessor.add(new IndexRequest("test", "test", "1").source(map));

        // Flush any remaining requests
        bulkProcessor.flush();

        // Or close the bulkProcessor if you don't need it anymore
        bulkProcessor.close();

        // Refresh your indices
        client.admin().indices().prepareRefresh().get();

        // Now you can start searching!
        client.prepareSearch().get();

    }


}
