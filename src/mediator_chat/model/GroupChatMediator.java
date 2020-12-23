package mediator_chat.model;

public class GroupChatMediator extends ChatMediator {

	public GroupChatMediator() {
		super();
	}
	
	public void send(String message) {
		send("", message);
	}
	
	@Override
	public void send(String receiver, String message) {
		for(User u: users) {
			u.receive(message);
 		}
	}
}
