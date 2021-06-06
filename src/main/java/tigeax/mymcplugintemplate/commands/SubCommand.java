package tigeax.mymcplugintemplate.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;

public abstract class SubCommand {

    /*
     * /<command> <subcommand> args[0] args[1]
     */
    
    protected MyMCPluginTemplate plugin;
    private String name;

    public SubCommand(String name) {
        plugin = MyMCPluginTemplate.getInstance();
        this.name = name.toLowerCase();
    }

    public abstract void onCommand(CommandSender sender, ArrayList<String> args);

    public String name() {
        return name;
    }

    public String info() {
        return null;
    }

    public String[] aliases() {
        return new String[0];
    }
}
