package userprofile.model;

public interface ListenerUser extends RadioListener {

 String pwd();

 String user();

 public default RadioListener radioListener() {
  return this;
 }
}
