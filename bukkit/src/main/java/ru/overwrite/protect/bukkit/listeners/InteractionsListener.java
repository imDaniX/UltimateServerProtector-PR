package ru.overwrite.protect.bukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import ru.overwrite.protect.bukkit.ServerProtectorManager;

public class InteractionsListener extends BaseListener {
    public InteractionsListener(ServerProtectorManager plugin) {
		super(plugin.getPluginAPI());
    }

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onMove(PlayerMoveEvent e) {
		handleEvent(e.getPlayer(), e, true);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerInteract(PlayerInteractEvent e) {
		handleEvent(e.getPlayer(), e, true);
	}

	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
	public void onPlayerInteractEntity(PlayerInteractEntityEvent e) {
		handleEvent(e.getPlayer(), e, true);
	}

}