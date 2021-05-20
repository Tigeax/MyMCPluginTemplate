package tigeax.mymcplugintemplate.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Util {

    /**
     * Translates a string using the '&' color code character into a string that
     * uses the internal ChatColor.COLOR_CODE color code character. &0 black, &1
     * dark blue, &2 dark green, &3 dark aqua, &4 dark red, &5 dark purple, &6 gold,
     * &7 gray, &8 dark grey, &9 blue, &a green, &b aqua, &c red, &d aqua, &e
     * yellow, &f white, &k obfuscated, &l bold, &m strikethrough, &n underline, &o
     * italic, &r reset
     */
    public static String parseChatColors(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    /**
     * Send a message to the sender only if the msg is not empty.
     * This is to prevent sending blank lines.
     * @param sender Sender to send message to.
     * @param msg Message to send.
     */
    public static void sendMessage(CommandSender sender, String msg) {

        if (msg.isEmpty()) {
            return;
        }

        sender.sendMessage(msg);
    }

}
