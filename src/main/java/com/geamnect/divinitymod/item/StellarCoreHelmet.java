package com.geamnect.divinitymod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class StellarCoreHelmet extends ArmorItem {

    public StellarCoreHelmet(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // 仅在服务端执行，且必须是玩家
        if (world.isClient() || !(entity instanceof PlayerEntity player)) {
            return;
        }

        // ✅ 核心优化：只在效果即将过期时才刷新，避免每 tick 重复添加
        StatusEffectInstance current = player.getStatusEffect(StatusEffects.REGENERATION);
        if (current == null || current.getDuration() <= 20) {
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION,
                    60,     // 3秒持续时间
                    1,      // II级 (amplifier=1)
                    true,   // ambient=true → HUD图标变淡，不显示倒计时
                    false   // ⚠️ showParticles=false → 关闭粒子特效！
            ));
        }
    }
}