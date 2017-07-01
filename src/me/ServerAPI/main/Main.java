package me.ServerAPI.main;

import me.ServerAPI.commands.RankCMD;
import me.ServerAPI.commands.SetPremiumCMD;
import me.ServerAPI.database.MySQL;
import me.ServerAPI.listeners.LoginEvent;
import me.ServerAPI.listeners.PingEvent;
import me.ServerAPI.rankapi.RankAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.command.CommandBungee;

public class Main extends Plugin{
	public static String pf = "§8[§eServer§8] ";
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		
		MySQL.username = "Quexer";
		MySQL.password = "oe196jUF";
		MySQL.database = "ownserver";
		MySQL.host = "localhost";
		MySQL.port = "3306";
		
		MySQL.Connect();
		MySQL.CreateTable();
		BungeeCord.getInstance().getConsole().sendMessage(pf+"§7Die MYSQL Verbindung wurde erfolgreich hergestellt§8!");
		
		BungeeCord.getInstance().getPluginManager().registerListener(this, new LoginEvent());
		BungeeCord.getInstance().getPluginManager().registerListener(this, new PingEvent());
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new RankCMD("Rank"));
		BungeeCord.getInstance().getPluginManager().registerCommand(this, new SetPremiumCMD("setPremium"));
		
		for(ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			RankAPI.fillRankInHashMap(all.getName());
		}
		
	}
	
	

}
