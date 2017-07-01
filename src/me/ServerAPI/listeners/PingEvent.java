package me.ServerAPI.listeners;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Protocol;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PingEvent implements Listener {
	
	@EventHandler
	   public void on(ProxyPingEvent e) {
	      ServerPing conn = e.getResponse();
	     
	      conn.setVersion(new Protocol("§c§lWartungsarbeiten", 2));
	      conn.setDescription("§bPortal§6MC §8- §cWartungsmodus");
	      e.setResponse(conn);
	   }


}
