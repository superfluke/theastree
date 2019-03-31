package fluke.dreamtree.config;

import fluke.dreamtree.DreamTree;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;

@Config(modid = DreamTree.MODID, category = "")
@Mod.EventBusSubscriber(modid = DreamTree.MODID)
public class Configs
{
	
	public static ConfigGeneral general = new ConfigGeneral();
	
	public static class ConfigGeneral
	{
		@Config.Comment({"If dreamwood leaves can naturally decay", "Default: false"})
		@Config.RequiresWorldRestart
		public boolean doLeavesDecay = false;
		
		@Config.Comment({"Infested leaves regeneration speed. Average regen in N mins.", "Default: 5"})
		@Config.RequiresWorldRestart
		public int infestationSpeed = 5;
		
		@Config.Comment({"Sap drop speed. Average time of N mins before sap wood produces fluid sap.", "Default: 5"})
		@Config.RequiresWorldRestart
		public int sapProductionSpeed = 5;
		
		@Config.Comment({"Bush growth speed. Average time of N mins before bushes regrow.", "Default: 5"})
		@Config.RequiresWorldRestart
		public int bushGrowthSpeed = 5;
		
		@Config.Comment({"Bush block to grow.", "Default: minecraft:deadbush"})
		@Config.RequiresWorldRestart
		public String bushBlock = "minecraft:deadbush";
		
		@Config.Comment({"Grass color", "Default: 3CC619"})
		@Config.RequiresWorldRestart
		public String grassColor = "3CC619";
		
		@Config.Comment({"Foliage color", "Default: 23A003"})
		@Config.RequiresWorldRestart
		public String foliageColor = "23A003";
	}

}
