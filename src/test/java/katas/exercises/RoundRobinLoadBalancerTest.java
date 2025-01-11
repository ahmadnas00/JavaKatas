package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoundRobinLoadBalancerTest {

    @Test
    public void testadd(){
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(loadBalancer.new IP("192.168.0.1"));
        assertEquals("192.168.0.1",loadBalancer.routeRequest().toString());
    }

    @Test
    public void testremove(){
        RoundRobinLoadBalancer loadBalancer = new RoundRobinLoadBalancer();

        loadBalancer.addServer(loadBalancer.new IP("192.168.0.1"));
        loadBalancer.addServer(loadBalancer.new IP("192.168.0.2"));
        loadBalancer.addServer(loadBalancer.new IP("192.168.0.3"));

        loadBalancer.removeServer(loadBalancer.new IP("192.168.0.3"));
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.2", loadBalancer.routeRequest().toString());
        assertEquals("192.168.0.1", loadBalancer.routeRequest().toString());



    }
}
