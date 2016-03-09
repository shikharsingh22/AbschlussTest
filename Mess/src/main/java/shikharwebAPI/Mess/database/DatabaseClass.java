//This is the class talking to the database. 
package shikharwebAPI.Mess.database;

import java.util.HashMap;
import java.util.Map;

import shikharwebAPI.Mess.model.Message;
import shikharwebAPI.Mess.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}

