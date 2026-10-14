package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;


public class ModArmorMaterials {

    // 1. 定义 RegistryKey（唯一身份证）
    public static final RegistryKey<ArmorMaterial> STELLAR_CORE_KEY =
            RegistryKey.of(RegistryKeys.ARMOR_MATERIAL, Identifier.of(DivinityMod.MOD_ID, "stellar_core"));

    // 2. 定义 RegistryEntry（供 ArmorItem 使用，先声明，在 register() 中赋值）
    public static RegistryEntry<ArmorMaterial> STELLAR_CORE_ENTRY;

    // 3. 核心注册方法（必须在主类的 onInitialize 中调用）
    public static void register() {
        // 获取下界合金的装备声音（1.21中需要 RegistryEntry<SoundEvent>）
        RegistryEntry<SoundEvent> equipSound = Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE.value());

        // 构建防御力数值
        Map<ArmorItem.Type, Integer> defense = new EnumMap<>(ArmorItem.Type.class);
        defense.put(ArmorItem.Type.BOOTS, 4);
        defense.put(ArmorItem.Type.LEGGINGS, 7);
        defense.put(ArmorItem.Type.CHESTPLATE, 9);
        defense.put(ArmorItem.Type.HELMET, 4);
        // 1.21.1 新增了 BODY（马铠等）类型，建议加上以防警告，不需要可删掉此行
        defense.put(ArmorItem.Type.BODY, 9);

        // 构建材质对象
        ArmorMaterial material = new ArmorMaterial(
                defense,                            // 防御力
                25,                                 // 附魔权重
                equipSound,                         // 装备声音 (RegistryEntry)
                () -> Ingredient.ofItems(ModItems.STELLAR_CORE_INGOT), // 修复材料 (Supplier)
                List.of(new ArmorMaterial.Layer(Identifier.of(DivinityMod.MOD_ID, "stellar_core"))), // 纹理层
                4.0f,                               // 韧性 (Toughness)
                0.3f                                // 击退抗性 (Knockback Resistance)
        );

        // 执行注册并获取 Entry
        STELLAR_CORE_ENTRY = Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                STELLAR_CORE_KEY,
                material
        );
    }
}