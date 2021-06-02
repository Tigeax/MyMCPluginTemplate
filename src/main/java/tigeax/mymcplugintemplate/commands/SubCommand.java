package tigeax.mymcplugintemplate.commands;

import org.bukkit.command.CommandSender;

public abstract class SubCommand {

    /*
     * /<command> <subcommand> args[0] args[1]
     */

    private String name;

    public SubCommand(String name) {
        this.name = name.toLowerCase();
    }

    public abstract void onCommand(CommandSender sender, String[] args);

    public String name() {
        return name;
    }

    public abstract String info();

    public abstract String[] aliases();
}
