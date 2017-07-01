package me.ServerAPI.rankapi;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import me.ServerAPI.database.MySQL;
import me.ServerAPI.main.Main;
import me.ServerAPI.utils.UUIDFetcher;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class RankAPI {
	
	public static HashMap<ProxiedPlayer, Rank> ranks = new HashMap<>();
	
	@SuppressWarnings("deprecation")
	public static void insertPlayerRankInMySQL(String name, Rank rank) {
		String UUID = UUIDFetcher.getUUID(name).toString();
		
		MySQL.update("INSERT INTO RankAPI(UUID, Rank) VALUES ('"+UUID+"','"+rank.toString()+"')");
		if(BungeeCord.getInstance().getPlayer(UUID) != null) {
			ProxiedPlayer p = BungeeCord.getInstance().getPlayer(UUID);
		p.sendMessage("§cDer Rank wurde geupdatet");
		p.disconnect(Main.pf+"§7Du hast den Rang "+rank.getFullWritten()+" §7erhalten§8!");
		}
		
	}
	public static Rank getRankFromMySQL(String name) {
		String UUID = UUIDFetcher.getUUID(name).toString();
		
		ResultSet rs = MySQL.getResult("SELECT * FROM RankAPI WHERE UUID='"+UUID+"'");
		
		try {
			if(rs.next()) {
				return Rank.valueOf(rs.getString("Rank"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Rank.SPIELER;
		
	}
	public static void deleteRank(String name) {
		String UUID = UUIDFetcher.getUUID(name).toString();
		
		MySQL.update("DELETE FROM RankAPI WHERE UUID='"+UUID+"'");
	}
	@SuppressWarnings("deprecation")
	public static void fillRankInHashMap(String name) {
		ranks.put(BungeeCord.getInstance().getPlayer(name), getRankFromMySQL(name));
		
		
	}
	public static Rank getRank(String name) {
		return ranks.get(BungeeCord.getInstance().getPlayer(name));
	}
	public static boolean hasMinimumRank(String name, Rank rank) {
		String p = name;
		if(rank == Rank.OWNER) {
			if(getRank(p) == Rank.OWNER || getRank(p) == Rank.ADMIN || getRank(p) == Rank.DEVELOPER || getRank(p) == Rank.SRMODERATOR || getRank(p) == Rank.MODERATOR || getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.ADMIN) {
			if(getRank(p) == Rank.ADMIN || getRank(p) == Rank.DEVELOPER || getRank(p) == Rank.SRMODERATOR || getRank(p) == Rank.MODERATOR || getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.DEVELOPER) {
			if(getRank(p) == Rank.DEVELOPER || getRank(p) == Rank.SRMODERATOR || getRank(p) == Rank.MODERATOR || getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.SRMODERATOR) {
			if(getRank(p) == Rank.SRMODERATOR || getRank(p) == Rank.MODERATOR || getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.MODERATOR) {
			if(getRank(p) == Rank.MODERATOR || getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.SUPPORTER) {
			if(getRank(p) == Rank.SUPPORTER || getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.BUILDER) {
			if(getRank(p) == Rank.BUILDER || getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.CONTENT) {
			if(getRank(p) == Rank.CONTENT || getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.YOUTUBER) {
			if(getRank(p) == Rank.YOUTUBER || getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.PREMIUMPLUS) {
			if(getRank(p) == Rank.PREMIUMPLUS || getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.PREMIUM) {
			if(getRank(p) == Rank.PREMIUM || getRank(p) == Rank.SPIELER){
				return true;
			}
		} else if (rank == Rank.SPIELER) {
			if(getRank(p) == Rank.SPIELER){
				return true;
			}
		}
		return false;
		
	}
	public static void setPremium(String name, long tage) {
		deleteRank(name);
		long end;
		if(tage == -1) {
			end = -1;
		} else {
		long current = System.currentTimeMillis();
		long newTage = 1000*60*60*24*tage;
		end = current+newTage;
		}
		String UUID = UUIDFetcher.getUUID(name).toString();
		
		MySQL.update("INSERT INTO RankAPI(UUID, Rank, end) VALUES ('"+UUID+"','"+Rank.PREMIUM.toString()+"','"+end+"')");
		if(BungeeCord.getInstance().getPlayer(name) != null) {
			if(end == -1) {
				BungeeCord.getInstance().getPlayer(name).disconnect(Main.pf+"§7Du hast den Rang "+Rank.PREMIUM.getFullWritten()+" §7für §e§lLIFETIME §7erhalten§8!");
			}
			BungeeCord.getInstance().getPlayer(name).disconnect(Main.pf+"§7Du hast den Rang "+Rank.PREMIUM.getFullWritten()+" §7für §c"+tage+" §7Tage erhalten§8!");
		}
		
		
		
	}
	public static boolean hasPremium(String name) {
String UUID = UUIDFetcher.getUUID(name).toString();
		
		ResultSet rs = MySQL.getResult("SELECT * FROM RankAPI WHERE UUID='"+UUID+"' AND Rank='Premium'");
		
		try {
			if(rs.next()) {
				long now = System.currentTimeMillis();
				long fromMySQL = rs.getLong("end");
				if(now <= fromMySQL || fromMySQL == -1) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static String getRemainingPremiumTime(String name) {
		Date date = new Date();
		
		String UUID = UUIDFetcher.getUUID(name).toString();
		
		ResultSet rs = MySQL.getResult("SELECT * FROM RankAPI WHERE UUID='"+UUID+"' AND Rank='Premium'");
		
		try {
			if(rs.next()) {
				if(rs.getLong("end") == -1) {
					return Main.pf+"§7Du hast den §6Premium §7Rang §e§lLIFETIME";
				}
				date.setTime(rs.getLong("end"));
				
				return Main.pf+"§7Du hast noch §8"+date.getMonth()+" §eMonat(e)§8, §8"+date.getDay()+" §eTag(e)§8 und §e"+date.getHours()+" §eStunde(n) §7Den §6Premium §7Rang";
				
			} else {
				return Main.pf+"§cDu hast keinen Premium Rang";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Main.pf+"§cDu hast keinen Premium Rang";
	}

}
