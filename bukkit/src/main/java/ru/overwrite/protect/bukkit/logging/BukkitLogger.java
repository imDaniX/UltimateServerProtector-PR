package ru.overwrite.protect.bukkit.logging;

import ru.overwrite.protect.bukkit.ServerProtectorManager;

import java.util.logging.Logger;

public class BukkitLogger implements PluginLogger {
	private final Logger log;
	
	public BukkitLogger(ServerProtectorManager plugin) {
		log = plugin.getLogger();
	}
	
	public void info(String msg) {
		log.info(msg);
	}
	
	public void warn(String msg) {
		log.warning(msg);
	}

}