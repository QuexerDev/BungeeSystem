package me.ServerAPI.commands;

import me.ServerAPI.main.Main;
import me.ServerAPI.rankapi.Rank;
import me.ServerAPI.rankapi.RankAPI;
import me.ServerAPI.utils.UUIDFetcher;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class SetPremiumCMD extends Command {

	public SetPremiumCMD(String string) {
		super(string);
	}

	@Override
	public void execute(CommandSender s, String[] args) {
		if(s.hasPermission("system.rank") || RankAPI.hasMinimumRank(s.getName(), Rank.ADMIN)) {
			
			if(args.length == 2) {
				
				
				RankAPI.setPremium(args[0], Integer.parseInt(args[1]));	
				s.sendMessage(Main.pf+"§7Der Spieler "+Rank.PREMIUM.getColor()+args[0]+" §7hat jetzt den §6Premium §7Rang§8!");
				if(BungeeCord.getInstance().getPlayer(UUIDFetcher.getUUID(args[0])) != null) {
					BungeeCord.getInstance().getPlayer(UUIDFetcher.getUUID(args[0])).disconnect(
							"§7§m-------------------------------------------------------------------------------------------\n"
							+ "\n"
							+ "§7Du hast den Rank §6Premium §7für §e"+RankAPI.getRemainingPremiumTime(args[0])+" §7erhalten§8!\n"
							+ "\n"
							+ "§7§m-------------------------------------------------------------------------------------------\n");
				}
				
				
			}
			
			
		}

	}

}
