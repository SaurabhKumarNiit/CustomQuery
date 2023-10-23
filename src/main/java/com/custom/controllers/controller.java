package com.custom.controllers;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.custom.Service.CustomerService;
import com.custom.Service.GoogleService;
import com.custom.enties.*;
import com.custom.exception.CustomerNotFoundException;
import com.custom.respository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200/")
public class controller {

	@Autowired
	respo respo;
	
	@Autowired
	RespoVideo respoVideo;

	@Autowired
	imgRespo imgRespo;

	@Autowired
	CustomerService customerService;


	@Autowired
	GoogleService googleService;


	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	FacebookRepository facebookRepository;
	
	
	//request video editing http://localhost:1001/videoRequest
	
	@PostMapping("/videoRequest")
	public VideoRequest submits(@RequestBody VideoRequest op) {

		VideoRequest videoRequest=new VideoRequest();
		videoRequest.setName(op.getName());
		videoRequest.setEmail(op.getEmail());
		videoRequest.setPhone(op.getPhone());
		videoRequest.setDuration(op.getDuration());
		videoRequest.setVideoType(op.getVideoType());
		videoRequest.setPlatform(op.getPlatform());
		videoRequest.setFrequency(op.getFrequency());
		videoRequest.setAfterEffects(op.getAfterEffects());
		videoRequest.setBudget(op.getBudget());
		videoRequest.setSpecifications(op.getSpecifications());
		videoRequest.setAnimationType(op.getAnimationType());
		videoRequest.setGenre(op.getGenre());

		VideoRequest request = respoVideo.save(videoRequest);

		return request;
	}
	
	//request video editing http://localhost:1001/Register
	
	@PostMapping("/Register")
	public rites register(@RequestBody rites rite) {
		rites rites = new rites();

		rites.setName(rite.getName());
		rites.setEmail(rite.getEmail());
		rites.setPhoneNo(rite.getPhoneNo());
		rites.setPassword(rite.getPassword());
		rites.setAdmin(false);
		rites ops= respo.save(rites);
		return ops;
	}
	
	
	//request video editing http://localhost:1001/addAdmin
	
	@PostMapping("/addAdmin")
	public rites addAdmin(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phoneNo") String phoneNo, @RequestParam("password") String password) {
		rites rites = new rites();

		rites.setName(name);
		rites.setEmail(email);
		rites.setPhoneNo(phoneNo);
		rites.setPassword(password);
		rites.setAdmin(true);

		rites ops=	respo.save(rites);
		return ops;
	}
	
	
	//request video editing http://localhost:1001/videoUpload

	@PostMapping(value = "/videoUpload")
	public img videoSave(@RequestParam("thumbnail") MultipartFile thumbnail,
			@RequestParam("video") MultipartFile video, @RequestParam("name") String name, HttpSession s) {

		System.out.println(thumbnail.getOriginalFilename());
		String thumbnails = thumbnail.getOriginalFilename();
		String videos = video.getOriginalFilename();

		img img = new img();
		img.setThumbnails(thumbnails);
		img.setName(name);
		img.setVideos(videos);

		img ops= imgRespo.save(img);

		try {
			// video
			byte[] b = thumbnail.getBytes();
			String path = s.getServletContext().getRealPath("images/") + thumbnail.getOriginalFilename();
			System.out.println(path);
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			fos.close();

			// images
			byte[] c = video.getBytes();
			String paths = s.getServletContext().getRealPath("video/") + video.getOriginalFilename();

			System.out.println(paths);
			FileOutputStream foss = new FileOutputStream(paths);
			foss.write(c);
			foss.close();

		} catch (Exception e) {

			// TODO: handle exception
		}
		
		return ops;
	}

	//request video editing http://localhost:1001/login
	@PostMapping("login")
	public String login(@RequestBody rites rites) {
		rites ses = respo.findByLogin(rites.getEmail(), rites.getPassword());

		if (ses != null) {

			if (ses.getAdmin() == true) {
				return "admin";
			}

			return "user";
		}

		return null;
	}


