package net.examplemod.fabric;

import net.examplemod.Registrar;
import net.examplemod.RegistryEntry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

@Registrar(element = Item.class, modid = "fabric_test_mod")
public class ModItems {

    @RegistryEntry("test_item")
    public static Item TEST_ITEM = new Item(new FabricItemSettings().tab(CreativeModeTab.TAB_MISC));
}
