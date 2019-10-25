package testgroup.philmography.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testgroup.philmography.security.JwtUtils;
import testgroup.philmography.service.CustomUserDetailsService;

@RestController
@Api(value = "JWT retreval REST Endpoint", description = "Manages JWT tokens")
public class AuthenticationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@ApiOperation("Get JWT token")
	@GetMapping(value = "/token")
	public ResponseEntity<?> createAuthenticationToken(@RequestParam String username, @RequestParam String password) throws Exception {
		
		UserDetails userDetails;
		
		try {
			userDetails = userDetailsService
					.loadUserByUsername(username);
		} catch (UsernameNotFoundException e) {
			logger.info(String.format("User with username %s is not found", username));
			return ResponseEntity.badRequest().body("Username or password are wrong.");
		}
		
		try {
			authenticate(username, password);
		} catch (Exception e) {
			ResponseEntity.badRequest().body("Username or password are wrong.");
		}
		
		final String token = jwtUtils.generateToken(userDetails);
		
		logger.info(String.format("Access token is successfully generated: %s", token));
		
		return ResponseEntity.ok(token);
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			logger.info(String.format("User with username %s is disabled", username));
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			logger.info(String.format("Invalid credentials of user with username %s are provided", username));
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
