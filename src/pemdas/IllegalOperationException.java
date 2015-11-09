package pemdas;

@SuppressWarnings("serial")
public class IllegalOperationException  extends IllegalArgumentException  {

	IllegalOperationException ()
	{
		
	}

	IllegalOperationException (String exception)
	{
		super(exception);
	}
}
