package de.bacherik.command.commands;

import de.bacherik.Bot;
import de.bacherik.command.Command;
import de.bacherik.command.CommandInteraction;
import net.dv8tion.jda.api.EmbedBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.awt.*;
import java.sql.*;

public class DashboardCommand extends Command {
    private static final Logger logger = LogManager.getLogger(DashboardCommand.class);

    public DashboardCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void execute(CommandInteraction command) {
        /*

        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Does not work correct !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + Bot.getInstance().getMySQLHost() + "/" + Bot.getInstance().getMySQLName(), Bot.getInstance().getMySQLUsername().toString(), Bot.getInstance().getMySQLPassword().toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //! create table in database if not exists
        try {
            // Check if the table already exists
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet rs = metaData.getTables(null, null, "Bot", null);
            boolean tableExists = rs.next();
            rs.close();

            // If the table does not exist yet, create it
            if (!tableExists) {
                logger.info("Create Bot table in database");
                Statement stmt = conn.createStatement();
                stmt.execute("CREATE TABLE Bot ("
                        + "ID INT NOT NULL AUTO_INCREMENT, "
                        + "User VARCHAR(255), "
                        + "Dashboard_1 TEXT, "
                        + "Dashboard_2 TEXT, "
                        + "Dashboard_3 TEXT, "
                        + "Dashboard_4 TEXT, "
                        + "PRIMARY KEY (ID)"
                        + ")");
                stmt.close();


                Statement userStatement = conn.createStatement();
                userStatement.execute("INSERT INTO Bot (User, Dashboard_1, Dashboard_2, Dashboard_3, Dashboard_4)" +
                        "VALUES ('BachErik#7612', '{\"key1\": \"value1\", \"key2\": \"value2\"}', '{\"key3\": " +
                        "\"value3\"}', '{\"key4\": \"value4\"}', '{\"key5\": \"value5\"}');");
                userStatement.close();
                logger.info("Successful created Bot table in database");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //? get Dashboard values from table
        logger.debug(command.getEvent().getUser().getAsTag());
        try {
            Statement stmt = conn.createStatement();
            String sql =
                    "SELECT Dashboard_1, Dashboard_2, Dashboard_3, Dashboard_4 FROM Bot WHERE User = '" + command.getEvent().getUser().getAsTag() + "'";
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();

            logger.debug(stmt);

            String dashboard1 = "";
            String dashboard2 = "";
            String dashboard3 = "";
            String dashboard4 = "";
            logger.debug("1");

            if (rs.next()) {
                dashboard1 = rs.getString("Dashboard_1");
                dashboard2 = rs.getString("Dashboard_2");
                dashboard3 = rs.getString("Dashboard_3");
                dashboard4 = rs.getString("Dashboard_4");
                rs.close();

                logger.debug("2");
                // Hier können Sie mit den Variablen dashboard1 bis dashboard4 arbeiten
                logger.debug(dashboard1);
                logger.debug(dashboard2);
                logger.debug(dashboard3);
                logger.debug(dashboard4);
            }

            logger.debug("3");

            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Dashboards");
            embedBuilder.setColor(Color.blue);
            embedBuilder.addField("Dashboard 1", dashboard1, true);
            embedBuilder.addField("Dashboard 2", dashboard2, true);
            embedBuilder.addField("Dashboard 3", dashboard3, true);
            embedBuilder.addField("Dashboard 4", dashboard4, true);
            command.getEvent().reply("Your Dashboards:").addEmbeds(embedBuilder.build()).setEphemeral(true).queue();

            logger.debug("4");
            // Close connection
            conn.close();
        } catch (SQLException ex) {
            // Fehlerbehandlung
        }


        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Does not work correct !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        */
    }
}
