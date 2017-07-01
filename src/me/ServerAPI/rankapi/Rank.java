package me.ServerAPI.rankapi;

public enum Rank {
	
	SPIELER("SPIELER","§a","§a", "§aSpieler"),
	
	PREMIUM("PREMIUM","§6","§6", "§6Premium"),
	
	PREMIUMPLUS("PREMIUMPLUS","§e","§e", "§ePremiumPlus"),
	
	YOUTUBER("YOUTUBER","§5","§5","§5YouTuber"),
	
	SUPPORTER("SUPPORTER","§9Sup §7| §9","§9","§9Supporter"),
	
	MODERATOR("MODERATOR","§cMod §7| §c","§c","§cModerator"),
	
	SRMODERATOR("SRMODERATOR","§cSrMod §7| §c","§c","§cSrModerator"),
	
	DEVELOPER("DEVELOPER","§bDev §7| §b","§b","§bDeveloper"),
	
	CONTENT("CONTENT","§bContent §7| §b","§b","§bContent"),
	
	BUILDER("BUILDER","§2Builder §7| §2","§2","§2Builder"),
	
	ADMIN("ADMIN","§4Admin §7| §4","§4","§4Admin"),
	
	OWNER("OWNER","§4OWNER §7| §4","§4","§4Owner");
	
	
	private String name;
	private String prefix;
	private String color;
	private String full;
	
	
	private Rank(String name, String prefix, String color, String full) {
		this.name = name;
		this.prefix = prefix;
		this.color = color;
		this.full = full;
	}
	
	public String getName() {
		return this.name;
	}
	public String getPrefix() {
		return this.prefix;
	}
	public String getColor() {
		return this.color;
	}
	public String getFullWritten() {
		return this.full;
	}
	
	

}
