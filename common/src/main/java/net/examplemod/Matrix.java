package net.examplemod;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Registry;


public class Matrix {
    @ExpectPlatform
    public static void register(Class<?> clazz, Registry<?> registry) {

    }
    @ExpectPlatform
    public static PlatformSpecificMatrix getMatrix(){
        throw new AssertionError();
    }





}
