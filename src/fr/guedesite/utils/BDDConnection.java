package fr.guedesite.utils;

import java.io.Serializable;

public class BDDConnection implements Serializable{

	private static final long serialVersionUID = 16414343346343L;
	private String URL,  MDP, User;
	
	public BDDConnection(String url,  String user,  String mdp) {
		URL=url;
		User=user;
		MDP=mdp;
		User=user;
	
	}
	
	public String getMDP() {
		return MDP;
	}
	
	public String getURL() {
		return URL;
	}
	
	public String getUser() {
		return User;
	}
}