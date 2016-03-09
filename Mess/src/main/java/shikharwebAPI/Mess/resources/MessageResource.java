package shikharwebAPI.Mess.resources;

//This is a resource called by client. It, when called, gets data from DB via MessageService.java


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import shikharwebAPI.Mess.model.Message;
import shikharwebAPI.Mess.service.MessageService;

@Path("/messages")  //So this is a path level annotation mapping to a class 

public class MessageResource {
	
	MessageService messageservice = new MessageService();

	
	@PUT
	@Path("/{MessageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message editMessage(@PathParam("MessageId") long Id, Message message){
		message.setId(Id);
		return messageservice.updateMessage(message);
		//return messageservice.getMessage(message.getId());
	}
	
	
	@DELETE
	@Path("/{MessageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delmessage(@PathParam("MessageId") long Id){
		 messageservice.removeMessage(Id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addmessage(Message message){
       return messageservice.addMessage(message);
       
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageservice.getAllMessages();						
	}
	
	@GET
	@Path("/{MessageId}")  //This is a sub class level annotation to map to a particular function in a class 
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageres(@PathParam("MessageId") long MessageId){  //Annotation to get hold of the Path Parameters
		 return messageservice.getMessage(MessageId);
		//return "Got path param:"+ MessageId;
	}
		
	
}
	

