package demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastMapExample {
    public static void main(String[] args) {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("localhost:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);

        IMap<Integer, Person> map = client.getMap("people");

        for (int i = 0; i < 10_000; i++) {
            map.put(i, new Person("Person-" + i));
        }
        System.out.println("Inserted 10,000 Person objects.");

        for (int i = 0; i < 10_000; i += 2500) {
            System.out.println("Retrieved at " + i + ": " + map.get(i));
        }

        client.shutdown();
    }
}
