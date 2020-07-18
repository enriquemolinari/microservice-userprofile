package userprofile.model;

import java.util.Optional;

public class DefaultRadioListeners implements RadioListeners {

 private RadioListenerRepository repository;
 private UsersNames usersName;

 public DefaultRadioListeners(RadioListenerRepository repository,
   UsersNames usersName) {
  this.repository = repository;
  this.usersName = usersName;
 }

 @Override
 public int newListener(String personId, String name, String surname,
   String phone, String email, String username, String pwd) {
  var listener = new DefaultListener(personId, name, surname, email, phone,
    username, usersName, pwd);

  return repository.addListener(listener);
 }

 @Override
 public Optional<RadioListener> listener(int listenerId) {
  return repository.listener(listenerId).map(l -> l.radioListener());
 }
}
