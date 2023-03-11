package de.bacherik.listeners;

import de.bacherik.Bot;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class OnGuild extends ListenerAdapter {
    private static final Logger logger = LogManager.getLogger(OnGuild.class);

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        logger.info("Join Server: " + event.getGuild().getName());
        Bot.servers++;
        if (Bot.servers == 1) {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Server"));
        } else {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Servers"));
            logger.info("Roberto.servers = " + Bot.servers);
        }
    }

    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        logger.info("Leave Server: " + event.getGuild().getName());
        Bot.servers--;
        if (Bot.servers == 1) {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Server"));
        } else {
            Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " Servers"));
            logger.info("Roberto.servers = " + Bot.servers);
        }
    }
}