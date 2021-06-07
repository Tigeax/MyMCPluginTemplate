package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import tigeax.mymcplugintemplate.commands.main.subcommands.Author;
import tigeax.mymcplugintemplate.commands.main.subcommands.HelloWorld;
import tigeax.mymcplugintemplate.commands.main.subcommands.Reload;
import tigeax.mymcplugintemplate.util.Util;
import tigeax.mymcplugintemplate.util.commands.Command;
import tigeax.mymcplugintemplate.util.commands.SubCommand;
import tigeax.mymcplugintemplate.util.commands.SubCommandManager;

public class MainCmd extends Command implements SubCommandManager {

    // A list containing all the subcommands
    ArrayList<SubCommand> subCommands = new ArrayList<SubCommand>();
    
    public MainCmd(String name, List<String> aliases, String permission) {
        super(name, aliases);
        setupSubCommands();
        setDescription("Main command of the plugin");
        setPermission(permission);
    }

    @Override
    public void setupSubCommands() {
        subCommands.add(new HelloWorld("helloworld"));
        subCommands.add(new Author("author"));
        subCommands.add(new Reload("reload"));
    }

    
    @Override
    public List<String> getTabCompletions(String[] args) {

        List<String> subCommandNames = Arrays.asList("helloworld", "author", "reload");

        if (args.length == 0) {
            return subCommandNames; 
        }

        if (args.length == 1) {
            if (subCommandNames.contains(args[0])) {
                return null;
            }

            List<String> completions = new ArrayList<>();

            StringUtil.copyPartialMatches(args[0], subCommandNames, completions);
            return completions;
        }

        return null;
    }


    @Override
    public void onCommandHasPerm(CommandSender sender, ArrayList<String> args) {

        if (args.size() == 0) {
            Util.sendMessage(sender, plugin.getMessages().notEnoughArguments());
            return;
        }

        SubCommand target = Util.getSubCommand(args.get(0), subCommands);

        if (target == null) {
            Util.sendMessage(sender, plugin.getMessages().invalidSubCommand());
            return;
        }

        args.remove(0);

        target.onCommand(sender, args);
    }

}
