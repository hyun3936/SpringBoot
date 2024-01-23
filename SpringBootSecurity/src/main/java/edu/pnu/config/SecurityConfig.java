package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //이  클래스가 설정  클래스라고 정의  (IoC 컨테이너에 로드)
@EnableWebSecurity //스프링 시큐리티 적용에 필요한 객체들 자동 생성
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
	
	@Bean // 이  메서드가 리턴  하는 객체를 IoC 컨테이너에 등록하라는 지시
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(security->security
			.requestMatchers("/member/**").authenticated()
			.requestMatchers("/manager/**").hasRole("MANAGER")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().permitAll());
		
		http.csrf(cf->cf.disable()); // CSRF 보호 비활성화 (JavaScript 호출)
		
		
		/*   -SecurityFilterChain 객체를 생성해서 Bean으로 등록하면 기본 로그인 화면이 나타나지 않는다.
	     -여기까지 완성되면 서버를 실행해서 정상적으로 실행되는 지  확인
		 -여기까지 완성되면 서버를 실행해서
		 -인덱스는 정상적으로 호출이 되고, 이외의 다른 url들은 403 (Forbidden – Access Denied)에러가 나타나는 
			지  확인한다. ➔  로그인 화면을 어떤 것을 사용할지 시큐리티에게 알려주지 않아서 에러가 발생
		 -AntPathRequestMatcher(또는 MvcRequestMatcher)를 이용한 경로 설정은  h2 데이터베이스를 사용하는 경우에 
			만  사용하면 되며, 만약 MySQL 혹은 다른 데이터베이스를 사용하만 경로명만 입력해도 된다.
		 -3.x 버전이  되면서 h2-console에서  사용하는 url과의 충돌로 인해 에러가 발생한다. */
		
		
		http.formLogin(form->form  //SpringBoot가 제공해주는 로그인 사용
				.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess",true)
		); 
//		  /member를 호출해서 로그인 화면으로 왔을 때  로그인에    성공한 뒤  /loginSuccess로 이동하겠다는 의미
//		  그렇지 않고 로그인에 성공한 뒤  호출한  url인 /member로 이동하려면 false로 설정하면 됨.
		
		
		
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied")); // 접근권한 없음 페이지 처리
		
		
		http.logout(logout->logout 		// 로그아웃 처리
			.invalidateHttpSession(true)  // 현재 브라우저와 연결된  세션  강제 종료
			.deleteCookies("JSESSIONID")  // 세션 아이디가 저장된  쿠키  삭제
			.logoutSuccessUrl("/login")); // 로그아웃 후  이동할 URL 지정
			
		return http.build();
	}
}




