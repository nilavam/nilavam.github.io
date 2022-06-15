class CheapSailor extends Sailor
{
	private final int coTravellers = 5;

	//non-parameterized constructor
	public CheapSailor()
	{
		super();
	}

	//parameterized constructor
	public CheapSailor(String n, String i)
	{
		super(n,i);
	}

	//to get the maximum number of cotravellers
	public int getMaxCoTravellers()
	{
		return coTravellers;
	}

	//check compatibility of cotravellers
	public boolean canCoTravel(Traveller t) throws IncomparableTravellersException
	{
		if(t instanceof Sailor)
		{
			if(t instanceof CheapSailor)
				return true;
			else return false;
		}
		else
			throw new IncomparableTravellersException("Cannot compare with a Sailor");
	}
}