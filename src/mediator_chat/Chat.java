package mediator_chat;
import mediator_chat.model.*;
public class Chat {
	
	public static void main(String[] args) {
		ChatMediator chat = new ChatMediator();
		
		GroupChatMediator group1 = new GroupChatMediator();
		GroupChatMediator group2 = new GroupChatMediator();
		
		User topolino = new User("Topolino", chat, group1);
		User paperino = new User("Paperino", chat, group2);
		User pippo = new User("Pippo", group1);
		User paperoga = new User("Paperoga", group2);
		User paperone = new User("Paperone", chat, group2);
		
		topolino.sendMessage("Paperone", "Ciao Paperone!");
		paperone.sendMessage("Topolino", "Ciao topo!");
		
		paperoga.sendMessageToGroup("Ciao Paperi!");
		
		pippo.sendMessage("Topolino","Mi sa che non funziona...");
		pippo.sendMessageToGroup("Topolino non riesco a contattarti!");
		
		paperino.sendMessage("Topolino", "Quando vieni a Paperopoli?");
		
	}
}
