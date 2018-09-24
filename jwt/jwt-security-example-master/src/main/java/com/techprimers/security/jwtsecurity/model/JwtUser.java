package com.techprimers.security.jwtsecurity.model;

public class JwtUser {
    private String username;
    private long id;
    private String role;


    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JwtUser [username=");
		builder.append(username);
		builder.append(", id=");
		builder.append(id);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}
    
    
}
