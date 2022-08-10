package jTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import utilities.GetUnsigned;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		LocalDate ldate = LocalDate.now();
		System.out.println(ldate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		LocalTime ltime = LocalTime.now();
		System.out.println(ltime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));

		LocalDateTime ldatetime = LocalDateTime.now();
		System.out.println(ldatetime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy | hh:mm:ss")));

		Instant inicio = Instant.now();

		//Thread.sleep(2000);
		System.out.println("Duração de de um sys.out:");

		Instant efinal = Instant.now();

		Duration duration = Duration.between(inicio, efinal);

		System.out.println(duration.toMillis());

		
		LocalDate dataAtual = LocalDate.now();
		LocalDate dataVencimento = LocalDate.of(2022, 6, 5);
		String dv = dataVencimento + "T00:00:00.00Z";
		Instant InstDataAtual  = Instant.now();
		Instant InstDataVencimento = Instant.parse(dv);
		Duration atrasoDuracao = Duration.between(InstDataAtual,InstDataVencimento);
		GetUnsigned dado = new GetUnsigned(atrasoDuracao.toDays());
		
		if(dataAtual.isAfter(dataVencimento)) {
			System.out.println("O boleto está vencido.");
			System.out.println("Está vencido a " +  dado.getUInteger() + " dias." );
			
		}else {
			System.out.println("Hoje é "+ dataAtual.toString() 
			+ ", A data de vencimento do boleto é em: " + dataVencimento.toString());
			System.out.println("Irá vencer em " + (atrasoDuracao.toDays() + 1) + " dias." );
			
		}

		for(int i  = 0;i < 12 ; i++) {
			dataAtual = dataAtual.plusMonths(1);
			System.out.println(dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
		}


		
	}

}
