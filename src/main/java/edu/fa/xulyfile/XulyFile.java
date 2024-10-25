package edu.fa.xulyfile;

import java.io.File;

public class XulyFile {

	public static boolean exists(String urlAndName) {
		File file = new File(urlAndName);
		return file.exists();
	}
}
