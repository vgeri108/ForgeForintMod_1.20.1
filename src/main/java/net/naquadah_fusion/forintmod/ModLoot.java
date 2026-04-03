package net.naquadah_fusion.forintmod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import net.naquadah_fusion.forintmod.item.ModItems;

import java.util.*;
@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = ForintMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModLoot {

    private static final Map<ResourceLocation, LootConfig> LOOT_MAP = new LinkedHashMap<>();

    static {
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/shipwreck_treasure"), new LootConfig(1.0f));
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/desert_pyramid"), new LootConfig(1.0f));

        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/village/village_plains_house"), new LootConfig(1.0f));
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/village/village_desert_house"), new LootConfig(1.0f));
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/village/village_savanna_house"), new LootConfig(1.0f));
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/village/village_taiga_house"), new LootConfig(1.0f));
        LOOT_MAP.put(new ResourceLocation("minecraft", "chests/village/village_snowy_house"), new LootConfig(1.0f));
    }

    private record LootConfig(float multiplier) {}

    private static final List<CoinSpec> COIN_SPECS = List.of(
            new CoinSpec(ModItems.Forint1, 10, 1, 8),
            new CoinSpec(ModItems.Forint2, 10, 1, 6),
            new CoinSpec(ModItems.Forint5, 15, 1, 5),
            new CoinSpec(ModItems.Forint10, 15, 1, 4),
            new CoinSpec(ModItems.Forint20, 10, 1, 3),
            new CoinSpec(ModItems.Forint50, 8, 1, 3),
            new CoinSpec(ModItems.Forint100, 5, 1, 2),
            new CoinSpec(ModItems.Forint200, 3, 1, 1),

            new CoinSpec(ModItems.Forint5F, 1, 1, 1),
            new CoinSpec(ModItems.Forint5O, 1, 1, 1),
            new CoinSpec(ModItems.Forint5R, 1, 1, 1),
            new CoinSpec(ModItems.Forint5I, 1, 1, 1),
            new CoinSpec(ModItems.Forint5N, 1, 1, 1),
            new CoinSpec(ModItems.Forint5T, 1, 1, 1)
    );

    private static final class CoinSpec {
        final RegistryObject<Item> itemRO;
        final int weight;
        final int minCount;
        final int maxCount;

        CoinSpec(RegistryObject<Item> itemRO, int weight, int minCount, int maxCount) {
            this.itemRO = itemRO;
            this.weight = weight;
            this.minCount = minCount;
            this.maxCount = maxCount;
        }
    }

    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation id = event.getName();
        LootConfig cfg = LOOT_MAP.get(id);
        if (cfg == null) return;

        try {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(UniformGenerator.between(0.0F, 2.0F))
                    .name(ForintMod.MOD_ID + ":forint_coins_pool");

            for (CoinSpec spec : COIN_SPECS) {
                Item coinItem = spec.itemRO.get();
                int scaledWeight = Math.max(1, Math.round(spec.weight * cfg.multiplier()));
                poolBuilder.add(LootItem.lootTableItem(coinItem)
                        .setWeight(scaledWeight)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(spec.minCount, spec.maxCount))));
            }
            event.getTable().addPool(poolBuilder.build());
            ForintMod.LOGGER.info("Appended Forint coin pool to {} ({} coin entries)", id, COIN_SPECS.size());
        } catch (Exception ex) {
            ForintMod.LOGGER.error("Failed to add Forint coins to loot table {}", id, ex);
        }
    }
}
