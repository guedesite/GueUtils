package fr.guedesite.utils;

import java.io.IOException;
import java.io.Serializable;

import fr.guedesite.utils.nbt.io.NBTUtil;
import fr.guedesite.utils.nbt.tag.CompoundTag;

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
	
	public static void main(String[] arg) {
		CompoundTag tag = new CompoundTag();
		tag.putString("url", "");
		tag.putString("user", "");
		tag.putString("mdp", "");
		try {
			NBTUtil.write(tag, "bdd.dat");
			System.out.println("Success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}