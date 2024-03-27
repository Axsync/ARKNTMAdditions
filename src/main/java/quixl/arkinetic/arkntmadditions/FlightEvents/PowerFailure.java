package quixl.arkinetic.arkntmadditions.FlightEvents;

import com.google.common.collect.Lists;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PowerFailure extends FlightEvent {

    public PowerFailure(FlightEventFactory entry, List<ResourceLocation> controls) {
        super(entry, controls);
    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.REFUELER.get().getRegistryName()
    );

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.getLevel().playSound(null, tile.getBlockPos(), RegSoundEvents.POWER_DOWN.get(), SoundCategory.PLAYERS, 3F, 1F);
        tile.setArtron(tile.getArtron() / 2);
        tile.getInteriorManager().setLight(0);
        tile.getInteriorManager().setAlarmOn(true);

    }

}
