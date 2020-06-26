package org.fatec.trabLabEng.stockSystem;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

	@GetMapping(produces="application/json")
	public @ResponseBody  ArrayList<String> index(){
	    ArrayList<String> teste = new ArrayList();

		return teste;
	}
}