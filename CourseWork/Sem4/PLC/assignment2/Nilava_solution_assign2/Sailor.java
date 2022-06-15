class Sailor implements Traveller
{
	private String name, id;

	//nonparameterized constructor
	public Sailor()
	{
		this.name = null;
		this.id = null;
	}

	//parameterized constructor
	public Sailor(String n, String i)
	{
		this.name = n;
		this.id = i;
	}

	//accessor for name
	public String getName()
	{
		return this.name;
	}

	//accessor for id
	public String getId()
	{
		return this.id;
	}

	//mutator for name
	public void setName(String n)
	{
		this.name = n;
	}

	//mutator for id
	public void setId(String i)
	{
		this.id = i;
	}

	public int getMaxCoTravellers()
	{
		return 100000;
	}

	public boolean canCoTravel(Traveller t) throws IncomparableTravellersException
	{
		if(t instanceof Sailor)
			return true;
		else
			throw new IncomparableTravellersException("Cannot travel with a Sailor");
	}
}