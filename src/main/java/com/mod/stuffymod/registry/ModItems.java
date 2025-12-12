package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import com.mod.stuffymod.registry.Items.SomePickaxeItem;
import com.mod.stuffymod.registry.Items.SickleFlintItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(StuffyMod.MODID);

    public static final DeferredItem<Item> EXAMPLE_ITEM =
            ITEMS.registerSimpleItem("example_item",
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(1)
                                    .saturationModifier(2f)
                                    .alwaysEdible()
                                    .build()
                    )
            );

    public static final DeferredItem<Item> SomePickaxeItem =
            ITEMS.register("some_pickaxe", SomePickaxeItem::new);

    public static final DeferredItem<Item> SickleFlintItem = ITEMS.register("sickle_flint",
                    () -> new SickleFlintItem(new Item.Properties().durability(32).stacksTo(1)));

    public static void register() {

    }
}
