package quixl.arkinetic.arkntmadditions.Hook;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.api.events.TardisEvent;
import quixl.arkinetic.arkntmadditions.ARKNTMAdditions;

@Mod.EventBusSubscriber(modid = ARKNTMAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class onTakeOff {
    @SubscribeEvent
    public static void onTakeOff(TardisEvent.Takeoff event) {
        /* TBC */
    }
}
