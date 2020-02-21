package com.christian.adventureengine.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Serializer {
	private String filepath;
	private OutputStream outStream;
	private InputStream inStream;
	
	public Serializer(String filepath) {
		this.filepath = filepath;
		
		try {
			outStream = new FileOutputStream(filepath);
			inStream = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void WriteInt(int val) {
		try {
			byte[] data = new byte[] {
					(byte)(val >>> 24),
					(byte)(val >>> 16),
					(byte)(val >>> 8),
					(byte)(val),
			};
			outStream.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void WriteFloat(float val) {
		try {
			outStream.write(Float.floatToIntBits(val));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void WriteString(String val) {
		try {
			outStream.write(val.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int ReadInt() {
		return 0;
	}
	public float ReadFloat() {
		return 0;
	}
	public String ReadString() {
		return "";
	}
}
