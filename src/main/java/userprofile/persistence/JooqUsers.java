package userprofile.persistence;

import static userprofile.persistence.jooq.tables.ListenerUser.LISTENER_USER;

import java.util.Optional;

import userprofile.model.User;
import userprofile.model.Users;

public class JooqUsers implements Users {

 private Tx tx;

 public JooqUsers(Tx tx) {
  this.tx = tx;
 }

 @Override
 public Optional<User> user(String user, String password) {
  return tx.execute(create -> {
   var record = create.select(LISTENER_USER.ID_USER).from(LISTENER_USER)
     .where(LISTENER_USER.USERNAME.eq(user)
       .and(LISTENER_USER.PASSWORD.eq(password)))
     .fetchOne();
   if (record == null) {
    return Optional.empty();
   }
   
   return Optional.of(new User() {
    @Override
    public int id() {
     return record.get(LISTENER_USER.ID_USER);
    }
   });
  });
 }
}
