package fluke.dreamtree.block;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictRegistrar
{
	
	public static void RegisterOreDicts()
	{
		OreDictionary.registerOre("bug", ModBlocks.bluebug);
		OreDictionary.registerOre("bug", ModBlocks.firebug);
		OreDictionary.registerOre("bug", ModBlocks.lightbug);
		
		OreDictionary.registerOre("logWood", ModBlocks.dwLog);
		OreDictionary.registerOre("torch", ModBlocks.dwTorch);
		OreDictionary.registerOre("doorWood", ModBlocks.dreamwooddoor);
		OreDictionary.registerOre("treeLeaves", ModBlocks.dwLeaves);
	}

}
