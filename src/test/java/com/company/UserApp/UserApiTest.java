//package com.company.UserApp;
//
//import java.net.URI;
//import java.time.LocalDate;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import junit.framework.Assert;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = UserAppApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(OrderAnnotation.class)
//public class UserApiTest {
//
//	@LocalServerPort
//	private int port;
//	private final TestRestTemplate restTemp = new TestRestTemplate();
//	private final HttpHeaders headers = new HttpHeaders();
//	private final User user = new User();
//
//	public URI loaduri(String uri) {
//		return URI.create(String.format("http://localhost:%s%s", port, uri));
//
//	}
//
//	@BeforeEach
//	public void loaduser() {
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		user.setName("UserName");
//		user.setBirthdate(LocalDate.of(1900, 11, 12));
//		user.setEmail("Test@gmail.com");
//		user.setAddress("address details");
//
//	}
//	@Test
//	@Order(1)
//	public void whenValidUser_create() {
//		final ResponseEntity<Object> reply = restTemp.exchange(loaduri("/addusers"), HttpMethod.POST,
//				new HttpEntity<>(user, headers), Object.class);
//		Assert.assertEquals(HttpStatus.CREATED.value(), reply.getStatusCodeValue());
//	
//	}
//	@Test
//	@Order(2)
//	public void whenValidUser_retriveone() {
//		final ResponseEntity<Object> reply = restTemp.exchange(loaduri("/getting/7"), HttpMethod.GET,
//				new HttpEntity<>(user, headers), Object.class);
//		Assert.assertEquals(HttpStatus.OK.value(), reply.getStatusCodeValue());
//	
//	}
//	@Test
//	@Order(3)
//	public void whenValidUser_retrivAll() {
//		final ResponseEntity<Object> reply = restTemp.exchange(loaduri("/get/user"), HttpMethod.GET,
//				new HttpEntity<>(user, headers), Object.class);
//		Assert.assertEquals(HttpStatus.OK.value(), reply.getStatusCodeValue());
//		
//	}
//	
//	@Test
//	@Order(4)
//	public void whenValidUser_Update() {
//		user.setName("UpdateName");
//		final ResponseEntity<Object> reply = restTemp.exchange(loaduri("/user/7"), HttpMethod.PUT,
//				new HttpEntity<>(user, headers), Object.class);
//		Assert.assertEquals(HttpStatus.ACCEPTED.value(), reply.getStatusCodeValue());
//		
//	}
////	@Test
////	@Order(5)
////	public void whenValidUser_DeleteUser() {
////		
////		final ResponseEntity<Object> reply = restTemp.exchange(loaduri("/user/7"), HttpMethod.DELETE,
////				new HttpEntity<>(user, headers), Object.class);
////		Assert.assertEquals(HttpStatus.NO_CONTENT.value(), reply.getStatusCodeValue());
////		
////	}
//}
