package br.com.jeftavares.converters;

public class NumberConvert {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null)
			return 0D;

		// BR 10,25 US 10.25
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);

		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
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
