package com.nexti4hack.webapp.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
@EnableWebSecurity
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var authProvider:  AuthenticationProviderImpl

    // セキュリティ無効化エリア
    override fun configure(web: WebSecurity) {
        web.ignoring().antMatchers(
                "/css/**",
                "/javascript/**"
        )
    }

    override fun configure(http: HttpSecurity) {
        // 権限設定
        http.authorizeRequests()
                // 全ユーザー閲覧可能
                .antMatchers("/login").permitAll()
                // adminユーザーのみ閲覧可能
                .antMatchers("/admin/**").hasRole("ADMIN")
                // 全ページ認証済みユーザーのみ閲覧可能
                .anyRequest().authenticated()

        // フィルター生成
        var authenticationFilter = AuthenticationFilter()
        authenticationFilter.setRequiresAuthenticationRequestMatcher(
                AntPathRequestMatcher("/login", "POST"))
        //authenticationFilter.setAuthenticationFailureHandler(AuthenticationFailureHandler())
        authenticationFilter.setAuthenticationManager(authenticationManagerBean())
        // ログイン設定(フィルター)
        http.addFilterBefore(authenticationFilter, AuthenticationFilter::class.java)

        // ログアウト設定
        http.logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authProvider)
    }

}