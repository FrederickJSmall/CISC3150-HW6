package pemdas;

@SuppressWarnings("serial")
public class IllegalOperationException  extends IllegalArgumentException  {

	private String exception;
	IllegalOperationException ()
	{
		
	}

	IllegalOperationException (String exception)
	{
		//super(exception);
		this.exception = exception;
	}
	@Override
	public String toString()
	{
		return this.exception;
	}
}
