package moovin.springarchetype.utils;

import com.ethlo.time.FastInternetDateTimeUtil;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
  public static Date asDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.of("America/Costa_Rica")).toInstant());
  }

  public static Date asDate(LocalDate localDate) {
    return Date.from(localDate.atStartOfDay().atZone(ZoneId.of("America/Costa_Rica")).toInstant());
  }

  public static LocalDate asLocalDate(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("America/Costa_Rica")).toLocalDate();
  }

  public static LocalDateTime asLocalDateTime(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("America/Costa_Rica")).toLocalDateTime();
  }

  public static String decodeBase64(String text) {
    String result = "";
    try {
      if (text != null) {
        result = new String(Base64.getDecoder().decode(text.getBytes()));
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String encodeBase64(String text) {
    String result = "";
    try {
      if (text != null) {
        result = new String(Base64.getEncoder().encode(text.getBytes()));
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String fillZerosInteger(BigInteger valor, int fill) {
    StringBuilder result = new StringBuilder();
    String numero = "";
    try {
      if (valor != null) {
        numero = valor.toString();
        if (fill > numero.length()) {
          result.append("0".repeat(fill));
          result = new StringBuilder(result.substring(0, fill - numero.length()) + numero);
        } else {
          result = new StringBuilder().append(numero);
        }
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result.toString();
  }

  public static String formatDecimal(BigDecimal valor, int digits) {
    String result = "";
    try {
      if (valor != null) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(digits);
        df.setMinimumFractionDigits(digits);
        df.setGroupingUsed(false);
        result = df.format(valor);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String formatDecimal(BigDecimal valor) {
    String result = "";
    try {
      if (valor != null) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setGroupingUsed(true);
        result = df.format(valor);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String formatDecimalCurrency(BigDecimal valor, String moneda) {
    return moneda + " " + formatDecimal(valor);
  }

  public static Date getDate(GregorianCalendar cal) {
    Date result = null;
    if (cal != null) {
      try {
        XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        result = xmlCalendar.toGregorianCalendar().getTime();
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
    return result;
  }

  public static Date getDate() {
    return Date.from(Instant.now().atZone(ZoneId.of("America/Costa_Rica")).toInstant());
  }

  public static XMLGregorianCalendar getDateAsXMLGregorianCalendar(Date date) {
    try {
      GregorianCalendar c = new GregorianCalendar();
      c.setTime(date);
      return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    } catch (Exception ignored) {
    }
    return null;
  }

  public static Date getDateFirstDay() {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    return getDateRFC3339(year + "-01-01 00:00:00");
  }

  public static Date getDateLastDay() {
    return asDate(asLocalDate(getDate()).with(TemporalAdjusters.lastDayOfMonth()));
  }

  public static Date getDateRFC3339(String dateString) {
    Date result;
    try {
      FastInternetDateTimeUtil itu = new FastInternetDateTimeUtil();
      OffsetDateTime date = itu.parseDateTime(dateString);
      result = Date.from(date.toInstant());
    } catch (Exception ex) {
      result = null;
      // System.out.println("ERROR 1i >>> " + ex.getMessage());
    }
    if (result == null) {
      /* se hace un segundo intento para leer la fecha  */
      String dateStringSinT = dateString.replaceFirst("T", " ");
      try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result = sdf.parse(dateStringSinT);
      } catch (Exception ex) {
        System.out.println("ERROR 2i >>>" + ex.getMessage());
      }
    }
    return result;
  }

  public static String getDateRFC3339Str(Date fecha) {
    String result = "";
    try {
      if (fecha != null) {
        result = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")
                .format(new Date());
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String getDateStr() {
    return getDateStr(LocalDateTime.now());
  }

  public static String getDateStr(LocalDateTime dt) {
    String result = "";
    try {
      if (dt != null) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        result = dtf.format(dt);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String getDateStr(Date d) {
    String result = "";
    try {
      if (d != null) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        result = sdf.format(d);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String getDateTimeStr() {
    return getDateTimeStr(LocalDateTime.now());
  }

  public static String getDateTimeStr(LocalDateTime dt) {
    String result = "";
    try {
      if (dt != null) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        result = dtf.format(dt);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String getFirstDayLastMonthStr() {
    return getDateStr(LocalDateTime.now().minusMonths(1).withDayOfMonth(1));
  }

  public static String getTimeStr() {
    return getTimeStr(LocalDateTime.now());
  }

  public static String getTimeStr(LocalDateTime dt) {
    String result = "";
    try {
      if (dt != null) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
        result = dtf.format(dt);
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return result;
  }

  public static String getYear(Date date) {
    return getDateStr(date).substring(0, 4);
  }

  public static String strSearchCleaner(String terms) {
    if (terms == null) {
      return "";
    }
    String result = "";
    String REGEX = "^([+-]+)(.*)([*]?)$|^(.*)([*]+)$|^\".*\"$";
    String REGEX_ONLY_NUMBERS = "[0-9]+";
    Pattern pattern = Pattern.compile(REGEX);
    Pattern patternOnlyDigits = Pattern.compile(REGEX_ONLY_NUMBERS);
    Matcher matcher;
    String term;
    terms = terms.replaceAll("[^\\p{IsLatin}\\p{Digit}*\\\"-.+]", " ");
    StringTokenizer st = new StringTokenizer(terms);
    StringBuilder sb = new StringBuilder();
    while (st.hasMoreElements()) {
      term = st.nextElement().toString();
      matcher = pattern.matcher(term);
      if (!matcher.matches()) {
        matcher = patternOnlyDigits.matcher(term);
        if (!matcher.matches()) {
          sb.append("+").append(term).append("* ");
        } else {
          sb.append(term).append(" ");
        }
      } else {
        sb.append(term).append(" ");
      }
    }
    result = sb.toString().trim();
    return result;
  }
}
