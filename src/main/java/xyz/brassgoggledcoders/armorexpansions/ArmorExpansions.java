package xyz.brassgoggledcoders.armorexpansions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import xyz.brassgoggledcoders.armorexpansions.blocks.BlockExtensionEditor;
import xyz.brassgoggledcoders.armorexpansions.proxies.CommonProxy;
import xyz.brassgoggledcoders.boilerplate.BaseCreativeTab;
import xyz.brassgoggledcoders.boilerplate.BoilerplateModBase;

@Mod(modid = ArmorExpansions.ID, name = ArmorExpansions.NAME, version = ArmorExpansions.VERSION,
		dependencies = ArmorExpansions.DEPENDENCIES)
public class ArmorExpansions extends BoilerplateModBase {
	public final static String ID = "armourexpansions";
	public final static String NAME = "ArmourExpansions";
	public final static String VERSION = "@VERSION@";
	public final static String DEPENDENCIES = "required-after:boilerplate";

	@SidedProxy(clientSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ClientProxy",
			serverSide = "xyz.brassgoggledcoders.armorexpansions.proxies.ServerProxy")
	public static CommonProxy proxy;

	@Instance(ArmorExpansions.ID)
	public static ArmorExpansions instance;

	public static Block extensionEditor;

	public static CreativeTabs tab = new AREXTab();

	public ArmorExpansions() {
		super(ArmorExpansions.ID, ArmorExpansions.NAME, ArmorExpansions.VERSION, tab);
	}

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		extensionEditor = new BlockExtensionEditor(Material.IRON, "extension_editor");
		this.getRegistryHolder().getBlockRegistry().registerBlock(extensionEditor);

		CapabilityHandler.init();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@Override
	public Object getInstance() {
		return instance;
	}

	public static class AREXTab extends BaseCreativeTab {
		public AREXTab() {
			super(ID);
		}

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(extensionEditor);
		}
	}
}
