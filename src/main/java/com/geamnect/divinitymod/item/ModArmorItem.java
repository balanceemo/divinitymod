package com.geamnect.divinitymod.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;

public class ModArmorItem extends ArmorItem {

    private final String armorSetId;

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings, String armorSetId) {
        super(material, type, settings);
        this.armorSetId = armorSetId;
    }

    public String getArmorSetId() {
        return armorSetId;
    }

    public static boolean belongsTo(ItemStack stack, String setId) {
        return stack.getItem() instanceof ModArmorItem armor && armor.getArmorSetId().equals(setId);
    }

    public static boolean isFullSet(LivingEntity entity, String setId) {
        return belongsTo(entity.getEquippedStack(EquipmentSlot.HEAD), setId)
                && belongsTo(entity.getEquippedStack(EquipmentSlot.CHEST), setId)
                && belongsTo(entity.getEquippedStack(EquipmentSlot.LEGS), setId)
                && belongsTo(entity.getEquippedStack(EquipmentSlot.FEET), setId);
    }
}