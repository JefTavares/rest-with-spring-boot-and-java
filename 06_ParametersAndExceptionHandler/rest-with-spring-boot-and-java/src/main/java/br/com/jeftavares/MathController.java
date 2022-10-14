package br.com.jeftavares;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	// a cada chamada gera um id maior
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);

	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;

		// BR 10,25 US 10.25
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);

		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;

		String number = strNumber.replaceAll(",", ".");
		// Expressão regular verificar se:
		// [-+] é numero positivo ou negativo
		// [0-9] de zero a nove
		// \\.? pode conter numeros fracionados 11.11 (de zero a nove ?[0-9]+)
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");

	}

}