package me.ServerAPI.commands;

import me.ServerAPI.main.Main;
import me.ServerAPI.rankapi.Rank;
import me.ServerAPI.rankapi.RankAPI;
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
				
				
			}
			
			
		}

	}

}
