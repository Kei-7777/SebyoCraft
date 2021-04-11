package com.github.kei7777.sebyocraft;

import com.github.kei7777.sebyocraft.illness.*;
import com.github.kei7777.sebyocraft.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.*;

import java.util.ArrayList;
import java.util.List;

public final class SebyoCraft extends JavaPlugin {

    public static SebyoCraft koko;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        koko = this;

        SebyoItemFactory.start();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new ToggleSneakListener(this), this);
        pm.registerEvents(new ChlamydiaListener(this), this);
        pm.registerEvents(new GonorrheaListener(this), this);
        pm.registerEvents(new HerpesListener(this), this);
        pm.registerEvents(new SyphilisListener(this), this);

        this.getCommand("sc").setExecutor(new MainCommandExecutor(this));

        IllnessManager.reg(IllnessType.chlamydia.id, new Chlamydia());
        IllnessManager.reg(IllnessType.syphilis.id, new Syphilis());
        IllnessManager.reg(IllnessType.gonorrhea.id, new Gonorrhea());
        IllnessManager.reg(IllnessType.herpes.id, new Herpes());

        new IllnessRunTask().runTaskTimer(this, 2, 2);
    }
}
