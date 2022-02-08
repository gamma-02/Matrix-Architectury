package net.examplemod.fabric;

import net.examplemod.PlatformSpecificMatrix;
import net.examplemod.Registrar;
import net.examplemod.RegistryEntry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MatrixImpl {
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void register(Class<?> clazz, Registry<?> registry) {
        Registrar registrar = clazz.getAnnotation(Registrar.class);
        if (registrar == null) {
            return;
        }

        String modid = registrar.modid();
        Class<?> element = registrar.element();

        Arrays.stream(clazz.getFields())
                .filter(field -> field.isAnnotationPresent(RegistryEntry.class)
                        && Modifier.isPublic(field.getModifiers())
                        && Modifier.isStatic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())
                        && element.isAssignableFrom(field.getType())
                )
                .forEach(field -> {
                    try {
                        Object value = field.get(null);
                        Registry.register((Registry) registry, new ResourceLocation(modid, field.getAnnotation(RegistryEntry.class).value()), element.cast(value));
                        if (value instanceof BlockItem) {
                            Item.BY_BLOCK.put(((BlockItem) value).getBlock(), (Item) value);
                        }
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    }
                });
    }
    public static PlatformSpecificMatrix getMatrix(){
        return new FabricSpecificMatrix();
    }

}
