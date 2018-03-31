package net.dries007.tfc.objects;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

import static net.dries007.tfc.Constants.MOD_ID;

public final class CreativeTab
{
    private static final List<CT> LIST = new ArrayList<>();

    public static final CreativeTabs CT_MISC = new CT("misc", "tfc:wand");

    public static void init()
    {
        LIST.forEach(CT::loadIconStack);
    }

    private static class CT extends CreativeTabs
    {
        private final ResourceLocation iconResourceLocation;
        private ItemStack iconStack;

        private CT(String label, String icon)
        {
            super(MOD_ID + "." + label);

            iconResourceLocation = new ResourceLocation(icon);

            LIST.add(this);
        }

        @Override
        public ItemStack getTabIconItem()
        {
            return iconStack;
        }

        private void loadIconStack()
        {
            //noinspection ConstantConditions
            iconStack = new ItemStack(ForgeRegistries.ITEMS.getValue(iconResourceLocation));
            if (iconStack.isEmpty()) throw new RuntimeException("No icon stack for creative tab " + iconResourceLocation);
        }
    }
}