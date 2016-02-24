package org.wsy.core.modules.user.domain;

public enum ROLE {
	
	admin("admin"), user("user");
	
	
	
	private String name;
	private ROLE(String name) {
        this.name = name;
    }
	public String getName(){
		return name;
	}
	
	

}
