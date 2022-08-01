package API;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BaseAPI {
	
	public BaseAPI() {}
	protected static String getApiKey() {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			return (String) env.lookup("apiKey");
		} catch (NamingException e) {
			return "";
		}
	}
	
	protected static String getBaseUri() {
		Context ctx;
		try {
			ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			return (String) env.lookup("baseURI");
		} catch (NamingException e) {
			return "";
		}
	}
}
