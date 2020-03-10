package com.github.officialgoat.learnmod.init;

import com.github.officialgoat.learnmod.Constants;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.function.Supplier;

public class ModItemGroups
{
    public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(Constants.MODID, () -> new ItemStack(ModItems.EXAMPLE_ITEM));

    public static class ModItemGroup extends ItemGroup
    {
        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroup(String name, Supplier<ItemStack> iconSupplier)
        {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon()
        {
            return iconSupplier.get();
        }

    }
}
