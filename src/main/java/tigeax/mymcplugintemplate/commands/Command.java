package tigeax.mymcplugintemplate.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bukkit.command.defaults.BukkitCommand;

import tigeax.mymcplugintemplate.util.Util;

public abstract class Command extends BukkitCommand {


    // TODO: Tab complete

    public ArrayList<SubCommand> commands = new ArrayList<SubCommand>();

    public Command(String name, List<String> aliases) {
        super(name);

        setAliases(aliases);

        Util.registerCommand(name, this);
        
        
    }

    public SubCommand getSubCommand(String name) {
        Iterator<SubCommand> subcommands = this.commands.iterator();

        while (subcommands.hasNext()) {
            SubCommand sc = (SubCommand) subcommands.next();

            if (sc.name().equalsIgnoreCase(name)) {
                return sc;
            }

            String[] aliases;
            int length = (aliases = sc.aliases()).length;

            for (int var5 = 0; var5 < length; ++var5) {
                String alias = aliases[var5];
                if (name.equalsIgnoreCase(alias)) {
                    return sc;
                }

            }
        }
        return null;
    }



}
