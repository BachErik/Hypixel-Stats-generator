package de.bacherik.command;


import de.bacherik.command.commands.HelpCommand;
import de.bacherik.command.commands.Issues;
import de.bacherik.command.commands.TestCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.restaction.CommandCreateAction;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {

    public List<Command> commands;

    public CommandManager() {
        commands = new ArrayList<>();
        commands.add(new TestCommand("test", "This is a Test Command").addArgument(OptionType.BOOLEAN,
                "wie-geht-es" + "-dir", "help", true).addArgument(OptionType.BOOLEAN, "wie-geht-es", "me"));
        commands.add(new HelpCommand("help", "This will show you a list of Commands."));
        commands.add(new Issues("issues", "Link to issues, bugs, Problems and Features, report Site"));
    }

    public void init(JDA jda) {
        for (Command command : this.commands) {
            CommandCreateAction commandCreateAction = jda.upsertCommand(command.getName(), command.getDescription());
            for (CommandArgument commandArgument : command.getArgs()) {
                commandCreateAction.addOption(commandArgument.getOptionType(), commandArgument.getName(),
                        commandArgument.getDescription(), commandArgument.isRequired());
            }
            if (command.getArgs().size() < 1) {
                for (SubCommand subCommand : command.getSubCommands()) {
                    commandCreateAction.addSubcommands(new SubcommandData(subCommand.getName(),
                            subCommand.getDescription()));
                }
            }
            commandCreateAction.queue();
        }
    }

    public void execute(CommandInteraction cmd) {
        for (Command command : this.commands) {
            if (command.getName().equals(cmd.getEvent().getName())) {
                command.execute(cmd);
            }
        }
    }
}
