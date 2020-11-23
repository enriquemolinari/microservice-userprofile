package userprofile.model.ports;

import java.util.Optional;

public interface Users {

 Optional<User> user(String user, String password);

}
