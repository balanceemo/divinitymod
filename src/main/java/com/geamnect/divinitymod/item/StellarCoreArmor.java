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

public class StellarCoreArmor extends ArmorItem {

    public StellarCoreArmor(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        // 仅在服务端执行，且必须是玩家
        if (world.isClient() || !(entity instanceof PlayerEntity player)) {
            return;
        }

        // 仅当穿戴在身体槽位时生效（头盔不提供再生）
        if (this.getType() != Type.CHESTPLATE
                && this.getType() != Type.LEGGINGS
                && this.getType() != Type.BOOTS) {
            return;
        }

        // ✅ 核心优化：检查现有效果的剩余时间，避免每 tick 重复添加
        StatusEffectInstance current = player.getStatusEffect(StatusEffects.REGENERATION);
        if (current == null || current.getDuration() <= 20) {
            // duration=40 (2秒), amplifier=0 (I级), ambient=true (隐藏粒子), showParticles=false
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.REGENERATION, 40, 0, true, false
            ));
        }
    }
}