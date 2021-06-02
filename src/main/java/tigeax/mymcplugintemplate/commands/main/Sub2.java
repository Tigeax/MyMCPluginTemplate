package tigeax.mymcplugintemplate.commands.main;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.commands.SubCommand;

public class Sub2 extends SubCommand {

    public Sub2(String name) {
        super(name);
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
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
