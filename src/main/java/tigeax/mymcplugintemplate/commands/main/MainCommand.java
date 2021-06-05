package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.commands.SubCommand;

public class MainCommand extends Command {
    
    public MainCommand(String name, List<String> aliases) {
        super(name, aliases);
        setupSubCommands();
        
    }

    private void setupSubCommands() {
        super.commands.add(new Author("author"));
        super.commands.add(new Sub2("sub2"));
    }

    
    @Override
    public List<String> getTabCompletions(String[] args) {
        return Arrays.asList("test1", "test2", "test3");
    }


    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {


        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Please add arguments to your command. Type /yt help for info");
            return true;
        }

        SubCommand target = this.getSubCommand(args[0]);

        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Invalid subcommand");
            return true;
        }

        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.addAll(Arrays.asList(args));
        arrayList.remove(0);

        try{
            target.onCommand(sender, args);
        }catch (Exception e){
            sender.sendMessage(ChatColor.RED + "An error has occurred.");

            e.printStackTrace();
            
        }

        return true;
    }

}
