package ru.overwrite.protect.bukkit.listeners;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Listener;
import ru.overwrite.protect.bukkit.api.ServerProtectorAPI;

public abstract class BaseListener implements Listener {
    protected final ServerProtectorAPI api;

    protected BaseListener(ServerProtectorAPI api) {
        this.api = api;
    }

    protected void handleEvent(CommandSender sender, Cancellable event, boolean blocking) {
        if (sender instanceof Player) handleEvent((Player) sender, event, blocking);
    }

    protected void handleEvent(Player player, Cancellable event, boolean blocking) {
        if (blocking) api.handleInteraction(player, event);
    }
}
