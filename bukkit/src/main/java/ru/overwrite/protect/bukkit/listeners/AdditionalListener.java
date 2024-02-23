package ru.overwrite.protect.bukkit.listeners;

import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import ru.overwrite.protect.bukkit.ServerProtectorManager;
import ru.overwrite.protect.bukkit.api.ServerProtectorAPI;
import ru.overwrite.protect.bukkit.utils.Config;

public class AdditionalListener implements Listener {
	private final ServerProtectorAPI api;
	private final Config pluginConfig;

	public AdditionalListener(ServerProtectorManager plugin) {
		api = plugin.getPluginAPI();
		pluginConfig = plugin.getPluginConfig();
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onItemDrop(PlayerDropItemEvent e) {
		handleEvent(e.getPlayer(), e, pluginConfig.blocking_settings_block_item_drop);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onItemPickup(EntityPickupItemEvent e) {
		handleEvent(e.getEntity(), e, pluginConfig.blocking_settings_block_item_pickup);
	}

	@EventHandler(ignoreCancelled = true)
	public void onTabComplete(AsyncTabCompleteEvent e) {
		handleEvent(e.getSender(), e, pluginConfig.blocking_settings_block_item_pickup);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerDamage(EntityDamageEvent e) {
		handleEvent(e.getEntity(), e, pluginConfig.blocking_settings_block_item_pickup);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerDamageEntity(EntityDamageByEntityEvent e) {
		handleEvent(e.getDamager(), e, pluginConfig.blocking_settings_block_item_pickup);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onInventoryOpen(InventoryOpenEvent e) {
		handleEvent(e.getPlayer(), e, pluginConfig.blocking_settings_block_item_pickup);
	}

	private void handleEvent(CommandSender sender, Cancellable event, boolean blocking) {
		if (sender instanceof Player) handleEvent((Player) sender, event, blocking);
	}

	private void handleEvent(Player player, Cancellable event, boolean blocking) {
		if (blocking) api.handleInteraction(player, event);
	}
}