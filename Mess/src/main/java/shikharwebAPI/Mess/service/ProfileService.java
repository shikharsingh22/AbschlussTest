package shikharwebAPI.Mess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import shikharwebAPI.Mess.database.DatabaseClass;
import shikharwebAPI.Mess.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("hero", new Profile(1L, "hero", "hero", "ajackei"));
		profiles.put("heeralal", new Profile(2L, "heeralal", "heralal", "Halwai"));
	}

	public List<Profile> getAllProfiles(){		
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String profileName){
			return profiles.get(profileName);			
		}

	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	

	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
			}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);		
	}

}
