package edu.asselvi.orcamentoobras.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberUtils {

	private static NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	
	public static BigDecimal getBigDecimalPtBr(String str) throws IllegalArgumentException, NumberFormatException {
		try {
			return new BigDecimal(formatter.parse(str).toString());
		} catch (ParseException e) {
			throw new NumberFormatException(e.getMessage());
		}
	}
}