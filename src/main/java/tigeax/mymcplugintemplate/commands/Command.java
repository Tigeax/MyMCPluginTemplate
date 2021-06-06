package tigeax.mymcplugintemplate.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.command.defaults.BukkitCommand;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.Util;

public abstract class Command extends BukkitCommand {

    protected MyMCPluginTemplate plugin;

    public ArrayList<SubCommand> subCommands = new ArrayList<SubCommand>();

    public String permission;

    public Command(String name, List<String> aliases, String permission) {
        super(name);
        plugin = MyMCPluginTemplate.getInstance();

        this.permission = permission;

        setAliases(aliases);
    
        Util.registerCommand(name, this);
    }


    public SubCommand getSubCommand(String name) {
        Iterator<SubCommand> subCommandsIterator = subCommands.iterator();

        while (subCommandsIterator.hasNext()) {
            SubCommand subCommand = (SubCommand) subCommandsIterator.next();

            if (subCommand.name().equalsIgnoreCase(name)) {
                return subCommand;
            }

            for (String alias : subCommand.aliases()) {
                if (name.equalsIgnoreCase(alias)) {
                    return subCommand;
                }
            }
        }

        return null;
    }

    public List<String> getTabCompletions(String[] args) {
        return null;
    }

}
