package br.com.sadock.bananabank.user.shared.utils;

public class CpfMasker {
	
	public static String mask(String cpf) {
	    if (cpf == null) return null;
	    return cpf.replaceAll("(\\d{3})\\d{5}(\\d{2})", "$1*****$2");
	}
	
	public static String unmask(String value) {
	    if (value == null || value.isBlank()) return value;
	    return value.replaceAll("\\D", "");
	}

}
