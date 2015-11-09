package pemdas;

@SuppressWarnings("serial")
public class NotEnoughNumbersException  extends IllegalArgumentException  {

	NotEnoughNumbersException ()
	{
		
	}

	NotEnoughNumbersException (String exception)
	{
		super(exception);
	}
}
