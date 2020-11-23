package userprofile.model.ports;

public interface Event {
 void publish(String type, String value);
}
