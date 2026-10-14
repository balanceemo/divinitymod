package com.geamnect.divinitymod;

import com.geamnect.divinitymod.block.ModBlocks;
import com.geamnect.divinitymod.item.ModArmorMaterials;
import com.geamnect.divinitymod.item.ModItemGroups;
import com.geamnect.divinitymod.item.ModItems;
import com.geamnect.divinitymod.item.ModToolMaterials;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DivinityMod implements ModInitializer {
	public static final String MOD_ID = "divinitymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID); // ✅ 修复：使用自己的 MOD_ID

	@Override
	public void onInitialize() {
		// ✅ 正确的注册顺序：材质 → 方块/物品 → 标签页
		ModArmorMaterials.register();   // 护甲材质必须在护甲物品之前
		ModToolMaterials.register();    // 工具材质必须在工具物品之前
		ModBlocks.registerModBlocks();     // 方块通常需要在物品之前（因为方块物品依赖方块）
		ModItems.registerModItems();       // 注册所有物品

		ModItemGroups.registerGroups();         // 注册自定义标签页
		ModItemGroups.registerItemGroupEntries(); // 将物品添加到标签页

		LOGGER.info("Divinity Mod initialized!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}