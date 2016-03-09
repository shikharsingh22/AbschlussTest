package shikharwebAPI.Mess.resources;


import java.util.List; 

import javax.ws.rs.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import shikharwebAPI.Mess.model.Profile;
import shikharwebAPI.Mess.service.ProfileService;
	
	@Path("/profiles")
	public class ProfileResource {

		  ProfileService profileservice = new ProfileService();
		  
		  @GET
		  @Produces(MediaType.APPLICATION_JSON)
		  @Consumes(MediaType.APPLICATION_JSON)
		  public List<Profile> getProfiles(){
		 	return profileservice.getAllProfiles();
		 }
		  
		  @GET
		  @Path("/{profileName}")
		  @Produces(MediaType.APPLICATION_JSON)
		  @Consumes(MediaType.APPLICATION_JSON)
		  public Profile getProfile(@PathParam("profileName") String profileName){
		 	return profileservice.getProfile(profileName);
		 }

		  @POST
		  @Consumes(MediaType.APPLICATION_JSON)
		  @Produces(MediaType.APPLICATION_JSON)
		  public Profile addProfile(Profile profile){
		 	return profileservice.addProfile(profile);
		 	
		 }

		  @PUT
		  @Path("/{profileName}")
		  public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
		 	profile.setProfileName(profileName);
		 	return profileservice.updateProfile(profile);
		 }

		  @DELETE
		  @Path("/{profileName}")
		  public void removeProfile(@PathParam("profileName") String profileName){
		 	profileservice.removeProfile(profileName);
		 }


		 

		 


	}
