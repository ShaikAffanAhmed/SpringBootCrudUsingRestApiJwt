package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.config.JwtServiceImpl;
import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.service.UserSecurityDetailsImpl;

import dto.LoginDto;

@RestController
@RequestMapping("api/v1/user")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserSecurityDetailsImpl userService;

	@Autowired
	private JwtServiceImpl service;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/create-user")
	public User createUser(@RequestBody User user) {

		User user1 = new User();
		user1.setMailId(user.getMailId());
		user1.setPassword(encoder.encode(user.getPassword()));
		user1.setRole(user.getRole());

		return userRepository.save(user1);
	}

	Map<String, Object> map = new HashMap<>();

	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody LoginDto loginDto) throws Exception {
		this.authenticate(loginDto.getUsername(), loginDto.getPassword());
		UserDetails userDetails = this.userService.loadUserByUsername(loginDto.getUsername());
		String token = this.service.generateToken(userDetails.getUsername());

		map.put("token", token);
		map.put("token expiration time", this.service.getExpirationDateFromToken(token).toString());
		map.put("token expiration time in milli seconds", this.service.getExpirationDateFromToken(token).getTime());
		map.put("message", "success");
		map.put("status", HttpStatus.OK.value());
		map.put("username", userDetails.getUsername());
		map.put("user-role", userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()));

		return ResponseEntity.ok().body(map);

	}

	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (DisabledException e) {
			throw new DisabledException("user is disabled");
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("bad credentials");
		}
	}
}
