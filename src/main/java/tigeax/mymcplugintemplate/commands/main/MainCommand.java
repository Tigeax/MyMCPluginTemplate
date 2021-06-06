package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.commands.SubCommand;
import tigeax.mymcplugintemplate.util.Util;

public class MainCommand extends Command {
    
    public MainCommand(String name, List<String> aliases, String permission) {
        super(name, aliases, permission);
        setupSubCommands();
        setDescription("Main command of the plugin");
        permission = "myplugin.command";
    }

    private void setupSubCommands() {
        super.subCommands.add(new HelloWorld("helloworld"));
        super.subCommands.add(new Author("author"));
        super.subCommands.add(new Reload("reload"));
    }

    
    @Override
    public List<String> getTabCompletions(String[] args) {

        List<String> subCommandNames = Arrays.asList("helloworld", "author", "reload");

        if (args.length == 0) {
            return subCommandNames; 
        }

        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], subCommandNames, completions);
            return completions;
        }

        return null;
    }


    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {

        if (!sender.hasPermission(permission)) {
            Util.sendMessage(sender, plugin.getMessages().noPermissionCommand());
            return true;
        }

        if (args.length == 0) {
            Util.sendMessage(sender, plugin.getMessages().notEnoughArguments());
            return true;
        }

        SubCommand target = super.getSubCommand(args[0]);

        if (target == null) {
            Util.sendMessage(sender, plugin.getMessages().invalidSubCommand());
            return true;
        }


        ArrayList<String> argsList = new ArrayList<String>(Arrays.asList(args));
        argsList.remove(0);

        target.onCommand(sender, argsList);

        return true;
    }

}
