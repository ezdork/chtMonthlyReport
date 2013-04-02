package promeritage.chtMonthlyReport.bean;

import java.net.URL;

public class ProUser {
    private String email;
    private String password;
    private URL workUrl;
    private URL workOverTimeUrl;
    private URL leaveWorkUrl;
    private String name;
    private String pmName;
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPmName() {
		return pmName;
	}
	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	public URL getWorkUrl() {
        return workUrl;
    }
    public void setWorkUrl(URL workUrl) {
        this.workUrl = workUrl;
    }
    public URL getWorkOverTimeUrl() {
        return workOverTimeUrl;
    }
    public void setWorkOverTimeUrl(URL workOverTimeUrl) {
        this.workOverTimeUrl = workOverTimeUrl;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public URL getLeaveWorkUrl() {
        return leaveWorkUrl;
    }
    public void setLeaveWorkUrl(URL leaveWorkUrl) {
        this.leaveWorkUrl = leaveWorkUrl;
    }
    @Override
    public String toString() {
        return "ProUser [email=" + email + ", password=" + password + ", workUrl=" + workUrl + ", workOverTimeUrl=" + workOverTimeUrl + ", leaveWorkUrl=" + leaveWorkUrl + "]";
    }
}
