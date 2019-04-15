package fluke.dreamtree.block;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.item.ItemDreamwoodDoor;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@GameRegistry.ObjectHolder(DreamTree.MODID)
@Mod.EventBusSubscriber(modid = DreamTree.MODID)
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
	
	@GameRegistry.ObjectHolder(BlockDreamwoodLeavesFlowering.REG_NAME)
    public static BlockDreamwoodLeavesFlowering dwFloweringLeaves;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodInfestedLeaves.REG_NAME)
    public static BlockDreamwoodInfestedLeaves dwInfestedLeaves;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodBushLeaves.REG_NAME)
    public static BlockDreamwoodBushLeaves dwBushLeaves;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodTorch.REG_NAME)
    public static BlockDreamwoodTorch dwTorch;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodDoor.REG_NAME)
    public static BlockDreamwoodDoor dwDoor;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodTrapdoor.REG_NAME)
    public static BlockDreamwoodTrapdoor dwTrapdoor;
	
	@GameRegistry.ObjectHolder(BlockDreamwoodStairs.REG_NAME)
    public static BlockDreamwoodStairs dwStairs;
	
	@GameRegistry.ObjectHolder(BlockHalfDreamwoodSlab.REG_NAME)
    public static BlockHalfDreamwoodSlab dwSlabHalf;
	
	@GameRegistry.ObjectHolder(BlockDoubleDreamwoodSlab.REG_NAME)
    public static BlockDoubleDreamwoodSlab dwSlabDouble;
	
	@GameRegistry.ObjectHolder(BlockHeartWood.REG_NAME)
    public static BlockHeartWood heartwood;
	
	@GameRegistry.ObjectHolder(BlockSapWood.REG_NAME)
    public static BlockSapWood sapwood;
	
	@GameRegistry.ObjectHolder(BlockBurlWood.REG_NAME)
    public static BlockBurlWood burlwood;
	
	@GameRegistry.ObjectHolder(BlockLightBug.REG_NAME)
    public static BlockLightBug lightbug;
	
	@GameRegistry.ObjectHolder(BlockFireBug.REG_NAME)
    public static BlockFireBug firebug;
	
	@GameRegistry.ObjectHolder(BlockBlueBug.REG_NAME)
    public static BlockBlueBug bluebug;
	
	@GameRegistry.ObjectHolder("dreamfruit")
    public static Item dreamfruit;
	
	public static ItemDreamwoodDoor dreamwooddoor;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) 
	{
		IForgeRegistry<Block> reggy = event.getRegistry();
		reggy.register(new BlockDreamwoodBark());
		reggy.register(new BlockDreamwoodRoot());
		reggy.register(new BlockDreamwoodLog());
		reggy.register(new BlockDreamwoodLeaves());
		reggy.register(new BlockDreamwoodLeavesFlowering());
		reggy.register(new BlockDreamwoodInfestedLeaves());
		reggy.register(new BlockDreamwoodBushLeaves());
		reggy.register(new BlockDreamwoodTorch());
		reggy.register(new BlockDreamwoodDoor());
		reggy.register(new BlockDreamwoodTrapdoor());
		reggy.register(new BlockDreamwoodStairs());
		reggy.register(new BlockHalfDreamwoodSlab());
		reggy.register(new BlockDoubleDreamwoodSlab());
		reggy.register(new BlockHeartWood());
		reggy.register(new BlockSapWood());
		reggy.register(new BlockBurlWood());
		reggy.register(new BlockLightBug());
		reggy.register(new BlockFireBug());
		reggy.register(new BlockBlueBug());
	}
	
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) 
	{
		IForgeRegistry<Item> reggy = event.getRegistry();
		reggy.register(new ItemBlock(ModBlocks.dwBark).setRegistryName(ModBlocks.dwBark.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwRoot).setRegistryName(ModBlocks.dwRoot.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwLog).setRegistryName(ModBlocks.dwLog.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwLeaves).setRegistryName(ModBlocks.dwLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwFloweringLeaves).setRegistryName(ModBlocks.dwFloweringLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwInfestedLeaves).setRegistryName(ModBlocks.dwInfestedLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwBushLeaves).setRegistryName(ModBlocks.dwBushLeaves.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwTorch).setRegistryName(ModBlocks.dwTorch.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwTrapdoor).setRegistryName(ModBlocks.dwTrapdoor.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.dwStairs).setRegistryName(ModBlocks.dwStairs.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.heartwood).setRegistryName(ModBlocks.heartwood.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.sapwood).setRegistryName(ModBlocks.sapwood.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.burlwood).setRegistryName(ModBlocks.burlwood.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.lightbug).setRegistryName(ModBlocks.lightbug.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.firebug).setRegistryName(ModBlocks.firebug.getRegistryName()));
		reggy.register(new ItemBlock(ModBlocks.bluebug).setRegistryName(ModBlocks.bluebug.getRegistryName()));

		reggy.register(new ItemSlab(ModBlocks.dwSlabHalf, ModBlocks.dwSlabHalf, ModBlocks.dwSlabDouble).setRegistryName(ModBlocks.dwSlabHalf.getRegistryName()));
		
		dreamfruit = new ItemFood(2, 0.3F, false).setUnlocalizedName(DreamTree.MODID + ".dreamfruit");
		reggy.register(dreamfruit.setRegistryName("dreamfruit"));
		
		dreamwooddoor = new ItemDreamwoodDoor(ModBlocks.dwDoor);
		reggy.register(dreamwooddoor);
		dwDoor.setItemStack(new ItemStack(dreamwooddoor));
	}
	
	@SideOnly(Side.CLIENT)
    public static void initModels() 
	{
		dwBark.initModel();
		dwRoot.initModel();
		dwLog.initModel();
		dwLeaves.initModel();
		dwFloweringLeaves.initModel();
		dwInfestedLeaves.initModel();
		dwBushLeaves.initModel();
		dwTorch.initModel();
		dwDoor.initModel();
		dwTrapdoor.initModel();
		dwStairs.initModel();
		dwSlabHalf.initModel();
		heartwood.initModel();
		sapwood.initModel();
		burlwood.initModel();
		lightbug.initModel();
		firebug.initModel();
		bluebug.initModel();
		
		dreamwooddoor.initModel();
		
		//lazy
	    ModelLoader.setCustomModelResourceLocation(dreamfruit, 0, new ModelResourceLocation(dreamfruit.getRegistryName(), "inventory"));

	}

}
