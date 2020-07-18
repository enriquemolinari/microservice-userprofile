package userprofile.model;

import java.util.Optional;

public interface RadioListeners {
 int newListener(String personId, String name, String surname,
   String phone, String email, String userName, String pwd);
 
 Optional<RadioListener> listener(int listenerId);
}
