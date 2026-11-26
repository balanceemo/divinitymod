package com.geamnect.divinitymod.item;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ModArmorSetEffects {

    // 记录每个玩家上一 tick 是否穿着终焉套，用于检测"脱下瞬间"
    private static final Map<UUID, Boolean> TERMINUS_WORN = new HashMap<>();

    // 效果持续 tick 数（略大于 1 tick 刷新间隔，避免闪烁）
    private static final int EFFECT_DURATION = 60;

    public static void register() {
        ServerTickEvents.END_SERVER_TICK.register(ModArmorSetEffects::tick);
    }

    private static void tick(MinecraftServer server) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            if (player.isRemoved()) continue;

            boolean stellar  = ModArmorItem.isFullSet(player, "stellar_core");
            boolean voidSet  = ModArmorItem.isFullSet(player, "void");
            boolean terminus = ModArmorItem.isFullSet(player, "terminus");

            // 三级套装效果可叠加（穿终焉套时同时享受陨星、虚空的基础加成）
            if (stellar)  applyStellarCoreBonus(player);
            if (voidSet)  applyVoidBonus(player);
            if (terminus) applyTerminusBonus(player);

            applyFlight(player, terminus);

            // 脱下终焉套的瞬间给缓降，防止高空换装摔死
            boolean wasWorn = TERMINUS_WORN.getOrDefault(player.getUuid(), false);
            if (wasWorn && !terminus) {
                applySlowFallOnRemove(player);
            }
            TERMINUS_WORN.put(player.getUuid(), terminus);
        }
    }

    /**
     * 刷新状态效果：amplifier 从 0 开始（0 = I 级，1 = II 级，2 = III 级）
     */
    private static void keep(PlayerEntity player, RegistryEntry<StatusEffect> effect, int amplifier) {
        player.addStatusEffect(new StatusEffectInstance(effect, EFFECT_DURATION, amplifier, false, false));
    }

    // ==================== 低级：陨星套（×2）====================
    // 夜视 I + 生命回复 I + 急迫 I
    private static void applyStellarCoreBonus(PlayerEntity player) {
        keep(player, StatusEffects.NIGHT_VISION, 0);
        keep(player, StatusEffects.REGENERATION, 0);
        keep(player, StatusEffects.HASTE, 0);
    }

    // ==================== 中级：虚空套（×3）====================
    // 夜视 I + 生命回复 II + 抗性提升 I + 急迫 II
    private static void applyVoidBonus(PlayerEntity player) {
        keep(player, StatusEffects.NIGHT_VISION, 0);
        keep(player, StatusEffects.REGENERATION, 1);
        keep(player, StatusEffects.RESISTANCE, 0);
        keep(player, StatusEffects.HASTE, 1);
    }

    // ==================== 终极：终焉套（×6）====================
    // 夜视 I + 抗性提升 II + 生命回复 III + 饱和 II + 速度 II + 急迫 III
    private static void applyTerminusBonus(PlayerEntity player) {
        keep(player, StatusEffects.NIGHT_VISION, 0);
        keep(player, StatusEffects.RESISTANCE, 1);
        keep(player, StatusEffects.REGENERATION, 2);
        keep(player, StatusEffects.SATURATION, 1);
        keep(player, StatusEffects.SPEED, 1);
        keep(player, StatusEffects.HASTE, 2);
    }

    /**
     * 脱下终焉套时触发：如果玩家正在下落，给 5 秒缓降。
     */
    private static void applySlowFallOnRemove(PlayerEntity player) {
        if (player.getVelocity().y < -0.1) {
            player.addStatusEffect(new StatusEffectInstance(
                    StatusEffects.SLOW_FALLING, 100, 0, false, true
            ));
        }
    }

    private static void applyFlight(ServerPlayerEntity player, boolean enabled) {
        var abilities = player.getAbilities();
        // 创造/旁观模式不干预
        if (abilities.creativeMode || player.isSpectator()) return;

        if (enabled) {
            abilities.allowFlying = true;
            player.sendAbilitiesUpdate();
        } else {
            // 只在确实被我们改过的情况下才关闭，避免覆盖其他模组的飞行权限
            if (abilities.allowFlying) {
                abilities.allowFlying = false;
                abilities.flying = false;
                player.sendAbilitiesUpdate();
            }
        }
    }
}