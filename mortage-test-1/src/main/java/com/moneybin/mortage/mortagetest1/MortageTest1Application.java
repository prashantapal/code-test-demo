package com.moneybin.mortage.mortagetest1;

import com.moneybin.mortage.mortagetest1.service.FileService;
import com.moneybin.mortage.mortagetest1.service.MonthlyInstalmentCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class MortageTest1Application {

	private static Logger logger = LoggerFactory.getLogger(MortageTest1Application.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MortageTest1Application.class, args);
		startCalculating(applicationContext);
	}

	private static void startCalculating(ApplicationContext applicationContext) {
		MonthlyInstalmentCalculator instalmentCalculator = applicationContext.getBean(MonthlyInstalmentCalculator.class);
		FileService fileService = applicationContext.getBean(FileService.class);
		fileService.readProspectFile()
				.stream()
				.map(instalmentCalculator::calculate)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.forEach(logger::info);
	}

}
