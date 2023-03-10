package de.bacherik;

import de.bacherik.command.CommandManager;
import de.bacherik.listeners.OnGuild;
import de.bacherik.listeners.ReadyListener;
import de.bacherik.listeners.SlashCommandListener;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Bot {


    public static int servers;
    private static Bot instance;
    private ShardManager shardManager;
    private CommandManager commandManager;
    private int guildCount;

    public static Bot getInstance() {
        return instance;
    }

    public static void setInstance(Bot instance) {
        Bot.instance = instance;
    }

    public static int getServers() {
        return servers;
    }

    public static void setServers(int servers) {
        Bot.servers = servers;
    }

    public void init(String token) {
        Main.logger.info("Bot Initialisation ...");
        instance = this;
        commandManager = new CommandManager();
        start(token);
        Main.logger.info("Bot Initializationed!");
    }

    public void start(String token) {
        Main.logger.info("Bot Strarting ...");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setActivity(Activity.watching("Starting ..."));
        builder.disableIntents(GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_TYPING);
        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new SlashCommandListener());
        builder.addEventListeners(new OnGuild());
        servers = getGuildCount();
        builder.setShardsTotal(2);

        shardManager = builder.build();
        Main.logger.info("Bot started!");
    }

    public int getGuildCount() {
        return guildCount;
    }

    public void setGuildCount(int guildCount) {
        this.guildCount = guildCount;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public void setShardManager(ShardManager shardManager) {
        this.shardManager = shardManager;
    }
}
