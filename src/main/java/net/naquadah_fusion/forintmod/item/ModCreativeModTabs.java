package net.naquadah_fusion.forintmod.item;

import net.naquadah_fusion.forintmod.ForintMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ForintMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FORINT_TAB = CREATIVE_MODE_TABS.register("forint",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.Forint100.get()))
                    .title(Component.translatable("creativetab.forints_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.Forint1.get());
                        pOutput.accept(ModItems.Forint2.get());
                        pOutput.accept(ModItems.Forint5.get());
                        pOutput.accept(ModItems.Forint10.get());
                        pOutput.accept(ModItems.Forint20.get());
                        pOutput.accept(ModItems.Forint50.get());
                        pOutput.accept(ModItems.Forint100.get());
                        pOutput.accept(ModItems.Forint200.get());
                        pOutput.accept(ModItems.Forint500.get());
                        pOutput.accept(ModItems.Forint1000.get());
                        pOutput.accept(ModItems.Forint2000.get());
                        pOutput.accept(ModItems.Forint5000.get());
                        pOutput.accept(ModItems.Forint10000.get());
                        pOutput.accept(ModItems.Forint20000.get());
                        pOutput.accept(ModItems.Forint5F.get());
                        pOutput.accept(ModItems.Forint5O.get());
                        pOutput.accept(ModItems.Forint5R.get());
                        pOutput.accept(ModItems.Forint5I.get());
                        pOutput.accept(ModItems.Forint5N.get());
                        pOutput.accept(ModItems.Forint5T.get());
                        pOutput.accept(ModItems.Forint200Old.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
