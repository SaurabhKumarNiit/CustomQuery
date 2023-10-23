package com.custom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.custom.enties.VideoRequest;
import com.custom.enties.img;
import com.custom.respository.RespoVideo;
import com.custom.respository.imgRespo;

@Controller
public class declare {

	@Autowired
	imgRespo imgRespo;
	
	@Autowired
	RespoVideo respoVideo;
	
	
//	@RequestMapping("addmin")
//	public String video() {
//
//		return "addAdmin";
//	}	
	
	
//	@RequestMapping("videoD")
//	public String adminAdd(Model m) {
//
//			List<VideoRequest> vi=(List<VideoRequest>)respoVideo.findAll();
//			
//			m.addAttribute("obj",vi);
//		
//			
//		return "showVideoData";
//	}
	
//	@RequestMapping("Login")
//	public String sss() {
//
//		return "Login";
//	}
//	
//	@RequestMapping("opskar")
//	public String ssss() {
//
//		return "videoRequest";
//	}
//
//	@RequestMapping("show")
//	public String showpage() {
//
//		return "image";
//	}
//
//	
//	//home page where we login
//	@RequestMapping("/home")
//	public String ops() {
//
//		return "index";
//	}

	
//	@RequestMapping("sd/{namess}")
//	public String aops(@PathVariable String namess, Model m) {
//		System.out.println("this sit IS ");
//		
//			String obj=imgRespo.findByVideos(namess);
//			
//
//		m.addAttribute("videoLink",namess);
//		m.addAttribute("title",obj);
//		
//		return "sd";
//	}

}
