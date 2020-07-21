package userprofile.infrastructure;

import static userprofile.infrastructure.jooq.tables.Token.TOKEN;
import static userprofile.infrastructure.jooq.tables.UserAudit.USER_AUDIT;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import userprofile.model.Token;
import userprofile.model.Tokens;
import userprofile.model.User;

public class JooqTokens implements Tokens {

 private Tx tx;

 public JooqTokens(Tx tx) {
  this.tx = tx;
 }

 @Override
 public Optional<Token> token(String token) {
  return tx.execute(create -> {
   var record = create.select(TOKEN.TOKEN_, TOKEN.CREATION_DATE).from(TOKEN)
     .where(TOKEN.TOKEN_.eq(token)).fetchOne();

   if (record == null) {
    return Optional.empty();
   }
  
   return Optional.of(new Token() {
    @Override
    public String token() {
     return record.get(TOKEN.TOKEN_);
    }
    
    @Override
    public LocalDateTime creationDate() {
     return record.get(TOKEN.CREATION_DATE);
    }
   });
  });
 }

 @Override
 public String newToken(User u) {
  return tx.execute(create -> {
   String token = UUID.randomUUID().toString();
   create
     .insertInto(TOKEN, TOKEN.ID_USER, TOKEN.CREATION_DATE, TOKEN.TOKEN_)
     .values(u.id(), LocalDateTime.now(), token).execute();

   create.insertInto(USER_AUDIT, USER_AUDIT.ID_USER, USER_AUDIT.LOGIN_DATE)
     .values(u.id(), LocalDateTime.now()).execute();

   return token;
  });
 }
}
