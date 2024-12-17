package org.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.main.listener.MonsterListener;
import org.main.listener.PlayerListener;
import org.main.listener.VillagerListener;

public class KJYPlugin extends JavaPlugin  {

    private final Listener VillagerListener = new VillagerListener();
    //private final Listener PlayerListener = new PlayerListener();
    private final Listener MonsterListener = new MonsterListener();

    @Override
    public void onEnable() {    //서버 실행 및 리로드 시 실행됨
        getServer().getPluginManager().registerEvents(VillagerListener, this);
        //getServer().getPluginManager().registerEvents(PlayerListener, this);
        getServer().getPluginManager().registerEvents(MonsterListener, this);
        //getServer : 서버가 이 플러그인을 실행함
        //getPluginManager : 대충 플러그인 매니저라는 뜻
        //registerEvents : 이벤트 리스너의 모든 이벤트를 플러그인에 등록함
    }

    @Override
    public void onDisable() { // 서버가 정지되면 실행된다.

    }

}
