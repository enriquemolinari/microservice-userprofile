package userprofile.persistence;

import userprofile.model.DefaultRadioListeners;
import userprofile.model.api.RadioListeners;

public class RadioListenersProvider {

 public static RadioListeners provider() {
  var tx = new Tx(
    new CheckEnv(System.getProperty(CheckEnv.CONN_STRING)).value(),
    new CheckEnv(System.getProperty(CheckEnv.USER)).value(),
    new CheckEnv(System.getProperty(CheckEnv.PWD)).value());

  return new DefaultRadioListeners(new JooqRadioListenerRepository(tx),
    new JooqUsersNames(tx));
 }
}