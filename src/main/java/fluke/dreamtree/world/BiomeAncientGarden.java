package fluke.dreamtree.world;

import fluke.dreamtree.config.Configs;
import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;

public class BiomeAncientGarden extends Biome
{
	//TODO spawnlist for mobs?
	public static BiomeProperties properties = new BiomeProperties("Ancient Garden");
	public static int grassColor;
	public static int foliageColor;
	
	static
	{
		properties.setTemperature(Biomes.JUNGLE.getDefaultTemperature());
		properties.setRainfall(Biomes.PLAINS.getRainfall());
	}

	public BiomeAncientGarden()
	{
		super(properties);
		updateBiomeConfigs();
	}
	
	public static void updateBiomeConfigs()
	{
		grassColor = colorFromText(Configs.general.grassColor);
		foliageColor = colorFromText(Configs.general.foliageColor);	
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) 
	{
		return super.getModdedBiomeGrassColor(grassColor);
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) 
	{
		return super.getModdedBiomeFoliageColor(foliageColor);
	}
	
	public static int colorFromText(String text)
	{
		text = "FF" + text;
		return (int)Long.parseLong(text, 16);
	}

}
