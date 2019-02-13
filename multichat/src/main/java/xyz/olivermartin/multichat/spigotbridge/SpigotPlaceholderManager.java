package xyz.olivermartin.multichat.spigotbridge;

import org.bukkit.entity.Player;

import net.milkbowl.vault.chat.Chat;

public class SpigotPlaceholderManager {

	public static String replaceLocalChatPlaceholders(Player player, String format) {

		format = format.replace("%NAME%", player.getName());
		format = format.replace("%DISPLAYNAME%", player.getDisplayName());
		if (MultiChatSpigot.hookedVault()) {
			Chat chat = MultiChatSpigot.getVaultChat().get();
			format = format.replace("%PREFIX%", chat.getPlayerPrefix(player));
			format = format.replace("%SUFFIX%", chat.getPlayerSuffix(player));
		}
		format = format.replace("%NICK%", NameManager.getInstance().getCurrentName(player.getUniqueId()));
		format = format.replace("%WORLD%", player.getWorld().getName());

		return format;

	}

}
