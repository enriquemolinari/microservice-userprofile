package userprofile.model;

import java.util.Optional;

public interface Tokens {

 Optional<Token> token(String token);

 String newToken(User u);

}
