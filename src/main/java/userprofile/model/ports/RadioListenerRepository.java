package userprofile.model.ports;

import java.util.Optional;

public interface RadioListenerRepository {

 int addListener(ListenerUser l);

 Optional<ListenerUser> listener(int id);
}
