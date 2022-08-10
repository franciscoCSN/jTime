package utilities;

public class GetUnsigned {

	long UInteger;
	public GetUnsigned(long uInteger) {
		UInteger = (uInteger - (2 * uInteger));
	}
	public long getUInteger() {
		return UInteger;
	}
	

	
}
