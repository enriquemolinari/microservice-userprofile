package main;

import java.util.Objects;

import userprofile.model.DefaultRadioListeners;
import userprofile.model.DefaultUserAuth;
import userprofile.model.PublishNewListener;
import userprofile.persistence.JooqRadioListenerRepository;
import userprofile.persistence.JooqTokens;
import userprofile.persistence.JooqUsers;
import userprofile.persistence.JooqUsersNames;
import userprofile.persistence.RedisEvent;
import userprofile.persistence.Tx;
import userprofile.web.Web;

public class Main {

 public static void main(String[] args) {
  String connString = Objects.requireNonNull(
    System.getProperty("conn-string"),
    "specify conn-string as a jvm argument");

  String user = Objects.requireNonNull(System.getProperty("user"),
    "specify a database user as a jvm argument");

  String pass = Objects.requireNonNull(System.getProperty("pwd"),
    "specify a database pwd as a jvm argument");

  var tx = new Tx(connString, user, pass);

  new Web(
    new PublishNewListener(
      new DefaultRadioListeners(new JooqRadioListenerRepository(tx),
        new JooqUsersNames(tx)),
      new RedisEvent("localhost", 6379)),
    new DefaultUserAuth(new JooqTokens(tx), new JooqUsers(tx)), 7001)
      .start();
 }
}
