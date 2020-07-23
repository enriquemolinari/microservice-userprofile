package userprofile.web;

import java.util.Map;
import java.util.Optional;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import userprofile.model.RadioException;
import userprofile.model.RadioListener;
import userprofile.model.RadioListeners;
import userprofile.model.UserAuth;

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
  app.post("/listener", addListener());
  app.post("/authenticate", auth());

  app.exception(RadioException.class, (e, ctx) -> {
   ctx.json(Map.of("result", "error", "message", e.getMessage()));
   // log error in a stream...
  });

  app.exception(Exception.class, (e, ctx) -> {
   ctx.json(
     Map.of("result", "error", "message", "Ups, something went wrong"));
   System.out.println(e.getMessage());
   // log error in a stream...
  });
 }

 private Handler addListener() {
  return ctx -> {
   ListenerData dto = ctx.bodyAsClass(ListenerData.class);
   this.listeners.newListener(dto.getPersonId(), dto.getName(),
     dto.getLastName(), dto.getPhone(), dto.getEmail(), dto.getUser(),
     dto.getPwd());
   ctx.json(Map.of("result", "success"));
  };
 }

 private Handler listener() {
  return ctx -> {
   Optional<RadioListener> l = this.listeners
     .listener(ctx.pathParam("id", Integer.class).get());

   ctx.json(l
     .map((l1) -> Map.of("result", "sucess", "personId", l1.personId(),
       "name", l1.name(), "lastName", l1.name(), "email", l1.email()))
     .orElse(Map.of()));
  };
 }

 private Handler auth() {
  return ctx -> {
   AuthData dto = ctx.bodyAsClass(AuthData.class);
   String token = this.auth.authenticate(dto.user(), dto.pwd());
   ctx.json(Map.of("result", "success", "token", token));
  };
 }
}
