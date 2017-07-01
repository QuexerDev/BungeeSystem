package me.ServerAPI.listeners;

import me.ServerAPI.rankapi.Rank;
import me.ServerAPI.rankapi.RankAPI;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginEvent implements Listener {
	
	@EventHandler
	public void onLogin(net.md_5.bungee.api.event.LoginEvent e) {
		String name = e.getConnection().getName();
		if(RankAPI.getRankFromMySQL(name) == Rank.PREMIUM) {
		if(RankAPI.hasPremium(name)) {
			if(e.getConnection() instanceof ProxiedPlayer) {
				ProxiedPlayer p = (ProxiedPlayer) e.getConnection();
				p.sendMessage(RankAPI.getRemainingPremiumTime(name));
			}
		} else {
			RankAPI.deleteRank(name);
		}
		}
		
		RankAPI.fillRankInHashMap(name);
		
	}

}
