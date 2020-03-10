package com.github.officialgoat.learnmod;

import com.github.officialgoat.learnmod.init.ModBlocks;
import com.github.officialgoat.learnmod.init.ModItemGroups;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistryEntry;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEventSubscriber
{
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(
                setup(new Item(new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP)), "example_item")
        );

        final Item.Properties properties = new Item.Properties().group(ModItemGroups.MOD_ITEM_GROUP);

        final BlockItem blockItem = new BlockItem(ModBlocks.EXAMPLE_ORE, properties);

        event.getRegistry().register(setup(blockItem, "example_ore"));
    }

    @SubscribeEvent
    public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(
                setup(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.0F, 3.0F)), "example_ore")
        );
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final String name)
    {
        return setup(entry, new ResourceLocation(Constants.MODID, name));
    }

    public static <T extends IForgeRegistryEntry<T>> T setup(final T entry, final ResourceLocation registryName)
    {
        entry.setRegistryName(registryName);
        return entry;
    }
}
