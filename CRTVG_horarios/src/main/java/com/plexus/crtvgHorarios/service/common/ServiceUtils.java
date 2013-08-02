package com.plexus.crtvgHorarios.service.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceUtils {

	public static byte[] getByteArrayFromFile(File file) throws Exception {

		InputStream is = new FileInputStream(file);

		long length = file.length();

		byte[] bytes = new byte[(int) length];

		int offset = 0, n = 0;

		while (offset < bytes.length && (n = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += n;
		}

		is.close();

		return bytes;

	}

	/*
	 * Funciones de uso común en los managedBeans, ej. getDateSelectItems
	 */

	public static boolean isNifValido(String nif) {

		if (nif != null && !nif.equals("")) {

			boolean isNif = true;

			String letra = nif.substring(nif.length() - 1, nif.length());

			nif = nif.substring(0, nif.length() - 1);

			if (nif.length() != 8) {
				isNif = false;
			}
			try {
				if (isNif) {
					String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
					int numeroNif = Integer.parseInt(nif);
					int numero = numeroNif % 23;

					String letraOk = letras.substring(numero, numero + 1);

					if (!letra.toUpperCase().equals(letraOk)) {
						isNif = false;
					}
				}
				return isNif;

			} catch (NumberFormatException nfe) {
				return false;
			}
		} else
			return false;
	}

	private static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;

		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean isCifValido(String cif) {

		if (cif != null && !cif.equals("")) {

			int[] v1 = new int[] { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };
			int temp = 0;

			for (int i = 2; i <= 6; i += 2) {
				if (!isNumeric(String.valueOf(cif.charAt(i - 1))))
					return false;

				temp = temp + v1[Integer.parseInt(String.valueOf(cif.charAt(i - 1)))];

				if (!isNumeric(String.valueOf(cif.charAt(i))))
					return false;

				temp = temp + Integer.parseInt(String.valueOf(cif.charAt(i)));
			}
			;

			temp = temp + v1[Integer.parseInt(String.valueOf(cif.charAt(7)))];

			temp = (10 - (temp % 10));

			if (temp == 10) {

				if (!cif.substring(cif.length() - 1, cif.length()).equals("J") && !cif.substring(cif.length() - 1, cif.length()).equals("0")) {
					return false;
				}

			} else {

				String v2 = "JABCDEFGHI";

				if (!(cif.substring(cif.length() - 1, cif.length())).equals(String.valueOf(temp))
						&& !(cif.substring(cif.length() - 1, cif.length()).equals(String.valueOf(v2.charAt(temp))))) {

					return false;
				}
			}

			return true;
		} else
			return false;
	}

	public static boolean isCPvalido(String cp, int codigoProvincia) {

		if (cp != null && !cp.equals("")) {

			if (cp.length() != 5)
				return false;

			if (Integer.parseInt(cp.substring(0, 2)) != codigoProvincia)
				return false;

			return true;
		} else
			return false;
	}

	public static boolean isTelefonoValido(String telefono) {

		if (telefono != null && !telefono.equals("")) {

			if (telefono.length() < 9)
				return false;

			return true;
		} else
			return false;
	}

	public static boolean isEmailValido(String email) {

		if (email != null && !email.equals("")) {

			String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";

			if (email.matches(regex))
				return true;
			else
				return false;
		} else
			return false;
	}

	public static boolean isHoraValida(String hora) {

		if (hora == null)
			return false;

		if (hora == "")
			return false;

		if (hora.length() != 5)
			return false;

		if (hora.indexOf(":") != 2)
			return false;

		String cadenaHora = hora.substring(0, 2);
		String cadenaMinutos = hora.substring(3, 5);

		if (!isNumeric(cadenaHora))
			return false;

		if (!isNumeric(cadenaMinutos))
			return false;

		int horas = Integer.parseInt(cadenaHora);
		int minutos = Integer.parseInt(cadenaMinutos);

		if (horas > 23)
			return false;

		if (minutos > 59)
			return false;

		return true;
	}

	private static int getDigitoControl(String cadena) {
		int[] cifras = new int[] { 1, 2, 4, 8, 5, 10, 9, 7, 3, 6 };
		int chequeo = 0;

		for (int i = 0; i < cifras.length; i++) {
			chequeo += Integer.parseInt(String.valueOf(cadena.charAt(i))) * cifras[i];
		}

		chequeo = 11 - (chequeo % 11);

		switch (chequeo) {

		case 11:
			chequeo = 0;
			break;
		case 10:
			chequeo = 1;
			break;
		}

		return chequeo;
	}

	public static boolean isNumeroCuentaValido(String entidad, String oficina, String dc, String numeroCuenta) {

		if (entidad != null && !entidad.equals("") && oficina != null && !oficina.equals("") && dc != null && !dc.equals("") && numeroCuenta != null
				&& !numeroCuenta.equals("")) {

			String cadenaControlPrimerDigito = "00" + entidad + oficina;
			int primerDigitoControl = getDigitoControl(cadenaControlPrimerDigito);
			if (primerDigitoControl != Integer.parseInt(String.valueOf(dc.charAt(0))))
				return false;

			String cadenaControlSegundoDigito = numeroCuenta;
			int segundoDigitoControl = getDigitoControl(cadenaControlSegundoDigito);
			if (segundoDigitoControl != Integer.parseInt(String.valueOf(dc.charAt(1))))
				return false;

			return true;
		} else
			return false;
	}

	public static BigDecimal truncar2Decimales(BigDecimal valor) {

		// Es necesario usar un nuevo Objeto BigDecimal ya que es un objeto
		// inmutable
		BigDecimal cantidadTruncada = valor.setScale(2, BigDecimal.ROUND_DOWN);

		return cantidadTruncada;
	}

	/**
	 * 
	 * @param valor
	 * @return
	 */
	public static Double getFormatDouble6Decimales(BigDecimal valor) {

		if (valor != null) {
			// Es necesario usar un nuevo Objeto BigDecimal ya que es un objeto
			// inmutable
			BigDecimal valorFormateado = valor.setScale(6, BigDecimal.ROUND_DOWN); 

			return new Double(valorFormateado.doubleValue());
		}
		return null;
	}

	public static BigDecimal getBigDecimalOfDouble(Double valor) {

		if (valor != null) {

			// Se crea el BigDecimal a partir de la cadena del Double y no del
			// double para evitar perder decimales en la conversión
			BigDecimal bigDecimalValue = new BigDecimal(valor.toString());

			return bigDecimalValue;
		}
		return null;
	}


	// Obtiene un idFecha de la forma (aaaaMMdd) a partir de la fecha indicada
	public static Long getIdFechaFromDate(Date fecha) {

		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String cadenaFecha = dateFormat.format(fecha);
		Long idFecha = new Long(cadenaFecha);

		return idFecha;
	}
}
