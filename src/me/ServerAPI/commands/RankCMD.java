package me.ServerAPI.commands;

import me.ServerAPI.main.Main;
import me.ServerAPI.rankapi.Rank;
import me.ServerAPI.rankapi.RankAPI;
import me.ServerAPI.utils.UUIDFetcher;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RankCMD extends Command {

	public RankCMD(String name) {
		super(name);
		
	}

	@Override
	public void execute(CommandSender s, String[] args) {
		if(s.hasPermission("system.rank") || RankAPI.hasMinimumRank(s.getName(), Rank.ADMIN)) {
			//rank set [Player] [Rank]
			//rank get [Player]
			if(args.length == 2) {
				if(args[0].equalsIgnoreCase("get")) {
					
					s.sendMessage(Main.pf+"§7Der Spieler "+RankAPI.getRankFromMySQL(args[1]).getColor()+args[1]+" §7hat den Rang "+RankAPI.getRankFromMySQL(args[1]).getFullWritten());
					
				} else {
					s.sendMessage(Main.pf+"§7Benutze§8: §c/rank get <Spieler>");
				}
			} else if(args.length == 3){
				
				if(args[0].equalsIgnoreCase("set")) {
					RankAPI.insertPlayerRankInMySQL(args[1], Rank.valueOf(args[2].toUpperCase()));
					s.sendMessage(Main.pf+"§7Der Spieler "+RankAPI.getRankFromMySQL(args[1]).getColor()+args[1]+" §7hat den Rang "+RankAPI.getRankFromMySQL(args[1]).getFullWritten());
				} else {
					s.sendMessage(Main.pf+"§7Benutze§8: §c/rank set <Spieler> <Rank>");
				}
				
			} else {
				s.sendMessage(Main.pf+"§7Benutze§8: §c/rank <set|get> <Spieler> <Rank>");
			}
		}


	}

}
