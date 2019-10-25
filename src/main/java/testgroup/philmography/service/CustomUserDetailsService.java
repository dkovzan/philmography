package testgroup.philmography.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.philmography.dao.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserDao userDao;
	
	@Autowired
	public CustomUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.userDao.getByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
	}
}
