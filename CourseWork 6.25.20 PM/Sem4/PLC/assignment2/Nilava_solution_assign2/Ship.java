class Ship implements Vehicle
{
	private String name;
	private int capacity;

	//non-parameterized constructor
	public Ship()
	{
		this.name = null;
		this.capacity = 0;
	}

	//parameterized constructor
	public Ship(String n, int cap)
	{
		this.name = n;
		this.capacity = cap;
	}

	//accessor for name
	public String getName()
	{
		return this.name;
	}

	//accessor for capacity
	public int getCapacity()
	{
		return this.capacity;
	}

	//mutator for name
	public void setName(String n)
	{
		this.name = n;
	}

	//mutator for capacity
	public void setCap(int cap)
	{
		this.capacity = cap;
	}
}