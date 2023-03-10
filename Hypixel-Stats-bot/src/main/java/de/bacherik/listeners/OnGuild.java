package de.bacherik.listeners;

import de.bacherik.Bot;
import de.bacherik.Main;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class OnGuild extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Main.logger.info("Join Server: " + event.getGuild().getName());
        Bot.servers++;
        if (Bot.servers == 1) {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Server"));
        } else {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Serveren"));
            Main.logger.info("Roberto.servers = " + Bot.servers);
        }
    }

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Main.logger.info("Leave Server: " + event.getGuild().getName());
        Bot.servers--;
        if (Bot.servers == 1) {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Server"));
        } else {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Serveren"));
            Main.logger.info("Roberto.servers = " + Bot.servers);
        }
    }
}