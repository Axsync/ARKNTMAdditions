package quixl.arkinetic.arkntmadditions.FlightEvents;

import com.google.common.collect.Lists;
import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.CrashType;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.IAlarmType;

import java.util.ArrayList;
import java.util.function.Supplier;

import java.util.ArrayList;
import java.util.List;

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
        tile.setArtron(tile.getArtron() / 2);
        tile.getInteriorManager().setLight(0);
        tile.getInteriorManager().setAlarmOn(true);

    }

}
