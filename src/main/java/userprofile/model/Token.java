package userprofile.model;

import java.time.LocalDateTime;

public interface Token {

 String token();

 LocalDateTime creationDate();

 default boolean isValid() {
  return LocalDateTime.now().isBefore(this.creationDate().plusDays(1));
 }
}
