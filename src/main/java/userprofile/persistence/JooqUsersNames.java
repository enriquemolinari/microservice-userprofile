package userprofile.persistence;

import static userprofile.persistence.jooq.tables.ListenerUser.LISTENER_USER;

import userprofile.model.RadioException;
import userprofile.model.UsersNames;

public class JooqUsersNames implements UsersNames {
 private Tx tx;

 public JooqUsersNames(Tx tx) {
  this.tx = tx;
 }

 @Override
 public String check(String user) throws RadioException {
  return 
    tx.execute(create -> {
     var record = create
     .select(LISTENER_USER.USERNAME).from(LISTENER_USER).where(LISTENER_USER.USERNAME.eq(user))
     .fetchOne(); 
     if (record != null) {
      throw new RadioException("User name already taken...");
     }
     return user;
  });
 }
}
