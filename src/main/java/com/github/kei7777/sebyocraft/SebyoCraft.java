package com.github.kei7777.sebyocraft;

import com.github.kei7777.sebyocraft.illness.*;
import com.github.kei7777.sebyocraft.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

import java.util.ArrayList;
import java.util.List;

public final class SebyoCraft extends JavaPlugin {

    public List<EntityType> mobs;
    public static SebyoCraft koko;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        koko = this;
        reload();

        SebyoItemFactory.start();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ToggleSneakListener(this), this);
        pm.registerEvents(new ChlamydiaListener(this), this);
        pm.registerEvents(new GonorrheaListener(this), this);
        pm.registerEvents(new HerpesListener(this), this);
        pm.registerEvents(new SyphilisListener(this), this);

        this.getCommand("sc").setExecutor(new MainCommandExecutor(this));

        IllnessManager.reload();
        new IllnessRunTask().runTaskTimer(this, 2, 2);
    }

    @Override
    public void onDisable() {
    }

    public void reload(){
        mobs = new ArrayList<>();
        for(EntityType t : EntityType.values()) {
            boolean can = true;
            for (String type : koko.getConfig().getStringList("settings.entities")) {
                if(t == EntityType.valueOf(type)){
                    can = false;
                }
            }
            if(can) mobs.add(t);
        }
    }

    public static void main(String[] args) {
        //test
        System.out.println(true ? "true" : "false");
        System.out.println(false ? "true" : "false");
    }
}
