package fluke.dreamtree.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import akka.japi.Pair;
import fluke.dreamtree.DreamTree;

public class WeightedList <T>
{
	private List<Pair<T, Integer>> list = new ArrayList<Pair<T, Integer>>();
	private int sumWeight = 0;
	private Random rand = new Random();
	
	public void add(T item, int weight)
	{
		list.add(new Pair<T, Integer>(item, weight));
		sumWeight += weight;
	}
	
	public T selectRandom()
	{
		int rando = rand.nextInt(sumWeight) + 1;
		int counter = 0;
		for(Pair<T, Integer> p : list)
		{
			counter += p.second();
			if(counter >= rando)
				return (T) p.first();
		}
		
		DreamTree.logger.error(list.toString());
		throw new RuntimeException("WeightedList selection ate shit");
	}

}
