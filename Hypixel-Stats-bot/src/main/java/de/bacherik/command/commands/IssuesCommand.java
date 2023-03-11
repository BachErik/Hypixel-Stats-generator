package de.bacherik.command.commands;

import de.bacherik.command.Command;
import de.bacherik.command.CommandInteraction;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class IssuesCommand extends Command {
    public IssuesCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(CommandInteraction command) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.CYAN);
        embedBuilder.setDescription("To report issues go there: " + "https://github.com/BachErik/Hypixel-Stats" +
                "-generator/issues/new");
        embedBuilder.setTitle("Issues");
        command.getEvent().replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
    }
}
