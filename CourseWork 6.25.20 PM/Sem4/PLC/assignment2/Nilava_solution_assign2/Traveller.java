interface Traveller
{
	public int getMaxCoTravellers();
	public boolean canCoTravel(Traveller t) throws IncomparableTravellersException;
}