package com.mauriciojdk.bancoData;

import com.mauriciojdk.bancoData.models.DadosBancarios;
import com.mauriciojdk.bancoData.models.Pessoa;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class BancoDataApplication {

	public static void main(String[] args) {SpringApplication.run(BancoDataApplication.class, args);

		try {
			Reader reader = Files.newBufferedReader(Paths.get("C:\\Codes\\Projeto\\bancoData\\src\\dados_bancarios.csv"));

			CsvToBean<DadosBancarios> csvToBean = new CsvToBeanBuilder(reader)
					.withType(DadosBancarios.class)
					.build();

			List<DadosBancarios> dadosBancarios = csvToBean.parse();

			for (DadosBancarios dadosBancarios1 : dadosBancarios){
				System.out.println(dadosBancarios1);
			}

		} catch (IOException e){
			e.printStackTrace();
		}

	}

}
