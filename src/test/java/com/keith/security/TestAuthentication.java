package com.keith.security;

import org.junit.Test;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证流程：
 * 1.用户输入用户名和密码由Authentication接口进行认证处理，封装成token
 * 2.Authentication交给AuthenticationManager接口进行处理，和调度实现类AuthenticationProvider
 * 3.AuthenticationProvider的supports()检测token是否合法，
 *  将用户名传给UserDetailsService进行查询，返回数据源用户信息和权限信息
 * 4.AuthenticationProvider对用户信息进行Authenticate(),利用PasswordEncoder对名文密码进行加密与数据源中的进行匹配
 * 5.认证成功返回Authentication
 */
public class TestAuthentication {
    @Test
    public void testAuth(){
        //创建内存用户
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(User.withUsername("jj").password(new BCryptPasswordEncoder().encode("kk")).roles("user").build());

        //创建provider，将userDetails中的用户信息设置进去
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        //将获取到用户信息的的provider交由AuthenticationManager
        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(provider);
        AuthenticationManager manager =new ProviderManager(providers);

        //用户提供的身份信息
        Authentication token = new UsernamePasswordAuthenticationToken("jj","kk");

        Class<? extends Authentication> supportedToken = token.getClass();

        System.out.println(provider.supports(supportedToken));  //true

        Authentication result = manager.authenticate(token);
        System.out.println(result);  //Username: jj; Password: [PROTECTED]

    }


}
