package net.examplemod.fabric;

import net.examplemod.ExampleMod;
import net.examplemod.Matrix;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExampleMod.init();
        //Matrix code after that!
        Matrix.register(ModItems.class, Registry.ITEM);

    }
}
