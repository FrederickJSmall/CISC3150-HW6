package pemdas;


@SuppressWarnings("serial")
public class NotANumberException  extends IllegalArgumentException  {

	NotANumberException ()
	{
		
	}

	NotANumberException (String exception)
	{
		super(exception);
	}
}
