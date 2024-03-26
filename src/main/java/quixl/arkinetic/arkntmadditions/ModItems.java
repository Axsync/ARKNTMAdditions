package quixl.arkinetic.arkntmadditions;

import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.*;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.IModBusEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.tardis.mod.constants.TardisConstants;
import net.tardis.mod.itemgroups.TItemGroups;
import net.tardis.mod.items.ArtronCapacitorItem;
import net.tardis.mod.items.ArtronItemStackBatteryItem;
import net.tardis.mod.items.TardisPartItem;
import net.tardis.mod.properties.Prop;

import java.util.concurrent.Callable;
import java.util.function.Supplier;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ARKNTMAdditions.MOD_ID);

    public static final RegistryObject<Item> ENGINE_BOOSTER_UPGRADE = ITEMS.register("upgrades/engine_booster", () -> createItem(new TardisPartItem(new Item.Properties().tab(ModItemGroups.MAIN), TardisConstants.Part.PartType.UPGRADE, false, false, TardisConstants.Translations.DEMAT_CIRCUIT)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static <T extends Item> T createItem(T item) {
        return item;
    }

    public static <T extends BlockItem> T createBlockItem(T item) {
        return item;
    }

}