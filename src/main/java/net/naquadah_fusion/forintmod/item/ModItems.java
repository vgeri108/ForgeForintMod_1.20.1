package net.naquadah_fusion.forintmod.item;

import net.naquadah_fusion.forintmod.ForintMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ForintMod.MOD_ID);

    public static final RegistryObject<Item> Forint1 = ITEMS.register("forint1",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint2 = ITEMS.register("forint2",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5 = ITEMS.register("forint5",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5F = ITEMS.register("forint5f",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5O = ITEMS.register("forint5o",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5R = ITEMS.register("forint5r",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5I = ITEMS.register("forint5i",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5N = ITEMS.register("forint5n",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5T = ITEMS.register("forint5t",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint10 = ITEMS.register("forint10",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint20 = ITEMS.register("forint20",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint50 = ITEMS.register("forint50",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint100 = ITEMS.register("forint100",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint200 = ITEMS.register("forint200",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint200Old = ITEMS.register("forint200old",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint500 = ITEMS.register("forint500",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint1000 = ITEMS.register("forint1000",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint2000 = ITEMS.register("forint2000",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint5000 = ITEMS.register("forint5000",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint10000 = ITEMS.register("forint10000",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Forint20000 = ITEMS.register("forint20000",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
