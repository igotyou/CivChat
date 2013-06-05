package com.untamedears.civchat;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CivChat extends JavaPlugin implements Listener {
	private ChatManager chat;
	private ChatListener cl;
	
	public void onEnable() {
		chat = new ChatManager(getConfig());
		Commands commands=new Commands(chat);
		cl = new ChatListener(chat);
		registerEvents();
		this.saveDefaultConfig();
		for (String command : getDescription().getCommands().keySet()) {
			getCommand(command).setExecutor(commands);
		}
	}
	
	public void onDisable() {

	}

	private void registerEvents() {
		getServer().getPluginManager().registerEvents(cl, this);
	}
}
