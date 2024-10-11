package org.main.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;

public class VillagerListener implements Listener {

    @EventHandler
    public void onVillagerCareerChange(VillagerCareerChangeEvent event) {
        if (event.getProfession() == Villager.Profession.LIBRARIAN) {
            //직업 변경 이벤트 취소
            event.setCancelled(true);
            //서버 전체 메시지
            Component message = Component.text("Can not career change to LIBRARIAN!");
            Bukkit.getServer().broadcast(message, "");
        }
    }

    @EventHandler
    public void onVillagerSpawn(CreatureSpawnEvent event) {
        if (event.getEntity() instanceof Villager) {
            Villager villager = (Villager) event.getEntity();

            //스폰된 주민의 직업이 사서면 무직으로 변경
            if (villager.getProfession() == Villager.Profession.LIBRARIAN) {
                villager.setProfession(Villager.Profession.NONE);
            }
        }
    }
}
