package fluke.dreamtree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import akka.japi.Pair;
import fluke.dreamtree.DreamTree;
import net.minecraft.block.state.IBlockState;

public class WeightedList
{
	private List<Pair<IBlockState, Integer>> list = new ArrayList<Pair<IBlockState, Integer>>();
	private int sumWeight = 0;
	private Random rand = new Random();
	
	public void add(IBlockState state, int weight)
	{
		list.add(new Pair<IBlockState, Integer>(state, weight));
		sumWeight += weight;
	}
	
	public IBlockState selectRandom()
	{
		int rando = rand.nextInt(sumWeight) + 1;
		int counter = 0;
		for(Pair<IBlockState, Integer> p : list)
		{
			counter += p.second();
			if(counter >= rando)
				return p.first();
		}
		
		DreamTree.logger.error(list.toString());
		throw new RuntimeException("WeightedList selection ate shit");
	}

}
