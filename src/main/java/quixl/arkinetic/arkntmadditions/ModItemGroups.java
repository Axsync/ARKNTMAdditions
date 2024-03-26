package quixl.arkinetic.arkntmadditions;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {
    public static ItemGroup MAIN = new ItemGroup(ARKNTMAdditions.MOD_ID + ".main") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ENGINE_BOOSTER_UPGRADE.get());
        }

        public ItemStack createIcon() {
            return new ItemStack(ModItems.ENGINE_BOOSTER_UPGRADE.get());
        }
    };
}