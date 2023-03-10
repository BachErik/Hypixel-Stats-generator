package de.bacherik.command;


import net.dv8tion.jda.api.interactions.commands.OptionType;

import java.util.ArrayList;

public abstract class Command {

    private final String name;
    private final String description;
    private final ArrayList<CommandArgument> args;
    private final ArrayList<SubCommand> subCommands;

    public Command(String name, String description) {
        this.name = name.toLowerCase();
        this.description = description;
        this.args = new ArrayList<>();
        this.subCommands = new ArrayList<>();
    }

    public Command addArgument(OptionType optionType, String name, String description) {
        args.add(new CommandArgument(optionType, name.toLowerCase(), description, false));
        return this;
    }

    public Command addArgument(OptionType optionType, String name, String description, boolean required) {
        args.add(new CommandArgument(optionType, name.toLowerCase(), description, required));
        return this;
    }

    public Command addSubCommand(String name, String description) {
        subCommands.add(new SubCommand(name, description));
        return this;
    }

    public abstract void execute(CommandInteraction command);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<CommandArgument> getArgs() {
        return args;
    }

    public ArrayList<SubCommand> getSubCommands() {
        return subCommands;
    }
}
