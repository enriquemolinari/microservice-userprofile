package userprofile.persistence;

import static userprofile.persistence.jooq.tables.Listener.LISTENER;
import static userprofile.persistence.jooq.tables.ListenerUser.LISTENER_USER;

import java.time.LocalDateTime;
import java.util.Optional;

import org.jooq.Record1;

import userprofile.model.ListenerUser;
import userprofile.model.RadioListenerRepository;

public class JooqRadioListenerRepository
  implements RadioListenerRepository {
 private Tx tx;

 public JooqRadioListenerRepository(Tx tx) {
  this.tx = tx;
 }

 @Override
 public void addListener(ListenerUser l) {
  tx.execute(create -> {
   Record1<Integer> fetchOne = create
     .insertInto(LISTENER, LISTENER.NAME, LISTENER.SURNAME, LISTENER.PHONE,
       LISTENER.EMAIL, LISTENER.PERSON_ID)
     .values(l.name(), l.lastName(), l.phone(), l.email(), l.personId())
     .returningResult(LISTENER.ID_LISTENER).fetchOne();

   create
     .insertInto(LISTENER_USER, LISTENER_USER.ID_LISTENER,
       LISTENER_USER.USERNAME, LISTENER_USER.PASSWORD,
       LISTENER_USER.CREATION_DATE)
     .values(fetchOne.get(LISTENER.ID_LISTENER), l.user(), l.pwd(),
       LocalDateTime.now())
     .execute();

   // just to make the compiler happy
   return null;
  });
 }

 @Override
 public Optional<ListenerUser> listener(int id) {
  return tx.execute(create -> {
   var record = create
     .select(LISTENER.ID_LISTENER, LISTENER.PERSON_ID, LISTENER.NAME, LISTENER.SURNAME,
       LISTENER.PHONE, LISTENER.EMAIL, LISTENER_USER.USERNAME, LISTENER_USER.PASSWORD)
     .from(LISTENER).join(LISTENER_USER).on(LISTENER_USER.ID_LISTENER.eq(LISTENER.ID_LISTENER))
     .where(LISTENER.ID_LISTENER.eq(id)).fetchOne();

   if (record == null) {
    return Optional.empty();
   }
   
   return Optional.of(new ListenerUser() {
    @Override
    public String phone() {
     return record.get(LISTENER.PHONE);
    }
    @Override
    public String personId() {
     return record.get(LISTENER.PERSON_ID);
    }
    @Override
    public String name() {
     return record.get(LISTENER.NAME);
    }
    
    @Override
    public String lastName() {
     return record.get(LISTENER.SURNAME);
    }
    
    @Override
    public String email() {
     return record.get(LISTENER.EMAIL);
    }
    
    @Override
    public String user() {
     return record.get(LISTENER_USER.USERNAME);
    }
    
    @Override
    public String pwd() {
     return record.get(LISTENER_USER.PASSWORD);
    }
   });
  });
 }
}
