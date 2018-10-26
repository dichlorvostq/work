package com.gkhn.wms.realm;

 

import java.util.HashSet;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.gkhn.wms.pojo.Pubemp;
import com.gkhn.wms.service.IndexService;
import com.gkhn.wms.service.MeunService;
import com.gkhn.wms.util.xjMD5;

 

public class DatabaseRealm extends AuthorizingRealm {
 
     @Autowired
     MeunService    meunService;
     
     @Autowired
     IndexService   indexService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		//能进入到这里，表示账号已经通过验证了
		String userName =(String) principalCollection.getPrimaryPrincipal();
		/*System.out.println(userName+"??________");*/
		//通过service获取角色和权限
		Set<String> permissions = meunService.selectMeunByusername(userName);
		Set<String> roles = new HashSet<String>();
		 roles.add("user");
		//授权对象
		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
		//把通过service获取到的角色和权限放进去
		s.setStringPermissions(permissions);
		s.setRoles(roles);
		return s;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取账号密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String userName= token.getPrincipal().toString();
		String psw= new String( t.getPassword());
		System.out.println(userName+"密码是什么？"+psw);
		
		String password = xjMD5.StandardMD5(psw);
		System.out.println("页面上输入的密码"+password);
		//获取数据库中的密码
		System.out.println(userName+"页面上传的用户名");
      	Pubemp p=	indexService.LoginByEmpCode(userName);
        System.out.println(p.getPassword()+"数据库获取的密码");
		String passwordInDB = p.getPassword();
     
		
		//如果为空就是账号不存在，如果不相同就是密码错误，但是都抛出AuthenticationException，而不是抛出具体错误原因，免得给破解者提供帮助信息
		if(null==passwordInDB || !passwordInDB.equals(password)) 
			throw new AuthenticationException();
		
		//认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(userName,psw,getName());
		return a;
	}

}
