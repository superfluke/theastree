package fluke.dreamtree.world;

import fluke.dreamtree.config.Configs;
import net.minecraft.init.Biomes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeAncientGarden extends Biome
{
	//TODO spawnlist for mobs?
	public static BiomeProperties properties = new BiomeProperties("Ancient Garden");
	public static int grassColor;
	public static int foliageColor;
	public static int skyColor;
	
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
		grassColor = colorFromText(Configs.dreamTreeWorld.grassColor);
		foliageColor = colorFromText(Configs.dreamTreeWorld.foliageColor);
		skyColor = colorFromText(Configs.dreamTreeWorld.skyColor);
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
	
	@SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float currentTemperature)
    {
		return skyColor;
    }
	
	public static int colorFromText(String text)
	{
		text = "FF" + text;
		return (int)Long.parseLong(text, 16);
	}

}
