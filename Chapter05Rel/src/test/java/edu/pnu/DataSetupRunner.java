package edu.pnu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSetupRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {


		System.out.println("-Test".repeat(25) + "-");

	}

}
