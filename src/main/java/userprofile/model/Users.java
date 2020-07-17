package userprofile.model;

import java.util.Optional;

public interface Users {

 Optional<User> user(String user, String password);

}
