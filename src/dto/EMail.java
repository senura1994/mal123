package dto;

import com.google.gson.annotations.Expose;

/**
 * Created by DDEZOYSA on 8/26/2016.
 */

public class EMail {

	@Expose
    private int party_id;
	@Expose
    private String email_type;
	@Expose
    private String email_id;
	@Expose
    private String active;

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public String getEmail_type() {
        return email_type;
    }

    public void setEmail_type(String email_type) {
        this.email_type = email_type;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
