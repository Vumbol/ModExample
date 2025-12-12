package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.*;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StuffyMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB =
            TABS.register("example_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.stuffymod"))
                            .withTabsBefore(CreativeModeTabs.COMBAT)
                            .icon(() -> ModItems.EXAMPLE_ITEM.get().getDefaultInstance())
                            .displayItems((params, output) -> {
                                output.accept(ModItems.EXAMPLE_ITEM.get());
                                output.accept(ModBlocks.EXAMPLE_BLOCK.get());
                                output.accept(ModItems.SomePickaxeItem.get());
                                output.accept(ModItems.SickleFlintItem.get());
                                output.accept(ModBlocks.SMALL_ROCK.get());
                            }).build()
            );

    public static void register() {}
}
