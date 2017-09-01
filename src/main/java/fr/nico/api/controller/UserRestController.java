package fr.nico.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.nico.api.entity.Device;
import fr.nico.api.entity.User;
import fr.nico.api.repository.UserRepository;
import fr.nico.api.security.JwtTokenUtil;
import fr.nico.api.security.JwtUser;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    private UserRepository _userRepository;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "/user/{id}", method=RequestMethod.GET)
    public User getUserById(@PathVariable Long id) {
        return this._userRepository.findOne(id);
    }
    
    @RequestMapping(value = "/user/", method=RequestMethod.GET)
    public List<User> getAllUsers() {
        return this._userRepository.findAll();
    }
    
    @RequestMapping(value = "/user/{id}/delete", method=RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        this._userRepository.delete(id);
    }
    
    @RequestMapping(value = "/user/", method=RequestMethod.POST)
    public User saveDevice(@RequestBody User user) {
        return this._userRepository.save(user);
    }
    
}
