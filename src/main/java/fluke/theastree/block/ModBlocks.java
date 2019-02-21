package fluke.theastree.block;

import fluke.theastree.TheasTree;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(TheasTree.MODID)
@Mod.EventBusSubscriber(modid = TheasTree.MODID)
public class ModBlocks 
{
	
	@GameRegistry.ObjectHolder(BlockDreamwoodBark.REG_NAME)
    public static BlockDreamwoodBark dwBark;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodRoot.REG_NAME)
    public static BlockDreamwoodRoot dwRoot;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodLog.REG_NAME)
    public static BlockDreamwoodLog dwLog;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodLeaves.REG_NAME)
    public static BlockDreamwoodLeaves dwLeaves;
	
	@GameRegistry.ObjectHolder(BlockHeartWood.REG_NAME)
    public static BlockHeartWood heartwood;
	
	@GameRegistry.ObjectHolder(BlockSapWood.REG_NAME)
    public static BlockSapWood sapwood;
	
	@GameRegistry.ObjectHolder(BlockBurlWood.REG_NAME)
    public static BlockBurlWood burlwood;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		IForgeRegistry<Block> reggy = event.getRegistry();
		reggy.register(new BlockDreamwoodBark());
		reggy.register(new BlockDreamwoodRoot());
		reggy.register(new BlockDreamwoodLog());
		reggy.register(new BlockDreamwoodLeaves());
		reggy.register(new BlockHeartWood());
		reggy.register(new BlockSapWood());
		reggy.register(new BlockBurlWood());
	}
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		IForgeRegistry<Item> reggy = event.getRegistry();
		reggy.register(new ItemBlock(ModBlocks.dwBark).setRegistryName(ModBlocks.dwBark.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwRoot).setRegistryName(ModBlocks.dwRoot.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwLog).setRegistryName(ModBlocks.dwLog.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwLeaves).setRegistryName(ModBlocks.dwLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.heartwood).setRegistryName(ModBlocks.heartwood.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.sapwood).setRegistryName(ModBlocks.sapwood.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.burlwood).setRegistryName(ModBlocks.burlwood.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() 
	{
		dwBark.initModel();
		dwRoot.initModel();
		dwLog.initModel();
		dwLeaves.initModel();
		heartwood.initModel();
		sapwood.initModel();
		burlwood.initModel();
	}

}