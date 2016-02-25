package org.wsy.core.generic.staticparams;

public class StaticParams {
	
	public static class USERROLE {
		public static final String ROLE_ADMIN ="ROLE_ADMIN";
		public static final String ROLE_USER = "ROLE_USER";
	}
	
	public static class PATHREGX {
		
		private final static String getPathRex(String path){
			return "/"+path+"**";
		}
		public static final String NOAUTH = getPathRex(PATH.NOAUTH);
		public static final String AUTHADMIN=getPathRex(PATH.AUTHADMIN);
		public static final String AUTHUSER=getPathRex(PATH.AUTHUSER);
		public static final String RESOURCE = getPathRex(PATH.RESOURCE);
		public static final String JS = getPathRex(PATH.JS);
		public static final String CSS = getPathRex(PATH.CSS);
		public static final String IMG = getPathRex(PATH.IMG);
	}
	
	public static class PATH {
		public static final String NOAUTH="no-auth/";
		public static final String AUTHADMIN="ad-auth/";
		public static final String AUTHUSER="auth/";
		public static final String RESOURCE = "resource/";
		public static final String JS = "js/";
		public static final String CSS = "css/";
		public static final String IMG = "img/";		
	}

}
