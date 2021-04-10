package com.github.kei7777.sebyocraft;

import com.github.kei7777.sebyocraft.illness.IllnessManager;
import com.github.kei7777.sebyocraft.illness.IllnessType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainCommandExecutor implements CommandExecutor, TabCompleter {
    public MainCommandExecutor(SebyoCraft sebyoCraft) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.isOp()) {
            sender.sendMessage(ChatColor.RED + "実行するには管理者権限が必要です。");
            return true;
        }

        if(args.length < 1){
            sender.sendMessage(ChatColor.WHITE + "/sc debug アイテムを入手します");
            sender.sendMessage(ChatColor.WHITE + "/sc sick <player> <type> 強制的に性病になります");
            sender.sendMessage(ChatColor.WHITE + "/sc cure <player> 完治させます");
            return true;
        }

        if("debug".equalsIgnoreCase(args[0])){
            Player p = (Player) sender;
            p.getInventory().addItem(SebyoItemFactory.rub);
            p.getInventory().addItem(SebyoItemFactory.med_c);
            p.getInventory().addItem(SebyoItemFactory.med_s);
            p.getInventory().addItem(SebyoItemFactory.med_g);
            p.getInventory().addItem(SebyoItemFactory.med_h);
            return true;
        }

        if("sick".equalsIgnoreCase(args[0])){
            if(args.length < 3){
                sender.sendMessage(ChatColor.WHITE + "/sc sick <player> <type> 強制的に性病になります");
                sender.sendMessage(ChatColor.WHITE + "- 梅毒, 淋病, ヘルペス, クラミジア");
                return true;
            } else {
                if("梅毒".equals(args[2])){
                    if(Bukkit.getPlayer(args[1]) != null){
                        IllnessManager.sick(Bukkit.getPlayer(args[1]), IllnessType.syphilis);
                    } else {
                        sender.sendMessage("プレイヤーが見つかりません。");
                    }
                } else if("淋病".equals(args[2])){
                    if(Bukkit.getPlayer(args[1]) != null){
                        IllnessManager.sick(Bukkit.getPlayer(args[1]), IllnessType.gonorrhea);
                    } else {
                        sender.sendMessage("プレイヤーが見つかりません。");
                    }
                } else if("ヘルペス".equals(args[2])){
                    if(Bukkit.getPlayer(args[1]) != null){
                        IllnessManager.sick(Bukkit.getPlayer(args[1]), IllnessType.herpes);
                    } else {
                        sender.sendMessage("プレイヤーが見つかりません。");
                    }
                } else if("クラミジア".equals(args[2])){
                    if(Bukkit.getPlayer(args[1]) != null){
                        IllnessManager.sick(Bukkit.getPlayer(args[1]), IllnessType.chlamydia);
                    } else {
                        sender.sendMessage("プレイヤーが見つかりません。");
                    }
                } else {
                    sender.sendMessage(ChatColor.WHITE + "/sc sick <player> <type> 強制的に性病になります");
                    sender.sendMessage(ChatColor.WHITE + "- 梅毒, 淋病, ヘルペス, クラミジア");
                    return true;
                }
                return true;
            }
        }
        if("cure".equalsIgnoreCase(args[0])){
            if(args.length < 2) {
                sender.sendMessage(ChatColor.WHITE + "/sc cure <player> 完治させます");
                return true;
            } else {
                if(Bukkit.getPlayer(args[1]) != null){
                    for(IllnessType t : IllnessType.values()) {
                        IllnessManager.cure(Bukkit.getPlayer(args[1]), t);
                        sender.sendMessage(args[1] + "の" + t + "を直しました。");
                    }
                } else {
                    sender.sendMessage("プレイヤーが見つかりません。");
                }
                return true;
            }
        }
        sender.sendMessage(ChatColor.WHITE + "/sc debug アイテムを入手します");
        sender.sendMessage(ChatColor.WHITE + "/sc sick <player> <sick> 強制的に性病になります");
        sender.sendMessage(ChatColor.WHITE + "/sc cure <player> 完治させます");
        return true;
    }


    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length < 2){
            List<String> l = new ArrayList<>();
            for(String s : Arrays.asList("debug", "sick", "cure")){
                if(s.startsWith(args[0])){
                    l.add(s);
                }
            }
            return l;
        }

        if(args.length == 2){
            List<String> l = new ArrayList<>();
            for(Player s : Bukkit.getOnlinePlayers()){
                if(s.getName().startsWith(args[1])){
                    l.add(s.getName());
                }
            }
            return l;
        }

        if(args.length == 3){
            List<String> l = new ArrayList<>();
            if("sick".equalsIgnoreCase(args[0])) {
                for (IllnessType s : IllnessType.values()) {
                    if (s.name.startsWith(args[2])) {
                        l.add(s.name);
                    }
                }
                return l;
            }
        }
        return Collections.singletonList("");
    }
}
