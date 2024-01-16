package edu.pnu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Chapter03ApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("Test입니다.");
	}

	@Test
	public void mytest01() {

		System.out.println("MyTest입니다");
	}

}
