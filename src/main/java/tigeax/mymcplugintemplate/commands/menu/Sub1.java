package tigeax.mymcplugintemplate.commands.menu;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.commands.SubCommand;

public class Sub1 extends SubCommand {
    
    public Sub1(String name) {
        super(name);
    }


    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {
        sender.sendMessage("Menu Sub1");
    }


    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

}
