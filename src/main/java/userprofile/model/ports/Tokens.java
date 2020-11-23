package userprofile.model.ports;

import java.util.Optional;

public interface Tokens {

 Optional<Token> token(String token);

 String newToken(User u);

}
