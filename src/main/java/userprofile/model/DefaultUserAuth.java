package userprofile.model;

import userprofile.model.api.UserAuth;

public class DefaultUserAuth implements UserAuth {

 private Tokens tokens;
 private Users users;

 public DefaultUserAuth(Tokens tokens, Users users) {
  this.tokens = tokens;
  this.users = users;
 }

 @Override
 public String authenticate(String user, String password)
   throws RadioException {
  User u = this.users.user(user, password).orElseThrow(
    () -> new RadioException("Username or password incorrect ..."));

  return tokens.newToken(u);
 }

 @Override
 public void validate(String token) throws RadioException {
  Token t = tokens.token(token).orElseThrow(
    () -> new RadioException("Token not valid... "));

  if (!t.isValid()) {
   throw new RadioException("Token not valid...");
  }
 }
}
