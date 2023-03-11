package de.bacherik;

import de.bacherik.command.CommandManager;
import de.bacherik.listeners.OnGuild;
import de.bacherik.listeners.ReadyListener;
import de.bacherik.listeners.SlashCommandListener;
import de.leonhard.storage.Json;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class Bot {

    private static final Logger logger = LoggerFactory.getLogger(Bot.class);
    public static int servers;
    private static Bot instance;
    private ShardManager shardManager;
    private CommandManager commandManager;
    private int guildCount;
    private File config;

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

    public void init(File config) {
        logger.info("Bot Initialisation ...");
        instance = this;
        this.config = config;
        commandManager = new CommandManager();
        start();
        logger.info("Bot Initialization finished!");
    }

    public void start() {
        logger.info("Bot Starting ...");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(getDiscordToken().toString());
        builder.setActivity(Activity.watching("Starting ..."));
        builder.disableIntents(GatewayIntent.GUILD_MESSAGE_TYPING, GatewayIntent.DIRECT_MESSAGE_TYPING);
        builder.addEventListeners(new ReadyListener());
        builder.addEventListeners(new SlashCommandListener());
        builder.addEventListeners(new OnGuild());
        servers = getGuildCount();
        builder.setShardsTotal(2);

        shardManager = builder.build();
        logger.info("Bot started!");
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

    public Object getDiscordToken() {
        Json config = new Json(this.config);
        return config.get("bot-token");
    }

    public Object getMySQLHost() {
        Json config = new Json(this.config);
        return config.get("database-host");
    }

    public Object getMySQLUsername() {
        Json config = new Json(this.config);
        return config.get("database-username");
    }

    public Object getMySQLPassword() {
        Json config = new Json(this.config);
        return config.get("database-password");
    }

    public Object getMySQLName() {
        Json config = new Json(this.config);
        return config.get("database-name");
    }
}
