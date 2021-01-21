package xyz.brassgoggledcoders.armorexpansions;

import com.hrznstudio.titanium.tab.TitaniumTab;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.brassgoggledcoders.armorexpansions.api.AREXAPI;
import xyz.brassgoggledcoders.armorexpansions.content.AREXBlocks;
import xyz.brassgoggledcoders.armorexpansions.content.AREXItems;


@Mod(ArmorExpansions.MOD_ID)
public class ArmorExpansions {
    public final static String MOD_ID = "armorexpansions";
    public final static String NAME = "ArmorExpansions";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup ITEM_GROUP = new TitaniumTab(MOD_ID,
            () -> new ItemStack(Items.IRON_CHESTPLATE));

    public ArmorExpansions() {
        super();
        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        AREXBlocks.register(modBus);
        AREXItems.register(modBus);
        //AREXAPI.registerCaps(); TODO
    }


}
