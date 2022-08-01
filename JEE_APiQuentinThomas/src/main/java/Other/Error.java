package Other;

import org.json.JSONObject;

public enum Error {
	DATABASE_CONNECTION_ERROR(1001),
	SQL_EXCEPTION(1002),
	USER_AUTHENTICATION_FAILED(1003),
	UNVALID_DATA_IN_REQ(1004)
    ; 


    private final int code;
    private String description = null;
    

    private Error(int code) {
        this.code = code;
    }
    

    public void setDescription(String description) {
    	this.description = description;
    }
    
    public int getCode() {
        return this.code;
    }
    
    public String getJSON() {
    	JSONObject error = new JSONObject();
    	error.put("code", code);
    	if(description != null ) {
    		error.put("description", description);
    	}else {
        	error.put("description", this);
    	}
    	return error.toString();
    }
}
