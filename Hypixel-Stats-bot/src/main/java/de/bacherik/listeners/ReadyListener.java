package de.bacherik.listeners;

import de.bacherik.Bot;
import de.bacherik.Main;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ReadyListener extends ListenerAdapter {

    private static int instances = 0;
    private static int readyShards = 0;

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        Bot.getInstance().getCommandManager().init(event.getJDA());
        Main.logger.debug("[Shard " + (instances + 1) + "] started");
        instances++;
        readyShards++;
        if (Bot.getInstance().getShardManager().getShardsTotal() == instances) {
            Main.logger.info("FERTIG");
            for (int i = 0; i < Bot.getInstance().getShardManager().getShards().size(); i++) {
                Main.logger.debug("[Shard " + (i + 1) + "]: Guilds: " + Bot.getInstance().getShardManager().getShards().get(i).getGuilds().size());
            }
        }
        if (Bot.getInstance().getShardManager().getShardsTotal() == readyShards) {
            Bot.getInstance().setGuildCount(0);
            for (int i = 0; i < Bot.getInstance().getShardManager().getShards().size(); i++) {
                Bot.getInstance().setGuildCount(Bot.getInstance().getGuildCount() + Bot.getInstance().getShardManager().getShards().get(i).getGuilds().size());
            }
            Bot.servers = Bot.getInstance().getGuildCount();
            if (Bot.servers == 1) {
                Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " " + "Server"
                ));
            } else {
                Bot.getInstance().getShardManager().setActivity(Activity.playing("auf " + Bot.servers + " " +
                        "Serveren"));
            }
        }
    }
}
