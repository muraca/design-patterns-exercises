package mediator_chat.model;

import java.util.ArrayList;

public class ChatMediator {
	protected ArrayList<User> users;
	
	public ChatMediator() {
		users = new ArrayList<>();
	}
	
	public void send(String receiver, String message) {
		for(User u: users) {
			if(u.getUsername().equals(receiver)) {
				u.receive(message);
			}
 		}
	}
	
	public void addUser(User u) {
		users.add(u);
	}
	
}
