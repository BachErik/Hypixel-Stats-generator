package de.bacherik.command.commands;


import de.bacherik.command.Command;
import de.bacherik.command.CommandInteraction;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class HelpCommand extends Command {

    public HelpCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(CommandInteraction command) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.GREEN);
        embed.setTitle("Title");
        embed.setAuthor("BachErik", "https://bacherik.de", "https://bacherik.de/LoGo.ico");
        command.getEvent().replyEmbeds(embed.build()).setEphemeral(true).queue();
    }
}
