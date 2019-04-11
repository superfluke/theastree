package fluke.dreamtree.config;

import java.util.Arrays;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.block.BlockDreamwoodBushLeaves;
import fluke.dreamtree.block.BlockSapWood;
import fluke.dreamtree.util.BlockUtil;
import fluke.dreamtree.util.WeightedList;
import fluke.dreamtree.world.BiomeAncientGarden;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Ignore;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = DreamTree.MODID, category = "")
@Mod.EventBusSubscriber(modid = DreamTree.MODID)
public class Configs
{
	public static ConfigGeneral general = new ConfigGeneral();
	public static ConfigDreamTreeWorld dreamTreeWorld = new ConfigDreamTreeWorld();
	
	@Ignore
	public static WeightedList weightedSapBlockList;
	@Ignore
	public static WeightedList weightedBushBlockList;
	
	public static class ConfigGeneral
	{
		@Config.Comment({"If dreamwood leaves can naturally decay", "Default: false"})
		@Config.RequiresMcRestart
		public boolean doLeavesDecay = false;
		
		@Config.Comment({"Infested leaves regeneration speed. Average regen in N mins.", "Default: 5"})
		public int infestationSpeed = 5;
		
		@Config.Comment({"Sap drop speed. Average time of N mins before sap wood produces fluid sap.", "Default: 5"})
		public int sapProductionSpeed = 5;
		
		@Config.Comment({"Bush growth speed. Average time of N mins before bushes regrow.", "Default: 5"})
		public int bushGrowthSpeed = 5;
		
		@Config.Comment({"Weighted list of blocks that may spawn under sap wood. Format is: [weight]-modid:blockname:meta"})
		public String[] sapBlockList = { "15-minecraft:flowing_water", "10-minecraft:log", "5-minecraft:flowing_lava" };
		
		@Config.Comment({"Weighted list of blocks that may spawn under bush producing leaves. Format is: [weight]-modid:blockname:meta"})
		public String[] bushBlockList = { "15-minecraft:deadbush", "10-minecraft:tallgrass:2", "5-minecraft:cactus" };
	}
	
	public static class ConfigDreamTreeWorld
	{
		@Config.Comment({"Grass color in Acient Garden biome", "Default: 3CC619"})
		public String grassColor = "3CC619";
		
		@Config.Comment({"Foliage color in Acient Garden biome", "Default: 23A003"})
		public String foliageColor = "23A003";
		
		@Config.Comment({"Sky color in Acient Garden biome", "Default: FFA500"})
		public String skyColor = "FFA500";
	}
	
	@Mod.EventBusSubscriber(modid = DreamTree.MODID)
	private static class ConfigEventHandler 
	{
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent ev) 
		{
			if (ev.getModID().equals(DreamTree.MODID)) 
			{
				ConfigManager.sync(DreamTree.MODID, Config.Type.INSTANCE);
				BiomeAncientGarden.updateBiomeConfigs();
				BlockSapWood.setSapBlockConfigs();
				BlockDreamwoodBushLeaves.setBushBlockConfigs();
				updateWeightedLists();
			}
		}
	}
	
	public static void updateWeightedLists()
	{
		weightedSapBlockList = new WeightedList();
		for(String s : Configs.general.sapBlockList)
		{
			String[] splitty = s.split("-");
			weightedSapBlockList.add(BlockUtil.getStateFromString(splitty[1].trim()), Integer.parseInt(splitty[0]));
		}
		
		weightedBushBlockList = new WeightedList();
		for(String s : Configs.general.bushBlockList)
		{
			String[] splitty = s.split("-");
			weightedBushBlockList.add(BlockUtil.getStateFromString(splitty[1].trim()), Integer.parseInt(splitty[0]));
		}
	}
}
