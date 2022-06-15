class PremiumSailor extends Sailor
{
	private final int coTravellers = 2;

	//non-parameterized constructor
	public PremiumSailor()
	{
		super();
	}

	//parameterized constructor
	public PremiumSailor(String n, String i)
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
			if(t instanceof PremiumSailor)
				return true;
			else return false;
		}
		else
			throw new IncomparableTravellersException("Cannot compare with Sailor");
	}
}