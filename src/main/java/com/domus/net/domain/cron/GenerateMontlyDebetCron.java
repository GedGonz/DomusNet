package com.domus.net.domain.cron;

import com.domus.net.domain.service.AccountReceivableService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GenerateMontlyDebetCron {


	private final AccountReceivableService accountReceivableService;

	public GenerateMontlyDebetCron(AccountReceivableService accountReceivableService) {
		this.accountReceivableService = accountReceivableService;
	}

	@Scheduled(cron = "0 0 0 1 * ?") //se ejecuta cada primer dia del mes a las 00
	//@Scheduled(cron = "0 * * * * ?") //se ejecuta cada minuto en cada hora
	public void generateMontlyDebet() {
		var dateNow = LocalDate.now();
		accountReceivableService.generateMontlydebet(dateNow);
	}
}
