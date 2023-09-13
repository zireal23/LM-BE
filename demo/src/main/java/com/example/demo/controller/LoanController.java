package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Loan;

import com.example.demo.service.LoanService;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoanController{
	@Autowired
	private LoanService loanService;

	@GetMapping("/showloan")
	public String showMessage() {
		return "Welcome";
	}
	
	@PostMapping("/saveLoan")
	public String saveLoan(@RequestBody Loan l) {
		String result = "";
		result = loanService.saveLoan(l);
		System.out.println(l.getLoanType());
	/*	if(obj != null) {
			result = "User data saved";
		}
		else {
			result = "Insertion failed";
		}*/
		
		return result;
	}
	@GetMapping("/fetchLoans")
	public List<Loan> getAllLoans()
	{
		return loanService.getAllLoans();
	}
	
	@GetMapping("/distinctLoanTypes")
	public List<String> getDistinctLoanTypes (){
		return loanService.getDistinctLoanTypes();
	}
	
	@GetMapping("/fetchLoanById/{loanId}")
	public Loan getLoanById(@PathVariable("loanId")  int lno)
	{
		return loanService.getLoanById(lno);
	}
//    @PutMapping("/updateStudent/{rno}")
//    public ResponseEntity<Student> updateStudent(@PathVariable("rno") int regno, @Valid @RequestBody Student stud) {
//
//       
//        Student studObj = studService.getStudentById(regno);
//
//        if (studObj != null) {
//        
//            studObj.setName(stud.getName());
//            studObj.setDepartment(stud.getDepartment());
//            return new ResponseEntity<>(studService.saveStudent(studObj), HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

	
}

