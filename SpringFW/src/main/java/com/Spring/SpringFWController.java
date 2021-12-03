package com.Spring;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springFW.dto.Employee;

@RestController
@RequestMapping(value = "/home")
public class SpringFWController {
//
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Employee> getMethod(@RequestHeader("host") int host) {
		Employee emp;
		System.out.println(host);
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp = new Employee(1, "rohith", 1234));
		list.add(emp = new Employee(1, "rohith", 1234));
		list.add(emp = new Employee(1, "rohith", 1234));
		list.add(emp = new Employee(1, "rohith", 1234));
		return list;
	}

	@RequestMapping(value = "/map", method = RequestMethod.POST)
	public void getData(@RequestBody List<Employee> emp) {

		Iterator<Employee> itr = emp.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void getFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
		ByteArrayInputStream stream = null;
		stream = new ByteArrayInputStream(multipartFile.getBytes());
		System.out.println(stream);
		Scanner scanner = new Scanner(stream);
		scanner.useDelimiter("\\Z");// To read all scanner content in one String
		String data = "";
		if (scanner.hasNext())
			data = scanner.next();
		System.out.println(data);
		scanner.close();
	}

}
