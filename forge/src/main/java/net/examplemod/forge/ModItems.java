package net.examplemod.forge;

import net.examplemod.Registrar;
import net.examplemod.RegistryEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@Registrar(element = Item.class, modid = "examplemod")
public class ModItems {
    @RegistryEntry("test_item")
    public static Item TEST_ITEM = new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC));
    @RegistryEntry("test_block_item")
    public static Item TEST_BLOCK_ITEM = new BlockItem(ModBlocks.TEST_BLOCK, new Item.Properties().tab(CreativeModeTab.TAB_BREWING));
}
