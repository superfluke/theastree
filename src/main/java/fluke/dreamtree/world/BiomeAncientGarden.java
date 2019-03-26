package fluke.dreamtree.world;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class BiomeAncientGarden extends Biome
{
	//TODO spawnlist for mobs?
	public static BiomeProperties properties = new BiomeProperties("Ancient Garden");
	
	static
	{
		properties.setTemperature(Biomes.JUNGLE.getDefaultTemperature());
		properties.setRainfall(Biomes.PLAINS.getRainfall());
	}

	public BiomeAncientGarden()
	{
		super(properties);
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) 
	{
		return super.getModdedBiomeGrassColor(0xFF3CC619);
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) 
	{
		return super.getModdedBiomeFoliageColor(0xFF23A003);
	}

}
