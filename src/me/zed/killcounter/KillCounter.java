package me.zed.killcounter;

import me.AdityaTD.ClusterAPI.Titles;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class KillCounter extends JavaPlugin implements Listener {

    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
    }
    public int count;

    @EventHandler
    public void kill(EntityDeathEvent e){
        LivingEntity entity = e.getEntity();
        LivingEntity killer = entity.getKiller();
        if(killer instanceof Player) {
            Player player = (Player)killer;
            count += 1;
            player.sendMessage(ChatColor.GREEN + "You're on a " + ChatColor.RED + count + ChatColor.GREEN + " Killstreak!");
            if(player.isDead()) {
                count = 0;
            }
            if(count == 2) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.RED + "Double Kill!", player.getName());
                player.playSound(player.getLocation(), Sound.MINECART_INSIDE, 5, 5);
            }
            if(count == 3) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.RED + "Triple Kill!", player.getName());
                player.playSound(player.getLocation(), Sound.LAVA_POP, 5,5);
            }
            if(count == 4) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.RED + "Quadra Kill!", player.getName());
                player.playSound(player.getLocation(), Sound.WATER, 5,5);
            }
            if(count == 5) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.RED.toString() + ChatColor.BOLD + "PENTA KILL!", player.getName());
                player.playSound(player.getLocation(), Sound.PORTAL, 5,5);
            }
            if(count == 10) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.DARK_RED + "Rampage!", player.getName());
                player.playSound(player.getLocation(), Sound.FIZZ, 5,5);
            }
            if(count == 12) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.DARK_RED + "Godlike!", player.getName());
                player.playSound(player.getLocation(), Sound.MINECART_BASE, 5,5);
            }
            if(count == 15) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.GOLD + "Legendary!", player.getName());
                player.playSound(player.getLocation(), Sound.LAVA, 5,5);
            }
            if(count == 17) {
                Titles.sendTitle(player, 25, 25, 25, ChatColor.GOLD.toString() + ChatColor.BOLD + "DOMINATING!", player.getName());
                player.playSound(player.getLocation(), Sound.DRINK, 5,5);
            }
        }
    }

    @EventHandler
    public void death(PlayerDeathEvent e) {
        Player p = (Player)e.getEntity();
        if(p instanceof Player) {
            //double checking, I'm not dumb..
            count = 0;
            p.sendMessage(ChatColor.GREEN + "Your killstreak has been reset to " + ChatColor.RED + count);
        }
    }
}
