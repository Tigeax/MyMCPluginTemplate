package tigeax.mymcplugintemplate.eventlisteners;

import java.util.Arrays;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.commands.Command;

public class OnTabComplete implements Listener {

    
    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {

        String buffer = event.getBuffer();
        String[] splitBuffer = buffer.split(" ");
        String commandName = splitBuffer[0].replace("/", "");
        String[] args = Arrays.copyOfRange(splitBuffer, 1, splitBuffer.length);

        Command command  = MyMCPluginTemplate.getInstance().getPluginCommand(commandName);

        if (command == null) {
            return;
        }

        List<String> tabCompletions = command.getTabCompletions(args);

        if (tabCompletions == null) {
            return;
        }

        event.setCompletions(tabCompletions);

    }

}
