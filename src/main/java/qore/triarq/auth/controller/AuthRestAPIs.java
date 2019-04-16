package qore.triarq.auth.controller;


import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import qore.triarq.auth.message.request.LoginForm;
import qore.triarq.auth.model.Authdetails;
import qore.triarq.auth.model.Payload;
import qore.triarq.auth.model.PersonResponse;
import qore.triarq.auth.model.TokenValidator;
import qore.triarq.auth.model.UserView;
import qore.triarq.auth.repository.AuthDetailsRepository;
import qore.triarq.auth.repository.RoleRepository;
import qore.triarq.auth.repository.UserRepository;
import qore.triarq.auth.repository.UserViewRepository;
import qore.triarq.auth.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthRestAPIs {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    UserViewRepository userViewRepository;

    @Autowired
    AuthDetailsRepository authDetailsRepository;
    
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;
    
    
    
    
    @GetMapping("/")
    public String hello()
    {
    	return "Hello from Auth Service...."; 
    }
    
    @GetMapping("/message")
    public String message()
    {
    	return "Confidential Content......!!!!!";
    }
    
    

    @PostMapping("/signin")
    public ResponseEntity<PersonResponse> authenticateUser(@RequestBody LoginForm loginRequest) {

    	List<UserView> u;
    	
    	u=(List<UserView>) userViewRepository.findByusername(loginRequest.getUsername());
    	
    	
    	List<Authdetails> ad;
    	
    	ad=authDetailsRepository.findByusername(loginRequest.getUsername());
    	
    	PersonResponse pr=new PersonResponse();
    	
    	Payload pl=new Payload();
    	
//    	for(UserView utemp:u)
//    	{
//    		
//    		System.out.println(u.toString());
////        	
//    	}
    	
    	
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        
             
        
        	
        
        String jwt = jwtProvider.generateJwtToken(authentication);
        
        
        DecodedJWT token = JWT.decode(jwt);
        
//        System.out.println("token"+token);
        
        String issuer = token.getIssuer();
//        System.out.println("token issuer:"+issuer);

        List<String> aud=token.getAudience();
//        System.out.println("token audience: "+aud.iterator().next());
        
        String tid=token.getId();
//        System.out.println("token Id:"+tid);
        
        String sub=token.getSubject();
//        System.out.println("token Subject:"+sub);
        
        Date expiresAt = token.getExpiresAt();
//        System.out.println("token expAt: "+expiresAt.getTime());
        
        Date issuedAt = token.getIssuedAt();
//        System.out.println("token issAt: "+issuedAt.getTime());
        
//        System.out.println("signature:"+token.getSignature().toString());
        
//        List<String> aud=token.getAudience(); 
//        
//        System.out.println("Token Aud:"+aud.toString());
     
//        if()
        
        
//        token.getSignature().compareTo(anotherString)
        
        
        pr.setToken(jwt);
        pr.setUsername(loginRequest.getUsername());
        pl.setIss(issuer);
        pl.setIat(issuedAt.toString());
        pl.setAud(aud.iterator().next());
        pl.setExp(expiresAt.toString());
        pl.setSub(sub);
        pr.setPayload(pl);
        pr.setUserView(u);
        pr.setAuthdetails(ad);
        

//        return ResponseEntity.ok(new JwtResponse(jwt));
    
        
        if(authentication.isAuthenticated())
        {
        	
        	return new ResponseEntity<PersonResponse>(pr,HttpStatus.ACCEPTED);
        	
        	
        }
        
        
        
        
        return new ResponseEntity<>(HttpStatus.LOCKED);
        
        
    }
    
    
//    @GetMapping("/validate")
//    public ResponseEntity<?> validateToken(@RequestParam(""))
//    {
//    	
//    	boolean tkn=jwtProvider.validateJwtToken(tokenValidator.getToken());
//    	
//    	if(tkn==true)
//    	{
//    		return new ResponseEntity<String>("Token is Valid",HttpStatus.OK);
//    	}
//    	
//    	return new ResponseEntity<String>("Token is invalid",HttpStatus.UNAUTHORIZED);
//    	
//    }
//    
    
    
    @GetMapping("/validatetoken")
    public ResponseEntity<?> validateToken(HttpServletRequest request) 
    {
        String authHeader = request.getHeader("Authorization");
        	
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	
        	String tokenValue=authHeader.replace("Bearer ","");
        	
        	boolean tkn=jwtProvider.validateJwtToken(tokenValue);
        	if(tkn==true)
           	{
           		return new ResponseEntity<String>("Token is Valid",HttpStatus.OK);
           	}
//        	return authHeader.replace("Bearer ","");
        }

        return new ResponseEntity<String>("Token is inalid",HttpStatus.UNAUTHORIZED); 
       }
    
    
    
    
    
    

//    @PostMapping("/signup")
//    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
//        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity<String>("Fail -> Username is already taken!",
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity<String>("Fail -> Email is already in use!",
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        // Creating user's account
//        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
//                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
//
//        Set<String> strRoles = signUpRequest.getRole();
//        Set<Role> roles = new HashSet<>();
//
//        strRoles.forEach(role -> {
//        	switch(role) {
//	    		case "admin":
//	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//	    			roles.add(adminRole);
//	    			
//	    			break;
//	    		case "pm":
//	            	Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
//	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//	            	roles.add(pmRole);
//	            	
//	    			break;
//	    		default:
//	        		Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//	        		roles.add(userRole);        			
//        	}
//        });
//        
////        user.setRoles(roles);
//        userRepository.save(user);
//
//        return ResponseEntity.ok().body("User registered successfully!");
//    }
}