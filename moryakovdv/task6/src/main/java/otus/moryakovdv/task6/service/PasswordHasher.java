package otus.moryakovdv.task6.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**Общий интерфйс для классов-хешировщиков*/
public interface PasswordHasher {

	String hash(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException;
	
}
