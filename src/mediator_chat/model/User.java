package mediator_chat.model;

public class User {

	private String username;
	private ChatMediator chat;
	private GroupChatMediator group;

	public User(String username, ChatMediator chat) {
		this.username = username;
		
		this.chat = chat;
		this.group = null;
		
		chat.addUser(this);
	}

	public User(String username, GroupChatMediator group) {
		this.username = username;
		
		this.chat = null;
		this.group = group;
		
		group.addUser(this);
	}
	
	public User(String username, ChatMediator chat, GroupChatMediator group) {
		this.username = username;
		this.chat = chat;
		this.group = group;
		
		chat.addUser(this);
		group.addUser(this);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void sendMessage(String receiver, String message) {
		if(chat != null)
			chat.send(receiver, message);
	}
	
	public void sendMessageToGroup(String message) {
		if(group != null)
			group.send(message);
	}
	
	public void receive(String message) {
		System.out.println("I am " + username + " and I received \"" + message + "\"");
	}
}
