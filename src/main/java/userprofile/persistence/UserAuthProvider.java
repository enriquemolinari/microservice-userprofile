package userprofile.persistence;

import userprofile.model.DefaultUserAuth;
import userprofile.model.api.UserAuth;

public class UserAuthProvider {

 public static UserAuth provider() {
  var tx = new Tx(
    new CheckEnv(System.getProperty(CheckEnv.CONN_STRING)).value(),
    new CheckEnv(System.getProperty(CheckEnv.USER)).value(),
    new CheckEnv(System.getProperty(CheckEnv.PWD)).value());

  return new DefaultUserAuth(new JooqTokens(tx), new JooqUsers(tx));
 }
}
