package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import com.mod.stuffymod.registry.Items.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
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

    public static final DeferredItem<Item> SICKLE_FLINT_ITEM = ITEMS.register("sickle_flint",
                    () -> new SickleFlintItem(new Item.Properties().durability(32).stacksTo(1)));

    public static final DeferredItem<Item> DIGGING_STICK_ITEM = ITEMS.register("digging_stick",
            () -> new DiggingStickItem(new Item.Properties().durability(24).stacksTo(1)));

    public static final DeferredItem<Item> FLINT_PICKAXE_ITEM = ITEMS.register("flint_pickaxe",
            () -> new FlintPickaxeItem(new Item.Properties().durability(48).stacksTo(1)));

    public static final DeferredItem<Item> BAG_ITEM = ITEMS.register("bag_item",
            () -> new BagItem(new Item.Properties()));


    public static void register() {

    }
}
