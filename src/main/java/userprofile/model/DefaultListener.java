package userprofile.model;

import userprofile.model.ports.ListenerUser;
import userprofile.model.ports.UsersNames;

class DefaultListener implements ListenerUser {

	private String personId;
	private String name;
	private String lastName;
	private Email email;
 private Phone phone;
 private String user;
 private String pwd;

	public DefaultListener(String personaId, String name, String lastName,
			String email, String phone, String user, UsersNames usersNames, String pwd) {
		this.personId = new NotNullNorEmpty<String>(personaId, "Id").value();
		this.name = new NotNullNorEmpty<String>(name, "Name").value();
		this.lastName = new NotNullNorEmpty<String>(lastName, "Last Name").value();
		this.email = new Email(email);
		this.phone = new Phone(phone);
		this.user = usersNames.check(user);
		this.pwd = pwd;
	}
	
	public String personId() {
		return personId;
	}
	
	public String name() {
		return name;
	}

	public String lastName() {
		return lastName;
	}
	
	public String email() {
		return email.toString();
	}
	
	public String phone() {
		return phone.toString();
	}

 @Override
 public String user() {
  return user;
 }

 @Override
 public String pwd() {
  return pwd;
 }
}
