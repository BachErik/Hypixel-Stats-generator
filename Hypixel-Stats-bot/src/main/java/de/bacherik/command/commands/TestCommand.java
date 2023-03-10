package de.bacherik.command.commands;


import de.bacherik.command.Command;
import de.bacherik.command.CommandInteraction;

public class TestCommand extends Command {

    public TestCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(CommandInteraction command) {
        command.getEvent().reply("Test success").setEphemeral(true).queue();
    }
}
