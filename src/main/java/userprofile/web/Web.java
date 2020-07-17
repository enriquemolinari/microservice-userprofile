package userprofile.web;

import java.util.Map;
import java.util.Optional;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import userprofile.model.api.RadioListener;
import userprofile.model.api.RadioListeners;
import userprofile.model.api.UserAuth;

public class Web {

 private RadioListeners listeners;
 private UserAuth auth;
 private int webPort;

 public Web(RadioListeners listeners, UserAuth auth, int webPort) {
  this.listeners = listeners;
  this.auth = auth;
  this.webPort = webPort;
 }

 public void start() {
  Javalin app = Javalin.create().start(this.webPort);
  app.get("/listener/:id", listener());
//   app.post("/listener", addListener());

  app.exception(Exception.class, (e, ctx) -> {
   ctx.json(Map.of("error", "Ups, somethong went wrong..."));
   System.out.println(e.getMessage());
   // log error in a stream...
  });
 }

 private Handler listener() {
  return ctx -> {
//    var i = ;
   Optional<RadioListener> l = this.listeners
     .listener(ctx.pathParam("id", Integer.class).get());

   ctx.json(l.map((l1) -> Map.of("name", l1.name(), "lastname", l1.name(),
     "email", l1.email())).orElse(Map.of()));

   // listeners.listener(1);
   // listeners.newListener(personId, name, surname, phone, email, userName, pwd);
   // users.authenticate(user, password)
   // users.validate(token);
  };
 }
}
