package userprofile.model;

import java.util.Optional;

public interface RadioListenerRepository {

 int addListener(ListenerUser l);

 Optional<ListenerUser> listener(int id);
}
