package my.spring.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.spring.project.Email.EmailService;

//import com.spring.boot.pojos.User;

import my.spring.project.dao.UserRepository;
import my.spring.project.pojos.User;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/Userportal")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/getAllusers")
	public Iterable<User>getAllusers()
	{
		return userRepository.findAll();
	}
	 @Autowired

	   private EmailService emailService;

	 @PostMapping("/saveUser")

	 public User saveUser(@RequestBody User user) {

	 System.out.println(user);

	 userRepository.save(user);



	 StringBuffer mailContain= new StringBuffer();

	 mailContain.append("Hi "+user.getUserName()+"\n");

	 mailContain.append("Please Click on Below Click to Confirm Your Email With Us\n");

	 mailContain.append("<a href='http://localhost:8015/Userportal/confirmEmail/"+user.getEmail()+">Click</a>\n");

	 mailContain.append("Thanks And Regards\n CTS Participant\n");



	 emailService.sendMail(user.getEmail(),"Email Confirmation", mailContain.toString());



	    //emailService.sendPreConfiguredMail("Ho ho ho");





	 return user;

	 }
	
	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") Integer id)
	 {
			user.setId(id);;
	 System.out.println(user);
	 userRepository.save(user);
	 return user;
	 }
	@GetMapping("/find/{id}")
	public User find( @PathVariable("id")Integer id)
	{
		
		Optional<User> user=userRepository.findById(id);
		return user.get();
	}
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id")Integer id)
	{
		userRepository.deleteById(id);
		return true;
	}
	@GetMapping("/confirmEmail/{emailId}")

	 public User confirmEmail(@PathVariable("emailId") String emailId)

	 {

	 Optional<User> user= userRepository.findByEmail(emailId);

	 if(user!=null && user.get()!=null)

	 {

	  User u=user.get();

	  u.setConfirmed("Yes");

	  userRepository.save(u);

	  return u;



	 }

	 return user.get();

	 }
	@GetMapping("/findByUserNameAndPassword/{username}/{password}")

	 public User findByUserNameAndPassword(@PathVariable("username") String username,@PathVariable("password") String password)

	 {

	 User user= userRepository.findByUserNameAndPasswordAndConfirmed(username, password,"yes");

	 return user;
	
	

}

}