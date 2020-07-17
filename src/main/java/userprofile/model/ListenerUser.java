package userprofile.model;

import userprofile.model.api.RadioListener;

public interface ListenerUser extends RadioListener {

 String pwd();

 String user();

 public default RadioListener radioListener() {
  return this;
 }
}
