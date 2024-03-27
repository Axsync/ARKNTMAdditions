package quixl.arkinetic.arkntmadditions.FlightEvents;

import com.google.common.collect.Lists;
import net.minecraft.client.audio.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.CrashType;
import net.tardis.mod.misc.CrashTypes;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.registries.ProtocolRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.DistressSignal;
import net.tardis.mod.tileentities.console.misc.IAlarmType;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

import java.util.ArrayList;
import java.util.function.Supplier;

import java.util.ArrayList;
import java.util.List;

public class DimensionalBreach extends FlightEvent {

    public DimensionalBreach(FlightEventFactory entry, List < ResourceLocation > controls) {
        super(entry, controls);
    }

    public static final Supplier < ArrayList < ResourceLocation >> CONTROLS = () -> Lists.newArrayList(
            ControlRegistry.THROTTLE.get().getRegistryName(),
            ControlRegistry.DIMENSION.get().getRegistryName()
    );

    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.getLevel().playSound(null, tile.getBlockPos(), RegSoundEvents.TARDIS_CANT_START.get(), SoundCategory.PLAYERS, 1F, 1F);
        tile.crash(CrashTypes.DEFAULT);
        tile.getInteriorManager().setAlarmOn(true);
    }

}