# Spring security Demo

hi.html需要登录 具有user角色才能访问，index.html无需登录...
```
/**
 * 验证流程：
 * 1.用户输入用户名和密码由Authentication接口进行认证处理，封装成token
 * 2.Authentication交给AuthenticationManager接口进行处理，和调度实现类AuthenticationProvider
 * 3.AuthenticationProvider的supports()检测token是否合法，
 *  将用户名传给UserDetailsService进行查询，返回数据源用户信息和权限信息
 * 4.AuthenticationProvider对用户信息进行Authenticate(),利用PasswordEncoder对名文密码进行加密与数据源中的进行匹配。
 * 5.认证成功返回Authentication..
 */
```

