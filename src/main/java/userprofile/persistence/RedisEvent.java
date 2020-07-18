package userprofile.persistence;

import redis.clients.jedis.Jedis;
import userprofile.model.Event;

public class RedisEvent implements Event {

 private String host;
 private int port;
 
 public RedisEvent(String host, int port) {
  this.host = host;
  this.port = port;
 }

 @Override
 public void publish(String type, String value) {
  try (Jedis j = new Jedis(this.host, this.port)) {
   j.publish(type, value);
  }
 }
}
