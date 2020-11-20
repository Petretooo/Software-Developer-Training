package app;

import javax.sql.DataSource;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.dao.ShiroRealm;

@Configuration
public class ShiroConfig {

	@Bean
	public Realm realm(DataSource dataSource) {
		
		JdbcRealm realm = new ShiroRealm();
		realm.setDataSource(dataSource);
		
		realm.setAuthenticationQuery("select password from user where username = ?");
		realm.setUserRolesQuery
		("select u.username from user as u "
				+ "join user_role as ur on u.user_id = ur.user_id "
				+ "join role as r on ur.role_id = r.role_id "
				+ "where u.username = ?");
		realm.setPermissionsQuery
		("select p.permission from user as u "
				+ "join user_role as ur on u.user_id = ur.user_id "
				+ "join role as r on ur.role_id = r.role_id "
				+ "join role_permission as rp on r.role_id = rp.role_id "
				+ "join permission as p on rp.permission_id = p.permission_id where u.username = ?");
		realm.setPermissionsLookupEnabled(true);
		
	    return realm;
	    
	}
	    
	@Bean
	public ShiroFilterChainDefinition shiroFilterChainDefinition() {
	    DefaultShiroFilterChainDefinition filter
	      = new DefaultShiroFilterChainDefinition();
	 
	    filter.addPathDefinition("/api/v1/games/**", "authc");
	    filter.addPathDefinition("/api/v1/alphabet/**", "authc");
	    filter.addPathDefinition("/api/v1/rank/**", "authc");
	    filter.addPathDefinition("/api/v1/users/**", "authc");
	    filter.addPathDefinition("/api/v1/words/**", "authc");
//	    filter.addPathDefinition("/hangman", "authc");
	    filter.addPathDefinition("/", "authc");
//	    filter.addPathDefinition("/rank", "anon");
//	    filter.addPathDefinition("/rank/topTen", "authc");
//	    filter.addPathDefinition("/rank/topMonth", "authc");
//	    filter.addPathDefinition("/games", "authc");
//	    filter.addPathDefinition("/games/**", "authc");
//	    filter.addPathDefinition("/words", "authc");
	    filter.addPathDefinition("/login", "anon");
	    filter.addPathDefinition("/registration", "anon");
	    filter.addPathDefinition("/secure", "authc");
	    filter.addPathDefinition("/logout", "logout");
	 
	    return filter;
	}


}
