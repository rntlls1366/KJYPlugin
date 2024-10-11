package org.main.listener;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    // 플레이어가 서버를 떠날 때(World를 종료할 때) 월드를 저장하는 핸들러
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        // 현재 서버에 로드된 모든 월드를 저장
        for (World world : Bukkit.getWorlds()) {
            world.save();  // 월드 저장
        }
    }
}
