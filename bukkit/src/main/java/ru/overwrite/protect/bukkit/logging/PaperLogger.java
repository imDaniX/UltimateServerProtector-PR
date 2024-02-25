package ru.overwrite.protect.bukkit.logging;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import ru.overwrite.protect.bukkit.ServerProtectorManager;

public class PaperLogger implements PluginLogger {
	private final ComponentLogger log;
	
	public PaperLogger(ServerProtectorManager plugin) {
		log = plugin.getComponentLogger();
	}
	
	public void info(String msg) {
		log.info(asComponent(msg));
	}
	
	public void warn(String msg) {
		log.warn(asComponent(msg));
	}

	@SuppressWarnings("deprecation")
	private static Component asComponent(String msg) {
		return LegacyComponentSerializer.legacyAmpersand().deserialize(msg.replace(ChatColor.COLOR_CHAR, '&'));
	}
}