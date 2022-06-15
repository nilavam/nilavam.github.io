import java.util.*;
class TravelUtils
{
	public static int getTypesCount(Collection<Vehicle> c)
	{
		Iterator<Vehicle> it = c.iterator();
		int s = c.size();
		if(s == 0) 
			return 0;
		int[] arr = new int[s];
		int i = 0;
		while(it.hasNext())
		{
			Vehicle v = it.next();
			arr[i] = v.getCapacity();
			i++;
		}
		Arrays.sort(arr);
		int distinct = 1;
		for(int j = 1 ; j < s ; j++)
		{
			if(arr[j] != arr[j-1])
				distinct++;
		}
		return distinct;
	}

	public static int getVehiclesClassCount(Collection<Traveller> c) throws IncomparableTravellersException
	{
		Iterator<Traveller> it = c.iterator();
		int s = c.size();
		if(s == 0) 
			return 0;
		Traveller[] arr = new Traveller[s];
		for(int i = 0 ; i < s ; i++)
			arr[i] = null;
		arr[0] = it.next();
		int classesSoFar = 1;
		while(it.hasNext())
		{
			boolean flag = false;
			Traveller t = it.next();
			for(int j = 0 ; j < classesSoFar ; j++)
			{
				try
				{
					flag = t.canCoTravel(arr[j]);
				}
				catch(IncomparableTravellersException e){}
				if(flag)
					break;
			}
			if(!flag)
			{
				classesSoFar++;
				arr[classesSoFar-1] = t;
			}
		}
		return classesSoFar;
	}
}