package net.examplemod.forge;

import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/**
 * @author gamma_02 <br>
 *
 * Asynchronously sets the registered objects to their non-RegistryObject form. Required for RegistryObjects to act like
 * {@code Registry.register(...)}.
 * @see ForgeSpecificMatrix
 *
 */
public class RegistryThread<T extends IForgeRegistryEntry<T>> extends Thread{
    private final List<Field> toRegister;
    private final HashMap<Field, RegistryObject<T>> registryObjects;

    public RegistryThread(List<Field> toRegister, HashMap<Field, RegistryObject<T>> registryObjects){
        this.toRegister = toRegister;
        this.registryObjects = registryObjects;
    }

    public void run(){
        while(!canReplaceFeilds()){
            try {
                wait(100);
            } catch (InterruptedException e) {
                System.out.println(e.getLocalizedMessage());
            }
        }
        for (Field field : this.toRegister) {
            try {
                field.set(field.get(null), this.registryObjects.get(field).get());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        this.stop();
    }

    private boolean canReplaceFeilds(){
        boolean[] returnVal = {true};
        this.registryObjects.values().forEach(tRegistryObject -> {
            if(!tRegistryObject.isPresent()){
                returnVal[0] = false;
            }

        });
        return returnVal[0];
    }


}
