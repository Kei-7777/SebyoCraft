package com.github.kei7777.sebyocraft;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;

public class SebyoItemFactory {

    public static ItemStack med_c;
    public static ItemStack med_g;
    public static ItemStack med_h;
    public static ItemStack med_s;

    public static ItemStack rub;

    static void start(){
        rub = new ItemStack(Material.PAPER);
        ItemMeta meta = rub.getItemMeta();
        meta.setDisplayName("コンドーム");
        meta.setLore(Arrays.asList(
                ChatColor.RESET + "これで性病予防！",
                ChatColor.RESET + "望まない妊娠を予防！"
        ));
        rub.setItemMeta(meta);

        med_c = new ItemStack(Material.POTION);
        PotionMeta meta2 = (PotionMeta) med_c.getItemMeta();
        meta2.setColor(Color.AQUA);
        meta2.setDisplayName("アジスロマイシン錠250mg「タカタ」");
        meta2.setLore(Arrays.asList(
                ChatColor.RESET + "" + ChatColor.RED + "この薬の作用と効果について",
                ChatColor.RESET + "マクロライド系の抗生物質で、細菌などの蛋白合成を阻害することにより抗菌作用を示します。",
                ChatColor.RESET + "通常、皮膚感染症、呼吸器感染症、尿道炎、子宮頸管炎、骨盤内炎症性疾患などの感染症治療に用いられます。",
                ChatColor.RESET + "クラミジアを治療することができます。",
                ChatColor.RESET + "" + ChatColor.RED + "この薬を使ったあと気をつけていただくこと（副作用）",
                ChatColor.RESET + "主な副作用として、下痢、腹痛、吐き気、嘔吐、血栓性静脈炎、カンジダ症、発疹、じんましん、",
                ChatColor.RESET + "かゆみ、アトピー性皮膚炎悪化、光線過敏性反応（光にあたった部分が赤くなる）、紅斑、水疱、皮膚剥離、",
                ChatColor.RESET + "多形紅斑、寝汗、多汗症、皮膚乾燥、皮膚変色、脱毛などが報告されています。",
                ChatColor.RESET + "このような症状に気づいたら、担当の医師または薬剤師に相談してください。"
        ));
        meta2.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 15*20, 1), true);
        med_c.setItemMeta(meta2);

        med_g = new ItemStack(Material.POTION);
        PotionMeta meta3 = (PotionMeta) med_g.getItemMeta();
        meta3.setColor(Color.GREEN);
        meta3.setDisplayName("セフトリアキソンナトリウム点滴静注用バッグ1g「ファイザー」");
        meta3.setLore(Arrays.asList(
                ChatColor.RESET + "" + ChatColor.RED + "この薬の作用と効果について",
                ChatColor.RESET + "〈適応菌種〉\n" +
                        "セフトリアキソンに感性のブドウ球菌属、レンサ球菌属、肺炎球菌、淋菌、大腸菌、シトロバクター属、",
                ChatColor.RESET + "クレブシエラ属、エンテロバクター属、セラチア属、プロテウス属、モルガネラ・モルガニー、プロビデンシア属、",
                ChatColor.RESET + "インフルエンザ菌、ペプトストレプトコッカス属、バクテロイデス属、プレボテラ属（プレボテラ・ビビアを除く）",
                ChatColor.RESET + "淋病を治療することができます。",
                ChatColor.RESET + "" + ChatColor.RED + "この薬を使ったあと気をつけていただくこと（副作用）",
                ChatColor.RESET + "主な副作用として、ショック、アナフィラキシー、劇症肝炎、偽膜性大腸炎等の血便を伴う重篤な大腸炎、肝機能障害、",
                ChatColor.RESET + "汎血球減少、無顆粒球症、白血球減少、血小板減少、溶血性貧血（頻度不明）などが報告されています。",
                ChatColor.RESET + "このような症状に気づいたら、担当の医師または薬剤師に相談してください。"
        ));
        meta3.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 15*20, 1), true);
        med_g.setItemMeta(meta3);

        med_s = new ItemStack(Material.POTION);
        PotionMeta meta4 = (PotionMeta) med_s.getItemMeta();
        meta4.setColor(Color.PURPLE);
        meta4.setDisplayName("サワシリンカプセル250（250mg1カプセル）");
        meta4.setLore(Arrays.asList(
                ChatColor.RESET + "" + ChatColor.RED + "この薬の作用と効果について",
                ChatColor.RESET + "アモキシシリン製剤、細菌の細胞壁合成を阻害し細菌に殺菌的に抗菌作用をあらわす薬。",
                ChatColor.RESET + "本剤は細菌のPBPに作用し細胞壁合成を阻害することで抗菌作用をあらわす。",
                ChatColor.RESET + "梅毒を治療することができます。",
                ChatColor.RESET + "" + ChatColor.RED + "この薬を使ったあと気をつけていただくこと（副作用）",
                ChatColor.RESET + "主な副作用として、下痢、吐き気、食欲不振、アナフィラキシーショック、偽皮膚のかゆみ、",
                ChatColor.RESET + "膜性大腸炎、腹痛、蕁麻疹、声のかすれ、息苦しさ、などが報告されています。",
                ChatColor.RESET + "このような症状に気づいたら、担当の医師または薬剤師に相談してください。"
        ));
        meta4.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 15*20, 1), true);
        med_s.setItemMeta(meta4);

        med_h = new ItemStack(Material.POTION);
        PotionMeta meta5 = (PotionMeta) med_h.getItemMeta();
        meta5.setColor(Color.YELLOW);
        meta5.setDisplayName("アラセナS");
        meta5.setLore(Arrays.asList(
                ChatColor.RESET + "" + ChatColor.RED + "この薬の作用と効果について",
                ChatColor.RESET + "「アラセナS」・「アラセナSクリーム」は、医療用で使用されている「アラセナ-A軟膏3％」",
                ChatColor.RESET + "「アラセナ-Aクリーム3％」と同じ濃度の有効成分を配合しています。",
                ChatColor.RESET + "ヘルペスを治療することができます。"));
        meta5.addCustomEffect(new PotionEffect(PotionEffectType.CONFUSION, 15*20, 1), true);
        med_h.setItemMeta(meta5);
    }
}
