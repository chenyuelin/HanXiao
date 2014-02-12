package csv;

import java.io.StringWriter;
import java.io.Writer;

import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;

import name.chenyuelin.util.AesEncryptionUtil;

import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;

public class CsvSample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String[][] csvContent = new String[3][3];
		csvContent[0][0] = "A";
		csvContent[0][1] = "B,";
		csvContent[0][2] = "C";
		csvContent[1][0] = "³Â";
		csvContent[1][1] = "ÔÀ";
		csvContent[1][2] = "÷ë";
		csvContent[2][0] = "ÕÅ";
		csvContent[2][1] = "Èý";
		csvContent[2][2] = "·á";
		CsvMapper cm = new CsvMapper();
		Writer writer = new StringWriter();
		CsvGenerator csvGenerator = cm.getFactory().createGenerator(writer);
		cm.writeValue(csvGenerator, csvContent);
		writer.close();
		System.out.println(writer.toString());
		
		byte[] keys=AesEncryptionUtil.initkey();
		System.out.println(DatatypeConverter.printBase64Binary(keys));
		System.out.println(DatatypeConverter.printHexBinary(keys));
		byte[] encryptedData=AesEncryptionUtil.encrypt("³ÂÔÀ÷ë".getBytes("utf-8"), keys);
		System.out.println(DatatypeConverter.printHexBinary(encryptedData));
		System.out.println(DatatypeConverter.printBase64Binary(encryptedData));
		
		//********************* EBC *****************************
		System.out.println();
		keys=DatatypeConverter.parseHexBinary("C00DEC4C2F261F4AF38A113EA544FA697A7837D60F8A96EA8DC53C0D5D2C1B91");
		System.out.println(DatatypeConverter.printHexBinary(keys));
		
		byte[] ivData=DatatypeConverter.parseHexBinary("2555041E7818227085770B5FC547603A");
		IvParameterSpec iv=new IvParameterSpec(ivData);
		System.out.println(DatatypeConverter.printHexBinary(iv.getIV()));
		encryptedData=AesEncryptionUtil.encrypt("abc".getBytes("utf-8"), keys);
		System.out.println(DatatypeConverter.printBase64Binary(encryptedData));
		System.out.println(DatatypeConverter.printHexBinary(encryptedData));
		
		System.out.println(new String(AesEncryptionUtil.decrypt(DatatypeConverter.parseHexBinary("5105bc493bb55a88ad880444728c7963"), keys,"AES/CBC/ISO10126Padding",iv),"utf-8"));
		
	}

}
