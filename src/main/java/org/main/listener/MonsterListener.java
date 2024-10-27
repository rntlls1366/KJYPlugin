package org.main.listener;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MonsterListener implements Listener {

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        //몬스터인지 확인
        if (isMonster(event.getEntityType())) {
            //스폰 위치
            Location spawnLocation = event.getLocation();

            if (isWithinLocation(spawnLocation, 220, 100, -372, 374, 125, -218)) {
                event.setCancelled(true);
            }
        }
    }

    private boolean isMonster(EntityType entityType) {
        switch (entityType) {
            case ZOMBIE:
            case SKELETON:
            case CREEPER:
            case SPIDER:
            case ENDERMAN:
            case BLAZE:
            case GHAST:
            case SLIME:
            case WITCH:
            case PHANTOM:
                return true;
            default:
                return false;
        }
    }

    private boolean isWithinLocation(Location location, int x1, int y1, int z1, int x2, int y2, int z2) {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2) && (z >= z1 && z <= z2);
    }
}
