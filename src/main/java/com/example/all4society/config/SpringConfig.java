//package com.example.all4society.config;
//
//import com.example.all4society.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//
//@Configuration
//@EnableWebSecurity // 스프링시큐리티필터체인이 자동으로 포함된다.
//public class SpringConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    MemberService memberService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception { //http 요청에 대한 보안을 설정한다.
//        http
//                .formLogin()
//                .loginPage("/members/login") // 로그인 페이지 설정
//                .defaultSuccessUrl("/") // 로그인 성공시 이동할 url 설정
//                .usernameParameter("email") // 로그인 시 사용할 파라미터 이름으로 email로 지정
//                .failureUrl("/members/login/error") // 로그인 실패 시 이동할 URL 설정
//                .and()
//                .logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) // 로그아웃 URL 설정
//                .logoutSuccessUrl("/"); // 로그아웃 성공 시 이동할 URL 설정
//
//        http
//                .authorizeRequests() // 시큐리티 처리에 HttpServletRequest를 이용한다는 것을 의미
//                .mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll() // permitAll을 통해 모든 사용자가
//                // 인증 없이 해당 경로 접근 가능 설정
//                .mvcMatchers("/admin/**").hasRole("ADMIN") // Role이 ADMIN일때만 접근 가능하게 설정
//                .anyRequest().authenticated(); // 앞서 설정해준 경로를 제외한 나머지 경로들은 인증을 요구하도록 설정
//
////        http
////                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint()); // 인증되지 않은 사용자가 리소스에 접근하였을 때
//        // 수행되는 핸들러를 등록
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**"); // static 디렉터리 하위 파일들은 인증 무시 설정
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
//        // SpringSecurity에서 인증은 Authentication 으로 이루어지며 AuthenticationManagerBuilder 가 AuthenticationManager를 생성한다.
//        // UserDetailService를 구현하고 있는 객체로 memberService를 지정해주며, 비밀번호 암호화를 위해 passwordEncoder를 지정해준다.
//    }
//}