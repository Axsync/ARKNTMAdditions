package quixl.arkinetic.arkntmadditions.Hook;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.api.events.TardisEvent;
import quixl.arkinetic.arkntmadditions.ARKNTMAdditions;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

@Mod.EventBusSubscriber(modid = ARKNTMAdditions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class onLand {
    @SubscribeEvent
    public static void onTardisLand(TardisEvent.Land event) {

        event.getConsole().getLevel().playSound(null, event.getConsole().getBlockPos(), RegSoundEvents.POWER_DOWN.get(), SoundCategory.PLAYERS, 3F, 1F);
    }
}
