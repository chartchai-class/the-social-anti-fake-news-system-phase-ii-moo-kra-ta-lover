package se331.mookratabackend.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.headers((headers) -> {
      headers.frameOptions((frameOptions) -> frameOptions.disable());
    });
    http
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf((crsf) -> crsf.disable())
            .authorizeHttpRequests((authorize) -> {
              authorize
                      // Public endpoints (no authentication required)
                      .requestMatchers("/api/v1/auth/**").permitAll()
                      .requestMatchers("/uploadImage").permitAll()
                      .requestMatchers("/uploadFile").permitAll()
                      .requestMatchers("/testSupabase").permitAll()
                      .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                      // News permissions
                      .requestMatchers(HttpMethod.GET, "/news/**").hasRole("READER")
                      .requestMatchers(HttpMethod.GET, "/news/**").hasRole("MEMBER")
                      .requestMatchers(HttpMethod.GET, "/news/**").hasRole("ADMIN")

                      .requestMatchers(HttpMethod.POST, "/news/**").hasRole("MEMBER")
                      .requestMatchers(HttpMethod.POST, "/news/**").hasRole("ADMIN")

                      .requestMatchers(HttpMethod.DELETE, "/news/**").hasRole("ADMIN")

                      // Comments (used as votes)
                      .requestMatchers(HttpMethod.POST, "/comments/**").hasRole("READER")
                      .requestMatchers(HttpMethod.POST, "/comments/**").hasRole("MEMBER")
                      .requestMatchers(HttpMethod.POST, "/comments/**").hasRole("ADMIN")

                      .requestMatchers(HttpMethod.DELETE, "/comments/**").hasRole("ADMIN")
                      .requestMatchers(HttpMethod.GET, "/admin/comments/**").hasRole("ADMIN")

                      // User management
                      .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                      .requestMatchers("/users/**").hasRole("ADMIN")

                      // Admin-only endpoints
                      .requestMatchers("/admin/**").hasRole("ADMIN")

                      // All other requests require authentication
                      .anyRequest().authenticated();
            })

            .sessionManagement((session) ->{
              session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            })

            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout((logout) -> {
              logout.logoutUrl("/api/v1/auth/logout");
              logout.addLogoutHandler(logoutHandler);
              logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
            })
    ;

    return http.build();

  }

  @Bean
    public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOriginPatterns(List.of("http://localhost:5173","http://13.212.6.216:8001"));
      config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS","PATCH"));
      config.setAllowedHeaders(List.of("*"));
      config.setExposedHeaders(List.of("x-total-count"));
      config.setAllowCredentials(true);

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", config);
      return source;
  }

  @Bean
  public FilterRegistrationBean<CorsFilter> corsFilerBean(){
    FilterRegistrationBean<CorsFilter> bean =
            new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
     bean.setOrder(Ordered.HIGHEST_PRECEDENCE); // run before security/Jwt
    return bean;
  }
}