	//request video editing http://localhost:1001/imgData
	
	@GetMapping("imgData")
	public ArrayList<img> showpages(Model m) {

		ArrayList<img> ops = (ArrayList<img>) imgRespo.findAll();

		m.addAttribute("obj", ops);
		return ops;
	}
	
	
	// this is get video REquest  from link  http://localhost:1001/videoRequestData
	@GetMapping("videoRequestData")
	public List<VideoRequest> adminAdd(Model m) {

			List<VideoRequest> vi=(List<VideoRequest>)respoVideo.findAll();
			
			m.addAttribute("obj",vi);
		
			
		return vi;
	}

//	=============================================================================================

//	http://localhost:1001/userLogin
	@PostMapping("/userLogin")
	public ResponseEntity<?> loginCustomer(@RequestBody Customer customer) throws CustomerNotFoundException {

		ResponseEntity responseEntity = null;
		try {
			Customer customer1 = customerService.findByEmailAndPassword(customer.getEmail(), customer.getPassword());

			responseEntity = new ResponseEntity<>(customer1,HttpStatus.OK);
		}catch (CustomerNotFoundException e) {
			throw new CustomerNotFoundException();
		}catch (Exception e){
			responseEntity = new ResponseEntity<>("Try After Some Time",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	//	http://localhost:1001/userRegister

	@PostMapping("/userRegister")
	public ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
		Customer customer1 = customerService.addCustomer(customer);
		return new ResponseEntity<>(customer1, HttpStatus.CREATED);
	}

	//	http://localhost:1001/googleLogin

//	@PostMapping("/googleLogin")
//	public ResponseEntity<?> googleLogin(@RequestBody GoogleLogin googleLogin) {
//
//		GoogleLogin addUser = googleService.addUser(googleLogin);
//		return new ResponseEntity<>(addUser, HttpStatus.CREATED);
//	}

	@PostMapping("/googleLogin")
	public GoogleLogin googleLoginCallback(@RequestBody GoogleLogin userCredential) {

		GoogleLogin googleLogin = new GoogleLogin();

		googleLogin.setId(userCredential.getId());
		googleLogin.setName(userCredential.getName());
		googleLogin.setEmail(userCredential.getEmail());
		googleLogin.setPhotoUrl(userCredential.getPhotoUrl());
		GoogleLogin googleLogin1 = new GoogleLogin();

		googleLogin1=googleService.saveUserCredential(googleLogin);
		return googleLogin1;
		// You can add additional logic or return a response if needed
	}

	//	http://localhost:1001/userCredentials
	@GetMapping("/userCredentials")
	public List<GoogleLogin> getAllUserCredentials() {
		return googleService.getAllUserCredentials();
	}


	//	http://localhost:1001/user/{email}
	@GetMapping("/user/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) throws CustomerNotFoundException {
		try {
			return new ResponseEntity<>(googleService.getUserCredentialsByEmail(email), HttpStatus.OK);

		}catch (CustomerNotFoundException e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	//	http://localhost:1001/feedback
	@PostMapping("/feedback")
	public Feedbacks saveFeedbacks(@RequestBody Feedbacks feedbacks) {

		Feedbacks feedbacks1;

		feedbacks1=feedbackRepository.save(feedbacks);
		return feedbacks1;
	}

	//	http://localhost:1001/allFeedbacks
	@GetMapping("/allFeedbacks")
	public List<Feedbacks> getAllFeedbacks() {

		return (List<Feedbacks>) feedbackRepository.findAll();
	}


	//	http://localhost:1001/facebookLogin
	@PostMapping("/facebookLogin")
	public FacebookLogin saveFacebookData(@RequestBody FacebookLogin facebookLogin) {

		FacebookLogin facebookLogin1;

		facebookLogin1=facebookRepository.save(facebookLogin);
		return facebookLogin1;
	}

	//	http://localhost:1001/facebookData
	@GetMapping("/facebookData")
	public List<FacebookLogin> getAllFacebookData() {

		return (List<FacebookLogin>) facebookRepository.findAll();
	}



}
