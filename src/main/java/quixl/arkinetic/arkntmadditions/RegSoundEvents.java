package quixl.arkinetic.arkntmadditions;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import quixl.arkinetic.arkntmadditions.ARKNTMAdditions;

@Mod.EventBusSubscriber(modid = ARKNTMAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegSoundEvents {
    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ARKNTMAdditions.MOD_ID);

    public static final RegistryObject<SoundEvent> ENGINE_BOOST_START = SOUND_EVENTS.register("engine_boost_start",
            () -> new SoundEvent(new ResourceLocation(ARKNTMAdditions.MOD_ID, "engine_boost_start")));

    public static final RegistryObject<SoundEvent> TARDIS_CANT_START = SOUND_EVENTS.register("tardis_cant_start",
            () -> new SoundEvent(new ResourceLocation(ARKNTMAdditions.MOD_ID, "tardis_cant_start")));

    public static final RegistryObject<SoundEvent> POWER_DOWN = SOUND_EVENTS.register("power_down",
            () -> new SoundEvent(new ResourceLocation(ARKNTMAdditions.MOD_ID, "power_down")));
    public static final RegistryObject<SoundEvent> VORTEX_AMBIENT_LOOP = SOUND_EVENTS.register("vortex_ambient_loop",
            () -> new SoundEvent(new ResourceLocation(ARKNTMAdditions.MOD_ID, "vortex_ambient_loop")));



    public static void registerModSoundEvents() {
        SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
