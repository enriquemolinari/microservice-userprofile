package userprofile.model.api;

import java.util.Optional;

public interface RadioListeners {
 void newListener(String personId, String name, String surname,
   String phone, String email, String userName, String pwd);
 
 Optional<RadioListener> listener(int listenerId);
}
