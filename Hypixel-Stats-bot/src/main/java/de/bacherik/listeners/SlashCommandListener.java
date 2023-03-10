package de.bacherik.listeners;

import de.bacherik.Bot;
import de.bacherik.command.CommandInteraction;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        Bot.getInstance().getCommandManager().execute(new CommandInteraction(event));
    }


}
