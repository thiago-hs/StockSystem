package org.fatec.trabLabEng.stockSystem.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saidas")
public class SaidaController {

	@GetMapping(produces="application/json")
	public @ResponseBody  ArrayList<String> index(){
	    ArrayList<String> saidas = new ArrayList();

		return saidas;
	}
}
