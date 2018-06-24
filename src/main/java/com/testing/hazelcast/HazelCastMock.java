package com.testing.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
public class HazelCastMock {

    private HazelcastInstance hazelcastInstance;
    private IMap<Long, HazelcastMapping> hazelcastInstanceMap;

    @PostConstruct
    public void startHazelCast() {
        com.hazelcast.config.Config config = new com.hazelcast.config.Config();
        config.setInstanceName("MyTest-Cluster");
        setupNetworkingConfig(config);
        hazelcastInstance = Hazelcast.getOrCreateHazelcastInstance(config);

        hazelcastInstanceMap = hazelcastInstance.getMap("MyTestMap");
    }

    @PreDestroy
    public void tearDown() {
        hazelcastInstance.shutdown();
    }

    private static void setupNetworkingConfig(com.hazelcast.config.Config config) {
        config.getGroupConfig().setName("MyTest-Cluster");
        config.getNetworkConfig().setPortAutoIncrement(true);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
    }


    public void add(HazelcastMapping hazelcastMapping) {
        long serial = new Random().nextLong();
        boolean value = new Random().nextBoolean();
        hazelcastInstanceMap.put(serial, new HazelcastMapping("key1", "value1"));
    }
}
