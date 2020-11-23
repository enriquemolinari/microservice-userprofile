package userprofile.model;

import java.util.Optional;

import userprofile.model.ports.Event;
import userprofile.model.ports.RadioListener;
import userprofile.model.ports.RadioListeners;

public class PublishNewListener implements RadioListeners {

 private static final String EVENT_NAME = "new-listener";
 private RadioListeners listeners;
 private Event event;

 public PublishNewListener(RadioListeners listeners, Event event) {
  this.listeners = listeners;
  this.event = event;
 }

 @Override
 public int newListener(String personId, String name, String surname,
   String phone, String email, String username, String pwd) {
  int idListener = this.listeners.newListener(personId, name, surname,
    phone, email, username, pwd);
  event.publish(EVENT_NAME, new NewListener(idListener, email).toJson());
  return idListener;
 }

 @Override
 public Optional<RadioListener> listener(int listenerId) {
  return this.listeners.listener(listenerId);
 }

}
