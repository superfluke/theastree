package fluke.dreamtree.config;

import fluke.dreamtree.DreamTree;
import fluke.dreamtree.block.BlockDreamwoodBushLeaves;
import fluke.dreamtree.block.BlockDreamwoodInfestedLeaves;
import fluke.dreamtree.block.BlockSapWood;
import fluke.dreamtree.util.BlockUtil;
import fluke.dreamtree.util.WeightedList;
import fluke.dreamtree.world.BiomeAncientGarden;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
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
	public static WeightedList<IBlockState> weightedSapBlockList;
	@Ignore
	public static WeightedList<IBlockState> weightedBushBlockList;
	@Ignore
	public static WeightedList<ItemStack> weightedInfestedDrops;

	public static class ConfigGeneral
	{
		@Config.Comment({ "If dreamwood leaves can naturally decay", "Default: false" })
		@Config.RequiresMcRestart
		public boolean doLeavesDecay = false;

		@Config.Comment({ "Infested leaves regeneration speed. Average regen in N mins.", "Default: 5" })
		public int infestationSpeed = 5;

		@Config.Comment({ "Sap drop speed. Average time of N mins before sap wood produces fluid sap.", "Default: 5" })
		public int sapProductionSpeed = 5;

		@Config.Comment({ "Bush growth speed. Average time of N mins before bushes regrow.", "Default: 5" })
		public int bushGrowthSpeed = 5;

		@Config.Comment({ "Weighted list of blocks that may spawn under sap wood. Format is: [weight]-modid:blockname:meta" })
		public String[] sapBlockList = { "15-minecraft:flowing_water", "10-minecraft:log", "5-minecraft:flowing_lava" };

		@Config.Comment({ "Weighted list of blocks that may spawn under bush producing leaves. Format is: [weight]-modid:blockname:meta" })
		public String[] bushBlockList = { "15-minecraft:deadbush", "10-minecraft:tallgrass:2", "5-minecraft:cactus" };

		@Config.Comment({ "Weighted list of items that may drop from infested leaves. Format is: [weight]-modid:blockname:meta" })
		public String[] infestedDropList = { "15-dreamtree:lightbug", "10-dreamtree:firebug", "5-dreamtree:bluebug" };

		@Config.Comment({ "Valid tools for harvesting infested leaves" })
		public String[] infestedHarvestingTools = { "minecraft:stick", "minecraft:carrot_on_a_stick" };
	}

	public static class ConfigDreamTreeWorld
	{
		@Config.Comment({ "Grass color in Acient Garden biome", "Default: 3CC619" })
		public String grassColor = "3CC619";

		@Config.Comment({ "Foliage color in Acient Garden biome", "Default: 23A003" })
		public String foliageColor = "23A003";

		@Config.Comment({ "Sky color in Acient Garden biome", "Default: FFA500" })
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
				updateConfigs();
			}
		}
	}

	public static void updateConfigs()
	{
		BiomeAncientGarden.updateBiomeConfigs();
		BlockSapWood.setSapBlockConfigs();
		BlockDreamwoodBushLeaves.setBushBlockConfigs();
		BlockDreamwoodInfestedLeaves.updateToolList();
		updateWeightedLists();
	}

	public static void updateWeightedLists()
	{
		weightedSapBlockList = new WeightedList<IBlockState>();
		for (String s : Configs.general.sapBlockList)
		{
			if (seemsValidDude(s))
			{
				String[] splitty = s.split("-");
				weightedSapBlockList.add(BlockUtil.getStateFromString(splitty[1].trim()), Integer.parseInt(splitty[0]));
			} else
			{
				DreamTree.logger.error("Error parsing string \"" + s + "\" for sap block config.");
			}
		}

		weightedBushBlockList = new WeightedList<IBlockState>();
		for (String s : Configs.general.bushBlockList)
		{
			if (seemsValidDude(s))
			{
				String[] splitty = s.split("-");
				weightedBushBlockList.add(BlockUtil.getStateFromString(splitty[1].trim()), Integer.parseInt(splitty[0]));
			} else
			{
				DreamTree.logger.error("Error parsing string \"" + s + "\" for bush block config.");
			}
		}

		weightedInfestedDrops = new WeightedList<ItemStack>();
		for (String s : Configs.general.infestedDropList)
		{
			if (seemsValidDude(s))
			{

				String[] splitty = s.split("-");
				weightedInfestedDrops.add(BlockUtil.getItemStackFromString(splitty[1].trim()), Integer.parseInt(splitty[0]));
			} else
			{
				DreamTree.logger.error("Error parsing string \"" + s + "\" for infested drop config.");
			}
		}
	}

	public static boolean seemsValidDude(String s)
	{
		if (s == null || s.trim().isEmpty())
			return false;
		if (s.split("-").length < 2)
			return false;
		return true;
	}
}
