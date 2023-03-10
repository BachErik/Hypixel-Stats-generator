package de.bacherik.command;


import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class CommandInteraction {

    private final SlashCommandInteractionEvent event;

    public CommandInteraction(SlashCommandInteractionEvent event) {
        this.event = event;
    }


    public SlashCommandInteractionEvent getEvent() {
        return event;
    }
}
